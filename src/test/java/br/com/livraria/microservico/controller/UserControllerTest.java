package br.com.livraria.microservico.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test //get
	public void consultaBancoGetRetorna200() throws Exception {
		URI uri = new URI("/users");
		
		mockMvc.perform(MockMvcRequestBuilders
				.get(uri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}
	
	@Test //Post
	public void consultaBancoPostRetorna201() throws Exception {
		URI uri = new URI("/users");
		String formUserJson = "{\r\n"
				+ "    \"name\": \"Teste 10\",\r\n"
				+ "    \"age\": 453,\r\n"
				+ "    \"cpf\": \"113.111.212-06\",\r\n"
				+ "    \"address\": {\r\n"
				+ "        \"street\": \"Servidão domingos manoel da silveira\",\r\n"
				+ "        \"district\": \"Ingleses\",\r\n"
				+ "        \"number\": 50\r\n"
				+ "    }\r\n"
				+ "}";
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(formUserJson)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}
	
		
	@Test //Put
	public void consultaBancoPuTRetorna200() throws Exception {
		URI uri = new URI("/users");
		String formUserJson = "{\r\n"
				+ "    \"id\": 13,\r\n"
				+ "    \"name\": \"Marcelo\",\r\n"
				+ "    \"age\": 44,\r\n"
				+ "    \"cpf\": \"281.123.222-46\",\r\n"
				+ "    \"status\": \"NOT_ACTIVE\",\r\n"
				+ "    \"address\": {\r\n"
				+ "        \"street\": \"Servidão domingos manoel da silveira\",\r\n"
				+ "        \"district\": \"Rio vermelho\",\r\n"
				+ "        \"number\": 4343\r\n"
				+ "    }\r\n"
				+ "}";
		
		mockMvc.perform(MockMvcRequestBuilders
				.put(uri)
				.content(formUserJson)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}
	
	@Test //Deleted
	public void consultaBancoDeletedRetorna200() throws Exception {
		Long id = 19L;		
		URI uri = new URI("/users/admin/"+id);
		mockMvc.perform(MockMvcRequestBuilders
				.delete(uri)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}

}
