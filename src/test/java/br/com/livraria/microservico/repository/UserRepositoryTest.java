package br.com.livraria.microservico.repository;

import static org.mockito.Mockito.mock;
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
		Assert.assertEquals(user.getId(), Long.valueOf(1L));
		Assert.assertTrue(user.getName().equalsIgnoreCase("Marcelo"));
		Assert.assertEquals(user.getAge(), Integer.valueOf(33));
		Assert.assertEquals(user.getCpf(), Long.valueOf(11111111111L));
		Assert.assertEquals(user.getAddress().getId(), Long.valueOf(1L));
		Assert.assertTrue(user.getAddress().getStreet().equalsIgnoreCase("testMock"));
		Assert.assertTrue(user.getAddress().getDistrict().equalsIgnoreCase("districtMock"));
		Assert.assertEquals(user.getAddress().getNumber(), Integer.valueOf(43));
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
		Assert.assertNotNull(userEntity);
		Assert.assertEquals(user.getId(), Long.valueOf(1L));
		Assert.assertTrue(user.getName().equalsIgnoreCase("Marcelo"));
		Assert.assertEquals(user.getAge(), Integer.valueOf(33));
		Assert.assertEquals(user.getCpf(), Long.valueOf(11111111111L));
		Assert.assertEquals(user.getAddress().getId(), Long.valueOf(1L));
		Assert.assertTrue(user.getAddress().getStreet().equalsIgnoreCase("testMock"));
		Assert.assertTrue(user.getAddress().getDistrict().equalsIgnoreCase("districtMock"));
		Assert.assertEquals(user.getAddress().getNumber(), Integer.valueOf(43));
		
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
}
