package br.com.livraria.microservico.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.livraria.microservico.dto.UserEntityDTO;
import br.com.livraria.microservico.exception.ClientNotFoundException;
import br.com.livraria.microservico.forms.FormUser;
import br.com.livraria.microservico.model.UserEntity;
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
	
	//post
	public UserEntityDTO save(FormUser formUser) {
		UserEntity userEntity = convertFormUserForUserEntity(formUser);
		repository.save(userEntity);
		return new UserEntityDTO(userEntity);
	}

	
	
	
	//criado metodo para converter um formulario para entity
	private UserEntity convertFormUserForUserEntity(FormUser formUser) {
		UserEntityDTO userDTO = new UserEntityDTO(formUser);
		UserEntity userEntity = new UserEntity(userDTO.getName(),userDTO.getAge(),userDTO.getCpf(),userDTO.getAddress());
		return userEntity;
	}

	public void delete(Long id) throws ClientNotFoundException {
		UserEntity userEntity = repository.findById(id).orElseThrow(
				() -> new ClientNotFoundException("Client não encontrado. Verifique por favor"));
		repository.deleteById(userEntity.getId());
	}
	
}
