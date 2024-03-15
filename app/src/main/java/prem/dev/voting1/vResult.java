package prem.dev.voting1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class vResult extends AppCompatActivity {
    TextView textParties1, textParties2, textParties3, textParties4;
    int voteCountParty1 = 0;
    int voteCountParty2 = 0;
    int voteCountParty3 = 0;
    int voteCountParty4 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_result);

        textParties1 = findViewById(R.id.textParties1);
        textParties2 = findViewById(R.id.textParties2);
        textParties3 = findViewById(R.id.textParties3);
        textParties4 = findViewById(R.id.textParties4);


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

                textParties1.setText("Party 1 = " + String.valueOf(parties1));
                textParties2.setText("Party 2 = " + String.valueOf(parties2));
                textParties3.setText("Party 3 = " + String.valueOf(parties3));
                textParties4.setText("Party 4 = " + String.valueOf(parties4));

                voteCountParty1 = parties1 + 1;
                voteCountParty2 = parties2 + 1;
                voteCountParty3 = parties3 + 1;
                voteCountParty4 = parties4 + 1;

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}