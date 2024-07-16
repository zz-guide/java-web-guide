package org.zz.web.guide.servlet.http.parameter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.Serial;
import java.util.Arrays;
import java.util.Map;

public class ParameterHttpServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = -3258116770750973627L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.getParameter(req, resp);
    }

    private void getParameter(HttpServletRequest req, HttpServletResponse resp){
        // getParameterMap
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String key: parameterMap.keySet()) {
            // 注意，就算只有一个值，里边也是数组形式
            System.out.println("key:"+key+",value:"+Arrays.toString(parameterMap.get(key)));
        }

        // getParameterValues()
        String[] ids = req.getParameterValues("ids");
        System.out.println("ids:" + Arrays.toString(ids));

        // getParameter()
        String id = req.getParameter("id");
        System.out.println("id:"+id);
    }
}
