package br.com.livraria.microservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.livraria.microservico.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
