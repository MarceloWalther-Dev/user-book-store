package br.com.livraria.microservico.forms;

import br.com.livraria.microservico.model.Address;
import br.com.livraria.microservico.model.enums.Active;

public class FormUser {

	private Long id;
	private String name;
	private Integer age;
	private String cpf;
	private Active status;

	private Address address;

	public FormUser() {}

	public FormUser(String name, int age, String cpf, Active active, Address address) {
		this.name = name;
		this.age = age;
		this.cpf = cpf;
		this.status = active;
		this.address = address;
	}
	
	

	public FormUser(Long id, String name, Integer age, String cpf, Active status, Address address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.cpf = cpf;
		this.status = status;
		this.address = address;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
