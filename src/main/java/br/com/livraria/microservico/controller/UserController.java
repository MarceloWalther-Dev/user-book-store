package br.com.livraria.microservico.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.livraria.microservico.dto.UserEntityDTO;
import br.com.livraria.microservico.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService; //poderia usar @Autowired
	
	public UserController(UserService userService) {
		this.userService = userService;	
	}
	
	@GetMapping
	public ResponseEntity<List<UserEntityDTO>> list(){
		List<UserEntityDTO> list = userService.list();
		return ResponseEntity.ok().body(list);
	}
	
}
