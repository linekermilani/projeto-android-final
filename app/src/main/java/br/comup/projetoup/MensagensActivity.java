package br.comup.projetoup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MensagensActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Mensagem> mensagens = new ArrayList<>();
    Mensagem mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagens);
        setTitle("Mensagens");
        recyclerView = findViewById(R.id.listaMensagens);
        mensagem = new Mensagem();

        mensagens = mensagem.mensagensCadastradas();

        MensagemAdapter adapter = new MensagemAdapter(mensagens);

        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        TextInputEditText txtEnviarMensagem = findViewById(R.id.edit_text_mensagem);
        Button botaoEnviar = findViewById(R.id.botaoEnviar);

        botaoEnviar.setOnClickListener(v -> {

            mensagem = new Mensagem();
            String descricao = txtEnviarMensagem.getText().toString();
            mensagem.setDescricao(descricao);
            mensagem.setStatus(1);
            mensagens.add(mensagem);
            adapter.notifyDataSetChanged();
            txtEnviarMensagem.setText("");

        });
    }
}
