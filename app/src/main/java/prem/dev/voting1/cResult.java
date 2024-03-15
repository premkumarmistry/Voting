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

public class cResult extends AppCompatActivity {
    TextView ctextParties1, ctextParties2, ctextParties3, ctextParties4;
    int cvoteCountParty1 = 0;
    int cvoteCountParty2 = 0;
    int cvoteCountParty3 = 0;
    int cvoteCountParty4 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_result);


        ctextParties1 = findViewById(R.id.textParties1);
        ctextParties2 = findViewById(R.id.textParties2);
        ctextParties3 = findViewById(R.id.textParties3);
        ctextParties4 = findViewById(R.id.textParties4);

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

                ctextParties1.setText("Party 1 = " + String.valueOf(parties1));
                ctextParties2.setText("Party 2 = " + String.valueOf(parties2));
                ctextParties3.setText("Party 3 = " + String.valueOf(parties3));
                ctextParties4.setText("Party 4 = " + String.valueOf(parties4));

                cvoteCountParty1 = parties1 + 1;
                cvoteCountParty2 = parties2 + 1;
                cvoteCountParty3 = parties3 + 1;
                cvoteCountParty4 = parties4 + 1;

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}