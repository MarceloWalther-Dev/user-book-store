package br.com.livraria.microservico.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.livraria.microservico.model.UserEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void deveriaCarregarUmUsuarioAoBuscarPeloCpf() {
		Long cpf = 11111122257L;
		UserEntity user = userRepository.findByCpf(cpf).get();
		
		Assert.assertNotNull(user);
		Assert.assertEquals(cpf, user.getCpf());
	}
	
	@Test
	public void deveriaCarregarUmUsuarioAoBuscarPeloID() {
		Long id = 5L;
		Integer numeroCasa = 43;
		
		UserEntity user = userRepository.findById(id).get();
		
		
		Assert.assertNotNull(user);
		Assert.assertEquals(numeroCasa, user.getAddress().getNumber());
	}
	
	
}
