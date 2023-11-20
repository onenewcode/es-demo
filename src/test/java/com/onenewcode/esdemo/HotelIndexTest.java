package com.onenewcode.esdemo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;


import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;


import co.elastic.clients.elasticsearch.indices.ExistsRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.StringReader;

import static com.onenewcode.esdemo.constants.HotelIndexConstants.MAPPING_TEMPLATE;


@SpringBootTest
class HotelIndexTest {
    @Autowired
    ElasticsearchClient esClient;
    // 通过json创建索引
    @Test
    void testCreateIndex() throws IOException {
//     设置索引库名称，并读取json设置映射关系
        CreateIndexRequest  request = CreateIndexRequest.of(i -> i
                .index("hotel")
                .withJson(new StringReader(MAPPING_TEMPLATE))
        );
        //构建是否存在的请求
        ExistsRequest existsRequest = ExistsRequest.of(i->i.index("hotel"));

        if (esClient.indices().exists(existsRequest).value()){
            System.out.println("该索引已经存在");
        }else {
//            创建新索引
            boolean response =esClient.indices().create(request).acknowledged();
        }
    }

    //删除索引
    @Test
    void testDeleteIndex() throws IOException {
        esClient.indices().delete(c -> c
                .index("hotel")
        );
    }

}
