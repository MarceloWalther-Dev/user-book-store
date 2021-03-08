package br.com.livraria.microservico.model;

import org.junit.Assert;
import org.junit.Test;



public class AddressTest {
	
	Address end = new Address(1L,"domingos", "ingleses", 43);
	Address end2 = new Address("RuaVazia","BairroVazio", 58);
	

	@Test
	public void testGetId() {
		Assert.assertEquals(end.getId(), Long.valueOf(1L));
	}

	@Test
	public void testSetId() {
		end2.setId(2L);
		Assert.assertEquals(end2.getId(), Long.valueOf(2L));
	}
	
	@Test
	public void testIdNotEquals() {
		Assert.assertNotEquals(end.getId(), Long.valueOf(5L));
	}
	
	@Test
	public void testIdNotNull() {
		Assert.assertNotNull(end.getId());
	}
	
	

	
	@Test
	public void testGetStreet() {
		Assert.assertTrue(end.getStreet().equalsIgnoreCase("domingos"));
	}

	@Test
	public void testSetStreet() {
		end.setStreet("teste");
		Assert.assertTrue(end.getStreet().equalsIgnoreCase("teste"));
	}
	
	@Test
	public void testStreetNotNull() {
		Assert.assertNotNull(end.getStreet());
	}
	
	@Test
	public void testStreetNotEquals() {
		Assert.assertNotEquals(end.getStreet(), end2.getStreet());
	}
	
	
	
	
	@Test
	public void testGetDistrict() {
		Assert.assertTrue(end.getDistrict().equalsIgnoreCase("InGlEseS"));
	}

	@Test
	public void testSetDistrict() {
		end.setDistrict("BairroNenhum");
		Assert.assertTrue(end.getDistrict().equalsIgnoreCase("bairroNenhUM"));
	}
	
	@Test
	public void testDistrictNotNull() {
		Assert.assertNotNull(end.getDistrict());
	}
	
	@Test
	public void testDistrictNotEquals() {
		Assert.assertNotEquals(end.getDistrict(), end2.getDistrict());
	}
	
	

	
	@Test
	public void testGetNumber() {
		Assert.assertEquals(end.getNumber(), Integer.valueOf(43));
	}

	@Test
	public void testSetNumber() {
		end.setNumber(42);
		Assert.assertEquals(end.getNumber(), Integer.valueOf(42));
	}
	
	@Test
	public void testNumberNotNull() {
		Assert.assertNotNull(end.getNumber());
	}
	
	@Test
	public void testNumberNotEquals() {
		Assert.assertNotEquals(end.getNumber(), end2.getNumber());
	}

}
