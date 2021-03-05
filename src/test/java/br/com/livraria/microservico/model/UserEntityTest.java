package br.com.livraria.microservico.model;



import org.junit.Assert;
import org.junit.Test;

import com.sun.jdi.IntegerValue;

import br.com.livraria.microservico.model.enums.Active;


public class UserEntityTest {
	
	Address end = new Address("domingos", "ingleses", 43);
	UserEntity user = new UserEntity("Marcelo", 33, 11111111111L, Active.ACTIVE, end);

	@Test
	public void testUserEntityLongStringIntegerLongAddress() {
	}

	@Test
	public void testGetStatus() {
		Assert.assertEquals(user.getStatus(),Active.ACTIVE);
	}

	@Test
	public void testSetStatus() {
		user.setStatus(Active.PENDING);
		Assert.assertEquals(user.getStatus(), Active.PENDING);
	}
	
	@Test
	public void testNullGetId() {
		Assert.assertNull(user.getId());
	}

	@Test
	public void testSetId() {
		user.setId(2L);
		Assert.assertEquals(user.getId(), Long.valueOf(2));
	}
	
	@Test
	public void testSetIdNotEquals() {
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
	public void testGetAge() {
		Assert.assertEquals(user.getAge(), Integer.valueOf(33));
	}
	@Test
	public void testGetAgeNotEquals() {
		Assert.assertNotEquals(user.getAge(), Integer.valueOf(10));
	}

	@Test
	public void testSetAge() {
		user.setAge(10);
		Assert.assertEquals(user.getAge(), Integer.valueOf(10));
	}
	@Test
	public void testSetAgeNotEquals() {
		user.setAge(10);
		Assert.assertNotEquals(user.getAge(), Integer.valueOf(33));
	}

	@Test
	public void testGetAddress() {
		Assert.assertEquals(user.getAddress(), end);
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
		
	}

	@Test
	public void testSetCpf() {
	}

	@Test
	public void testGetCpf() {
	}

}
