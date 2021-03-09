package br.com.livraria.microservico.dto;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.livraria.microservico.forms.FormUser;
import br.com.livraria.microservico.model.Address;
import br.com.livraria.microservico.model.UserEntity;
import br.com.livraria.microservico.model.enums.Active;

public class UserEntityDTOTest {
	
	UserEntityDTO userDto = new UserEntityDTO(new UserEntity(1L,"Marcelo", 33, 1234567891011L, Active.ACTIVE, new Address(1L,"domingos", "ingleses", 43)));
	UserEntityDTO userDto2 = new UserEntityDTO(new UserEntity(4L,"Marcelo2", 34, 121314151617L, Active.NOT_ACTIVE, new Address(2L,"domingos2", "ingleses2", 432)));
	UserEntityDTO userDto3 = new UserEntityDTO(new UserEntity(3L,"Marcelo3", 35, 121314151633L, Active.PENDING, new Address(3L,"domingos3", "ingleses3", 433)));
	
	UserEntity user = new UserEntity(1L,"Marcelo", 33, 1234567891011L, Active.ACTIVE, new Address("domingos", "ingleses", 43));
	UserEntity user2 = new UserEntity(2L,"Usuario2",43,1110987654321L, Active.NOT_ACTIVE, new Address("RuaVazia","BairroVazio", 58));
	
	List<UserEntity> listUser = new ArrayList<UserEntity>();
	List<UserEntityDTO> listDto = new ArrayList<UserEntityDTO>();

	@Test
	public void testGetStatus() {
		Assert.assertEquals(userDto.getStatus(), Active.ACTIVE);
	}

	@Test
	public void testSetStatus() {
		userDto.setStatus(Active.NOT_ACTIVE);
		Assert.assertEquals(userDto.getStatus(), Active.NOT_ACTIVE);
	}
	
	@Test
	public void testStatusNotNull() {
		Assert.assertNotNull(userDto.getStatus());
	}
	
	@Test
	public void testStatusNotEquals() {
		Assert.assertNotEquals(userDto.getStatus(), Active.NOT_ACTIVE);
	}
	
	

	
	@Test
	public void testGetId() {
		Assert.assertEquals(userDto.getId(), Long.valueOf(1L));
	}

	@Test
	public void testSetId() {
		userDto.setId(2L);
		Assert.assertEquals(userDto.getId(), Long.valueOf(2L));
	}
	
	@Test
	public void testIdNotNull() {
		Assert.assertNotNull(userDto.getId());
	}
	
	@Test
	public void testIdNotEquals() {
		Assert.assertNotEquals(userDto.getId(), Long.valueOf(2L));
	}
	
	
	
	
	@Test
	public void testGetName() {
		Assert.assertTrue(userDto.getName().equalsIgnoreCase("Marcelo"));
	}

	@Test
	public void testSetName() {
		userDto.setName("SemNome");
		Assert.assertTrue(userDto.getName().equalsIgnoreCase("SeMnOme"));
	}
	
	@Test
	public void testNameNotNull() {
		Assert.assertNotNull(userDto.getName());
	}
	
	@Test
	public void testNameNotEquals() {
		Assert.assertNotEquals(userDto.getName(), "testando");
	}
	
	
	

	@Test
	public void testGetAge() {
		Assert.assertEquals(userDto.getAge(), Integer.valueOf(33));
	}

	@Test
	public void testSetAge() {
		userDto.setAge(32);
		Assert.assertEquals(userDto.getAge(), Integer.valueOf(32));
	}

	@Test
	public void testAgeNotNull() {
		Assert.assertNotNull(userDto.getAge());
	}
	
	@Test
	public void testAgeNotEquals() {
		Assert.assertNotEquals(userDto.getAge(), Integer.valueOf(59));
	}
	
	
	
	
	@Test
	public void testGetCpf() {
		Assert.assertEquals(userDto.getCpf(), Long.valueOf(1234567891011L));
	}

	@Test
	public void testSetCpf() {
		userDto.setCpf(123L);
		Assert.assertEquals(userDto.getCpf(), Long.valueOf(123L));
	}
	
	@Test
	public void testCpfNotNull() {
		Assert.assertNotNull(userDto.getCpf());		
	}

	@Test
	public void testCpfNotEquals() {
		Assert.assertNotEquals(userDto.getCpf(), Long.valueOf(123456L));
	}
	
	

	@Test
	public void testGetAddress() {
		Assert.assertEquals(userDto.getAddress().getId(), Long.valueOf(1L));
		Assert.assertTrue(userDto.getAddress().getStreet().equalsIgnoreCase("DomInGoS"));
		Assert.assertTrue(userDto.getAddress().getDistrict().equalsIgnoreCase("InglEses"));
		Assert.assertEquals(userDto.getAddress().getNumber(), Integer.valueOf(43));
	}

	@Test
	public void testSetAddress() {
		userDto.getAddress().setId(3L);
		userDto.getAddress().setStreet("SemRua");
		userDto.getAddress().setDistrict("SemBairro");
		userDto.getAddress().setNumber(99);
		
		Assert.assertEquals(userDto.getAddress().getId(), Long.valueOf(3L));
		Assert.assertTrue(userDto.getAddress().getStreet().equalsIgnoreCase("SeMRuA"));
		Assert.assertTrue(userDto.getAddress().getDistrict().equalsIgnoreCase("SEMBaiRRO"));
		Assert.assertEquals(userDto.getAddress().getNumber(), Integer.valueOf(99));
		
	}

	@Test
	public void testAddressNotNull() {
		Assert.assertNotNull(userDto.getAddress().getId());
		Assert.assertNotNull(userDto.getAddress().getStreet());
		Assert.assertNotNull(userDto.getAddress().getDistrict());
		Assert.assertNotNull(userDto.getAddress().getNumber());
	}

	@Test
	public void testAddressNotEquals() {
		Assert.assertNotEquals(userDto.getAddress().getId(), Long.valueOf(3L));
		Assert.assertNotEquals(userDto.getAddress().getStreet(),"Teste");
		Assert.assertNotEquals(userDto.getAddress().getDistrict(),"TesteBairro");
		Assert.assertNotEquals(userDto.getAddress().getNumber(), Integer.valueOf(00));
	}
	
	
	
	
	@Test
	public void testConvert() {
		listUser.add(user);
		
		List<UserEntityDTO> list = UserEntityDTO.convert(listUser);
		
		//é necessario testar essa parte? o metodo converte uma lista de Entity para Lista de entityDto
		list.stream().forEach(i ->{
			Assert.assertTrue(i.getName().equalsIgnoreCase("Marcelo"));
			Assert.assertTrue(i.getAddress().getStreet().equalsIgnoreCase("domingos"));
		});
		
	}

	@Test
	public void testConvertToDto() {
		UserEntityDTO userDto = new UserEntityDTO(
				new UserEntity(1L,"Marcelo", 33, 1234567891011L, Active.ACTIVE, 
						new Address(1L,"domingos", "ingleses", 43)));
		
		Assert.assertTrue(userDto.getName().equalsIgnoreCase("mArCeLo"));
	}

	@Test
	public void testConvertToDTOForm() {
		Address end = new Address("domingos", "ingleses", 43);
		FormUser formUser = new FormUser("NameForm", 55, "11111", Active.ACTIVE, end);
		UserEntityDTO entityDTO = userDto.convertToDTOForm(formUser);
		
		//é necessario testar essa parte?
		Assert.assertTrue(entityDTO.getName().equalsIgnoreCase("nameForm"));
		
	}

	@Test
	public void testRemoveMask() {
		String cpf = "111.222.333-44";
		Long removeMask = UserEntityDTO.removeMask(cpf);
		
		userDto.setCpf(removeMask);
		Assert.assertEquals(userDto.getCpf(), Long.valueOf(11122233344L));
	}

}
