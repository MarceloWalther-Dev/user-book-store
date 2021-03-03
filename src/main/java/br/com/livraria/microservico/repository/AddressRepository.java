package br.com.livraria.microservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.livraria.microservico.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
