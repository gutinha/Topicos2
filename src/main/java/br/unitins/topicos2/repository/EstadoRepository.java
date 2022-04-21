package br.unitins.topicos2.repository;
import java.util.List;
import javax.persistence.Query;
import br.unitins.topicos2.model.Estado;
import br.unitins.topicos2.utils.RepositoryException;

public class EstadoRepository extends Repository<Estado>{
	
	@SuppressWarnings("unchecked")
	public List<Estado> findByNome(String nome) throws RepositoryException {
		try { 
			String sql = "SELECT e FROM Estado e WHERE lower(e.nome) LIKE lower(:nome) or lower(e.sigla) LIKE lower(:nome)";
			Query query = getEntityManager().createQuery(sql);
			query.setParameter("nome", "%" + nome + "%");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome(Estado)." + e.getMessage());
		}
	}

}
