package com.example.SpringBootEs.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2020/1/4 15:55
 * @work //TODO
 */
@Getter
@Setter
@Document(indexName = "shop", type = "product")
public class ProductEs implements Serializable {


    private static final long serialVersionUID = -4112699790892944078L;


    @Id
    private String id;

    private String productName;

    private Long count;
}
