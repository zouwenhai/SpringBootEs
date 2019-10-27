package com.example.SpringBootEs.dao;

import com.example.SpringBootEs.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2019/10/27 16:02
 * @work //TODO
 */
public interface ProductRepository extends ElasticsearchRepository<Product, String> {





}
