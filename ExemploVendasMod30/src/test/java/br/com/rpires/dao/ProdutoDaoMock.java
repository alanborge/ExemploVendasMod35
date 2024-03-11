package br.com.rpires.dao;

import java.util.Collection;

import br.com.rpires.dao.jpa.IProdutoJpaDAO;
import br.com.rpires.domain.jpa.ProdutoJpa;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoDaoMock implements IProdutoJpaDAO {

	@Override
	public ProdutoJpa cadastrar(ProdutoJpa entity) throws TipoChaveNaoEncontradaException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(ProdutoJpa entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProdutoJpa alterar(ProdutoJpa entity) throws TipoChaveNaoEncontradaException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Collection<ProdutoJpa> buscarTodos() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutoJpa consultar(Long id) throws MaisDeUmRegistroException, TableException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
