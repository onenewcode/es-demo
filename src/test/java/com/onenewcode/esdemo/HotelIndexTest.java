package com.onenewcode.esdemo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;



@SpringBootTest
class HotelIndexTest {
    @Autowired
    ElasticsearchClient esClient;

//    @Test
//    void testCreateIndex() throws IOException {
//        // 1.准备Request      PUT /hotel
//        CreateIndexRequest request = new CreateIndexRequest("hotel");
//        // 2.准备请求参数
//        request.source(MAPPING_TEMPLATE, XContentType.JSON);
//        // 3.发送请求
//        client.indices().create(request, RequestOptions.DEFAULT);
//    }

//    @Test
//    void testExistsIndex() throws IOException {
//        // 1.准备Request
//        GetIndexRequest request = new GetIndexRequest("hotel");
//        // 3.发送请求
//        boolean isExists = client.indices().exists(request, RequestOptions.DEFAULT);
//
//        System.out.println(isExists ? "存在" : "不存在");
//    }

    @Test
    void testDeleteIndex() throws IOException {
        esClient.indices().delete(c -> c
                .index("hotel")
        );
    }

}
