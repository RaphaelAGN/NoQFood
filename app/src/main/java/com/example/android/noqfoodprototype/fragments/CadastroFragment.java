package com.example.android.noqfoodprototype.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.noqfoodprototype.Activities.MainActivity;
import com.example.android.noqfoodprototype.constructors.Usuario;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.android.noqfoodprototype.R;

public class CadastroFragment extends Fragment {

    private EditText nomeID, numCartao;
    private Button btn_cadastrar;
    private FirebaseAuth auth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    public CadastroFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro, container, false);

        nomeID = (EditText) view.findViewById(R.id.nomeID);
        //numCartao = (EditText) view.findViewById(R.id.cadastroNumCartao);
        btn_cadastrar = (Button) view.findViewById(R.id.btn_saveCadastro);
        auth = FirebaseAuth.getInstance();

        inicializarFirebase();

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nomeID.getText()!=null){
                    Usuario usuario = new Usuario();
                    usuario.setNome(nomeID.getText().toString());
                    databaseReference.child("Usuario").child(auth.getCurrentUser().getUid()).setValue(usuario);
                    startActivity(new Intent(getActivity(), MainActivity.class));
                }
                else{
                    Toast.makeText(getContext(),"Preencha todos os campos",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    public void inicializarFirebase(){
        FirebaseApp.initializeApp(getContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}
