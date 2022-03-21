package br.com.fiap.enjoy.domain.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tb_cliente")
public class ClienteDTO {
	
		@Id
		@SequenceGenerator(name="clienteDTO",sequenceName="sq_tb_cliente",allocationSize=1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="clienteDTO")
		@Column(name = "cd_cliente")
		private Integer id;

		@Column(name = "nm_nome", length = 100)
		private String nome;
		
		@Column(name = "ds_telefone")
		private String telefone;
		
		@Column(name = "vl_consumo")
		private Double consumo;
		
		@Column(name = "nm_choppfavorito", length = 100)
		private String choppFavorito;
		
		@CreationTimestamp
		@Column(name = "dt_datavisita")
		private LocalDate dataVisita;
		
		@CreationTimestamp
		@Column(name = "dh_criacao")
		private LocalDate dataCriacao;
		
		@CreationTimestamp
		@Column(name = "dh_atualizacao")
		private LocalDate dataAtualizacao;
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public Double getConsumo() {
			return consumo;
		}

		public void setConsumo(Double consumo) {
			this.consumo = consumo;
		}

		public String getChoppFavorito() {
			return choppFavorito;
		}

		public void setChoppFavorito(String choppFavorito) {
			this.choppFavorito = choppFavorito;
		}

		public LocalDate getDataVisita() {
			return dataVisita;
		}

		public void setDataVisita(LocalDate dataVisita) {
			this.dataVisita = dataVisita;
		}

		public LocalDate getDataCriacao() {
			return dataCriacao;
		}

		public void setDataCriacao(LocalDate dataCriacao) {
			this.dataCriacao = dataCriacao;
		}

		public LocalDate getDataAtualizacao() {
			return dataAtualizacao;
		}

		public void setDataAtualizacao(LocalDate dataAtualizacao) {
			this.dataAtualizacao = dataAtualizacao;
		}

		@Override
		public String toString() {
			return "ClienteDTO [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", consumo=" + consumo
					+ ", choppFavorito=" + choppFavorito + ", dataVisita=" + dataVisita + ", dataCriacao=" + dataCriacao
					+ ", dataAtualizacao=" + dataAtualizacao + "]";
		}
		
		
}
