package br.com.fiap.enjoy.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.enjoy.domain.Bebida;
import br.com.fiap.enjoy.domain.Cliente;
import br.com.fiap.enjoy.domain.Estabelecimento;

public class InserirTest {

	public static void main(String[] args) {
		
		EntityManager em = null;

		try { 
			
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			em.getTransaction().begin();
			
			Bebida bebida = new Bebida();
			bebida.setTipo("Ipa");
			bebida.setValor(10.00);
			
			Estabelecimento estabelecimento = new Estabelecimento();
			estabelecimento.setNomeEstabelecimento("Bar do Zé");
					
			Cliente cliente = new Cliente();
			cliente.setNome("Maria da Silva");
			cliente.setChoppFavorito("Ipa");
			cliente.setTelefone("1198890909");
			cliente.setBebida(bebida);
			cliente.setEstabelecimento(estabelecimento);
			
			
			Cliente cliente2 = new Cliente();
			cliente2.setNome("Carolina da Silva");
			cliente2.setChoppFavorito("Ipa");
			cliente2.setTelefone("35998121061");
			cliente2.setBebida(bebida);
			cliente2.setEstabelecimento(estabelecimento);
			
			
			em.persist(bebida);
			em.persist(estabelecimento);
			em.persist(cliente);
			//em.persist(cliente2);

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
