/**
 * 
 */
package br.com.rpires.jpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.rpires.dao.jpa.IProdutoJpaDAO;
import br.com.rpires.dao.jpa.ProdutoJpaDAO;
import br.com.rpires.domain.jpa.ProdutoJpa;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoJpaDAOTest {

	private IProdutoJpaDAO produtoDao;

	public ProdutoJpaDAOTest() {
		this.produtoDao = new ProdutoJpaDAO();
	}

	@After
	public void end() throws DAOException {
		Collection<ProdutoJpa> list = produtoDao.buscarTodos();
		list.forEach(prod -> {
			try {
				produtoDao.excluir(prod);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	@Test
	public void pesquisar()
			throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
		ProdutoJpa produtoJpa = criarProduto("A1");
		Assert.assertNotNull(produtoJpa);
		ProdutoJpa produtoDB = this.produtoDao.consultar(produtoJpa.getId());
		Assert.assertNotNull(produtoDB);
	}

	private ProdutoJpa criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
		ProdutoJpa produto = new ProdutoJpa();
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
		produtoDao.cadastrar(produto);
		return produto;
	}

	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		ProdutoJpa produto = criarProduto("A2");
		Assert.assertNotNull(produto);
	}

	private void excluir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
		ProdutoJpa produto = criarProduto("A3");
		Assert.assertNotNull(produto);
		this.produtoDao.excluir(produto);
		ProdutoJpa produtoBD = this.produtoDao.consultar(produto.getId());
		assertNull(produtoBD);
	}

	@Test
	public void alterarCliente()
			throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		ProdutoJpa produto = criarProduto("A4");
		produto.setNome("Rodrigo Pires");
		produtoDao.alterar(produto);
		ProdutoJpa produtoBD = this.produtoDao.consultar(produto.getId());
		assertNotNull(produtoBD);
		Assert.assertEquals("Rodrigo Pires", produtoBD.getNome());
	}

	@Test
	public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
		criarProduto("A5");
		criarProduto("A6");
		Collection<ProdutoJpa> list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);

		for (ProdutoJpa prod : list) {
			this.produtoDao.excluir(prod);
		}

		list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 0);

	}
}
