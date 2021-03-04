package br.com.livraria.microservico.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import br.com.livraria.microservico.model.enums.Active;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "age", length = 3)
	private Integer age;

	@NotNull
	@Column(name = "cpf", unique = true)
	private Long cpf;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Active status;

	@NotNull
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
	@JoinColumn(name = "address_id")
	private Address address;

	public UserEntity() {
	}

	public UserEntity(String name, Integer age, Long cpf, Address address) {
		this.name = name;
		this.age = age;
		this.cpf = cpf;
		this.address = address;
	}

	public UserEntity(Long id, String name, Integer age, Long cpf, Address address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.cpf = cpf;
		this.address = address;
	}

	public UserEntity(String name, Integer age, Long cpf, Active status, Address address) {
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
		this.name = name.toUpperCase();
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

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getCpf() {
		return cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
