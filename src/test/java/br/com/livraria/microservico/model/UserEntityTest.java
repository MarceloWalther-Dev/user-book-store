package br.com.livraria.microservico.model;



import org.junit.Assert;
import org.junit.Test;

import br.com.livraria.microservico.model.enums.Active;


public class UserEntityTest {
	
	Address end = new Address("domingos", "ingleses", 43);
	Address end2 = new Address("RuaVazia","BairroVazio", 58);
	
	UserEntity user = new UserEntity(1L,"Marcelo", 33, 1234567891011L, Active.ACTIVE, end);
	UserEntity user2 = new UserEntity(2L,"Usuario2",43,1110987654321L, Active.NOT_ACTIVE, end2);
	
	

	@Test
	public void testUserEntityLongStringIntegerLongAddress() {
	}

	@Test
	public void testGetStatus() {
		Assert.assertNotNull(user.getStatus());
		Assert.assertEquals(user.getStatus(),Active.ACTIVE);
	}

	@Test
	public void testSetStatus() {
		user.setStatus(Active.PENDING);
		Assert.assertEquals(user.getStatus(), Active.PENDING);
	}
	
	@Test
	public void testNullStatus() {
		Assert.assertNotNull(user.getStatus());
	}
	
	@Test
	public void testNotEquals() {
		Assert.assertNotEquals(user.getStatus(), Active.NOT_ACTIVE);
	}
	
	
	
	
	
	@Test
	public void testGetId() {
		Assert.assertEquals(user.getId(), Long.valueOf(1));
	}

	@Test
	public void testSetId() {
		user.setId(2L);
		Assert.assertEquals(user.getId(), Long.valueOf(2));
	}
	
	@Test
	public void testNotNullId() {
		Assert.assertNotNull(user.getId());
	}
	
	@Test
	public void testNotEqualsId() {
		Assert.assertNotEquals(Long.valueOf(5), user.getId());
	}
	
	
		

	@Test
	public void testGetName() {
		Assert.assertEquals(user.getName(), "Marcelo");
	}
	@Test
	public void testGetNameNotEquals() {
		Assert.assertNotEquals(user.getName(), "Teste");
	}

	@Test
	public void testSetName() {
		user.setName("teste");
		Assert.assertTrue(user.getName().equalsIgnoreCase("teste"));
	}
	
	@Test
	public void testNotNull() {
		Assert.assertNotNull(user.getName());
	}
	
	
	
	
	@Test
	public void testGetAge() {
		Assert.assertEquals(user.getAge(), Integer.valueOf(33));
	}

	@Test
	public void testSetAge() {
		user.setAge(10);
		Assert.assertEquals(user.getAge(), Integer.valueOf(10));
	}
	
	@Test
	public void testGetAgeNotEquals() {
		Assert.assertNotEquals(user.getAge(), Integer.valueOf(10));
	}

	@Test
	public void testAgeNotNull() {
		Assert.assertNotNull(user.getAge());
	}

	
	
	
	@Test
	public void testGetAddress() {
		Assert.assertEquals(user.getAddress().getStreet(), end.getStreet());
		Assert.assertEquals(user.getAddress().getDistrict(), end.getDistrict());
		Assert.assertEquals(user.getAddress().getNumber(), end.getNumber());
	}

	@Test
	public void testSetAddress() {
		end.setStreet("Servidao");
		end.setDistrict("Jurere");
		end.setNumber(Integer.valueOf(1000));
		user.setAddress(end);
		
		Assert.assertEquals(user.getAddress().getStreet(), "Servidao");
		Assert.assertEquals(user.getAddress().getDistrict(), "Jurere");
		Assert.assertEquals(user.getAddress().getNumber(), Integer.valueOf(1000));
		
		Assert.assertNotEquals(user.getAddress().getStreet(), "Jurere");
		Assert.assertNotEquals(user.getAddress().getDistrict(), "Servidao");
		Assert.assertNotEquals(user.getAddress().getNumber(), Integer.valueOf(1));
		
	}
	
	@Test
	public void testAddressNotNull() {
		Assert.assertNotNull(end);
	}
	
	
	

	@Test
	public void testSetCpf() {
		Long cpf = 11111111111L;
		user.setCpf(cpf);
		Assert.assertEquals(user.getCpf(), cpf);
	}

	@Test
	public void testGetCpf() {
		Assert.assertEquals(user.getCpf(), Long.valueOf(1234567891011L));
	}
	
	@Test
	public void testCpfNotNull() {
		Assert.assertNotNull(user.getCpf());
	}
	
	@Test
	public void testCpfNotEquals() {
		Assert.assertNotEquals(user.getCpf(), user2.getCpf());
	}

}
