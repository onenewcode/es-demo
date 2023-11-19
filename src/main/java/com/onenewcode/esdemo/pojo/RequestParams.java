package com.onenewcode.esdemo.pojo;

import lombok.Data;
/**
 * @author 29071
 * @version 1.0
 * @data 2023/11/19 16:42
 */
@Data
public class RequestParams {
    private String key;
    private Integer page;
    private Integer size;
    private String sortBy;
    private String brand;
    private String city;
    private String starName;
    private Integer minPrice;
    private Integer maxPrice;
    private String location;
}
