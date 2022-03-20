package br.com.fiap.enjoy.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.fiap.enjoy.domain.Cliente;

public class Consultas {

	public static void main(String[] args) {

		
		EntityManager em = null;

		try { 
			
			int idProcurado = 35998121061;
			
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			
			Cliente cliente = em.find(Cliente.class, idProcurado);
			
			Query query = em.createQuery("from Consumo where cliente = :id ");
			query.setParameter("id", "35998121061");
			List list = query.list();
			
            String sequel = "Select max(dt_consumo) from Consumo";
            Query q = em.createQuery(sequel);
            List currentSeq = q.list();

            List<Cliente> clientes = em.createQuery("from Cliente where sexo = 'M'", Cliente.class).getResultList();
            
            Query qExample = em.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a");
            List<Object[]> authors = qExample.getResultList();
           
            
            for (Cliente clientee : clientes) {
    			System.out.println("Nome: " + cliente.getNome());
    			System.out.println("Consumo: " + cliente.getConsumo());
    			System.out.println("----------------------------");
    		}

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

}
