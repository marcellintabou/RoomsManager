package org.opendevup.dao;

import org.opendevup.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String>{
	//public Role save(Role role);
}
