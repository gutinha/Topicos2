package br.unitins.topicos2.repository;
import java.util.List;

import javax.persistence.Query;

import br.unitins.topicos2.model.Pais;
import br.unitins.topicos2.utils.RepositoryException;

public class PaisRepository extends Repository<Pais>{
	
	@SuppressWarnings("unchecked")
	public List<Pais> findByNome(String nome) throws RepositoryException {
		try { 
			String sql = "SELECT p FROM Pais p WHERE lower(p.pais_nome) LIKE lower(:paisNome) or lower(p.pais_name) LIKE lower(:paisNome)";
			Query query = getEntityManager().createQuery(sql);
			query.setParameter("paisNome", "%" + nome + "%");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome(País)." + e.getMessage());
		}
	}

}
