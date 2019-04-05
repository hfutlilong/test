package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        String uri = req.getRequestURI();
        boolean isLoginReq = uri.matches("/user/.*\\.do");

        boolean isLogin = session.getAttribute("isLogin") != null
                && (boolean)session.getAttribute("isLogin");
        if (isLoginReq || isLogin) {
            chain.doFilter(request, response);
            return;
        }
        //跳转至sso认证中心
        res.sendRedirect("/user/login.do");
    }
}
