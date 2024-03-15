package prem.dev.voting1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Staff_Result_Select extends AppCompatActivity {
    Button first,second;
    DatabaseReference one,two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff__result__select);


        first = findViewById(R.id.enable);
        second = findViewById(R.id.disable);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one = FirebaseDatabase.getInstance().getReference("Result").child("EnableResult");


                one.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Map<String, Object> hashMap = new HashMap<>();
                        hashMap.put("EnableViewing", "true");
                        one.updateChildren(hashMap);
                        Toast.makeText(Staff_Result_Select.this, "Result Enabled", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                two = FirebaseDatabase.getInstance().getReference("Result").child("EnableResult");


                two.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Map<String, Object> hashMap = new HashMap<>();
                        hashMap.put("EnableViewing", "false");
                        two.updateChildren(hashMap);
                        Toast.makeText(Staff_Result_Select.this, "Result Disabled", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

    }
}