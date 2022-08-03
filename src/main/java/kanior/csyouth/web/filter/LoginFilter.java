package kanior.csyouth.web.filter;

import kanior.csyouth.web.SessionConst;
import kanior.csyouth.web.user.dto.LoginUserInfo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);

        if (session != null) {
            Object userInfoObj = session.getAttribute(SessionConst.LOGIN_USER);
            if (userInfoObj != null) {
                request.setAttribute("userInfo", userInfoObj);
            }
        }

        chain.doFilter(request, response);
    }
}
