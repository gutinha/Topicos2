package br.unitins.topicos2.repository;

import java.util.List;
import javax.persistence.Query;

import br.unitins.topicos2.model.Dominio;
import br.unitins.topicos2.utils.RepositoryException;

public class DominioRepository extends Repository<Dominio> {

	public List<Dominio> findByNome(String nome) throws RepositoryException {
		return findByNome(nome, null);
	}

	@SuppressWarnings("unchecked")
	public List<Dominio> findByNome(String nome, Integer maxResults) throws RepositoryException {
		try {
			String sql = "SELECT e FROM Dominio e WHERE lower(e.dominio) LIKE lower(:nome) AND e.ativo = true";
			Query query = getEntityManager().createQuery(sql);
			query.setParameter("nome", "%" + nome + "%");
			if (maxResults != null)
				query.setMaxResults(maxResults);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome(Dominio)." + e.getMessage());
		}
	}

}
