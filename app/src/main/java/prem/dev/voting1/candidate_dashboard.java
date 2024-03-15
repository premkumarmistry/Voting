package prem.dev.voting1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class candidate_dashboard extends AppCompatActivity {
    ImageView one,two,three,four,five;

    ImageView invisible_one;
    TextView invisible_two,invisible_three;

    DatabaseReference creference,vote,ViewResult;
    FirebaseAuth cauth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_dashboard);




        cauth = FirebaseAuth.getInstance();
        String Uid = cauth.getUid();
        creference = FirebaseDatabase.getInstance().getReference("CandidateUsers").child(Uid);

        vote = FirebaseDatabase.getInstance().getReference("Voting").child("EnableVoting");
        ViewResult = FirebaseDatabase.getInstance().getReference("Result").child("EnableResult");


        one = findViewById(R.id.cp);
        two = findViewById(R.id.cu);
        three = findViewById(R.id.csf);
        four = findViewById(R.id.cv);
        five = findViewById(R.id.cr);

        invisible_one = findViewById(R.id.cimageView2);
        invisible_two = findViewById(R.id.Cverfication_text1);
        invisible_three = findViewById(R.id.cverfication_text2);



        four.setVisibility(View.GONE);
        five.setVisibility(View.GONE);

        creference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

//             User user = snapshot.getValue(User.class);

                // String isEnabled = (String) snapshot.child("CisEnabled").getValue().toString();
                String nam = (String) snapshot.child("cisEnabled").getValue().toString();


                if (nam.equals("No")){
                    invisible_one.setVisibility(View.VISIBLE);
                    invisible_two.setVisibility(View.VISIBLE);
                    invisible_three.setVisibility(View.VISIBLE);

                    one.setVisibility(View.GONE);

                    two.setVisibility(View.GONE);
                    three.setVisibility(View.GONE);


                    //email.setText(user.getEmail());

                }

                else {

                    invisible_one.setVisibility(View.GONE);
                    invisible_two.setVisibility(View.GONE);
                    invisible_three.setVisibility(View.GONE);

                    two.setVisibility(View.VISIBLE);
                    three.setVisibility(View.VISIBLE);
                    one.setVisibility(View.VISIBLE);
                    four.setVisibility(View.VISIBLE);
                    five.setVisibility(View.VISIBLE);



                }

            }


                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

      /*  vote.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String nam1 = (String) snapshot.child("isEnabled").getValue().toString();

                if (nam1.equals("false")){

                    four.setVisibility(View.GONE);
                    five.setVisibility(View.GONE);


                    //email.setText(user.getEmail());

                }

                else {
                    four.setVisibility(View.VISIBLE);
                    five.setVisibility(View.VISIBLE);



                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        //RESULT
 /*ViewResult.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String nam2 = (String) snapshot.child("EnableViewing").getValue().toString();
                if (nam2.equals("false")){


                    five.setVisibility(View.GONE);


                    //email.setText(user.getEmail());

                }

                else {
                    five.setVisibility(View.VISIBLE);
                    // five.setVisibility(View.VISIBLE);



                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/




                one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vp = new Intent(candidate_dashboard.this, Candidate_Profile.class);
                startActivity(vp);
            }
        });


               three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vp = new Intent(candidate_dashboard.this, cShareFeeds.class);
                startActivity(vp);
            }
        });




        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vp = new Intent(candidate_dashboard.this, cVote.class);
                startActivity(vp);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vp = new Intent(candidate_dashboard.this, cResult.class);
                startActivity(vp);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vp = new Intent(candidate_dashboard.this, cUpload_Manifesto.class);
                startActivity(vp);
            }
        });
    }}

