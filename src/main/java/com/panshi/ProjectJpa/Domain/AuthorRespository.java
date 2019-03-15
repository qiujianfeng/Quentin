package com.panshi.ProjectJpa.Domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorRespository extends JpaRepository<Author, Integer>{
	
	//1、格式：find + 限定词 + By + 实体属性名称 + 限定词或连接词 + 其他属性名称 + OrderBy + 排序属性 + 排序方向
	public List<Author> findByNickAndPhoneOrderBySignDateDesc(String nick,String phone);
	
	public List<Author> findByNickLike(String nick);
	
	
	//2、格式：jpql语句
	@Query("select a from Author a where a.nick like %?1%")
	public List<Author> findArray(String nickName,Sort sort);
	
	//3、格式：sql语句
	@Query(value = "select * from t_author where nick_name like %?1%",nativeQuery=true)
	public List<Author> findBySql(String nickName);
	
	
	
	//4、更新 
	@Transactional
	@Modifying    //update、delete必须在事务下执行，必须使用Modifying注解
	@Query(value = "update t_author set phone = ?1 where id = ?2",nativeQuery=true)
	public int updateAuthor(String phone,Integer id);
	
	//5、分页
	@Query(value="select * from t_author",countQuery="select count(1) from t_author",nativeQuery=true)
	public Page<Author> getAuthorPage(Pageable pageable);
	
}
