package br.com.livraria.microservico.mask;

import br.com.livraria.microservico.model.UserEntity;

public class UpperCaseName {
	
	public static void main(String[] args) {
		UserEntity user = new UserEntity();
		
		user.setName("Marcelo");
		
		System.out.println(user.getName());
	}
	
	
	

}
