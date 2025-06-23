
package br.com.barbearia.repository;

import br.com.barbearia.entity.Cliente;
import br.com.barbearia.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteRepository {

    public void salvar(Cliente obj) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Cliente buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public List<Cliente> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Cliente", Cliente.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Cliente obj = em.find(Cliente.class, id);
            if (obj != null) {
                em.remove(obj);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
