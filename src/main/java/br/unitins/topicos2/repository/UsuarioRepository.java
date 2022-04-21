package br.unitins.topicos2.repository;

import java.util.List;
import javax.persistence.Query;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.utils.RepositoryException;

public class UsuarioRepository extends Repository<Usuario> {
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findByEmailAndDTYPE(String email, String dtype) throws RepositoryException {
		try { 
			String sql = "SELECT u FROM Usuario u WHERE u.email LIKE ?0 and DTYPE LIKE ?1";
			Query query = getEntityManager().createQuery(sql);
			query.setParameter(0, "%" + email + "%");
			query.setParameter(1, "%" + dtype + "%");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByEmailAndDTYPE.");
		}
	}
	
}