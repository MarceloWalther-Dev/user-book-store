package br.com.livraria.microservico.repository;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.livraria.microservico.model.Address;
import br.com.livraria.microservico.model.UserEntity;
import javassist.NotFoundException;

@RunWith(SpringRunner.class)
public class UserRepositoryTest {
	
	@MockBean
	private UserRepository mockRepository;
	
	@Test
	public void retornaUmUserEntityPesquisadoPorId() {
		UserEntity userEntity = createdUserEntity();
		
		when(mockRepository.findById(1L)).thenReturn(Optional.of(userEntity));
		
		UserEntity user = userEntity;
		Assert.assertNotNull(user);
		Assert.assertTrue(user.getName().equalsIgnoreCase("Marcelo"));
	}
	
	@Test
	public void naoDeveriaRetornarNenhumUsuarioSeOIdPassadoNaoExistirNoBanco() {
		try {
			when(mockRepository.findById(20L)).thenThrow(NotFoundException.class);
			
		} catch (Exception e) {}
	}

	
	
	
	
	
	
	
	
	
	private UserEntity createdUserEntity() {
		UserEntity entity = new UserEntity(1L,"Marcelo",33,11111111111L,
				new Address(1L,"testMock","districtMock", 43));
		return entity;

	}
}
