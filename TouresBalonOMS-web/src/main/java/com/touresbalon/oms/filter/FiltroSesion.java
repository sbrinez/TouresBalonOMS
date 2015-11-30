package com.touresbalon.oms.filter;

import com.touresbalon.oms.constant.ConstantesAppWeb;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SergioDavid
 */
public class FiltroSesion implements javax.servlet.Filter {

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String path = request.getRequestURI();
        System.out.println(path);
        if (!path.endsWith("login.xhtml")) {
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute(ConstantesAppWeb.USERNAME) == null) {
                response.sendRedirect("login.xhtml");
            }            
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }

}
