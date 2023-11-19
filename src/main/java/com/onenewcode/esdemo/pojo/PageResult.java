package com.onenewcode.esdemo.pojo;

import lombok.Data;

import java.util.List;
/**
 * @author 29071
 * @version 1.0
 * @data 2023/11/19 16:42
 */
@Data
public class PageResult {
    private Long total;
    private List<HotelDoc> hotels;

    public PageResult() {
    }

    public PageResult(Long total, List<HotelDoc> hotels) {
        this.total = total;
        this.hotels = hotels;
    }
}
