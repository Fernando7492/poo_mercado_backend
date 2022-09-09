package com.example.Mercado_POO.basica;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProdutoVenda {
	private Integer qtdProdutos;
	private BigDecimal valorTotal;
	private Date validade;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Produto produto;
	
	public void calcularValorTotal() {
		valorTotal = produto.getValorVenda().multiply(new BigDecimal(qtdProdutos));
		
	}

	public Integer getQtdProdutos() {
		return qtdProdutos;
	}

	public void setQtdProdutos(Integer qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public Date getValidade() {
		return validade;
	}

	public ProdutoVenda(Integer qtdProdutos, Date validade, Produto produto) {
		super();
		this.qtdProdutos = qtdProdutos;
		this.produto = produto;
		this.validade = this.produto.getValidade();
	}
	
	
	}

