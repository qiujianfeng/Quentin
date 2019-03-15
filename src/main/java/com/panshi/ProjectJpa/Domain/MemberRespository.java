package com.panshi.ProjectJpa.Domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRespository extends JpaRepository<Member, Integer>{

	public Member findByName(String name);
}
