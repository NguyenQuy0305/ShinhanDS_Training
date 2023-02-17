package com.example.practice_aop.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(1)
public class UserAgentFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String userAgent = httpRequest.getHeader("User-Agent");
        if (userAgent.contains("Postman")) {
            ((HttpServletResponse) servletResponse).setStatus(HttpServletResponse.SC_FORBIDDEN);

            Map<String, String> responseBody = new HashMap<>();
            String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SS").format(new java.util.Date());
            String path = httpRequest.getServletPath();

            responseBody.put("timestamp", timeStamp);
            responseBody.put("status", "403");
            responseBody.put("error", "Forbidden");
            responseBody.put("message", "Your request from Postman!");
            responseBody.put("path", path);

            ObjectMapper objectMapper = new ObjectMapper();
            String responseString = objectMapper.writeValueAsString(responseBody);
            ((HttpServletResponse) servletResponse).getWriter().write(responseString);
            ((HttpServletResponse) servletResponse).getWriter().flush();
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
