package br.comup.projetoup;

import java.util.ArrayList;

public class Mensagem {

    private String descricao;
    private Integer status;

    public Mensagem(){
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ArrayList<Mensagem> mensagensCadastradas(){
        ArrayList<Mensagem> mensagens = new ArrayList<>();

        Mensagem mensagem = new Mensagem();
        mensagem.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Porta non pulvinar neque laoreet suspendisse interdum.");
        mensagem.setStatus(1);
        mensagens.add(mensagem);

        mensagem = new Mensagem();
        mensagem.setDescricao("Turpis egestas pretium aenean pharetra magna. Tellus orci ac auctor augue.");
        mensagem.setStatus(0);
        mensagens.add(mensagem);

        mensagem = new Mensagem();
        mensagem.setDescricao("Duis at tellus at urna condimentum mattis pellentesque.");
        mensagem.setStatus(1);
        mensagens.add(mensagem);

        mensagem = new Mensagem();
        mensagem.setDescricao("Rhoncus mattis rhoncus urna neque viverra justo nec ultrices.");
        mensagem.setStatus(0);
        mensagens.add(mensagem);

        return mensagens;
    }
}
