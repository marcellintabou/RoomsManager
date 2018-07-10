package org.opendevup.dao;

import org.opendevup.entities.Categorie;
import org.opendevup.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	//public Role save(Role role);
}
