
package br.com.barbearia.repository;

import br.com.barbearia.entity.Funcionario;
import br.com.barbearia.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class FuncionarioRepository {

    public void salvar(Funcionario obj) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Funcionario buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Funcionario.class, id);
        } finally {
            em.close();
        }
    }

    public List<Funcionario> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Funcionario", Funcionario.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Funcionario obj = em.find(Funcionario.class, id);
            if (obj != null) {
                em.remove(obj);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
