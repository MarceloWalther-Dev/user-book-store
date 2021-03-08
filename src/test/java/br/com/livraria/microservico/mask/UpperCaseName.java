package br.com.livraria.microservico.mask;


import br.com.livraria.microservico.dto.UserEntityDTO;
import br.com.livraria.microservico.model.UserEntity;

public class UpperCaseName {
	
	public static void main(String[] args) {
		UserEntity user = new UserEntity();
		UserEntityDTO userDto = new UserEntityDTO(user);
		
		System.out.println(user.getClass().isInstance(userDto));
		
		user.setName("Marcelo");
		
		System.out.println(user.getName());
	}
	
	
	

}
