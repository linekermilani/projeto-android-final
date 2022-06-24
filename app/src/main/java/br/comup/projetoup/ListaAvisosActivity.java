package br.comup.projetoup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListaAvisosActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Aviso> avisos = new ArrayList<>();
    FirebaseFirestore db;
    AvisoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_avisos);
        setTitle("Avisos");
        recyclerView = findViewById(R.id.listaAvisos);
        Aviso aviso = new Aviso();

        db = FirebaseFirestore.getInstance();
        //avisos = aviso.avisosCadastrados();

        adapter = new AvisoAdapter(avisos);

        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        fireBaseAviso();
    }

    private void fireBaseAviso() {
        db.collection("avisos").get().
                addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot task) {
                        if(!task.isEmpty()) {
                            List<DocumentSnapshot> documents = task.getDocuments();
                            for(DocumentSnapshot document : documents) {
                                Aviso m = document.toObject(Aviso.class);
                                avisos.add(m);
                            }
                            adapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(ListaAvisosActivity.this, "", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ListaAvisosActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }

}