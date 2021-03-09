package br.com.livraria.microservico.forms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.livraria.microservico.model.Address;
import br.com.livraria.microservico.model.enums.Active;

public class FormUserTest {
	
	private FormUser userForm;
	
	@Before
	public void init() {
		userForm = new FormUser(1L,"Marcelo", 1, "1111333344", Active.ACTIVE,
								new Address(1L,"testStreet","testDistrict",43));
	}
	
	@Test
	public void testGetStatus() {
		Assert.assertEquals(userForm.getStatus(), Active.ACTIVE);
	}

	@Test
	public void testSetStatus() {
		userForm.setStatus(Active.NOT_ACTIVE);
		Assert.assertEquals(userForm.getStatus(), Active.NOT_ACTIVE);
	}
	
	@Test
	public void testStatusNotNull() {
		Assert.assertNotNull(userForm.getStatus());
	}
	
	@Test
	public void testStatusNotEquals() {
		Assert.assertNotEquals(userForm.getStatus(), Active.NOT_ACTIVE);
	}
	
	

	
	@Test
	public void testGetId() {
		Assert.assertEquals(userForm.getId(), Long.valueOf(1L));
	}

	@Test
	public void testSetId() {
		userForm.setId(2L);
		Assert.assertEquals(userForm.getId(), Long.valueOf(2L));
	}
	
	@Test
	public void testIdNotNull() {
		Assert.assertNotNull(userForm.getId());
	}
	
	@Test
	public void testIdNotEquals() {
		Assert.assertNotEquals(userForm.getId(), Long.valueOf(4L));
	}

	
	
	
	
	@Test
	public void testGetName() {
		Assert.assertTrue(userForm.getName().equalsIgnoreCase("marcelo"));
	}

	@Test
	public void testSetName() {
		userForm.setName("test");
		Assert.assertTrue(userForm.getName().equalsIgnoreCase("test"));
	}
	
	@Test
	public void testNameNotNull() {
		Assert.assertNotNull(userForm.getName());
	}
	
	@Test
	public void testNameNotEquals() {
		Assert.assertNotEquals(userForm.getName(), "test");
	}
	
	

	@Test
	public void testGetAge() {
		Assert.assertEquals(userForm.getAge(), Integer.valueOf(1));
	}

	@Test
	public void testSetAge() {
		userForm.setAge(2);
		Assert.assertEquals(userForm.getAge(), Integer.valueOf(2));
	}
	
	@Test
	public void testAgeNotNull() {
		Assert.assertNotNull(userForm.getAge());
	}
	
	@Test
	public void testAgeNotEquals() {
		Assert.assertNotEquals(userForm.getAge(), Integer.valueOf(5));
	}
	
	
	
	
	

	@Test
	public void testGetCpf() {
		Assert.assertEquals(userForm.getCpf(), "1111333344");
	}

	@Test
	public void testSetCpf() {
		userForm.setCpf("1111333355");
		Assert.assertEquals(userForm.getCpf(), "1111333355" );
	}
	
	@Test
	public void testCpfNotNull() {
		Assert.assertNotNull(userForm.getCpf());
	}
	
	@Test
	public void testCpfNotEquals() {
		Assert.assertNotEquals(userForm.getCpf(),"teste");
	}
	
	
	

	@Test
	public void testGetAddress() {
		Assert.assertTrue(userForm.getAddress().getStreet().equalsIgnoreCase("testStreet"));
		Assert.assertTrue(userForm.getAddress().getDistrict().equalsIgnoreCase("testDistrict"));
		Assert.assertEquals(userForm.getAddress().getNumber(), Integer.valueOf(43));
		Assert.assertEquals(userForm.getAddress().getId(), Long.valueOf(1L));
	}

	@Test
	public void testSetAddress() {
		userForm.getAddress().setStreet("test");
		userForm.getAddress().setDistrict("test2");
		userForm.getAddress().setNumber(99);
		userForm.getAddress().setId(99L);
		
		Assert.assertTrue(userForm.getAddress().getStreet().equalsIgnoreCase("test"));
		Assert.assertTrue(userForm.getAddress().getDistrict().equalsIgnoreCase("test2"));
		Assert.assertEquals(userForm.getAddress().getNumber(), Integer.valueOf(99));
		Assert.assertEquals(userForm.getAddress().getId(), Long.valueOf(99L));
	}
	
	@Test
	public void testAddressNotNull() {
		Assert.assertNotNull(userForm.getAddress());
	}
	
	@Test
	public void testAddressNotEquals() {
		Assert.assertNotEquals(userForm.getAddress().getStreet(), "notEquals");
		Assert.assertNotEquals(userForm.getAddress().getDistrict(), "notEquals");
		Assert.assertNotEquals(userForm.getAddress().getNumber(), Integer.valueOf(6));
		Assert.assertNotEquals(userForm.getAddress().getId(), Long.valueOf(66L));
	}

}
