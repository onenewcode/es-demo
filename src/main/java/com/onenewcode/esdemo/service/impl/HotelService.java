package com.onenewcode.esdemo.service.impl;



import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.onenewcode.esdemo.mapper.HotelMapper;
import com.onenewcode.esdemo.pojo.Hotel;

import com.onenewcode.esdemo.pojo.PageResult;
import com.onenewcode.esdemo.pojo.RequestParams;
import com.onenewcode.esdemo.service.IHotelService;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;


/**
 * @author 29071
 * @version 1.0
 * @data 2023/11/19 16:42
 */
@Slf4j
@Service
public class HotelService extends ServiceImpl<HotelMapper, Hotel> implements IHotelService {

    @Autowired
    private ElasticsearchClient esClient;

    @Override
    public PageResult search(RequestParams params) {
//        GetResponse<Product> response = esClient.get(g -> g
//                        .index("products")
//                        .id("bk-1"),
//                Product.class
//        );
        return null;
    }
}
