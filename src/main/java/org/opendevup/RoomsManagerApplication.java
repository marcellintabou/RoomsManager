package org.opendevup;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.opendevup.dao.ImmeubleRepository;
import org.opendevup.dao.RoleRepository;
import org.opendevup.dao.UserRepository;
import org.opendevup.entities.Immeuble;
import org.opendevup.entities.Role;
import org.opendevup.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RoomsManagerApplication {

	public static void main(String[] args) throws ParseException{
		ApplicationContext ctx = SpringApplication.run(RoomsManagerApplication.class, args);
		ImmeubleRepository immeubleRepository = ctx.getBean(ImmeubleRepository.class);
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		RoleRepository roleRepository = ctx.getBean(RoleRepository.class);
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		//On enregistre deux roles
		Role r1 = roleRepository.save(new Role("ADMIN", "L'utilisateur ayant ce privillège peut tout faire dans le système"));
		Role r2 = roleRepository.save(new Role("USER", "L'utilisateur ayant ce privillège peut faire certaines taches dans le système"));
		//On enregistre un utilisateur
		User u = userRepository.save(new User("BOSS", "BOSSPASS", true));
		userRepository.flush();
		u.getRoles().add(r1);
		u.getRoles().add(r2);
		//On enregistre l'utilisateur
		userRepository.save(u);
		
		//immeubleRepository.save(new Immeuble("A", new Date(), null, null, null)); 
		//immeubleRepository.save(new Immeuble("B", new Date(), null, null, null)); 
	}
}
