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

public class Voter_login extends AppCompatActivity {
    EditText email, password;
    Button btn_login;
    User vote ;
    DatabaseReference creference,vreference;
    FirebaseAuth vlauth;
    TextView sign_in,check;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voter_login);



        vlauth = FirebaseAuth.getInstance();

        String Uid1 = vlauth.getUid();
        Toast.makeText(Voter_login.this,Uid1, Toast.LENGTH_SHORT).show();


        vreference = FirebaseDatabase.getInstance().getReference("Users").child(Uid1);

        email = findViewById(R.id.vlemail);
        password = findViewById(R.id.vlpassword);
        btn_login = findViewById(R.id.vlbtn_login);
        sign_in = findViewById(R.id.vlsign_in_login);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Reg1 = new Intent(Voter_login.this, Register_mainscreen.class);
                startActivity(Reg1);
            }
        });


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = vlauth.getCurrentUser();
                if( mFirebaseUser != null){
                    Toast.makeText(Voter_login.this, "You Are Logged In", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent (Voter_login.this, MainActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Voter_login.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();


                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(Voter_login.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {

                    vlauth.signInWithEmailAndPassword(txt_email, txt_password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()){

                                        Intent intent = new Intent(Voter_login.this, login_check.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();




                                       /* vreference.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                Toast.makeText(getApplicationContext(), "Cref", Toast.LENGTH_SHORT).show();
                                                String name = (String) snapshot.child("isvoter").getValue().toString();
                                                String name1 = (String) snapshot.child("isCandidate").getValue().toString();

                                                if (name != null) {
                                                    if (name.equals("true")) {

                                                        Intent intent = new Intent(Voter_login.this, Voter_dashboard.class);
                                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                        startActivity(intent);
                                                        finish();

                                                    }

                                                    else if (name1.equals("true")) {


                                                        Intent intent = new Intent(Voter_login.this, Voter_dashboard.class);
                                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                        startActivity(intent);
                                                        finish();
                                                    }
                                                    else {
                                                        Toast.makeText(getApplicationContext(), "Cref-else-part", Toast.LENGTH_SHORT).show();

                                                    }
                                                } else {
                                                    Toast.makeText(getApplicationContext(), "Cref-Second-else-part", Toast.LENGTH_SHORT).show();


                                                }

                                            }






                                            @Override
                                            public void onCancelled(@NonNull DatabaseError error) {

                                            }
                                        });
*/
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
                                        Toast.makeText(Voter_login.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

            }
        });

    }
}