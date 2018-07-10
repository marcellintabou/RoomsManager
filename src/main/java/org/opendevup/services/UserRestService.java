package org.opendevup.services;

import java.util.Collection;
import java.util.List;

import org.opendevup.dao.RoleRepository;
import org.opendevup.dao.UserRepository;
import org.opendevup.entities.Role;
import org.opendevup.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Secured(value={"ROLE_BOSS"})
@RequestMapping(value="/api")
public class UserRestService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	/**
	 * Web service for getting all the Users in the application.
	 * 
	 * @return list of all User
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/users", method=RequestMethod.GET)
	private List<User> users(){
		return userRepository.findAll();
	}
	
	/**
	 * Web service for getting a User by his ID.
	 * @param id
	 * 		User ID
	 * @return User
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	private ResponseEntity<User> userById(@PathVariable Long id){
		User u = userRepository.findOne(id);
		if (u == null){
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}else{
			return new ResponseEntity<User>(HttpStatus.OK);
		}
	}
	
	/**
	 * Web service for getting a User by his USERNAME.
	 * @param username
	 * 		User USERNAME
	 * @return User
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/users/{username}", method=RequestMethod.GET)
	private ResponseEntity<User> userByUsername(@PathVariable String username){
		User u = userRepository.findOneByUsername(username);
		if (u == null){
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}else{
			return new ResponseEntity<User>(HttpStatus.OK);
		}
	}
	
	/**
	 * Web service for deleting a User by his ID.
	 * @param id
	 * 		User ID
	 * @return User
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	private ResponseEntity<User> deleteUser(@PathVariable Long id){
		User u = userRepository.findOne(id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUsername = auth.getName();
		
		if (u == null){
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}else if (u.getUsername().equals(loggedUsername)){
			throw new RuntimeException("You cannot delete your account");
		} else {
			userRepository.delete(u);
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}
	}
	
	
	/**
	 * Web service for deleting a User by his USERNAME.
	 * @param username
	 * 		User USERNAME
	 * @return User
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/users/{username}", method=RequestMethod.DELETE)
	private ResponseEntity<User> deleteUser(@PathVariable String username){
		User u = userRepository.findOneByUsername(username);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUsername = auth.getName();
		
		if (u == null){
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}else if (u.getUsername().equals(loggedUsername)){
			throw new RuntimeException("You cannot delete your account");
		} else {
			userRepository.delete(u);
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}
	}
	
	
	/**
	 * Method for adding a User
	 * 
	 * @param User
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/users", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user){
		if(userRepository.findOneByUsername(user.getUsername()) != null){
			throw new RuntimeException("Username already exist");
		}
		return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
	}
	
	/**
	 * Method for editing an User details
	 * 
	 * @param User
	 * @return modified User
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/users", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user){
		if(userRepository.findOneByUsername(user.getUsername()) != null
				&& userRepository.findOneByUsername(user.getUsername()).getIdUser() != user.getIdUser()){
			throw new RuntimeException("Username already exist");
		}
		return userRepository.save(user);
	}
	 
	/**
	 * Web service for getting all the Roles in the application.
	 * 
	 * @return list of all Role
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/roles", method=RequestMethod.GET)
	private List<Role> roles(){
		return roleRepository.findAll();
	}
	
	/**
	 * Web service for getting a Role by his rolename.
	 * @param rolename
	 * 		Role ROLENAME
	 * @return Role
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/roles/{rolename}", method=RequestMethod.GET)
	private ResponseEntity<Role> roleByRolename(@PathVariable String rolename){
		Role r = roleRepository.findOne(rolename);
		if (r == null){
			return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
		}else{
			return new ResponseEntity<Role>(HttpStatus.OK);
		}
	}
	
	/**
	 * Web service for deleting a Role by his rolename.
	 * @param rolename
	 * 		Role ROLE
	 * @return Role
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/roles/{rolename}", method=RequestMethod.DELETE)
	private ResponseEntity<Role> deleteRole(@PathVariable String rolename){
		Role r = roleRepository.findOne(rolename);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (r == null){
			return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
		}else if (auth.getAuthorities().contains(r)){
			throw new RuntimeException("You cannot delete your Authority");
		} else {
			roleRepository.delete(r);
			return new ResponseEntity<Role>(r, HttpStatus.OK);
		}
	}
	
	/**
	 * Method for adding a Role
	 * 
	 * @param Role
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/roles", method = RequestMethod.POST)
	public ResponseEntity<Role> createRole(@RequestBody Role role){
		if(roleRepository.findOne(role.getRolename()) != null){
			throw new RuntimeException("Role already exist");
		}
		return new ResponseEntity<Role>(roleRepository.save(role), HttpStatus.CREATED);
	}
	
	/**
	 * Method for editing a Role details
	 * 
	 * @param Role
	 * @return modified Role
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/roles", method = RequestMethod.PUT)
	public Role updateRole(@RequestBody Role role){
		
		if(roleRepository.findOne(role.getRolename()) != null ){
			throw new RuntimeException("Username already exist");
		}
		return roleRepository.save(role);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/addRoleToUser")
	public User addRoleToUser(String username, String rolename){
		
		User u = userRepository.findOneByUsername(username);
		Role r = roleRepository.findOne(rolename);
		if( u == null){
			throw new RuntimeException("Username not found !");
		}else{
			if(r == null){
				throw new RuntimeException("Authority not found");
			}
		}
		Collection<Role> roles = u.getRoles();
		if (roles.contains(r)){
			throw new RuntimeException("The user already have this authority!");
		}
		roles.add(r);
		u.setRoles(roles);
		userRepository.save(u);
		return u;
	}
	

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/removeRoleToUser")
	public User removeRoleToUser(String username, String rolename){
		
		User u = userRepository.findOneByUsername(username);
		Role r = roleRepository.findOne(rolename);
		if( u == null){
			throw new RuntimeException("Username not found !");
		}else{
			if(r == null){
				throw new RuntimeException("Authority not found");
			}
		}
		Collection<Role> roles = u.getRoles();
		if (!roles.contains(r)){
			throw new RuntimeException("The user do not have this authority!");
		}
		roles.remove(r);
		u.setRoles(roles);
		userRepository.save(u);
		return u;
	}
	
	
	/*
	@RequestMapping(value="/addRole")
	private Role save(Role r){
		return roleRepository.save(r);
	}
	
	
	
	@RequestMapping(value="/findRoles")
	private List<Role> findRoles(){
		return roleRepository.findAll();
	}
	
	*/
	
}
