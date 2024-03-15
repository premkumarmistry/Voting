package prem.dev.voting1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Staff_Dashboard extends AppCompatActivity {
Button approve_voter ,approve_candidate,vote,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff__dashboard);
        vote = findViewById(R.id.vote);
        result = findViewById(R.id.result);

        approve_voter = findViewById(R.id.av);
        approve_candidate = findViewById(R.id.ac);

        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vv = new Intent(Staff_Dashboard.this, Staff_ElectionSelect.class);
                startActivity(vv);
            }
        });



        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vp = new Intent(Staff_Dashboard.this, Staff_Result_Select.class);
                startActivity(vp);
            }
        });


        approve_candidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vR = new Intent(Staff_Dashboard.this, Staff_Candidate_list.class);
                startActivity(vR);
            }
        });

        approve_voter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vc = new Intent(Staff_Dashboard.this, Staff_Voter_List.class);
                startActivity(vc);
            }
        });


    }



    public void onBackPressed() {
        moveTaskToBack(true);
    }



}