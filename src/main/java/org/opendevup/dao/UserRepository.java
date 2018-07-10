package org.opendevup.dao;

import org.opendevup.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	public User findOneByUsername(String username);
}
