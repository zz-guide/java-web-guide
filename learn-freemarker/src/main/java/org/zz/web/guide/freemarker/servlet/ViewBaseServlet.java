package org.zz.web.guide.freemarker.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebApplication;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.io.Serial;

public class ViewBaseServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -1289363666353791277L;

    ITemplateEngine iTemplateEngine;
    JakartaServletWebApplication jakartaServletWebApplication;

    @Override
    public void init() {
        jakartaServletWebApplication = JakartaServletWebApplication.buildApplication(getServletContext());
        iTemplateEngine = buildTemplateEngine(jakartaServletWebApplication);
    }

    private static ITemplateEngine buildTemplateEngine(IWebApplication application) {

        WebApplicationTemplateResolver templateResolver = new WebApplicationTemplateResolver(application);

        templateResolver.setTemplateMode(TemplateMode.HTML);
        // This will convert "home" to "/WEB-INF/templates/home.html"
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        // Set template cache TTL to 1 hour. If not set, entries would live in cache until expelled by LRU
        templateResolver.setCacheTTLMs(3600000L);

        // Cache is set to true by default. Set to false if you want templates to
        // be automatically updated when modified.
        templateResolver.setCacheable(true);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        return templateEngine;
    }

    public void processTemplate(String templateName, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        WebContext ctx = new WebContext(
                jakartaServletWebApplication.buildExchange(req, resp),
                req.getLocale(),
                jakartaServletWebApplication.getAttributeMap()
        );
        iTemplateEngine.process(templateName, ctx, resp.getWriter());
    }
}
