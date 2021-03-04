package br.com.livraria.microservico.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.livraria.microservico.dto.UserEntityDTO;
import br.com.livraria.microservico.exception.ClientNotFoundException;
import br.com.livraria.microservico.forms.FormUser;
import br.com.livraria.microservico.model.Address;
import br.com.livraria.microservico.model.UserEntity;
import br.com.livraria.microservico.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository repository; // poderia ser @Autowired
	
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	//get todos
	public List<UserEntityDTO> list(){
		return UserEntityDTO.convert(repository.findAll());
	}
	
	//getcpf
	public UserEntityDTO findByCpf(String cpf) throws ClientNotFoundException {
		Long cpfFormat = Long.parseLong(cpf);
		return UserEntityDTO.convertToDto(repository.findByCpf(cpfFormat).orElseThrow(
				()-> new ClientNotFoundException("Client não encontrado. Verifique por favor")));
	}
	
	//getUserAddress
	public UserEntityDTO findByAddressDistrict(String address) throws ClientNotFoundException {		
		return UserEntityDTO.convertToDto(repository.findByAddress_District(address).orElseThrow(
				()-> new ClientNotFoundException("Client não encontrado. Verifique por favor")));
	}
	
	//post
	public UserEntityDTO save(FormUser formUser) {
		UserEntity userEntity = convertFormUserForUserEntity(formUser);
		repository.save(userEntity);
		return new UserEntityDTO(userEntity);
	}

	//delete
	public void delete(Long id) throws ClientNotFoundException {
		UserEntity userEntity = repository.findById(id).orElseThrow(
				() -> new ClientNotFoundException("Client não encontrado. Verifique por favor"));
		repository.deleteById(userEntity.getId());
	}
	
	//put
	public UserEntityDTO update(FormUser formUser) throws ClientNotFoundException {
		UserEntity user = repository.findById(formUser.getId()).orElseThrow(
				() -> new ClientNotFoundException("Client não encontrado. Verifique por favor"));
		putUserAndAddress(formUser, user);
		return new UserEntityDTO(user);		
	}

	
	//metodo criado para atualizar o user e o endereco
	private void putUserAndAddress(FormUser formUser, UserEntity user) {
		Address address = new Address();
		address.setId(user.getAddress().getId());
		address.setStreet(formUser.getAddress().getStreet());
		address.setDistrict(formUser.getAddress().getDistrict());
		address.setNumber(formUser.getAddress().getNumber());
		
		user.setId(formUser.getId());
		user.setName(formUser.getName());
		user.setAge(formUser.getAge());
		Long cpfRemoveMask = UserEntityDTO.removeMask(formUser.getCpf());
		
		user.setCpf(cpfRemoveMask);
				
		user.setAddress(address);
		
		repository.save(user);
	}
	
	//criado metodo para converter um formulario para entity
	private UserEntity convertFormUserForUserEntity(FormUser formUser) {
		UserEntityDTO userDTO = new UserEntityDTO(formUser);
		UserEntity userEntity = new UserEntity(userDTO.getName(),userDTO.getAge(),userDTO.getCpf(),userDTO.getAddress());
		return userEntity;
	}

}
