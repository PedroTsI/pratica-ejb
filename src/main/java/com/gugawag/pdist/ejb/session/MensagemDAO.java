package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class MensagemDAO {

    @PersistenceContext(unitName = "bd2")
    private EntityManager em;

    public void inserirMSG(Mensagem novaMensagem) { em. persist(novaMensagem);}

    public List<Mensagem> listar(){ return em.createQuery("SELECT u FROM tb_mensagem_pdist u").getResultList();}

    public Mensagem pesquisarPorId(long id){return (Mensagem) em.createQuery("SELECT m FROM tb_mensagem_pdist m WHERE m.id = " +id).getResultList().get(0);}

}
