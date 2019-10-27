package com.example.SpringBootEs.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Setting;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2019/10/27 15:38
 * @work //TODO
 */
@Getter
@Setter
@Document(indexName = "user")
public class Product implements Serializable {


    private static final long serialVersionUID = 2940138548267455120L;


    @Id
    private Long id;

    private String productName;
    
}
