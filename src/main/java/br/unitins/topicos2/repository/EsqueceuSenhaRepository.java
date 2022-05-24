package br.unitins.topicos2.repository;

import java.time.LocalDateTime;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.unitins.topicos2.model.EsqueceuSenha;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.utils.RepositoryException;

public class EsqueceuSenhaRepository extends Repository<EsqueceuSenha>  {

	public Usuario findUserByCodigo(String codigo) throws RepositoryException {
		try { 
			String sql = "SELECT u FROM Usuario u,EsqueceuSenha e WHERE e.codigo = :codigo AND e.usuario.id = u.id AND e.utilizado = false";
			Query query = getEntityManager().createQuery(sql);
			query.setParameter("codigo", codigo);

			return (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findUserByCodigo.");
		}		
	}
	
	public EsqueceuSenha validateCodigo(String codigo) throws RepositoryException {
		try { 
			String sql = "SELECT e FROM EsqueceuSenha e WHERE e.codigo = ?0 AND e.utilizado = false AND e.dataHoraLimite > ?1";
			Query query = getEntityManager().createQuery(sql);
			query.setParameter(0, codigo);
			query.setParameter(1, LocalDateTime.now());
			return (EsqueceuSenha) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByCodigo.");
		}	
	}

}
