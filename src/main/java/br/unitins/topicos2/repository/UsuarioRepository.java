package br.unitins.topicos2.repository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.utils.RepositoryException;

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
	
}