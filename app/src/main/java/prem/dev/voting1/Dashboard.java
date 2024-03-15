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

public class Dashboard extends AppCompatActivity {
    /*   private TextView verification_txt , name, email;
       DatabaseReference reference;
       FirebaseAuth auth;

       Button logout;*/

    //FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;


//.child(currentFirebaseUser.getUid());

   // private RecyclerView recyclerView;
    /*private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Users");
    private MyAdapter adapter;
    private ArrayList<Model> list;*/


    private TextView verification_txt1 ,verification_txt2 , name, email,email_label,verify_text,address_label,address,birthday,birthday_label,age,age_label,gender,gender_label,aadharFront_Label,aadharBack_label,mobile_label,mobile,upload_label,birthcertificate_label,leavingcertificate_label;
    ImageView imageView,photo,tick,AadharFront,AadharBack,leaving,birthcertificate;
    DatabaseReference reference;
    FirebaseAuth auth;
    ScrollView scrollView;
    RelativeLayout relativeLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

       /* recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
*/


        scrollView= findViewById(R.id.scrollView);
        relativeLayout=findViewById(R.id.Relative);
        email = findViewById(R.id.cremail_retrieve_dashboard);
        email_label = findViewById(R.id.cremail_label_dashboard);
        birthday = findViewById(R.id.crbirthday_retrieve_dashboard);
        birthday_label = findViewById(R.id.crbirthday_label_dashboard);
        age = findViewById(R.id.crage_retrieve_dashboard);
        age_label = findViewById(R.id.crage_label_dashboard);
        gender=findViewById(R.id.crgender_retrieve_dashboard);
        gender_label = findViewById(R.id.crgender_label_dashboard);
        address = findViewById(R.id.craddress_retrieve_dashboard);
        address_label = findViewById(R.id.craddress_label_dashboard);


        leavingcertificate_label = findViewById(R.id.crleavingcertificate_label_dashboard);
        birthcertificate_label= findViewById(R.id.crbirthdaycertificate_label_dashboard);
        upload_label = findViewById(R.id.crupload_label_dashboard);
        mobile = findViewById(R.id.crmobile_retrieve_dashboard);
        mobile_label = findViewById(R.id.crmobile_label_dashboard);
        aadharFront_Label= findViewById(R.id.craadhar_frontside_label_dashboard);
        aadharBack_label = findViewById(R.id.craadhar_backside_label_dashboard);
        leaving = findViewById(R.id.crleavingcertificate_retrieve_dashboard);
        birthcertificate = findViewById(R.id.crbirthdaycertificate_retrieve_dashboard);
        AadharFront= findViewById(R.id.craadhar_frontside_retrieve_dashboard);
        AadharBack = findViewById(R.id.craadhar_backside_retrieve_dashboard);
        photo = findViewById(R.id.cphoto_retrieve);
        tick = findViewById(R.id.ctick);
        verify_text = findViewById(R.id.cverify_text);
        name = findViewById(R.id.cname_retrive);
        imageView = findViewById(R.id.cimageView2);
        verification_txt1 = findViewById(R.id.Cverfication_text1);
        verification_txt2 = findViewById(R.id.cverfication_text2);
        auth = FirebaseAuth.getInstance();
        String Uid = auth.getUid();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(Uid);


      /*  list = new ArrayList<>();
        adapter = new MyAdapter(this ,list );*/

        //recyclerView.setAdapter(adapter);

      /*  root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    *//*Model model = dataSnapshot.getValue(model.class);
                    list.add(model);*//*
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/



        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                User user = snapshot.getValue(User.class);
                if (user.getIsEnabled().equals("No")){
                        verification_txt1.setVisibility(View.VISIBLE);
                        verification_txt2.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.VISIBLE);


                    //email.setText(user.getEmail());

                }else{
                    scrollView.setVisibility(View.VISIBLE);
                    relativeLayout.setVisibility(View.VISIBLE);

                    verification_txt1.setVisibility(View.GONE);
                    verification_txt2.setVisibility(View.GONE);
                    imageView.setVisibility(View.GONE);
                    name.setVisibility(View.VISIBLE);
                    email.setVisibility(View.VISIBLE);
                    email_label.setVisibility(View.VISIBLE);
                    address.setVisibility(View.VISIBLE);
                    address_label.setVisibility(View.VISIBLE);
                    birthday.setVisibility(View.VISIBLE);
                    birthday_label.setVisibility(View.VISIBLE);
                    age.setVisibility(View.VISIBLE);
                    age_label.setVisibility(View.VISIBLE);
                    gender.setVisibility(View.VISIBLE);
                    gender_label.setVisibility(View.VISIBLE);
                    mobile_label.setVisibility(View.VISIBLE);
                    mobile.setVisibility(View.VISIBLE);
                    upload_label.setVisibility(View.VISIBLE);
                    aadharFront_Label.setVisibility(View.VISIBLE);
                    aadharBack_label.setVisibility(View.VISIBLE);
                    birthcertificate_label.setVisibility(View.VISIBLE);
                    birthcertificate.setVisibility(View.VISIBLE);
                    leavingcertificate_label.setVisibility(View.VISIBLE);
                    leaving.setVisibility(View.VISIBLE);


                    email.setText(user.getEmail());
                    address.setText(user.getAddress());
                    birthday.setText(user.getBirthday());
                    age.setText(user.getAge());
                    gender.setText(user.getGender());
                    name.setText(user.getName());
                    mobile.setText(user.getMobile());
                    AadharFront.setVisibility(View.VISIBLE);
                    AadharBack.setVisibility(View.VISIBLE);

                    String url = user.getPhoto();
                    String url1 = user.getAadharCardFront();
                    String url2 = user.getAadharCardBack();
                    String url3 = user.getBirthCertificate();
                    String url4 = user.getLeaving();

                    photo.setVisibility(View.VISIBLE);
                    
                    Glide.with(Dashboard.this)

                            .load(url)

                            .into(photo);



                    Glide.with(Dashboard.this)

                            .load(url1)

                            .into(AadharFront);

                    Glide.with(Dashboard.this)

                            .load(url2)

                            .into(AadharBack);

                    Glide.with(Dashboard.this)

                            .load(url3)

                            .into(birthcertificate);

                    Glide.with(Dashboard.this)

                            .load(url4)

                            .into(leaving);



                    tick.setVisibility(View.VISIBLE);
                    verify_text.setVisibility(View.VISIBLE);






                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}




       /* verification_txt = findViewById(R.id.verification_txt);
        auth = FirebaseAuth.getInstance();
        String Uid = auth.getUid();
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        logout = findViewById(R.id.logout);

        reference = FirebaseDatabase.getInstance().getReference("Users").child(Uid);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Dashboard.this, login.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

            }
        });
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                User user = snapshot.getValue(User.class);

                if (user.getIsEnabled().equals("No")){
                    verification_txt.setText("Your Verification In Progress");

                    email.setText(user.getEmail());

                }else{
                    verification_txt.setText("Your Verification Completed ..................");

                    name.setText(user.getName());
                    email.setText(user.getEmail());

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}*/