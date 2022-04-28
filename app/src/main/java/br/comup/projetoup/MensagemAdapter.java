package br.comup.projetoup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MensagemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Mensagem> mensagens;

    public MensagemAdapter(ArrayList<Mensagem> listaMensagens) {
        this.mensagens = listaMensagens;
    }

    @NonNull
    // Cria uma instância do item_aviso.xml para ser o template da nossa lista.
    public MensagemEnviadaViewHolder onCreateViewHolderEnviada(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View layoutEnviada = layoutInflater.inflate(R.layout.item_enviada, parent, false);
        MensagemEnviadaViewHolder mensagemEnviadaViewHolder = new MensagemEnviadaViewHolder(layoutEnviada);
        return mensagemEnviadaViewHolder;
    }

    public MensagemRecebidaViewHolder onCreateViewHolderRecebida(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View layoutRecebida = layoutInflater.inflate(R.layout.item_recebida, parent, false);
        MensagemRecebidaViewHolder mensagemRecebidaViewHolder = new MensagemRecebidaViewHolder(layoutRecebida);
        return mensagemRecebidaViewHolder;
    }

    // Pega cada item da lista instanciada e seta os valores no xml de acordo com o item da lista
    public void onBindViewHolder(@NonNull MensagemEnviadaViewHolder holder, int position) {

        Mensagem descricao = mensagens.get(position);

        TextView txtDescricao = holder.itemView.findViewById(R.id.mensagem_enviada);

        txtDescricao.setText(descricao.getDescricao());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mensagens.size();
    }

    public class MensagemEnviadaViewHolder extends RecyclerView.ViewHolder {
        public MensagemEnviadaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class MensagemRecebidaViewHolder extends RecyclerView.ViewHolder {
        public MensagemRecebidaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
