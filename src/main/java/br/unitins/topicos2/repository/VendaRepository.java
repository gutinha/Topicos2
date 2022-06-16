package br.unitins.topicos2.repository;

import java.util.List;
import javax.persistence.Query;

import br.unitins.topicos2.model.Venda;
import br.unitins.topicos2.utils.RepositoryException;

public class VendaRepository extends Repository<Venda> {

	public List<Venda> findByNome(String nome) throws RepositoryException {
		return findByNome(nome, null);
	}

	@SuppressWarnings("unchecked")
	public List<Venda> findByNome(String nome, Integer maxResults) throws RepositoryException {
		try {
			String sql = "SELECT v FROM Venda v WHERE v.id = :id";
			Query query = getEntityManager().createQuery(sql);
			query.setParameter("id", "%" + nome + "%");
			if (maxResults != null)
				query.setMaxResults(maxResults);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome(Venda)." + e.getMessage());
		}
	}

}
