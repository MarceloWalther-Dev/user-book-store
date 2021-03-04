package br.com.livraria.microservico.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.livraria.microservico.dto.UserEntityDTO;
import br.com.livraria.microservico.exception.ClientNotFoundException;
import br.com.livraria.microservico.forms.FormUser;
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
	
	@PostMapping
	public ResponseEntity<UserEntityDTO> create(@RequestBody FormUser formUser){
		UserEntityDTO userDTO = userService.save(formUser);
		return new ResponseEntity<UserEntityDTO>(userDTO, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/admin/{id}")
	public List<UserEntityDTO> delete(@PathVariable Long id) throws ClientNotFoundException{
		userService.delete(id);
		return userService.list();
	}
}
