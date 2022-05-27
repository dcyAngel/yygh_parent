package cn.dcy.yygh.hosp.repository;

import cn.dcy.yygh.model.hosp.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department,String> {
    //根据医院编号和科室编号进行查询
    Department getDepartmentByHoscodeAndDepcode(String hoscode, String depcode);
}
