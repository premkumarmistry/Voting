package prem.dev.voting1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Candidate_Login_Check extends AppCompatActivity {
    DatabaseReference creference, vreference;
    FirebaseAuth auth;
    User vote1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate__login__check);

        auth = FirebaseAuth.getInstance();
        String Uid = auth.getUid();
        String Uid1 = auth.getUid();

        creference = FirebaseDatabase.getInstance().getReference("CandidateUsers").child(Uid);



            creference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                   // Toast.makeText(getApplicationContext(), "Cref", Toast.LENGTH_SHORT).show();


                    try {
                       // Toast.makeText(getApplicationContext(), "Entered Try", Toast.LENGTH_SHORT).show();

                        String name = (String) snapshot.child("isCandidate").getValue().toString();
                        String name1 = (String) snapshot.child("Cisvoter").getValue().toString();


                        if (name.equals("true") && name1.equals("false")) {

                            Intent intent = new Intent(Candidate_Login_Check.this, candidate_dashboard.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();

                        } /*else if ( {


                    Intent intent = new Intent(Candidate_Login_Check.this, Voter_dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();

                } */ else {
                            Toast.makeText(getApplicationContext(), "You Are Not A Candidate User", Toast.LENGTH_SHORT).show();

                        }


                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "You Are Not A Candidate User", Toast.LENGTH_SHORT).show();

                        Intent intent1 = new Intent(Candidate_Login_Check.this, Choose_Login.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent1);
                        finish();

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            });


    }
}


