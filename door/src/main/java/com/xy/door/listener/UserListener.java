package com.xy.door.listener;

import com.xy.door.vo.UserVo;
import org.apache.catalina.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author xiayun
 * @version V1.0.0
 * @description UserListener
 * @date   2019/12/24 14:46
 */
public class UserListener extends HttpServlet implements Filter {

    private String[] excludedUris;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludedUris = filterConfig.getInitParameter("excludedUri").split(",");
        ;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String uri = req.getServletPath();
        if (isExcludedUri(uri)) {
            filterChain.doFilter(req, resp);
        } else {
            HttpSession session = ((HttpServletRequest) servletRequest).getSession(true);
            UserVo uv = (UserVo) session.getAttribute("user");
            if (uv != null && uv.getId() != null) {
                filterChain.doFilter(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/door/index");
                // resp.sendRedirect("index");
            }

        }


    }

    private boolean isExcludedUri(String uri) {
        if (excludedUris == null || excludedUris.length <= 0) {
            return false;
        }
        for (String ex : excludedUris) {
            uri = uri.trim();
            ex = ex.trim();
            if (uri.toLowerCase().matches(ex.toLowerCase().replace("*", ".*")))
                return true;
        }
        return false;
    }
}