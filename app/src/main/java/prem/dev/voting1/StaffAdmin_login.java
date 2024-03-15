package prem.dev.voting1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class StaffAdmin_login extends AppCompatActivity {
    EditText email, password;
    Button btn_login;
    DatabaseReference creference,vreference;
    FirebaseAuth saauth;
    TextView sign_in,check;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_admin_login);


        email = findViewById(R.id.saemail);
        password = findViewById(R.id.sapassword);
        btn_login = findViewById(R.id.sabtn_login);
        //sign_in = findViewById(R.id.sasign_in_login);

        saauth = FirebaseAuth.getInstance();
        String Uid2 = saauth.getUid();


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();


                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(StaffAdmin_login.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {

                    saauth.signInWithEmailAndPassword(txt_email, txt_password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()){
                                        Intent intent = new Intent(StaffAdmin_login.this, Staff_Dashboard.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();





                                    }


                                    else {
                                        Toast.makeText(StaffAdmin_login.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

            }
        });

    }
}