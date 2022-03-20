package br.com.fiap.enjoy.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@SequenceGenerator(name="cliente",sequenceName="sq_tb_cliente",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cliente")
	@Column(name = "cd_cliente")
	private Integer id;

	@Column(name = "nm_nome", length = 100)
	private String nome;
	
	@Column(name = "ds_telefone")
	private String telefone;
	
	@Column(name = "vl_consumo")
	private Double consumo;
	
	@Column(name = "nm_choppFavorito", length = 100)
	private String choppFavorito;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_dataVisita")
	private Calendar dataVisita;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private Calendar dataCriacao;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_atualizacao")
	private Calendar dataAtualizacao;
	
	@JoinColumn(name="cd_bebida")
	@ManyToOne
	private Bebida bebida;
	
	@JoinColumn(name="cd_estabelecimento")
	@ManyToOne
	private Estabelecimento estabelecimento;
	
	/*
	@JoinColumn(name="cd_usuario")
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy = "contato")
	private Collection<Vacina> vacinas;
	*/
	
	//constructors, getters and setters
	
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

	public Calendar getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(Calendar dataVisita) {
		this.dataVisita = dataVisita;
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

	public Bebida getBebida() {
		return bebida;
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, String telefone, Double consumo, String choppFavorito, Calendar dataVisita,
			Calendar dataCriacao, Calendar dataAtualizacao, Bebida bebida, Estabelecimento estabelecimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.consumo = consumo;
		this.choppFavorito = choppFavorito;
		this.dataVisita = dataVisita;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
		this.bebida = bebida;
		this.estabelecimento = estabelecimento;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", dataCriacao=" + dataCriacao + "]";
	}

}