package prem.dev.voting1;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.Model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyAdapterTwo   extends RecyclerView.Adapter<MyAdapterTwo.MyViewHolder> {
    int p;
    String pdf ,pdf2,pdf3,pdf4;
    DownloadManager manager;
    DatabaseReference check1,check2;
    int count = 1;

    ArrayList<Model> mList;
    Context context1;

    public MyAdapterTwo(Context context1, ArrayList<Model> mList) {

        this.mList = mList;
        this.context1 = context1;
        //areference = FirebaseDatabase.getInstance().getReference("Authentication").child("authorised_voter_id");
      //  rreference = FirebaseDatabase.getInstance().getReference("Authentication").child("rejected_voter_id");

        Log.d("ManiFest Value", "MyAdapterTwo");
    }


    @NonNull
    @Override
    public MyAdapterTwo.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("ManiFest Value", "onCreate View ke Ander");

        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.voterlist, parent, false);
        return new MyAdapterTwo.MyViewHolder(view);




    }
    @Override
    public void onBindViewHolder(@NonNull MyAdapterTwo.MyViewHolder holder, int position) {
        model2 model2 = (prem.dev.voting1.model2) mList.get(position);


        p = position;

        holder.vname.setText(model2.getName());
        holder.vaddress.setText(model2.getAddress());
        holder.vage.setText(model2.getAge());
        holder.vbirthday.setText(model2.getBirthday());
        holder.vgender.setText(model2.getGender());
        holder.visvoter.setText(model2.getIsvoter());
        holder.visCandidate.setText(model2.getIsCandidate());
        holder.visEnabled.setText(model2.getIsEnabled());
        holder.vemail.setText(model2.getEmail());
        holder.fetchid.setText(model2.getId());


        Glide.with(context1).load(((model2) mList.get(position)).getPhoto()).into(holder.imageView);

        holder.approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = holder.fetchid.getText().toString();
                check1 = FirebaseDatabase.getInstance().getReference("Users").child(id);

                check1.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //  String nam = (String) snapshot.child("feed").getValue().toString();
                        Map<String, Object> hashMap = new HashMap<>();
                        hashMap.put("isEnabled", "true");
                        check1.updateChildren(hashMap);
                        Toast.makeText(context1.getApplicationContext(), "Approved SuccessFully", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


              /*  areference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Map<String, Object> hashMap = new HashMap<>();
                        String key = areference.push().getKey();

                        hashMap.put(key, emailget);


                        areference.setValue(hashMap);
                        Toast.makeText(context1.getApplicationContext(),emailget + "is Rejected",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });*/



            }
        });

        holder.reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = holder.fetchid.getText().toString();
                check2 = FirebaseDatabase.getInstance().getReference("Users").child(id);
                check2.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //  String nam = (String) snapshot.child("feed").getValue().toString();
                        Map<String, Object> hashMap = new HashMap<>();
                        hashMap.put("isEnabled", "False");
                        check2.updateChildren(hashMap);
                        Toast.makeText(context1.getApplicationContext(), "Rejected SuccessFully", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });









      /*  holder.reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailget = holder.vemail.getText().toString();

                rreference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Map<String, Object> hashMap = new HashMap<>();
                        hashMap.put(emailget, "Rejected");
                        rreference.updateChildren(hashMap);
                        Toast.makeText(context1.getApplicationContext(),emailget + "is Rejected",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                //   Toast.makeText(context1.getApplicationContext(),emailget + "is Rejected",Toast.LENGTH_SHORT).show();





            }
        });*/

        // Glide.with(context1).load(((model2) mList.get(position)).getcPhoto()).into(holder.imageView);

//         holder.manifetch.setText(model.getMani());

//         String value = holder.manifetch.toString();



        //leave
        holder.birthcertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.bc.setText(model2.getBirthCertificate());

                pdf4 = holder.bc.getText().toString();
                Log.d("ManiFest Value", "Button CLicked");


                initDownload4();


            }
        });





        //leave
        holder.leaving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.l.setText(model2.getLeaving());

                pdf3 = holder.l.getText().toString();
                Log.d("ManiFest Value", "Button CLicked");


                initDownload3();


            }
        });





        //aadharFront
        holder.aadharfront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.af.setText(model2.getAadharCardFront());

                pdf2 = holder.af.getText().toString();
                Log.d("ManiFest Value", "Button CLicked");


                initDownload2();


            }
        });





        //aadharBack
        holder.aadharback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.surname.setText(model2.getAadharCardBack());

                pdf = holder.surname.getText().toString();
                Log.d("ManiFest Value", "Button CLicked");


                initDownload();


            }
        });


        //LEAVE




    }











    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView fetchid,surname,l,af,bc,vaddress,vage,vbirthday,vemail,vgender,visCandidate,visEnabled,visvoter,vname;

        Button aadharback,leaving,aadharfront,birthcertificate,approve,reject;

        //,address,age,gender,id,isEnabled,mobile,birthday
        // A,B,L;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.cimage);
            approve  = itemView.findViewById(R.id.cApprove);
            reject = itemView.findViewById(R.id.cReject);
            l = itemView.findViewById(R.id.cleavef);
            bc = itemView.findViewById(R.id.cbirthf);
            fetchid = itemView.findViewById(R.id.fetchidd);

            af = itemView.findViewById(R.id.caadharf);
            vaddress = itemView.findViewById(R.id.rcr_address_retrive_data);
            vage = itemView.findViewById(R.id.rcr_age_retrive_data);
            vbirthday = itemView.findViewById(R.id.rcr_bithday_retrive_data);
            vemail = itemView.findViewById(R.id.rcr_email_retrive_data);
            vgender = itemView.findViewById(R.id.rcr_gender_retrive_data);
            visCandidate = itemView.findViewById(R.id.rcr_isCandidate_retrive_data);
            visEnabled = itemView.findViewById(R.id.rcr_isenabled_retrive_data);
            visvoter = itemView.findViewById(R.id.rcr_isvoter_retrive_data);
            vname = itemView.findViewById(R.id.rcr_name_retrive_data);
            surname = itemView.findViewById(R.id.cid);
            aadharback = itemView.findViewById(R.id.cAadharCardBack);
            aadharfront = itemView.findViewById(R.id.cAadharCardFront);
            leaving = itemView.findViewById(R.id.cleaving);
            birthcertificate = itemView.findViewById(R.id.cBirthCertificate);



 /*           A= imageView= itemView.findViewById(R.id.Aadhar);
            B= imageView= itemView.findViewById(R.id.birth);
            L= imageView= itemView.findViewById(R.id.leaving);
            address= itemView.findViewById(R.id.address);
            age= itemView.findViewById(R.id.age);
            gender= itemView.findViewById(R.id.gender);
            id= itemView.findViewById(R.id.id);
            mobile= itemView.findViewById(R.id.mobile);
            birthday= itemView.findViewById(R.id.birthday);
            isEnabled= itemView.findViewById(R.id.is);
*/



        }



    }

    private void initDownload() {
        //String uri = "https://drive.google.com/uc?id=1gXJ7qf3XJz1Lly4SZJZRYasS3lbQbzuv&export=download";
        download(context1.getApplicationContext(), "votingfile", ".pdf", "Downloads", pdf.trim());
    }
    private void download(Context context, String Filename, String FileExtension, String DesignationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, DesignationDirectory, Filename + FileExtension);
        assert downloadManager != null;
        downloadManager.enqueue(request);
        Toast.makeText(context.getApplicationContext(),"Downloading",Toast.LENGTH_SHORT).show();

    }

    //2nd download

    private void initDownload2() {
        //String uri = "https://drive.google.com/uc?id=1gXJ7qf3XJz1Lly4SZJZRYasS3lbQbzuv&export=download";
        download2(context1.getApplicationContext(), "votingfile", ".pdf", "Downloads", pdf2.trim());
    }
    private void download2(Context context, String Filename, String FileExtension, String DesignationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, DesignationDirectory, Filename + FileExtension);
        assert downloadManager != null;
        downloadManager.enqueue(request);
        Toast.makeText(context.getApplicationContext(),"Downloading",Toast.LENGTH_SHORT).show();

    }

    //3rd download

    private void initDownload3() {
        //String uri = "https://drive.google.com/uc?id=1gXJ7qf3XJz1Lly4SZJZRYasS3lbQbzuv&export=download";
        download3(context1.getApplicationContext(), "votingfile", ".pdf", "Downloads", pdf3.trim());
    }
    private void download3(Context context, String Filename, String FileExtension, String DesignationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, DesignationDirectory, Filename + FileExtension);
        assert downloadManager != null;
        downloadManager.enqueue(request);
        Toast.makeText(context.getApplicationContext(),"Downloading",Toast.LENGTH_SHORT).show();

    }

    //4th download
    private void initDownload4() {
        //String uri = "https://drive.google.com/uc?id=1gXJ7qf3XJz1Lly4SZJZRYasS3lbQbzuv&export=download";
        download4(context1.getApplicationContext(), "votingfile", ".pdf", "Downloads", pdf4.trim());
    }
    private void download4(Context context, String Filename, String FileExtension, String DesignationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, DesignationDirectory, Filename + FileExtension);
        assert downloadManager != null;
        downloadManager.enqueue(request);
        Toast.makeText(context.getApplicationContext(),"Downloading",Toast.LENGTH_SHORT).show();

    }



}