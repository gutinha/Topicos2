package br.unitins.topicos2.repository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.unitins.topicos2.model.PessoaFisica;
import br.unitins.topicos2.model.PessoaJuridica;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.utils.RepositoryException;
import br.unitins.topicos2.utils.Util;

public class UsuarioRepository extends Repository<Usuario> {
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findListByEmail(String email) throws RepositoryException {
		try { 
			String sql = "SELECT u FROM Usuario u WHERE u.email = :email";
			Query query = getEntityManager().createQuery(sql);
			query.setParameter("email", "%" + email + "%");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findListByEmail.");
		}
	}
	
	public Usuario findByEmail(String email) throws RepositoryException {
		try { 
			String sql = "SELECT u FROM Usuario u WHERE u.email = :email";
			Query query = getEntityManager().createQuery(sql);
			query.setParameter("email", email);

			return (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByEmail.");
		}		
	}
	
	public Usuario verifyLogin(String email, Usuario usu) throws RepositoryException {
		try { 
			String sql = "SELECT u FROM Usuario u WHERE u.email = ?0 and u.senha = ?1";
			Query query = getEntityManager().createQuery(sql);
			query.setParameter(0, email);
			query.setParameter(1, Util.hash(usu));
			if((Usuario) query.getSingleResult() instanceof PessoaFisica) {
				return (PessoaFisica) query.getSingleResult();
			} else if ((Usuario) query.getSingleResult() instanceof PessoaJuridica) {
				return (PessoaJuridica) query.getSingleResult();
			} else {
				return null;
			}
			
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o verifyLogin.");
		}		
	}
	
	public String findNomePfById(Integer id) throws RepositoryException {
		try { 
			String sql = "SELECT pf.nome FROM Usuario u,PessoaFisica pf WHERE u.id = ?0 AND u.id = pf.id";
			Query query = getEntityManager().createNativeQuery(sql);
			query.setParameter(0, id);
			return query.getSingleResult().toString();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findNomePfById.");
		}		
	}
	
	public String findNomePjById(Integer id) throws RepositoryException {
		try { 
			String sql = "SELECT pj.nomefantasia FROM Usuario u,PessoaJuridica pj WHERE u.id = ?0 AND u.id = pj.id";
			Query query = getEntityManager().createNativeQuery(sql);
			query.setParameter(0, id);
			return query.getSingleResult().toString();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findNomePjById.");
		}		
	}
	
}