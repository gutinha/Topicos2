package br.unitins.topicos2.repository;

import java.util.List;
import javax.persistence.Query;
import br.unitins.topicos2.model.PessoaJuridica;
import br.unitins.topicos2.utils.RepositoryException;

public class PessoaJuridicaRepository extends Repository<PessoaJuridica> {
	
	@SuppressWarnings("unchecked")
	public List<PessoaJuridica> findByEmail(String email) throws RepositoryException {
		try { 
			String sql = "SELECT pj FROM PessoaJuridica pj WHERE pj.email LIKE :email";
			Query query = getEntityManager().createQuery(sql);
			query.setParameter("email", "%" + email + "%");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByEmail(PJ).");
		}
	}
	
}