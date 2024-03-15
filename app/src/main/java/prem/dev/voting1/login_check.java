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

public class login_check extends AppCompatActivity {
    DatabaseReference creference,vreference;
    FirebaseAuth auth;
    User vote1;

    int check = 0 ;
    //DataSnapshot snapshot1,snapshot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_check);
        auth = FirebaseAuth.getInstance();
        String Uid = auth.getUid();
        String Uid1 = auth.getUid();
        // User vote1 = snapshot1.getValue(User.class);


        vreference = FirebaseDatabase.getInstance().getReference("Users").child(Uid1);


        creference = FirebaseDatabase.getInstance().getReference("CandidateUsers").child(Uid);
     /*   creference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User vote = snapshot.getValue(User.class);

                if (vote.getIsCandidate().equals("true")) {
                    Intent intent = new Intent(login_check.this, candidate_dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
                else if (vote.getIsvoter().equals("true")){
                    Intent intent = new Intent(login_check.this, Voter_dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();


                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/



        vreference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Toast.makeText(getApplicationContext(), "Cref", Toast.LENGTH_SHORT).show();


                try {
                    // Toast.makeText(getApplicationContext(), "Entered Try", Toast.LENGTH_SHORT).show();

                    String name = (String) snapshot.child("isCandidate").getValue().toString();
                    String name1 = (String) snapshot.child("isvoter").getValue().toString();

                    if (name.equals("false") && name1.equals("true")) {

                        Intent intent = new Intent(login_check.this, Voter_dashboard.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();

                    } /*else if ( {


                    Intent intent = new Intent(Candidate_Login_Check.this, Voter_dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();

                } */ else {
                        Toast.makeText(getApplicationContext(), "You Are Not A Voter User", Toast.LENGTH_SHORT).show();

                    }


                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "You Are Not A Voter User", Toast.LENGTH_SHORT).show();

                    Intent intent1 = new Intent(login_check.this, Choose_Login.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent1);
                    finish();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });



    /*    vreference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot1) {
                Toast.makeText(getApplicationContext(),"Vref",Toast.LENGTH_SHORT).show();

                name1 = snapshot1.child("isvoter").getValue().toString();
                if (name1.equals("true")) {
                    Intent intent = new Intent(login_check.this, Voter_dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();


                }
                else {


                    Toast.makeText(getApplicationContext(),"Cref-else-part",Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
                                         }*/

       /* String name = (String) snapshot1.child("isCandidate").getValue().toString();
        String name1 = (String) snapshot.child("isVoter").getValue().toString();*/


    }}
/*
        if (check == 0) {
            creference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot2) {


                    String name = (String) snapshot1.child("isCandidate").getValue().toString();

                    if (name.equals("true")) {
                        check = 1;
                        Intent intent = new Intent(login_check.this, candidate_dashboard.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }
            else if (check == 0){

            vreference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String name1 = (String) snapshot.child("isVoter").getValue().toString();


                    if(name1.equals("true")) ;
                        check = 1;
                        Intent intent = new Intent(login_check.this, candidate_dashboard.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }




                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }*/

                //endof create



