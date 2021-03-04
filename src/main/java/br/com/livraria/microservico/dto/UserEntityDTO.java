package br.com.livraria.microservico.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.livraria.microservico.forms.FormUser;
import br.com.livraria.microservico.model.Address;
import br.com.livraria.microservico.model.UserEntity;
import br.com.livraria.microservico.model.enums.Active;

public class UserEntityDTO {

	private Long id;
	private String name;
	private Integer age;
	private Long cpf;
	private Active status;
	private Address address;
	

	public UserEntityDTO(UserEntity user) { //verificar se necessario
		this.id = user.getId();
		this.name = user.getName();
		this.age = user.getAge();
		this.cpf = user.getCpf();
		this.status = user.getStatus();
		this.address = user.getAddress();
	}

	public UserEntityDTO(FormUser formUser) {
		this.id = formUser.getId();
		this.name = formUser.getName().toUpperCase();
		this.age = formUser.getAge();
		this.cpf = removeMask(formUser.getCpf());
		this.status = formUser.getStatus();
		this.address = formUser.getAddress();
	}
	
	

	public Active getStatus() {
		return status;
	}

	public void setStatus(Active status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static List<UserEntityDTO> convert(List<UserEntity> users) {
		return users.stream().map(UserEntityDTO::new).collect(Collectors.toList());
	}

	public static UserEntityDTO convertToDto(UserEntity users) {
		return new UserEntityDTO(users);
	}

	public UserEntityDTO convertToDTOForm(FormUser formUser) {
		return new UserEntityDTO(formUser);
	}

	public static Long removeMask(String cpf) {
		String cpfFormat = (cpf.replaceAll("\\D", ""));
		Long newCpf = Long.parseLong(cpfFormat);
		return newCpf;
	}

}
