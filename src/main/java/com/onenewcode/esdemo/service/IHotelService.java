package com.onenewcode.esdemo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.onenewcode.esdemo.pojo.Hotel;
import com.onenewcode.esdemo.pojo.PageResult;
import com.onenewcode.esdemo.pojo.RequestParams;
/**
 * @author 29071
 * @version 1.0
 * @data 2023/11/19 16:42
 */
public interface IHotelService extends IService<Hotel> {
    PageResult search(RequestParams params);
}
