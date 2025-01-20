package com.airpremia.eosh.config;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RestClientConfiguration {
    private static final int MAX_CONNECTIONS_PER_ROUTE = 10;
    private static final int MAX_CONNECTIONS_TOTAL = 100;
    private static final String X_API_KEY = "x-api-key";

    @Value("${airpremia.api.url}")
    private String airpremiaApiUrl;

    @Value("${airpremia.api.x-api-key}")
    private String airpremiaApiKey;

    @Value("${ecm.api.url}")
    private String ecmUri;

    @Value("${ecm.api.message}")
    private String messageApiPath;

    @Value("${ecm.api.report-path}")
    private String reportApiPath;

    @Bean
    public CloseableHttpClient httpClient() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(MAX_CONNECTIONS_TOTAL);
        connectionManager.setDefaultMaxPerRoute(MAX_CONNECTIONS_PER_ROUTE);

        return HttpClients.custom().setConnectionManager(connectionManager).build();
    }

    @Bean
    public RestClient restClient(CloseableHttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

        return RestClient.builder().requestFactory(requestFactory)
            .baseUrl(airpremiaApiUrl)
            .defaultHeader(X_API_KEY, airpremiaApiKey)
            .build();
    }

    @Bean
    public RestClient messageClient(CloseableHttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return RestClient.builder().requestFactory(requestFactory)
            .baseUrl(ecmUri + messageApiPath).build();
    }

    @Bean
    public RestClient reportClient(CloseableHttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return RestClient.builder().requestFactory(requestFactory)
            .baseUrl(ecmUri + reportApiPath).build();
    }

    @Bean
    public RestClient hrClient(CloseableHttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

        return RestClient.builder().requestFactory(requestFactory)
            .baseUrl(airpremiaApiUrl)
            .defaultHeader(X_API_KEY, airpremiaApiKey)
            .build();
    }

}
