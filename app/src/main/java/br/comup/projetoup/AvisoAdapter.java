package br.comup.projetoup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AvisoAdapter extends RecyclerView.Adapter<AvisoAdapter.AvisoViewHolder> {

    private ArrayList<Aviso> avisos;

    public AvisoAdapter(ArrayList<Aviso> lista) {
        this.avisos = lista;
    }

    @NonNull
    @Override
    // Cria uma instância do item_aviso.xml para ser o template da nossa lista.
    public AvisoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View layout = layoutInflater.inflate(R.layout.item_aviso, parent, false);

        AvisoViewHolder avisoViewHolder = new AvisoViewHolder(layout);
        return avisoViewHolder;
    }

    @Override
    // Pega cada item da lista instanciada e seta os valores no xml de acordo com o item da lista
    public void onBindViewHolder(@NonNull AvisoViewHolder holder, int position) {

        Aviso item = avisos.get(position);

        TextView txtMensagem = holder.itemView.findViewById(R.id.mensagem_user);

        txtMensagem.setText(item.getMensagem());
    }

    @Override
    public int getItemCount() {
        return avisos.size();
    }

    public class AvisoViewHolder extends RecyclerView.ViewHolder {
        public AvisoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
