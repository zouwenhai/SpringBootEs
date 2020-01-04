package com.example.SpringBootEs.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.SpringBootEs.dao.EmployeeRepository;
import com.example.SpringBootEs.entity.EmployeeEs;
import com.example.SpringBootEs.entity.ProductEs;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2020/1/4 10:36
 * @work //TODO
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;


    @RequestMapping("/insert")
    public String save() {

        EmployeeEs employeeEs = new EmployeeEs();
        employeeEs.setId(6L);
        employeeEs.setFirstName("cc");
        employeeEs.setLastName("zhao");
        employeeEs.setAge(26L);
        employeeEs.setAbout("I love to go rock climbing");
        List<String> str = Arrays.asList("sports", "music");
        String interest = JSONObject.toJSONString(str);
        employeeEs.setInterests(interest);
        employeeEs = employeeRepository.index(employeeEs);
        return JSONObject.toJSONString(employeeEs);
    }

    @RequestMapping("/get")
    public String get() {
        //queryBuilder（查询条件）是通过QueryBuilders来构建
        QueryBuilder queryBuilder = QueryBuilders.termQuery("id", 1);
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder().withQuery(queryBuilder);
        SearchQuery searchQuery = builder.build();
        //查询数据的SearchQuery一般通过NativeSearchQueryBuilder来构建
        Page<EmployeeEs> page = employeeRepository.search(searchQuery);
        return JSONObject.toJSONString(page);
    }

    @RequestMapping("/saveProduct")
    public String saveProduct() {
        ProductEs productEs = new ProductEs();
        productEs.setId("1");
        productEs.setCount(100L);
        productEs.setProductName("巧克力");
        //保存数据的IndexQuery通过IndexQueryBuilder来构建
        IndexQuery indexQuery = new IndexQueryBuilder().withId(productEs.getId()).withObject(productEs).build();
        return elasticsearchTemplate.index(indexQuery);
    }

    @RequestMapping("/getProduct")
    public String getProduct() {
        QueryBuilder queryBuilder = QueryBuilders.termQuery("id", "1");
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        List<ProductEs> productEs = elasticsearchTemplate.queryForList(searchQuery, ProductEs.class);
        return JSONObject.toJSONString(productEs);
    }


}
