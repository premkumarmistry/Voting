package prem.dev.voting1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Candidate_login extends AppCompatActivity {
    EditText email, password;
    Button btn_login;
    User vote ;
    DatabaseReference creference,vreference;
    FirebaseAuth clauth;
    TextView sign_in,check;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_login);




        email = findViewById(R.id.Cllemail);
        password = findViewById(R.id.Cllpassword);
        btn_login = findViewById(R.id.Cllbtn_login);
        sign_in = findViewById(R.id.Cllsign_in_login);

        clauth = FirebaseAuth.getInstance();
        String Uid2 = clauth.getUid();





        creference = FirebaseDatabase.getInstance().getReference("CandidateUsers").child(Uid2);




        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Reg = new Intent(Candidate_login.this, Register_mainscreen.class);
                startActivity(Reg);
            }
        });

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = clauth.getCurrentUser();
                if( mFirebaseUser != null){
                    Toast.makeText(Candidate_login.this, "You Are Logged In", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent (Candidate_login.this, MainActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Candidate_login.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();


                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(Candidate_login.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {

                    clauth.signInWithEmailAndPassword(txt_email, txt_password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()){
                                        Intent intent = new Intent(Candidate_login.this, Candidate_Login_Check.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();

                                        //User vote = snapshot.getValue(User.class);

                                            /*if (vote.getIsCandidate().equals("true")) {
                                                Intent intent = new Intent(login.this, candidate_dashboard.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                startActivity(intent);
                                                finish();*/

                                              /*  if (){

                                                    Intent intent = new Intent(login.this, candidate_dashboard.class);
                                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    startActivity(intent);
                                                    finish();


                                                }

                                               else  if (vote.getIsvoter().equals("true")){
                                                   Intent intent1 = new Intent(login.this, Voter_dashboard.class);
                                                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    startActivity(intent1);
                                                    finish();}



                                            }*/
                                    }


                                    else {
                                        Toast.makeText(Candidate_login.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

            }
        });

    }
}