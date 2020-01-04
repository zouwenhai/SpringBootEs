package com.example.SpringBootEs.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2019/12/25 11:01
 * @work //TODO
 */
@Getter
@Setter
@Document(indexName = "megacorp", type = "employee")
public class EmployeeEs implements Serializable {


    private static final long serialVersionUID = 6166136006944519431L;


    @Id
    private Long id;

    @Field(type = FieldType.Text)
    private String firstName;

    @Field(type = FieldType.Text)
    private String lastName;

    @Field(type = FieldType.Long)
    private Long age;

    @Field(type = FieldType.Text)
    private String about;

    @Field(type = FieldType.Text)
    private String interests;
}
