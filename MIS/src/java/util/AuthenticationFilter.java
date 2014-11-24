/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TheKey
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {
 
    private ServletContext context;
     
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }
     
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
         
        String uri = req.getRequestURI();
        this.context.log("Requested Resource::"+uri);
         
        HttpSession session = req.getSession(false);
         
        if(session == null && !(uri.endsWith("html") || uri.endsWith("/")  )){
            this.context.log("Unauthorized access request");
            res.sendRedirect("Login.jsp");
        }else{
            // pass the request along the filter chain
            if(!(uri.endsWith("html") || uri.endsWith("/")  ))
            {
                if (session != null)
                {
                    ViewModel.UserProfileVM test = ( ViewModel.UserProfileVM)session.getAttribute("profile");
                    if (null != test.getUser())
                    {
                        chain.doFilter(request, response);
                    }
                    else
                    {
                        this.context.log("Unauthorized access request");
                        res.sendRedirect(req.getContextPath() + "/");
                    }
                }
            }
            else
                chain.doFilter(request, response);

        }    
    }
    public void destroy() {
        //close any resources here
    }
 
}