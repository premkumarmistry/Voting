package prem.dev.voting1;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.model.Model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Staff_Voter_List extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FirebaseUser user;
    public static Context context;

    private DatabaseReference reference;
    private String uid;
    private MyAdapterTwo adapter2;
    private ArrayList<Model> list;
    private TextView verification_txt , name, email;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff__voter__list);


        context = getApplicationContext();

        auth = FirebaseAuth.getInstance();

        String Uid = auth.getUid();
        // user = FirebaseAuth.getInstance().getCurrentUser();

        reference = FirebaseDatabase.getInstance().getReference("Users");

        recyclerView = findViewById(R.id.recycler1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        list = new ArrayList<>();

        adapter2 = new MyAdapterTwo(this ,list );

        recyclerView.setAdapter(adapter2);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {


                  /*  Intent i = new Intent(VoterCandidate_ListActivity.this,VCandidate_viewRecycleActivity.class);
                    i.putExtra("uid",Uid);
                    Toast.makeText(VoterCandidate_ListActivity.this,"Sent !", Toast.LENGTH_SHORT).show();

                    startActivity(i);*/


                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {


            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });




        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){



                    Model model2 = dataSnapshot.getValue(model2.class);
                    list.add(model2);




                }
                adapter2.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}