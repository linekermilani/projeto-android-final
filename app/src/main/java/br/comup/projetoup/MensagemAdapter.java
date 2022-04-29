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

    @Override
    public int getItemViewType(int position) {
        if(mensagens.get(position).getStatus() == 1) return R.layout.item_enviada;
        return R.layout.item_recebida;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View layout;

        if(viewType == R.layout.item_enviada) {
            layout = layoutInflater.inflate(R.layout.item_enviada, parent, false);
            return new MensagemEnviadaViewHolder(layout);
        }

        layout = layoutInflater.inflate(R.layout.item_recebida, parent, false);
        return new MensagemRecebidaViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType() == R.layout.item_enviada){
            MensagemEnviadaViewHolder enviadaViewHolder = (MensagemEnviadaViewHolder) holder;
            enviadaViewHolder.txtMensagem.setText(mensagens.get(position).getDescricao());
        } else {
            MensagemRecebidaViewHolder recebidaViewHolder = (MensagemRecebidaViewHolder) holder;
            recebidaViewHolder.txtMensagem.setText(mensagens.get(position).getDescricao());
        }

    }

    @Override
    public int getItemCount() {
        return mensagens.size();
    }

    public class MensagemEnviadaViewHolder extends RecyclerView.ViewHolder {
        TextView txtMensagem;
        public MensagemEnviadaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMensagem = itemView.findViewById(R.id.mensagem_enviada);
        }
    }

    public class MensagemRecebidaViewHolder extends RecyclerView.ViewHolder {
        TextView txtMensagem;
        public MensagemRecebidaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMensagem = itemView.findViewById(R.id.mensagem_recebida);
        }
    }

}
