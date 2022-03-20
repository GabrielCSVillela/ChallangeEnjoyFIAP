package br.com.fiap.enjoy.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.enjoy.domain.Alergia;
import br.com.fiap.enjoy.domain.Usuario;

public class MergeTest {

	public static void main(String[] args) {
		EntityManager em = null;
		try {
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			Usuario usuario = new Usuario();
			usuario.setId(1);
			usuario.setNome("Maria da Silva");
			em.merge(usuario);
			
			Alergia alergia = new Alergia();
			alergia.setId(1);
			alergia.setDescricaoAlergia("Alergia a dipirona");
			em.merge(alergia);
			
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if (em != null) {
			em.close();
		}
		System.exit(0);
	}

}


