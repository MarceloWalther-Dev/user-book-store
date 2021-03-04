package br.com.livraria.microservico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.livraria.microservico.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	  Optional<UserEntity> findByCpf(Long cpf);
	  Optional<UserEntity> findByAddress_District(String address);
}
