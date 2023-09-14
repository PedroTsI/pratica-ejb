package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import com.gugawag.pdist.modelo.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;


import java.util.List;

@Stateless(name = "usuarioService")
public class UsuarioService {
    @EJB
    private UsuarioDAO usuarioDAO;
    @EJB
    private MensagemDAO mensagemDAO;

    public void inserir(long id, String nome) {
        Usuario novoUsuario = new Usuario(id, nome);
        this.usuarioDAO.inserir(novoUsuario);
        if (id == 4){
            novoUsuario.setNome(novoUsuario.getNome() + " -Alterado");
            this.mensagemDAO.inserirMSG(new Mensagem(50, "Mensagem Feita"));
        }
        if (id == 5){
            this.mensagemDAO.inserirMSG(new Mensagem(100, "Mensagem Feita 2"));
            throw new RuntimeException();
        }

    }

    public List<Usuario> listar() {
        return this.usuarioDAO.listar();
    }
}
