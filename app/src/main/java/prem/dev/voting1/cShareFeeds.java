package prem.dev.voting1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class cShareFeeds extends AppCompatActivity {
            EditText getText;
            Button sub;


    FirebaseAuth cauth;
    DatabaseReference creference,check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_share_feeds);


        getText = findViewById(R.id.seditext);
        sub = findViewById(R.id.btn_feed);

        cauth = FirebaseAuth.getInstance();
        String Uid = cauth.getUid();
        creference = FirebaseDatabase.getInstance().getReference("CandidateUsers").child(Uid);
        check = FirebaseDatabase.getInstance().getReference("CandidateUsers").child(Uid);



        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String nam = (String) snapshot.child("feed").getValue().toString();

                        if (nam.equals("No")){

                            sharefeed();

                        }
                        else{

                            Toast.makeText(cShareFeeds.this, "Feed Already Sent !", Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });




    }


    private void sharefeed(){

        creference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                String txt = getText.getText().toString();




                FirebaseUser firebaseUser = cauth.getCurrentUser();


                Map<String, Object> hashMap = new HashMap<>();
                hashMap.put("feed", txt);
                creference.updateChildren(hashMap);
                Toast.makeText(cShareFeeds.this, "Feed Sent SuccessFully", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


}