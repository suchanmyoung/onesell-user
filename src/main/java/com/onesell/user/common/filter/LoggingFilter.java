package com.onesell.user.common.filter;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        final String method = httpServletRequest.getMethod();

        final String requestURI = makeRequestURI(httpServletRequest);
        final String requestId = UUID.randomUUID().toString();

        MDC.put("REQUEST_ID_KEY", requestId);
        log.info("API REQUEST:: method={}, requestURI={}", method, requestURI);

        try {
            chain.doFilter(request, response);
        } finally {
            log.info("API RESPONSE:: method={}, requestURI={}, ", method, requestURI);
            MDC.remove("REQUEST_ID_KEY");
        }
    }

    private String makeRequestURI(HttpServletRequest httpServletRequest) {
        final String requestURI = httpServletRequest.getRequestURI();
        final String queryString = httpServletRequest.getQueryString();

        if (queryString == null) {
            return requestURI;
        } else {
            return requestURI + "?" + queryString;
        }
    }
}
