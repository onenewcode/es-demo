package com.onenewcode.esdemo.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 29071
 * @version 1.0
 * @data 2023/11/19 16:42
 */
@Configuration
public class ESConfig {
    @Value("${spring.elasticsearch.uris}")
    private String urls;

    @Bean
    public ElasticsearchClient ESConfigClient(){
        System.out.println(urls);
         // Create the low-level client 创建低级客户端
         RestClient restClient = RestClient
                 .builder(HttpHost.create(urls)).build();
         // 创建json映射器
        ElasticsearchTransport transport=new RestClientTransport(restClient,new JacksonJsonpMapper());
        // 创建api客户端
        return new ElasticsearchClient(transport);
     }
}
