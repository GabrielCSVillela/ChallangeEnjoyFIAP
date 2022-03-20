package br.com.fiap.enjoy.testes;

import javax.persistence.Persistence;

public class ConexaoBancoTest {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
	}
	
}