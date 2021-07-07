package AuthFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author brkn_
 */

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/indexogrenci.xhtml", "/misafir/*"})

public class AuthFilter2 implements Filter {

    public AuthFilter2() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession ses = req.getSession(false);
            String reqURI = req.getRequestURI();
            if ((ses != null && ses.getAttribute("username2") != null)
            )
                chain.doFilter(request, response);
            else
                res.sendRedirect(req.getContextPath() + "/misafirindex.xhtml");

        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
    } //doFilter

    @Override
    public void destroy() {

    }
}
