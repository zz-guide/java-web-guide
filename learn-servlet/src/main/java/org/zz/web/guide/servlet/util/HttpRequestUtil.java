package org.zz.web.guide.servlet.util;

import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HttpRequestUtil {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static String getRequestIp(HttpServletRequest request) {
        String ip = "";
        if (StringUtil.isNotBlank(ip = request.getHeader("X-Forwarded-For"))) {
            return ip.split(",")[0];
        }

        if (StringUtil.isNotBlank(ip = request.getHeader("Proxy-Client-IP"))) {
            return ip;
        }

        if (StringUtil.isNotBlank(ip = request.getHeader("WL-Proxy-Client-IP"))) {
            return ip;
        }

        if (StringUtil.isNotBlank(ip = request.getHeader("HTTP_CLIENT_IP"))) {
            return ip;
        }

        if (StringUtil.isNotBlank(ip = request.getHeader("HTTP_X_FORWARDED_FOR"))) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    /**
     * 是否包含请体
     *
     * @param request
     * @return
     */
    public static boolean isIncludePayload(HttpServletRequest request) {
        return request.getContentLength() > 0
                || "chunked".equals(request.getHeader("Transfer-Encoding"));
    }

    /**
     * 读取请求体
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static String readRequestBody(HttpServletRequest request) throws IOException {
        if (!HttpRequestUtil.isIncludePayload(request)) {
            return "";
        }

        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append(LINE_SEPARATOR);
        }
        if (!sb.isEmpty()) {
            return sb.substring(0, sb.length() - LINE_SEPARATOR.length());
        }
        return "";
    }

    //  header = HttpRequestUtils.logHeaderStr(logProperties.getLogRespHeader(), response::getHeader);
    /**
     * 日志输出log字符
     *
     * @param headerKeyList
     * @param getHeaderFunc
     * @return
     */
    public static String logHeaderStr(Set<String> headerKeyList, Function<String, String> getHeaderFunc) {
        return headerKeyList.stream()
                .map(k -> k + "=" + Optional.ofNullable(getHeaderFunc.apply(k))
                        .orElse(""))
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
