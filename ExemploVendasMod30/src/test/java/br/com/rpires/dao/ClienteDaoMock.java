package br.com.rpires.dao;

import java.util.Collection;

import br.com.rpires.dao.jpa.IClienteJpaDAO;
import br.com.rpires.domain.jpa.ClienteJpa;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDaoMock implements IClienteJpaDAO {

	@Override
	public ClienteJpa cadastrar(ClienteJpa entity) throws TipoChaveNaoEncontradaException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(ClienteJpa entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteJpa alterar(ClienteJpa entity) throws TipoChaveNaoEncontradaException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteJpa consultar(Long valor) throws MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpa cliente = new ClienteJpa();
		cliente.setCpf(valor);
		return cliente;
	}

	@Override
	public Collection<ClienteJpa> buscarTodos() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
 
}
