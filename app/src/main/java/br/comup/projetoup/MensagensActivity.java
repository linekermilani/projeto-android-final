package br.comup.projetoup;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MensagensActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Mensagem> mensagens = new ArrayList<>();
    Mensagem mensagem;
    FirebaseFirestore db;
    MensagemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagens);
        setTitle("Mensagens");

        recyclerView = findViewById(R.id.listaMensagens);
        mensagem = new Mensagem();

        //mensagens = mensagem.mensagensCadastradas();

        db = FirebaseFirestore.getInstance();

        adapter = new MensagemAdapter(mensagens);

        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        TextInputEditText txtEnviarMensagem = findViewById(R.id.edit_text_mensagem);
        Button botaoEnviar = findViewById(R.id.botaoEnviar);
        fireBaseMensagem();

        botaoEnviar.setOnClickListener(v -> {

            mensagem = new Mensagem();
            String descricao = txtEnviarMensagem.getText().toString();
            mensagem.setDescricao(descricao);
            mensagem.setStatus(1);
            mensagens.add(mensagem);
            adapter.notifyDataSetChanged();
            txtEnviarMensagem.setText("");
            db.collection("mensagens").add(mensagem);
        });
    }

    private void fireBaseMensagem() {
        db.collection("mensagens").get().
            addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot task) {
                if(!task.isEmpty()) {
                    List<DocumentSnapshot> documents = task.getDocuments();
                    for(DocumentSnapshot document : documents) {
                        Mensagem m = document.toObject(Mensagem.class);
                        mensagens.add(m);
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MensagensActivity.this, "Sem dados", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MensagensActivity.this, "Erro ao carregar as mensagens", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
