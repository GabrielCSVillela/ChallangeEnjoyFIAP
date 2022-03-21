package br.com.fiap.enjoy.domain;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.persistence.*;

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

	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "cd_cliente"),
			inverseJoinColumns = @JoinColumn(name = "cd_bebida"),
			name = "tb_bebida_cliente")
	private List<Bebida> bebidas;

	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "cd_cliente"),
			inverseJoinColumns = @JoinColumn(name = "cd_estabelecimento"),
			name = "tb_estabelecimento_cliente")
	private List<Estabelecimento> estabecimentos;

	public Cliente() {
	}

	public Cliente(Integer id, String nome, String telefone, Double consumo, String choppFavorito, LocalDate dataVisita, LocalDate dataCriacao, LocalDate dataAtualizacao) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.consumo = consumo;
		this.choppFavorito = choppFavorito;
		this.dataVisita = dataVisita;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
	}

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

	public List<Bebida> getBebidas() {
		//Devolve uma lista somente para leitura, para alterar a lista precisa do método especifico adicionaBebidas
		return Collections.unmodifiableList(bebidas);
	}
	public void adicionaBebidas(Bebida bebida) {
		this.bebidas.add(bebida);
	}

	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	public List<Estabelecimento> getEstabecimentos() {
		//Devolve uma lista somente para leitura, para alterar a lista precisa do método especifico adicionaEstabelecimento
		return Collections.unmodifiableList(estabecimentos);
	}

	public void adicionaEstabelecimento(Estabelecimento estabelecimento) {
		this.estabecimentos.add(estabelecimento);
	}

	public void setEstabecimentos(List<Estabelecimento> estabecimentos) {
		this.estabecimentos = estabecimentos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", consumo=" + consumo
				+ ", choppFavorito=" + choppFavorito + ", dataVisita=" + dataVisita + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizacao=" + dataAtualizacao + ", bebidas=" + bebidas + ", estabecimentos=" + estabecimentos
				+ "]";
	}	
}