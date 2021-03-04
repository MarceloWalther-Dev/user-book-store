package br.com.livraria.microservico.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//buscar por cpf
	@GetMapping("/{cpf}")
	public ResponseEntity<UserEntityDTO> findByCpf(@PathVariable String cpf) throws ClientNotFoundException{
		UserEntityDTO userDTO = userService.findByCpf(cpf);
		return ResponseEntity.ok().body(userDTO);
	}
	
	//buscar por bairro
	@GetMapping("/district/{address}")
	public ResponseEntity<UserEntityDTO> findByUserAddressDistrict(@PathVariable String address) throws ClientNotFoundException{
		UserEntityDTO userDTO = userService.findByAddressDistrict(address);
		return ResponseEntity.ok().body(userDTO);
	}
	
	@PostMapping
	public ResponseEntity<UserEntityDTO> create(@RequestBody FormUser formUser){
		UserEntityDTO userDTO = userService.save(formUser);
		return new ResponseEntity<UserEntityDTO>(userDTO, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<UserEntityDTO> update(@RequestBody FormUser formUser) throws ClientNotFoundException{
		UserEntityDTO userDTO = userService.update(formUser);
		return new ResponseEntity<UserEntityDTO>(userDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/{id}")
	public List<UserEntityDTO> delete(@PathVariable Long id) throws ClientNotFoundException{
		userService.delete(id);
		return userService.list();
	}
}
