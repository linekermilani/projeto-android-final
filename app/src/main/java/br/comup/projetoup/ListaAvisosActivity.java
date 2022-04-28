package br.comup.projetoup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListaAvisosActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Aviso> avisos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_avisos);
        setTitle("Avisos");
        recyclerView = findViewById(R.id.listaAvisos);
        Aviso aviso = new Aviso();

        avisos = aviso.avisosCadastrados();

        AvisoAdapter adapter = new AvisoAdapter(avisos);

        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }



}