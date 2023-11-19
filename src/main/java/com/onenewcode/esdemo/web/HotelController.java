package com.onenewcode.esdemo.web;

import com.onenewcode.esdemo.pojo.PageResult;
import com.onenewcode.esdemo.pojo.RequestParams;
import com.onenewcode.esdemo.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 * @author 29071
 * @version 1.0
 * @data 2023/11/19 16:42
 */
@RestController
@RequestMapping("hotel")
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @GetMapping("list")
    public PageResult search(@RequestBody RequestParams params) {
        return hotelService.search(params);
    }
}
