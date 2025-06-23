package br.com.barbearia.repository;

import br.com.barbearia.entity.Agendamento;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AgendamentoRepository {

    private EntityManager em;

    public AgendamentoRepository(EntityManager em) {
        this.em = em;
    }

    public void salvar(Agendamento agendamento) {
        em.getTransaction().begin();
        em.persist(agendamento);
        em.getTransaction().commit();
    }

    public Agendamento buscarPorId(Long id) {
        return em.find(Agendamento.class, id);
    }

    public List<Agendamento> buscarTodos() {
        return em.createQuery("SELECT a FROM Agendamento a", Agendamento.class).getResultList();
    }

    public void atualizar(Agendamento agendamento) {
        em.getTransaction().begin();
        em.merge(agendamento);
        em.getTransaction().commit();
    }

    public void deletar(Long id) {
        em.getTransaction().begin();
        Agendamento agendamento = em.find(Agendamento.class, id);
        if (agendamento != null) {
            em.remove(agendamento);
        }
        em.getTransaction().commit();
    }
}
