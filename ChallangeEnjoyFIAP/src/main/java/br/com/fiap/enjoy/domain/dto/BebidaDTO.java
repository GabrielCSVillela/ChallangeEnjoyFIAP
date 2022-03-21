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
@Table(name = "tb_bebida")
public class BebidaDTO {

	@Id
	@SequenceGenerator(name="bebidaDTO",sequenceName="sq_tb_bebida",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bebidaDTO")
	@Column(name = "cd_bebida")
	private Integer id;

	@Column(name = "vl_valor", length = 100)
	private Double valor;

	@Column(name = "ds_tipo", length = 50)
	private String tipo;
	
	@CreationTimestamp
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private LocalDate dataCriacao;
	
	@CreationTimestamp
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_atualizacao")
	private LocalDate dataAtualizacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		return "Bebida{" +
				"id=" + id +
				", valor=" + valor +
				", tipo='" + tipo + '\'' +
				", dataCriacao=" + dataCriacao +
				", dataAtualizacao=" + dataAtualizacao +
				'}';
	}
}