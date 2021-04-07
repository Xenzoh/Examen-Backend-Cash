package com.init.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.init.api.dao.UserDAO;
import com.init.api.entidades.User;

@RestController
@RequestMapping("users")
public class UsersServices {

	@Autowired
	private UserDAO userDao;
	
	@GetMapping
	public ResponseEntity< List<User>> getUsers(){
		
		List<User> usuarios=userDao.findAll();
		
		return ResponseEntity.ok(usuarios);
	}
	
	@RequestMapping
	public ResponseEntity<User> getUserById(@RequestParam Long userId){
		
		Optional<User> usuario=userDao.findById(userId);
		
		if(usuario.isPresent()) {
			
			return ResponseEntity.ok(usuario.get());
			
		}else {
			
			return ResponseEntity.noContent().build();
			
		}
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User usuario){
		
		User newUser=userDao.save(usuario);
		
		return ResponseEntity.ok(newUser);
		
	}
	
	@DeleteMapping(value="{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId){
		
		userDao.deleteById(userId);
		
		return ResponseEntity.ok(null);
		
	}
}
