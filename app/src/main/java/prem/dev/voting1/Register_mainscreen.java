package prem.dev.voting1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Register_mainscreen extends AppCompatActivity {

    //ImageView v , c;
    TextView loginn;

    Button v,c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_mainscreen);

        v= findViewById(R.id.register);
        c =  findViewById(R.id.login);
       /* loginn =  findViewById(R.id.login);
        loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_mainscreen.this, login.class);
                startActivity(intent);
            }
        });
*/
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_mainscreen.this, Register_for_voter.class);
                startActivity(intent);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_mainscreen.this, Register_for_candinate.class);
                startActivity(intent);
            }
        });
    }
}