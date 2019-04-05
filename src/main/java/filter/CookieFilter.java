package filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;

public class CookieFilter implements Filter {
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

        String uri = req.getRequestURI();
        boolean isLoginReq = uri.matches("/user/.*\\.do");

        boolean isLogin = false;
        // 判断cookie是否有username，如果有代表登陆过
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie != null && URLDecoder.decode(cookie.getName(), "utf-8").equals("username")) {
                    isLogin = true;
                    break;
                }
            }
        }

        if (isLoginReq || isLogin) {
            chain.doFilter(request, response);
            return;
        }
        //跳转至登录页面
        res.sendRedirect("/user/login.do");
    }
}
