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

public class vVote extends AppCompatActivity {

    Button party1, party2, party3, party4, logout;
    TextView textParties1, textParties2, textParties3, textParties4;

    int voteCountParty1 = 0;
    int voteCountParty2 = 0;
    int voteCountParty3 = 0;
    int voteCountParty4 = 0;

    DatabaseReference reference;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_vote);
        logout = findViewById(R.id.logout);
        auth = FirebaseAuth.getInstance();
        String Uid = auth.getUid();
        party1 = findViewById(R.id.party1);
        party2 = findViewById(R.id.party2);
        party3 = findViewById(R.id.party3);
        party4 = findViewById(R.id.party4);
        reference = FirebaseDatabase.getInstance().getReference("Users").child(Uid);

     /*   party1 = findViewById(R.id.party1);
        party2 = findViewById(R.id.party2);
        party3 = findViewById(R.id.party3);
        party4 = findViewById(R.id.party4);
        logout = findViewById(R.id.logout);

        textParties1 = findViewById(R.id.textParties1);
        textParties2 = findViewById(R.id.textParties2);
        textParties3 = findViewById(R.id.textParties3);
        textParties4 = findViewById(R.id.textParties4);*/

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


                voteCountParty1 = parties1 + 1;
                voteCountParty2 = parties2 + 1;
                voteCountParty3 = parties3 + 1;
                voteCountParty4 = parties4 + 1;

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Vote vote1 = snapshot.getValue(Vote.class);
                if (vote1.getVoted().equals("false")){

                    party1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            User vote = snapshot.getValue(User.class);
                        /*    HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("id", vote.getId());
                            hashMap.put("name", vote.getName());
                            hashMap.put("email", vote.getEmail());
                            hashMap.put("voted", "true");

                            reference.setValue(hashMap);*/
                            FirebaseUser firebaseUser = auth.getCurrentUser();

                            
                            Map<String, Object> hashMap = new HashMap<>();
                            hashMap.put("voted", "true");
                            reference.updateChildren(hashMap);
                            
                            
                            
                            DatabaseReference partyRef = FirebaseDatabase.getInstance().getReference("Parties");

                            partyRef.child("parties1").setValue(voteCountParty1);

                            Toast.makeText(vVote.this, "Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                    party2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            User vote = snapshot.getValue(User.class);
                            Map<String, Object> hashMap = new HashMap<>();
                            hashMap.put("voted", "true");
                            reference.updateChildren(hashMap);



                            DatabaseReference partyRef = FirebaseDatabase.getInstance().getReference("Parties");

                            partyRef.child("parties2").setValue(voteCountParty2);

                            Toast.makeText(vVote.this, "Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                    party3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            User vote = snapshot.getValue(User.class);
                            Map<String, Object> hashMap = new HashMap<>();
                            hashMap.put("voted", "true");
                            reference.updateChildren(hashMap);



                            DatabaseReference partyRef = FirebaseDatabase.getInstance().getReference("Parties");

                            partyRef.child("parties3").setValue(voteCountParty3);

                            Toast.makeText(vVote.this, "Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                    party4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            User vote = snapshot.getValue(User.class);
                            Map<String, Object> hashMap = new HashMap<>();
                            hashMap.put("voted", "true");
                            reference.updateChildren(hashMap);


                            DatabaseReference partyRef = FirebaseDatabase.getInstance().getReference("Parties");

                            partyRef.child("parties4").setValue(voteCountParty4);

                            Toast.makeText(vVote.this, "Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                }else{

                    party1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(vVote.this, "You have already Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                    party2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(vVote.this, "You have already Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                    party3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(vVote.this, "You have already Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                    party4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(vVote.this, "You have already Voted", Toast.LENGTH_SHORT).show();

                        }
                    });

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(vVote.this, MainScreen.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

            }
        });

    }

}