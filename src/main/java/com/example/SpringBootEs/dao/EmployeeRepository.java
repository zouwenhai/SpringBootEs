package com.example.SpringBootEs.dao;

import com.example.SpringBootEs.entity.EmployeeEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2019/10/27 16:02
 * @work //TODO
 */
@Repository
public interface EmployeeRepository extends ElasticsearchRepository<EmployeeEs, Long> {


}
