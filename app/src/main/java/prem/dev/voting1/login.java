package prem.dev.voting1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class login extends AppCompatActivity {




    DatabaseReference creference;

    EditText email, password;
    Button btn_login;
    User vote ;
    FirebaseAuth auth;
    TextView sign_in,check;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       /* String Uid = auth.getUid();

        creference = FirebaseDatabase.getInstance().getReference("CandidateUsers").child(Uid);
*/
        auth = FirebaseAuth.getInstance();

        check = findViewById(R.id.check);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        sign_in = findViewById(R.id.sign_in_login);




        /*creference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User vote = snapshot.getValue(User.class);

                if (vote.getIsCandidate().equals("true")) {
                    Intent intent = new Intent(login.this, candidate_dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
                else if (vote.getIsvoter().equals("true")){
                    Intent intent = new Intent(login.this, Voter_dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();


                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/





        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Reg = new Intent(login.this, Register_mainscreen.class);
                startActivity(Reg);
            }
        });



        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = auth.getCurrentUser();
                if( mFirebaseUser != null){
                    Toast.makeText(login.this, "You Are Logged In", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent (login.this, MainActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(login.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };

                btn_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String txt_email = email.getText().toString();
                        String txt_password = password.getText().toString();


                        if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                            Toast.makeText(login.this, "All fields are required", Toast.LENGTH_SHORT).show();
                        } else {

                            auth.signInWithEmailAndPassword(txt_email, txt_password)
                                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {

                                            if (task.isSuccessful()){
                                                Intent intent = new Intent(login.this, login_check.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                startActivity(intent);
                                                finish();

                                            //User vote = snapshot.getValue(User.class);

                                            /*if (vote.getIsCandidate().equals("true")) {
                                                Intent intent = new Intent(login.this, candidate_dashboard.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                startActivity(intent);
                                                finish();*/

                                              /*  if (){

                                                    Intent intent = new Intent(login.this, candidate_dashboard.class);
                                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    startActivity(intent);
                                                    finish();


                                                }

                                               else  if (vote.getIsvoter().equals("true")){
                                                   Intent intent1 = new Intent(login.this, Voter_dashboard.class);
                                                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    startActivity(intent1);
                                                    finish();}



                                            }*/
                                            }


                                            else {
                                                Toast.makeText(login.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        }

                    }
                });
    }
}

            


   /* @Override
    protected void onStart(){
        super.onStart();
        auth.addAuthStateListener(mAuthStateListener);
    }*/
//}


//Comment

/*
package prem.dev.voting;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.content.ContextCompat;

        import android.content.Intent;
        import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.Html;
        import android.text.TextUtils;
        import android.text.TextWatcher;
        import android.text.method.PasswordTransformationMethod;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageButton;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    EditText email, password;
    */
/*  ImageButton eyeToggle;*//*


    Button loginn, loginwithoutpassword;
    String pass, e;
    boolean show = true;

    FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        auth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = auth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(login.this, "You Are Logged In", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(login.this, MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(login.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#121212"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#121212'></font>"));

        loginn = findViewById(R.id.login_btn);
        loginwithoutpassword = findViewById(R.id.login_without_password);
        email = findViewById(R.id.mail_edit_text);
        password = findViewById(R.id.password_edit_text);
        // eyeToggle = findViewById(R.id.password_toggle);



    */
/*    if(email.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }*//*



       */
/* eyeToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show) {
                    show = false;
                    eyeToggle.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    password.setTransformationMethod(new PasswordTransformationMethod());
                } else {
                    show = true;
                    eyeToggle.setImageResource(R.drawable.ic_baseline_visibility_24);
                    password.setTransformationMethod(null);
                }
            }
        });
*//*


        loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();
                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(login.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {

                    auth.signInWithEmailAndPassword(txt_email, txt_password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(login.this, MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(login.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

            }
        });


        loginwithoutpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(login.this, "Login Without Password Is Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    e = "Done";
                    email.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.edit_text_focus_bg));
                    password.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.edit_text_bg));
                }
            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    password.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.edit_text_focus_bg));
                    email.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.edit_text_bg));
                }
            }
        });


        password.addTextChangedListener(loginTextWatcher);
        email.addTextChangedListener(loginTextWatcher);


    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(mAuthStateListener);
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String emailinput, passwordinput;
            emailinput = email.getText().toString().trim();
            passwordinput = password.getText().toString().trim();


            if (!emailinput.isEmpty() && !passwordinput.isEmpty()) {
                loginn.setEnabled(true);
                loginn.setClickable(true);
                loginn.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_bg_active));
            } else {
                loginn.setEnabled(false);
                loginn.setClickable(false);
                loginn.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_background));
            }


        */
/*    if(!e.isEmpty()&& !pass.isEmpty())
            {
                login.setEnabled(true);
                login.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.btn_background));
            }
*//*

            //  login.setTextColor(getResources().getColor(R.color.grey))


        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}*/
