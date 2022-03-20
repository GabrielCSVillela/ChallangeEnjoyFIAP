package br.com.fiap.enjoy.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.enjoy.domain.Alergia;
import br.com.fiap.enjoy.domain.Usuario;

public class AlterarTest {

public static void main(String[] args) {
		
		EntityManager em = null;

		try { 
			
			int idProcurado = 1;
			
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			Usuario usuario = em.find(Usuario.class, idProcurado);
			Alergia alergia = em.find(Alergia.class, idProcurado);
			
			em.getTransaction().begin();
			usuario.setNome("Maria da Silva - Alterado");
			alergia.setDescricaoAlergia("Alergia a dipirona - Alterado");

			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

}