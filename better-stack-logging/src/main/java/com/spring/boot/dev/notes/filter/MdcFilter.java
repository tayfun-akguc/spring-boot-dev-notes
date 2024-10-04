package com.spring.boot.dev.notes.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class MdcFilter implements Filter {

    private static final String TRACE_ID_HEADER = "X-Trace-Id";
    private static final String MDC_TRACE_ID_KEY = "traceId";

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        MDC.put(MDC_TRACE_ID_KEY, getOrCreateTraceId(httpServletRequest));

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.clear();
        }
    }

    private String getOrCreateTraceId(HttpServletRequest httpServletRequest) {
        var traceId = httpServletRequest.getHeader(TRACE_ID_HEADER);
        return traceId != null
                ? traceId
                : String.valueOf(UUID.randomUUID());
    }
}
