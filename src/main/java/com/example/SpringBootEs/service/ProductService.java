package com.example.SpringBootEs.service;

import com.example.SpringBootEs.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2019/10/27 16:17
 * @work //TODO
 */
public interface ProductService {

    long count();

    Product save(Product product);

    void delete(Product product);

    Iterable<Product> getAll();

    List<Product> getByName(String name);

    Page<Product> pageQuery(Integer pageNo, Integer pageSize, String kw);
}
