package br.comup.projetoup;

import java.util.ArrayList;

public class Aviso {

    private String mensagem;

    public Aviso() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public ArrayList<Aviso> avisosCadastrados(){
        ArrayList<Aviso> avisos = new ArrayList<>();

        Aviso aviso = new Aviso();
        aviso.setMensagem("Na sexta-feira (16/04) não teremos aula");
        avisos.add(aviso);

        aviso = new Aviso();
        aviso.setMensagem("Desejamos a todos uma feliz páscoa!");
        avisos.add(aviso);

        aviso = new Aviso();
        aviso.setMensagem("Na quinta-feira (21/04) e na sexta-feira (22/04) não teremos aula, retornamos as atividades na segunda-feira dia (25/04)");
        avisos.add(aviso);

        return avisos;
    }
}
