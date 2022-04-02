package br.unitins.topicos2.repository;

import java.util.List;
import javax.persistence.Query;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.utils.RepositoryException;

public class UsuarioRepository extends Repository<Usuario> {
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findByNome(String nome) throws RepositoryException {
		try { 
			String sql = "SELECT u FROM Usuario u WHERE u.nome LIKE :nome";
			Query query = getEntityManager().createQuery(sql);
			query.setParameter("nome", "%" + nome + "%");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}
	}
	
}