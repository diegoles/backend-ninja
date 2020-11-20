package com.udemy.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

    private final static Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

    // PRIMERO
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setAttribute("startTime", System.currentTimeMillis());

        return super.preHandle(request, response, handler);
    }

    // SEGUNDO
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        long startTime = (long) request.getAttribute("startTime");
        LOG.info("URL: '" + request.getRequestURL().toString() + "' IN: '" + (System.currentTimeMillis() - startTime) + "'ms");

        super.afterCompletion(request, response, handler, ex);
    }

}
