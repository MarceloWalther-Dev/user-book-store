package br.com.livraria.microservico.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.livraria.microservico.dto.UserEntityDTO;
import br.com.livraria.microservico.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository repository; // poderia ser @Autowired
	
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	//get
	public List<UserEntityDTO> list(){
		return UserEntityDTO.convert(repository.findAll());
	}
	
}
