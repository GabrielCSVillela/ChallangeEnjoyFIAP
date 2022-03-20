package br.com.fiap.enjoy.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.enjoy.domain.Alergia;
import br.com.fiap.enjoy.domain.Usuario;

public class RemoveTest {

	public static void main(String[] args) {
		
		EntityManager em = null;

		try { 
			
			int idProcurado = 2;
			
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			Usuario usuario = em.find(Usuario.class, idProcurado);
			Alergia alergia = em.find(Alergia.class, idProcurado);
			
			em.getTransaction().begin();
			em.remove(usuario);
			em.remove(alergia);
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