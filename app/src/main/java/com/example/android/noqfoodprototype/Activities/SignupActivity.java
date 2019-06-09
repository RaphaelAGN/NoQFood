package com.example.android.noqfoodprototype.Activities;

        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AutoCompleteTextView;
        import android.widget.EditText;
        import android.widget.ProgressBar;
        import android.widget.Toast;
        import android.widget.Toolbar;

        import com.example.android.noqfoodprototype.R;
        import com.example.android.noqfoodprototype.constructors.Usuario;
        import com.example.android.noqfoodprototype.fragments.SignUpFragment;
        import com.google.android.gms.common.ConnectionResult;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.OnFailureListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;

public class SignupActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private String email, password;
    private static final String TAG = "SignupActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_signup, new SignUpFragment())
                .commit();

    }
}