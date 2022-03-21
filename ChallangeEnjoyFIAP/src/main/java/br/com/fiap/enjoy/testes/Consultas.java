package br.com.fiap.enjoy.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.fiap.enjoy.domain.Cliente;
import br.com.fiap.enjoy.domain.dto.BebidaDTO;
import br.com.fiap.enjoy.domain.dto.ClienteDTO;

public class Consultas {

	public static void main(String[] args) {
	
		EntityManager em = null;

		try { 
					
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
					
			Query queryUv = em.createNativeQuery("SELECT "
            		+ "*"
            		+ " FROM TB_CLIENTE A "
            		+ "inner join tb_estabelecimento_cliente B on A.cd_cliente = B.cd_cliente "
            		+ "inner join tb_estabelecimento C on B.cd_estabelecimento = C.cd_estabelecimento "
            		+ "where A.nm_nome = ?1 "
            		+ "order by A.dt_datavisita desc ", ClienteDTO.class)
					.setParameter(1, "Maria da Silva");
			
			List<ClienteDTO> ultimaVisita = (List<ClienteDTO>)queryUv.getResultList();
			
			System.out.println(""); 
			System.out.println(""); 
			System.out.println(""); 
                     
			ultimaVisita.forEach(cli -> { 
				System.out.println("QUAL DATA DA ULTIMA VISITA?"); 
				System.out.println("------------------------------------"); 
				
				System.out.println("Cliente: " + cli.getNome()); 
				System.out.println("Data da ultima visita: " + cli.getDataVisita()); 
				System.out.println("------------------------------------"); 
			}); 
			
			Query queryFv = em.createNativeQuery("SELECT * FROM TB_CLIENTE cli "
					+ "WHERE cli.DT_DATAVISITA between to_date(?1) AND to_date(?2) AND cli.CD_CLIENTE = ?3", ClienteDTO.class)
				 .setParameter(1, "01/03/2022")
		         .setParameter(2, "31/03/2022")
		         .setParameter(3, 1);
		 
			List<ClienteDTO> freqVisi = (List<ClienteDTO>)queryFv.getResultList();
			
			System.out.println(""); 
			System.out.println(""); 
			System.out.println(""); 

			freqVisi.forEach(cli -> {			
				System.out.println("FREQUÊNCIA DE VISITAS"); 
				System.out.println("------------------------------------"); 
				System.out.println("Cliente: " + cli.getNome()); 
				System.out.println("Data da ultima visita: " + cli.getDataVisita()); 
				System.out.println("------------------------------------"); 
			});
						
			Query queryTm = em.createNativeQuery("SELECT AVG(beb.VL_VALOR) "
					+ "FROM TB_CLIENTE cli "
					+ "INNER JOIN TB_BEBIDA_CLIENTE lig ON lig.CD_CLIENTE = cli.CD_CLIENTE "
					+ "INNER JOIN TB_BEBIDA beb ON beb.CD_BEBIDA = lig.CD_BEBIDA "
					+ "INNER JOIN TB_ESTABELECIMENTO_CLIENTE ligEst ON ligEst.CD_CLIENTE = cli.CD_CLIENTE "
					+ "INNER JOIN TB_ESTABELECIMENTO est ON est.CD_ESTABELECIMENTO = ligEst.CD_ESTABELECIMENTO "
					+ "WHERE est.CD_ESTABELECIMENTO = ?1", BebidaDTO.class)
				 .setParameter(1, 1);
		 
			List<BebidaDTO> ticketMedio = (List<BebidaDTO>)queryTm.getResultList();
			
			System.out.println(""); 
			System.out.println(""); 
			System.out.println(""); 

			ticketMedio.forEach(beb -> {			
				System.out.println("TICKET MÉDIO"); 
				System.out.println("------------------------------------"); 
				System.out.println("Tipo de Bebida: " + beb.getTipo()); 
				System.out.println("Ticket médio gasto neste Estabelecimento: " + beb.getValor()); 
				System.out.println("------------------------------------"); 
			});
			
			
			Query queryBf = em.createNativeQuery("SELECT SUM((C.vl_valor * cli.vl_consumo)) "
					+ "AS Valor_Total, C.ds_tipo\r\n"
					+ "FROM TB_CLIENTE cli \r\n"
					+ "inner join tb_bebida_cliente B on cli.cd_cliente = B.cd_cliente \r\n"
					+ "inner join tb_bebida C on B.cd_bebida = C.cd_bebida \r\n"
					+ "where cli.cd_cliente = ?1\r\n"
					+ "group by (C.ds_tipo)", ClienteDTO.class)
				 .setParameter(1, 1);
		 
			List<ClienteDTO> bebidaFavorita = (List<ClienteDTO>)queryBf.getResultList();
			
			System.out.println(""); 
			System.out.println(""); 
			System.out.println(""); 

			bebidaFavorita.forEach(cli -> {			
				System.out.println("BEBIDA FAVORITA"); 
				System.out.println("------------------------------------");
				System.out.println("Cliente: " + cli.getNome()); 
				System.out.println("Bebida favorita: " + cli.getChoppFavorito()); 
				System.out.println("------------------------------------"); 
			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

}
