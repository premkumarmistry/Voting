package prem.dev.voting1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class cVote extends AppCompatActivity {
    Button cparty1, cparty2, cparty3, cparty4, clogout;
    TextView ctextParties1, ctextParties2, ctextParties3, ctextParties4;

    int cvoteCountParty1 = 0;
    int cvoteCountParty2 = 0;
    int cvoteCountParty3 = 0;
    int cvoteCountParty4 = 0;

    DatabaseReference creference;
    FirebaseAuth cauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_vote);

        clogout = findViewById(R.id.clogout);
        cauth = FirebaseAuth.getInstance();
        String Uid = cauth.getUid();
        cparty1 = findViewById(R.id.cparty1);
        cparty2 = findViewById(R.id.cparty2);
        cparty3 = findViewById(R.id.cparty3);
        cparty4 = findViewById(R.id.cparty4);
        creference = FirebaseDatabase.getInstance().getReference("CandidateUsers").child(Uid);




        DatabaseReference partyRef = FirebaseDatabase.getInstance().getReference("Parties");

        partyRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Parties parties = snapshot.getValue(Parties.class);
                assert parties != null;

                int parties1 = parties.getParties1();
                int parties2 = parties.getParties2();
                int parties3 = parties.getParties3();
                int parties4 = parties.getParties4();


                cvoteCountParty1 = parties1 + 1;
                cvoteCountParty2 = parties2 + 1;
                cvoteCountParty3 = parties3 + 1;
                cvoteCountParty4 = parties4 + 1;

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        creference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = (String) snapshot.child("cVoted").getValue().toString();


                if (name.equals("false")){

                    cparty1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                           // User vote = snapshot.getValue(User.class);

                            FirebaseUser firebaseUser = cauth.getCurrentUser();


                            Map<String, Object> hashMap = new HashMap<>();
                            hashMap.put("cVoted", "true");
                            creference.updateChildren(hashMap);



                            DatabaseReference partyRef = FirebaseDatabase.getInstance().getReference("Parties");

                            partyRef.child("parties1").setValue(cvoteCountParty1);

                            Toast.makeText(cVote.this, "Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                    cparty2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            //User vote = snapshot.getValue(User.class);
                            Map<String, Object> hashMap = new HashMap<>();
                            hashMap.put("cVoted", "true");
                            creference.updateChildren(hashMap);



                            DatabaseReference partyRef = FirebaseDatabase.getInstance().getReference("Parties");

                            partyRef.child("parties2").setValue(cvoteCountParty2);

                            Toast.makeText(cVote.this, "Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                    cparty3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                           // User vote = snapshot.getValue(User.class);
                            Map<String, Object> hashMap = new HashMap<>();
                            hashMap.put("cVoted", "true");
                            creference.updateChildren(hashMap);



                            DatabaseReference partyRef = FirebaseDatabase.getInstance().getReference("Parties");

                            partyRef.child("parties3").setValue(cvoteCountParty3);

                            Toast.makeText(cVote.this, "Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                    cparty4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                          //  User vote = snapshot.getValue(User.class);
                            Map<String, Object> hashMap = new HashMap<>();
                            hashMap.put("cVoted", "true");
                            creference.updateChildren(hashMap);


                            DatabaseReference partyRef = FirebaseDatabase.getInstance().getReference("Parties");

                            partyRef.child("parties4").setValue(cvoteCountParty4);

                            Toast.makeText(cVote.this, "Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                else{

                    cparty1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(cVote.this, "You have already Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                    cparty2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(cVote.this, "You have already Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                    cparty3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(cVote.this, "You have already Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                    cparty4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(cVote.this, "You have already Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        clogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(cVote.this, login.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

            }
        });

    }

}