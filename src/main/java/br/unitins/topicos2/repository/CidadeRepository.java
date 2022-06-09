package br.unitins.topicos2.repository;
import java.util.List;
import javax.persistence.Query;
import br.unitins.topicos2.model.Cidade;
import br.unitins.topicos2.utils.RepositoryException;

public class CidadeRepository extends Repository<Cidade>{
	
	@SuppressWarnings("unchecked")
	public List<Cidade> findByNome(String nome) throws RepositoryException {
		try { 
			String sql = "SELECT DISTINCT c FROM Cidade c, Estado e WHERE lower(c.nome) LIKE lower(:nome) or lower(e.nome) LIKE lower(:nome)";
			Query query = getEntityManager().createQuery(sql);
			query.setParameter("nome", "%" + nome + "%");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome(Cidade)." + e.getMessage());
		}
	}

	public List<Object[]> findByNomeSQL(String nome) throws RepositoryException {
		try { 
			String sql = "SELECT c.id, c.nome, e.nome as nomeEstado, e.sigla FROM Cidade c, Estado e WHERE c.id_estado = e.id AND lower(c.nome) LIKE lower(:nome) or lower(e.nome) LIKE lower(:nome)";
			Query query = getEntityManager().createNativeQuery(sql.toString());
			query.setParameter("nome", "%" + nome + "%");

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNomeSQL.");
		}
	}

}
