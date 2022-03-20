package br.com.fiap.enjoy.testes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
			
			List<Bebida> bebidas = new ArrayList();
			bebidas.add(bebida);
				
			Estabelecimento estabelecimento = new Estabelecimento();
			estabelecimento.setNomeEstabelecimento("Bar do Zé");
			estabelecimento.setDataVisita(LocalDate.of(2022, 03, 22));
			
			List<Estabelecimento> estabelecimentos = new ArrayList();
			estabelecimentos.add(estabelecimento);
					
			Cliente cliente = new Cliente();
			cliente.setNome("Maria da Silva");
			cliente.setChoppFavorito("Ipa");
			cliente.setTelefone("1198890909");
			cliente.setConsumo(1000.00);
			//cliente.adicionaBebidas(new Bebida (2, 10.00, "Pilsen", LocalDate.now(), LocalDate.now()));
			cliente.setBebidas(bebidas);
			cliente.setEstabecimentos(estabelecimentos);
			
			Cliente cliente2 = new Cliente();
			cliente2.setNome("Carolina da Silva");
			cliente2.setChoppFavorito("Ipa");
			cliente2.setTelefone("35998121061");
			cliente2.setConsumo(2000.00);
			cliente2.setBebidas(bebidas);
			cliente2.setEstabecimentos(estabelecimentos);
			
			Cliente cliente3 = new Cliente();
			cliente3.setNome("João da Silva");
			cliente3.setChoppFavorito("Ipa");
			cliente3.setTelefone("11909098989");
			cliente3.setBebidas(bebidas);
			cliente3.setEstabecimentos(estabelecimentos);
			
			em.persist(bebida);
			em.persist(estabelecimento);
			em.persist(cliente);
			em.persist(cliente2);
			em.persist(cliente3);

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
