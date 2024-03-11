/**
 * 
 */
package br.com.rpires.dao.jpa;




import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import br.com.rpires.dao.jpa.generic.jpa.GenericJpaDAO;
import br.com.rpires.domain.jpa.ClienteJpa;
import br.com.rpires.domain.jpa.ProdutoJpa;
import br.com.rpires.domain.jpa.ProdutoQuantidadeJpa;
import br.com.rpires.domain.jpa.VendaJpa;
import br.com.rpires.domain.jpa.VendaJpa.Status;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class VendaJpaDAO extends GenericJpaDAO<VendaJpa, String> implements IVendaJpaDAO {
	
	private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    
	public VendaJpaDAO() {
		super(VendaJpa.class);
		this.entityManagerFactory = Persistence.createEntityManagerFactory("ExemplosJPA");
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.alterar(venda);
	}

	@Override
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.alterar(venda);
	}

	@Override
	public void excluir(VendaJpa entity) throws DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public VendaJpa cadastrar(VendaJpa entity) throws TipoChaveNaoEncontradaException, DAOException {
		try {
			
			entityManager.getTransaction().begin();
	        
	        
	        for (ProdutoQuantidadeJpa produtoQuantidade : entity.getProdutos()) {
	        	 ProdutoJpa produto = produtoQuantidade.getProduto();
	        	 produtoQuantidade.setProduto(entityManager.merge(produto));;
	             produtoQuantidade.setVenda(entity);
	        }
	        
	        entityManager.persist(entity);
	        entityManager.getTransaction().commit();
			
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new DAOException("ERRO SALVANDO VENDA ", e);
		}
		
	}

	@Override
	public VendaJpa consultarComCollection(Long id) {
		openConnection();
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<VendaJpa> query = builder.createQuery(VendaJpa.class);
		Root<VendaJpa> root = query.from(VendaJpa.class);
		root.fetch("clienteJpa");
		root.fetch("produtos");
		query.select(root).where(builder.equal(root.get("id"), id));
		TypedQuery<VendaJpa> tpQuery = 
				entityManager.createQuery(query);
		VendaJpa venda = tpQuery.getSingleResult();   
		closeConnection();
		return venda;
	}

	
	
}
