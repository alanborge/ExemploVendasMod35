/**
 * 
 */
package br.com.rpires.domain.jpa;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import anotacao.ColunaTabela;
import anotacao.Tabela;

/**
 * @author rodrigo.pires
 *
 */
@Entity
@Tabela("TB_PRODUTO_QUANTIDADE")
public class ProdutoQuantidadeJpa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prod_qtd_seq")
	@SequenceGenerator(name="prod_qtd_seq", sequenceName="sq_prod_qtd", initialValue = 1, allocationSize = 1)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private ProdutoJpa produtoJpa;
	
	@Column(name = "quantidade", nullable = true)
	private Integer quantidade;
	
	@Column(name = "valor_total", nullable = true)
	private BigDecimal valorTotal;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_venda_fk", 
		foreignKey = @ForeignKey(name = "fk_prod_qtd_venda"), 
		referencedColumnName = "id", nullable = false)
	private VendaJpa venda;
	
	public ProdutoQuantidadeJpa() {
		this.quantidade = 0;
		this.valorTotal = BigDecimal.ZERO;
	}

	public ProdutoJpa getProduto() {
		return produtoJpa;
	}

	public void setProduto(ProdutoJpa produtoJpa) {
		this.produtoJpa = produtoJpa;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void adicionar(Integer quantidade) {
		this.quantidade += quantidade;
		BigDecimal novoValor = this.produtoJpa.getValor().multiply(BigDecimal.valueOf(quantidade));
		BigDecimal novoTotal = this.valorTotal.add(novoValor);
		this.valorTotal = novoTotal;
	}
	
	public void remover(Integer quantidade) {
		this.quantidade -= quantidade;
		BigDecimal novoValor = this.produtoJpa.getValor().multiply(BigDecimal.valueOf(quantidade));
		this.valorTotal = this.valorTotal.subtract(novoValor);
	}

	public ProdutoJpa getProdutoJpa() {
		return produtoJpa;
	}

	public void setProdutoJpa(ProdutoJpa produtoJpa) {
		this.produtoJpa = produtoJpa;
	}

	public VendaJpa getVenda() {
		return venda;
	}

	public void setVenda(VendaJpa venda) {
		this.venda = venda;
	}

	

	
	
}
