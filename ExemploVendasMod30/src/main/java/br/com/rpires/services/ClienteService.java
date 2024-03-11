/**
 * 
 */
package br.com.rpires.services;

import br.com.rpires.dao.jpa.IClienteJpaDAO;
import br.com.rpires.domain.jpa.ClienteJpa;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;
import br.com.rpires.services.generic.jpa.GenericJpaService;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteService extends GenericJpaService<ClienteJpa, Long> implements IClienteService {
	
	//private IClienteJpaDAO clienteDAO;
	
	public ClienteService(IClienteJpaDAO clienteJpaDAO) {
		super(clienteJpaDAO);
		//this.clienteDAO = clienteDAO;
	}

//	@Override
//	public Boolean salvar(ClienteJpa cliente) throws TipoChaveNaoEncontradaException {
//		return clienteDAO.cadastrar(cliente);
//	}

	@Override
	public ClienteJpa buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public void excluir(Long cpf) {
//		clienteDAO.excluir(cpf);
//	}
//
//	@Override
//	public void alterar(ClienteJpa cliente) throws TipoChaveNaoEncontradaException{
//		clienteDAO.alterar(cliente);
//	}

}
