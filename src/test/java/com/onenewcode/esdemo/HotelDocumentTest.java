package com.onenewcode.esdemo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.alibaba.fastjson.JSON;
import com.onenewcode.esdemo.pojo.Hotel;
import com.onenewcode.esdemo.pojo.HotelDoc;
import com.onenewcode.esdemo.service.impl.HotelService;
import org.elasticsearch.client.RequestOptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

/**
 * @author 29071
 * @version 1.0
 * @data 2023/11/20 8:57
 */
@SpringBootTest
 class HotelDocumentTest {
    @Autowired
    private ElasticsearchClient esClient;
    @Autowired
    HotelService hotelService;
//    添加文档
    @Test
    void testAddDocument() throws IOException {
        // 1.查询数据库hotel数据
        Hotel hotel = hotelService.getById(61083L);
        // 2.转换为HotelDoc
        HotelDoc hotelDoc = new HotelDoc(hotel);
        IndexResponse response = esClient.index(i -> i
                .index("hotel")
                .id(hotelDoc.getId().toString())
                .document(hotelDoc)
        );
    }
// 获取文档
    @Test
    void testGetDocumentById() throws IOException {
        GetResponse<HotelDoc> response = esClient.get(g -> g
                        .index("hotel") //选择索引库
                        .id("61083"),
                HotelDoc.class //选择查询对象的映射
        );

        if (response.found()) {
            //获取结果
            HotelDoc hotelDoc = response.source();
            System.out.println("查询结果"+hotelDoc);
        } else {
            System.out.println("未查询到数据");
        }
    }
// 删除文档
    @Test
    void testDeleteDocumentById() throws IOException {
        esClient.delete(d -> d.index("hotel").id("61083"));
    }
//更新。java api支持又一个
    @Test
    void testUpdateById() throws IOException {
        // 1.查询数据库hotel数据
        Hotel hotel = hotelService.getById(61083L);
        // 2.转换为HotelDoc
        HotelDoc hotelDoc = new HotelDoc(hotel);
//        HotelDoc hotelDoc=new HotelDoc();
        esClient.update(u -> u
                        .index("hotel")
                        .id("61083")
                        .upsert(hotelDoc),
                HotelDoc.class
        );

    }

    @Test
    void testBulkRequest() throws IOException {
        // 查询所有的酒店数据
        List<Hotel> list = hotelService.list();
        // 循环遍历
        list.forEach(i->//循环闭包
        {
            try {//捕捉异常
                esClient.index(
                        x-> x.index("hotel").id(i.getId().toString())
                                .document(new HotelDoc(i)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
