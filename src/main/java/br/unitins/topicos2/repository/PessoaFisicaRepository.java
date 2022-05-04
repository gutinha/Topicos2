package br.unitins.topicos2.repository;

import java.util.List;
import javax.persistence.Query;
import br.unitins.topicos2.model.PessoaFisica;
import br.unitins.topicos2.utils.RepositoryException;

public class PessoaFisicaRepository extends Repository<PessoaFisica> {
	
	@SuppressWarnings("unchecked")
	public List<PessoaFisica> findByEmail(String email) throws RepositoryException {
		try { 
			String sql = "SELECT pf FROM PessoaFisica pf WHERE pf.email LIKE :email";
			Query query = getEntityManager().createQuery(sql);
			query.setParameter("email", "%" + email + "%");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByEmail(PF).");
		}
	}
	
}