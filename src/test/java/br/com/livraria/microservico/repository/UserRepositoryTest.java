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
		UserEntity user = userEntity;
		
		when(mockRepository.findById(1L)).thenReturn(Optional.of(userEntity));
		
		assertUser(userEntity, user);
	}
	
	@Test
	public void naoDeveriaRetornarNenhumUsuarioSeOIdPassadoNaoExistirNoBanco() {
		try {
			when(mockRepository.findById(Mockito.any())).thenThrow(NotFoundException.class);
		} catch (Exception e) {}
	}

	@Test
	public void retornaOptionalDeUserEntityBuscadoPeloCpf() {
		UserEntity userEntity = createdUserEntity();
		UserEntity user = userEntity;
		
		when(mockRepository.findByCpf(userEntity.getCpf())).thenReturn(Optional.of(userEntity));
		assertUser(userEntity, user);
	}

	@Test
	public void naoDeveriaRetornarNenhumUsuarioSeOCpfPassadoNaoExistirNoBanco() {
		try {
			when(mockRepository.findByCpf(Mockito.any())).thenThrow(NotFoundException.class);
		} catch (Exception e) {}
	}

	
	
	
	private UserEntity createdUserEntity() {
		UserEntity entity = new UserEntity(1L,"Marcelo",33,11111111111L,
				new Address(1L,"testMock","districtMock", 43));
		return entity;

	}
		
	private void assertUser(UserEntity userEntity, UserEntity user) {
		Assert.assertNotNull(userEntity);
		Assert.assertEquals(user.getId(), userEntity.getId());
		Assert.assertTrue(user.getName().equalsIgnoreCase(userEntity.getName()));
		Assert.assertEquals(user.getAge(), userEntity.getAge());
		Assert.assertEquals(user.getCpf(), userEntity.getCpf());
		Assert.assertEquals(user.getAddress().getId(), userEntity.getAddress().getId());
		Assert.assertTrue(user.getAddress().getStreet().equalsIgnoreCase(userEntity.getAddress().getStreet()));
		Assert.assertTrue(user.getAddress().getDistrict().equalsIgnoreCase(userEntity.getAddress().getDistrict()));
		Assert.assertEquals(user.getAddress().getNumber(), userEntity.getAddress().getNumber());
	}
	
	
	
}
