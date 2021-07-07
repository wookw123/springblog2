package Blog2.springBlog2.handler;

import org.aspectj.bridge.MessageUtil;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import sun.misc.MessageUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFailHandler implements AuthenticationFailureHandler {



    private String loginidname;
    private String loginpwname;
    private String errormsgname;
    private String defaultFailureUrl;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {


        String username = request.getParameter(loginidname);
        String password = request.getParameter(loginpwname);
        String errormsg = exception.getMessage();





        출처: https://to-dy.tistory.com/92 [todyDev]

        request.setAttribute(loginidname, username);
        request.setAttribute(loginpwname, password);
        request.setAttribute(errormsgname,errormsg);

        request.getRequestDispatcher(defaultFailureUrl).forward(request, response);

    }

    public String getLoginidname() {
        return loginidname;
    }

    public void setLoginidname(String loginidname) {
        this.loginidname = loginidname;
    }

    public String getLoginpwname() {
        return loginpwname;
    }

    public void setLoginpwname(String loginpwname) {
        this.loginpwname = loginpwname;
    }

    public String getErrormsgname() {
        return errormsgname;
    }

    public void setErrormsgname(String errormsgname) {
        this.errormsgname = errormsgname;
    }

    public String getDefaultFailureUrl() {
        return defaultFailureUrl;
    }

    public void setDefaultFailureUrl(String defaultFailureUrl) {
        this.defaultFailureUrl = defaultFailureUrl;
    }
}
