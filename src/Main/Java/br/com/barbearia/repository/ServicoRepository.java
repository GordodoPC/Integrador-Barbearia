
package br.com.barbearia.repository;

import br.com.barbearia.entity.Servico;
import br.com.barbearia.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ServicoRepository {

    public void salvar(Servico obj) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Servico buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Servico.class, id);
        } finally {
            em.close();
        }
    }

    public List<Servico> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Servico", Servico.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Servico obj = em.find(Servico.class, id);
            if (obj != null) {
                em.remove(obj);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
