package br.com.livraria.microservico.mask;

public class RemoveMaskCpf {

	public static void main(String[] args) {
		String cpf = "111.222.333-44";
		String cnpj = "11.222.333/4444-55";
		String test = "test";
		
		System.out.println(cnpj.replaceAll("\\D",""));
	}

}
