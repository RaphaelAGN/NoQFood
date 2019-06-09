package com.example.android.noqfoodprototype.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.noqfoodprototype.Activities.LoginActivity;
import com.example.android.noqfoodprototype.Activities.MainActivity;
import com.example.android.noqfoodprototype.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class SignUpFragment extends Fragment {
    private EditText inputEmail, inputPassword, inputConfirm;
    private TextView txtLogin;
    private Button btnSignUp;
    private FirebaseAuth auth;
    private LinearLayout signup_layout;
    private LinearLayout fragment;


    public SignUpFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        txtLogin = (TextView) view.findViewById(R.id.txt_loginID);
        btnSignUp = (Button) view.findViewById(R.id.btn_createID);
        inputEmail = (EditText) view.findViewById(R.id.edt_create_emailID);
        inputPassword = (EditText) view.findViewById(R.id.edt_create_passwordID);
        inputConfirm = (EditText) view.findViewById(R.id.edt_create_confirmID);
        signup_layout = (LinearLayout) view.findViewById(R.id.fragment_signup);


        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String confirm = inputConfirm.getText().toString().trim();

                if (email.isEmpty()) {
                    Toast.makeText(getContext(), "Entre com o seu email!", Toast.LENGTH_SHORT).show();
                    //return;
                }

                if (password.isEmpty()) {
                    Toast.makeText(getContext(), "Escolha uma senha!", Toast.LENGTH_SHORT).show();
                    //return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getContext(), "Senha muito curta, minimo de 6 caracteres!", Toast.LENGTH_SHORT).show();
                    //return;
                }
                if(!confirm.equals(password)){
                    Toast.makeText(getContext(), "Senhas diferentes", Toast.LENGTH_SHORT).show();
                    //return;
                }

                //startActivity(new Intent(getActivity(), MainActivity.class));
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                } else {
                                    CadastroFragment newFragment = new CadastroFragment();
                                    FragmentTransaction transaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                                    // Replace whatever is in the fragment_container view with this fragment,
                                    // and add the transaction to the back stack so the user can navigate back
                                    transaction.replace(R.id.layout_signup, newFragment);
                                    transaction.addToBackStack(null);
                                    // Commit the transaction
                                    transaction.commit();
                                }
                            }
                        });


            }
        });
        return view;
    }

}
