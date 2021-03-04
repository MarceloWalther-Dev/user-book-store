package br.com.livraria.microservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.livraria.microservico.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
