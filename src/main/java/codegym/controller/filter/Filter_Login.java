package codegym.controller.filter;

import codegym.model.Account;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/home", "/user"})
public class Filter_Login extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession httpSession = req.getSession();
        Account account = (Account) httpSession.getAttribute("account");
        if (account != null) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect("/login");
        }
    }
}
