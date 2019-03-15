package com.panshi.ProjectJpa.Domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeptRespository extends JpaRepository<Dept, Integer>{

	public Dept findByDeptno(String deptno);

	//多表关联分页
	@Query(value="select t_dept.deptname,t_dept.deptno,t_member.`name`,t_member.position from t_dept "
			+ "LEFT JOIN t_member on t_dept.id=t_member.dept_id where t_member.name like %?1%",
			countQuery="select count(1) from t_dept LEFT JOIN t_member on t_dept.id=t_member.dept_id  where t_member.name like %?1%",nativeQuery=true)
	public Page<Object[]> getDeptPageByLike(String name, Pageable pageable);
}
