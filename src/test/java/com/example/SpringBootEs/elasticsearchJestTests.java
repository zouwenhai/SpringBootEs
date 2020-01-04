package com.example.SpringBootEs;

import com.alibaba.fastjson.JSONObject;
import com.example.SpringBootEs.dao.EmployeeRepository;
import com.example.SpringBootEs.entity.EmployeeEs;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2019/11/14 19:55
 * @work //TODO
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootEsApplication.class)
public class elasticsearchJestTests {

    @Autowired
    EmployeeRepository employeeRepository;


    @Test
    public void testInsert() {

        EmployeeEs employeeEs = new EmployeeEs();
        employeeEs.setId(6L);
        employeeEs.setFirstName("cc");
        employeeEs.setLastName("zhao");
        employeeEs.setAge(26L);
        employeeEs.setAbout("I love to go rock climbing");
        List<String> str = Arrays.asList("sports", "music");
        String interest = JSONObject.toJSONString(str);
        employeeEs.setInterests(interest);
        employeeRepository.index(employeeEs);

    }


}
