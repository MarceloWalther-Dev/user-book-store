package br.com.livraria.microservico.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.livraria.microservico.model.Address;
import br.com.livraria.microservico.model.UserEntity;

public class UserEntityDTO {

	private Long id;
	private String name;
	private Integer age;
	private Address address;

	public UserEntityDTO(UserEntity user) {
		this.id = user.getId();
		this.name = user.getName();
		this.age = user.getAge();
		this.address = user.getAddress();
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public static List<UserEntityDTO> convert(List<UserEntity> users) {
		return users.stream().map(UserEntityDTO ::new).collect(Collectors.toList());
	}

	public UserEntityDTO convertToDto(UserEntity users) {
		return new UserEntityDTO(users);
	}

}
