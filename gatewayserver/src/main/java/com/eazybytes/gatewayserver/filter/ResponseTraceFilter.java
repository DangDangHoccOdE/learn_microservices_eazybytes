package com.eazybytes.gatewayserver.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

@Configuration
public class ResponseTraceFilter {

    private static final Logger logger = LoggerFactory.getLogger(ResponseTraceFilter.class);
// ResponseTraceFilter là một GlobalFilter xử lý các yêu cầu sau khi đã hoàn tất và trước khi response được trả về cho client. Filter này đảm bảo rằng correlation ID sẽ được đưa vào header của response, để client có thể theo dõi thông tin về các request đã xử lý.
    @Autowired
    FilterUtility filterUtility;

    @Bean
    public GlobalFilter postGlobalFilter() { //Filter này sẽ xử lý response sau khi tất cả các filter khác đã được thực thi.
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
                String correlationId = filterUtility.getCorrelationId(requestHeaders);

                if(exchange.getResponse().getHeaders().containsKey(filterUtility.CORRELATION_ID)) {
                    logger.debug("Updated the correlation id to the outbound headers: {}", correlationId);
                    exchange.getResponse().getHeaders().add(filterUtility.CORRELATION_ID, correlationId);
                }
            }));
        };
    }
}
