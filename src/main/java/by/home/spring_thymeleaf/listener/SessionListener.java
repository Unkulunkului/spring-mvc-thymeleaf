package by.home.spring_thymeleaf.listener;

import by.home.spring_thymeleaf.entity.CalcHistory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("calculatorHistory", new CalcHistory());
        se.getSession().setAttribute("isGuest", true);
        se.getSession().setAttribute("isUser", false);
        se.getSession().setAttribute("isAdmin", false);
    }
}
