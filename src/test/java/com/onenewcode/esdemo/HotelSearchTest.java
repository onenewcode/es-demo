package com.onenewcode.esdemo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MultiMatchQuery;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import co.elastic.clients.elasticsearch.core.search.TotalHitsRelation;
import com.alibaba.fastjson.JSON;
import com.onenewcode.esdemo.pojo.HotelDoc;
import org.elasticsearch.client.RequestOptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 29071
 * @version 1.0
 * @data 2023/11/20 8:59
 */
@SpringBootTest
class HotelSearchTest {

    @Autowired
    private ElasticsearchClient esClient;

    @Test
    void testMatchAll() throws IOException {
//进行查询
        SearchResponse<HotelDoc> response = esClient.search(s -> s
                        .index("hotel")
                        .query(q -> q
                                .matchAll(new MatchAllQuery.Builder().build())),
                HotelDoc.class
        );
        // 获取命中结果
        List<Hit<HotelDoc>> hits = response.hits().hits();
        for (Hit<HotelDoc> hit: hits) {
            HotelDoc product = hit.source();
            System.out.println("Found product " + product + ", score " + hit.score());
        }
    }

    @Test
    void testMatch() throws IOException {
//        MultiMatchQuery multiMatchQuery=new MultiMatchQuery.Builder().
//        SearchResponse<HotelDoc> response = esClient.search(i->i
//                .index("hotel")
//                .query(),
//                HotelDoc.class
        );

//        // 2.准备请求参数
//        // request.source().query(QueryBuilders.matchQuery("all", "外滩如家"));
//        request.source().query(QueryBuilders.multiMatchQuery("外滩如家", "name", "brand", "city"));
//        // 3.发送请求，得到响应
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        // 4.结果解析
//        handleResponse(response);
    }
//
//    @Test
//    void testBool() throws IOException {
//        // 1.准备request
//        SearchRequest request = new SearchRequest("hotel");
//        // 2.准备请求参数
//       /*
//         BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
//        // 2.1.must
//        boolQuery.must(QueryBuilders.termQuery("city", "杭州"));
//        // 2.2.filter
//        boolQuery.filter(QueryBuilders.rangeQuery("price").lte(250));
//        */
//
//        request.source().query(
//                QueryBuilders.boolQuery()
//                        .must(QueryBuilders.termQuery("city", "杭州"))
//                        .filter(QueryBuilders.rangeQuery("price").lte(250))
//        );
//        // 3.发送请求，得到响应
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        // 4.结果解析
//        handleResponse(response);
//    }
//
//    @Test
//    void testSortAndPage() throws IOException {
//        int page = 2,size = 5;
//
//        // 1.准备request
//        SearchRequest request = new SearchRequest("hotel");
//        // 2.准备请求参数
//        // 2.1.query
//        request.source()
//                .query(QueryBuilders.matchAllQuery());
//        // 2.2.排序sort
//        request.source().sort("price", SortOrder.ASC);
//        // 2.3.分页 from\size
//        request.source().from((page - 1) * size).size(size);
//
//        // 3.发送请求，得到响应
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        // 4.结果解析
//        handleResponse(response);
//    }
//
//    @Test
//    void testHighlight() throws IOException {
//        // 1.准备request
//        SearchRequest request = new SearchRequest("hotel");
//        // 2.准备请求参数
//        // 2.1.query
//        request.source().query(QueryBuilders.matchQuery("all", "外滩如家"));
//        // 2.2.高亮
//        request.source().highlighter(new HighlightBuilder().field("name").requireFieldMatch(false));
//        // 3.发送请求，得到响应
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        // 4.结果解析
//        handleResponse(response);
//    }
//
//    private void handleResponse(SearchResponse response) {
//        SearchHits searchHits = response.getHits();
//        // 4.1.总条数
//        long total = searchHits.getTotalHits().value;
//        System.out.println("总条数：" + total);
//        // 4.2.获取文档数组
//        SearchHit[] hits = searchHits.getHits();
//        // 4.3.遍历
//        for (SearchHit hit : hits) {
//            // 4.4.获取source
//            String json = hit.getSourceAsString();
//            // 4.5.反序列化，非高亮的
//            HotelDoc hotelDoc = JSON.parseObject(json, HotelDoc.class);
//            // 4.6.处理高亮结果
//            // 1)获取高亮map
//            Map<String, HighlightField> map = hit.getHighlightFields();
//            // 2）根据字段名，获取高亮结果
//            HighlightField highlightField = map.get("name");
//            // 3）获取高亮结果字符串数组中的第1个元素
//            String hName = highlightField.getFragments()[0].toString();
//            // 4）把高亮结果放到HotelDoc中
//            hotelDoc.setName(hName);
//            // 4.7.打印
//            System.out.println(hotelDoc);
//        }
//    }
}
