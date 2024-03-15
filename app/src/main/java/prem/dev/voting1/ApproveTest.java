package prem.dev.voting1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import prem.dev.voting1.R;

public class ApproveTest extends AppCompatActivity {
    String c;
    DatabaseReference areference,rreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_test);



        areference = FirebaseDatabase.getInstance().getReference("Authentication").child("authorised_voter_id");


        Intent i =  getIntent();

        c = i.getStringExtra("first");
        Toast.makeText(ApproveTest.this,c+ "Fetched",Toast.LENGTH_SHORT).show();

        areference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Map<String, Object> hashMap = new HashMap<>();
                String key = areference.push().getKey();

                hashMap.put(key, c);


                areference.setValue(hashMap);
                Toast.makeText(ApproveTest.this, c + "is Approved", Toast.LENGTH_SHORT).show();
              //  Intent iC = new Intent(getApplicationContext(),Staff_Candidate_list.class);
           // startActivity(iC);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

    }
}