package br.com.fiap.enjoy.domain;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tb_bebida")
public class Bebida {

	@Id
	@SequenceGenerator(name="bebida",sequenceName="sq_tb_bebida",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bebida")
	@Column(name = "cd_bebida")
	private Integer id;

	@Column(name = "vl_valor", length = 100)
	private Double valor;

	@Column(name = "ds_tipo", length = 50)
	private String tipo;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private Calendar dataCriacao;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_atualizacao")
	private Calendar dataAtualizacao;
		
	@OneToMany (mappedBy = "bebida")
	private Collection<Cliente> clientes;
	
	//constructors, getters and setters

	public Bebida() {
		super();
	}

	public Bebida(Integer id, Double valor, String tipo, Calendar dataCriacao, Calendar dataAtualizacao,
			Collection<Cliente> clientes) {
		super();
		this.id = id;
		this.valor = valor;
		this.tipo = tipo;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
		this.clientes = clientes;
	}

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

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public String toString() {
		return "Consumo [id=" + id + ", valor=" + valor + ", tipo=" + tipo + "]";
	}

}