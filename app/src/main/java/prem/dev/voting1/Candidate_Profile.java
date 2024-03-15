package prem.dev.voting1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Candidate_Profile extends AppCompatActivity {
    private TextView cverification_txt1 ,cverification_txt2 , cname, cemail,cemail_label,cverify_text,caddress_label,caddress,cbirthday,cbirthday_label,cage,cage_label,cgender,cgender_label,caadharFront_Label,caadharBack_label,cmobile_label,cmobile,cupload_label,cbirthcertificate_label,cleavingcertificate_label;
    ImageView cimageView,cphoto,ctick,cAadharFront,cAadharBack,cleaving,cbirthcertificate;
    DatabaseReference creference;
    FirebaseAuth cauth;
    ScrollView cscrollView;
    RelativeLayout crelativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate__profile);

        cscrollView= findViewById(R.id.scrollView);
        crelativeLayout=findViewById(R.id.Relative);
        cemail = findViewById(R.id.cremail_retrieve_dashboard);
        cemail_label = findViewById(R.id.cremail_label_dashboard);
        cbirthday = findViewById(R.id.crbirthday_retrieve_dashboard);
        cbirthday_label = findViewById(R.id.crbirthday_label_dashboard);
        cage = findViewById(R.id.crage_retrieve_dashboard);
        cage_label = findViewById(R.id.crage_label_dashboard);
        cgender=findViewById(R.id.crgender_retrieve_dashboard);
        cgender_label = findViewById(R.id.crgender_label_dashboard);
        caddress = findViewById(R.id.craddress_retrieve_dashboard);
        caddress_label = findViewById(R.id.craddress_label_dashboard);


        cleavingcertificate_label = findViewById(R.id.crleavingcertificate_label_dashboard);
        cbirthcertificate_label= findViewById(R.id.crbirthdaycertificate_label_dashboard);
        cupload_label = findViewById(R.id.crupload_label_dashboard);
        cmobile = findViewById(R.id.crmobile_retrieve_dashboard);
        cmobile_label = findViewById(R.id.crmobile_label_dashboard);
        caadharFront_Label= findViewById(R.id.craadhar_frontside_label_dashboard);
        caadharBack_label = findViewById(R.id.craadhar_backside_label_dashboard);
        cleaving = findViewById(R.id.crleavingcertificate_retrieve_dashboard);
        cbirthcertificate = findViewById(R.id.crbirthdaycertificate_retrieve_dashboard);
        cAadharFront= findViewById(R.id.craadhar_frontside_retrieve_dashboard);
        cAadharBack = findViewById(R.id.craadhar_backside_retrieve_dashboard);
        cphoto = findViewById(R.id.cphoto_retrieve);
        ctick = findViewById(R.id.ctick);
        cverify_text = findViewById(R.id.cverify_text);
        cname = findViewById(R.id.cname_retrive);
        cimageView = findViewById(R.id.cimageView2);
        cverification_txt1 = findViewById(R.id.Cverfication_text1);
        cverification_txt2 = findViewById(R.id.cverfication_text2);


        cauth = FirebaseAuth.getInstance();
        String Uid = cauth.getUid();
        creference = FirebaseDatabase.getInstance().getReference("CandidateUsers").child(Uid);

        creference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

//             User user = snapshot.getValue(User.class);

               // String isEnabled = (String) snapshot.child("CisEnabled").getValue().toString();
                String nam = (String) snapshot.child("cisEnabled").getValue().toString();

                if (nam.equals("No")){
                    cverification_txt1.setVisibility(View.VISIBLE);
                    cverification_txt2.setVisibility(View.VISIBLE);
                    cimageView.setVisibility(View.VISIBLE);


                    //email.setText(user.getEmail());

                }else{
                    cscrollView.setVisibility(View.VISIBLE);
                    crelativeLayout.setVisibility(View.VISIBLE);

                    cverification_txt1.setVisibility(View.GONE);
                    cverification_txt2.setVisibility(View.GONE);
                    cimageView.setVisibility(View.GONE);
                    cname.setVisibility(View.VISIBLE);
                    cemail.setVisibility(View.VISIBLE);
                    cemail_label.setVisibility(View.VISIBLE);
                    caddress.setVisibility(View.VISIBLE);
                    caddress_label.setVisibility(View.VISIBLE);
                    cbirthday.setVisibility(View.VISIBLE);
                    cbirthday_label.setVisibility(View.VISIBLE);
                    cage.setVisibility(View.VISIBLE);
                    cage_label.setVisibility(View.VISIBLE);
                    cgender.setVisibility(View.VISIBLE);
                    cgender_label.setVisibility(View.VISIBLE);
                    cmobile_label.setVisibility(View.VISIBLE);
                    cmobile.setVisibility(View.VISIBLE);
                    cupload_label.setVisibility(View.VISIBLE);
                    caadharFront_Label.setVisibility(View.VISIBLE);
                    caadharBack_label.setVisibility(View.VISIBLE);
                    cbirthcertificate_label.setVisibility(View.VISIBLE);
                    cbirthcertificate.setVisibility(View.VISIBLE);
                    cleavingcertificate_label.setVisibility(View.VISIBLE);
                    cleaving.setVisibility(View.VISIBLE);

                    //

                    String email = (String) snapshot.child("cemail").getValue().toString();
                    String address = (String) snapshot.child("caddress").getValue().toString();

                    String birthday = (String) snapshot.child("cbirthday").getValue().toString();
                    String age = (String) snapshot.child("cage").getValue().toString();
                    String gender = (String) snapshot.child("cgender").getValue().toString();
                    String nname = (String) snapshot.child("cname").getValue().toString();
                    String mobile = (String) snapshot.child("cmobile").getValue().toString();




                    cemail.setText(email);
                    caddress.setText(address);
                    cbirthday.setText(birthday);
                    cage.setText(age);
                    cgender.setText(gender);
                    cname.setText(nname);
                    cmobile.setText(mobile);
                    cAadharFront.setVisibility(View.VISIBLE);
                    cAadharBack.setVisibility(View.VISIBLE);




                    String url = (String) snapshot.child("cPhoto").getValue().toString();
                    String url1 = (String) snapshot.child("cAadharCardFront").getValue().toString();
                    String url2 = (String) snapshot.child("cAadharCardBack").getValue().toString();
                    String url3 = (String) snapshot.child("cBirthCertificate").getValue().toString();
                    String url4 = (String) snapshot.child("cleaving").getValue().toString();

                    cphoto.setVisibility(View.VISIBLE);
                    Glide.with(Candidate_Profile.this)

                            .load(url)

                            .into(cphoto);



                    Glide.with(Candidate_Profile.this)

                            .load(url1)

                            .into(cAadharFront);

                    Glide.with(Candidate_Profile.this)

                            .load(url2)

                            .into(cAadharBack);

                    Glide.with(Candidate_Profile.this)

                            .load(url3)

                            .into(cbirthcertificate);

                    Glide.with(Candidate_Profile.this)

                            .load(url4)

                            .into(cleaving);



                    ctick.setVisibility(View.VISIBLE);
                    cverify_text.setVisibility(View.VISIBLE);






                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}