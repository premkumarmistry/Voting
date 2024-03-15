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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyAdapterThree extends RecyclerView.Adapter<MyAdapterThree.MyViewHolder> {
    int p;
    String pdf5,pdf ,pdf2,pdf3,pdf4;
    DownloadManager manager;
    DatabaseReference areference,rreference,second;
    int count = 1;
    FirebaseAuth vlauth;
    ArrayList<Model> mList;
    Context context2;

    public MyAdapterThree(Context context2, ArrayList<Model> mList) {

        this.mList = mList;
        this.context2 = context2;
        areference = FirebaseDatabase.getInstance().getReference("Authentication").child("authorised_candidate_id");

        Log.d("ManiFest Value", "MyAdapterTwo");
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("ManiFest Value", "onCreate View ke Ander");

        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.staffcandidatelist, parent, false);
        return new MyViewHolder(view);




    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        model3 model3 = (prem.dev.voting1.model3) mList.get(position);


        p = position;

        holder.cname.setText(model3.getCname());
        holder.caddress.setText(model3.getCaddress());
        holder.cage.setText(model3.getCage());
        holder.cbirthday.setText(model3.getCbirthday());
        holder.cgender.setText(model3.getCgender());

        holder.cisCandidate.setText(model3.getIsCandidate());
        holder.cisEnabled.setText(model3.getCisEnabled());
        holder.cemail.setText(model3.getCemail());
        holder.fetchid.setText(model3.getCid());
        holder.pname.setText(model3.getCpartyname());
        holder.pcode.setText(model3.getCpartycode());
        holder.feed.setText(model3.getFeed());

        Glide.with(context2).load(((model3) mList.get(position)).getcPhoto()).into(holder.cimageView);
            //aPPROVE rEJECT kA OncLICK lISTENERER



        holder.capprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = holder.fetchid.getText().toString();
                rreference = FirebaseDatabase.getInstance().getReference("CandidateUsers").child(id);

                rreference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                      //  String nam = (String) snapshot.child("feed").getValue().toString();
                        Map<String, Object> hashMap = new HashMap<>();
                        hashMap.put("cisEnabled", "true");
                        rreference.updateChildren(hashMap);
                        Toast.makeText(context2.getApplicationContext(), "Approved SuccessFully", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



/*

                areference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Map<String, Object> hashMap = new HashMap<>();
                        String key = areference.push().getKey();

                        hashMap.put(key, id);


                        areference.updateChildren(hashMap);
                        Toast.makeText(context2.getApplicationContext(),id + "is Approved",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

*/



                //  holder.csurname.setText(model3.getCid());
                //dusre activity me bhejne ke liye
               /* Toast.makeText(context2.getApplicationContext(),id + "is Rejected",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context2.getApplicationContext(),ApproveTest.class);
                i.putExtra("first",id);
                context2.startActivity(i);*/
            }
        });

            holder.creject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String id = holder.fetchid.getText().toString();
                    second = FirebaseDatabase.getInstance().getReference("CandidateUsers").child(id);

                    second.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //  String nam = (String) snapshot.child("feed").getValue().toString();
                            Map<String, Object> hashMap = new HashMap<>();
                            hashMap.put("cisEnabled", "false");
                            second.updateChildren(hashMap);
                            Toast.makeText(context2.getApplicationContext(), "Rejected SuccessFully", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            });
      /*  holder.approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ccount = String.valueOf(count+1);

                String emailget = holder.vemail.getText().toString();

                areference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Map<String, Object> hashMap = new HashMap<>();
                        String key = areference.push().getKey();

                        hashMap.put(key, emailget);


                        areference.setValue(hashMap);
                        Toast.makeText(context2.getApplicationContext(),emailget + "is Rejected",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



            }
        });
        holder.reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailget = holder.vemail.getText().toString();

                rreference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Map<String, Object> hashMap = new HashMap<>();
                        hashMap.put(emailget, "Rejected");
                        rreference.updateChildren(hashMap);
                        Toast.makeText(context2.getApplicationContext(),emailget + "is Rejected",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                //   Toast.makeText(context1.getApplicationContext(),emailget + "is Rejected",Toast.LENGTH_SHORT).show();





            }
        });
*/







        //birth ka click listenerr
        holder.cbirthcertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.cbc.setText(model3.getcBirthCertificate());

                pdf4 = holder.cbc.getText().toString();
                Log.d("ManiFest Value", "Button CLicked");


                initDownload4();


            }
        });





        //leave
        holder.cleaving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.cl.setText(model3.getCleaving());

                pdf3 = holder.cl.getText().toString();
                Log.d("ManiFest Value", "Button CLicked");


                initDownload3();


            }
        });





        //aadharFront ka click listener
        holder.caadharfront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.caf.setText(model3.getcAadharCardFront());

                pdf2 = holder.caf.getText().toString();
                Log.d("ManiFest Value", "Button CLicked");


                initDownload2();


            }
        });





        //aadharBack ka click listener
        holder.caadharback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.csurname.setText(model3.getcAadharCardBack());

                pdf = holder.csurname.getText().toString();
                Log.d("ManiFest Value", "Button CLicked");


                initDownload();


            }
        });



        //FetchManiFesto

        //Manifesto ka click listener
        holder.manifesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.fetchmani.setText(model3.getMani());

                pdf5 = holder.fetchmani.getText().toString();
                Log.d("ManiFest Value", "Button CLicked");

                    //Download id chnage karna hai humko idhar ko
                initDownload5();


            }
        });





    }











    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView cimageView;
        TextView fetchmani,feed,pname,pcode,fetchid,csurname, cl, caf, cbc, caddress, cage, cbirthday, cemail, cgender, cisCandidate, cisEnabled, cisvoter, cname;

        Button caadharback, cleaving, caadharfront, cbirthcertificate, capprove, creject,manifesto;

        //,address,age,gender,id,isEnabled,mobile,birthday
        // A,B,L;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            fetchmani = itemView.findViewById(R.id.cfetchm);

            manifesto = itemView.findViewById(R.id.cManifesto);

            pname = itemView.findViewById(R.id.rcr_partyname_retrive_data);
            pcode = itemView.findViewById(R.id.rcr_partycode_retrive_data);

            cimageView = itemView.findViewById(R.id.cimage);
            capprove = itemView.findViewById(R.id.cApprove);
            creject = itemView.findViewById(R.id.cReject);
            cl = itemView.findViewById(R.id.cleavef);
            cbc = itemView.findViewById(R.id.cbirthf);

            caf = itemView.findViewById(R.id.caadharf);
            caddress = itemView.findViewById(R.id.rcr_address_retrive_data);
            cage = itemView.findViewById(R.id.rcr_age_retrive_data);
            cbirthday = itemView.findViewById(R.id.rcr_bithday_retrive_data);
            cemail = itemView.findViewById(R.id.rcr_email_retrive_data);
            cgender = itemView.findViewById(R.id.rcr_gender_retrive_data);
            cisCandidate = itemView.findViewById(R.id.rcr_iscandidate1_retrive_data);
            cisEnabled = itemView.findViewById(R.id.rcr_isenabled_retrive_data);
            cisvoter = itemView.findViewById(R.id.rcr_isvoter_retrive_data);
            cname = itemView.findViewById(R.id.rcr_name_retrive_data);
            csurname = itemView.findViewById(R.id.cid);
            caadharback = itemView.findViewById(R.id.cAadharCardBack);
            caadharfront = itemView.findViewById(R.id.cAadharCardFront);
            cleaving = itemView.findViewById(R.id.cleaving);
            cbirthcertificate = itemView.findViewById(R.id.cBirthCertificate);
            fetchid = itemView.findViewById(R.id.ccid);
            feed = itemView.findViewById(R.id.rcr_feed_retrive_data);



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
        download(context2.getApplicationContext(), "votingfile", ".pdf", "Downloads", pdf.trim());
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
        download2(context2.getApplicationContext(), "votingfile", ".pdf", "Downloads", pdf2.trim());
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
        download3(context2.getApplicationContext(), "votingfile", ".pdf", "Downloads", pdf3.trim());
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
        download4(context2.getApplicationContext(), "votingfile", ".pdf", "Downloads", pdf4.trim());
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



    //5th Download
    //4th download
    private void initDownload5() {
        //String uri = "https://drive.google.com/uc?id=1gXJ7qf3XJz1Lly4SZJZRYasS3lbQbzuv&export=download";
        download4(context2.getApplicationContext(), "votingfile", ".pdf", "Downloads", pdf5.trim());
    }
    private void download5(Context context, String Filename, String FileExtension, String DesignationDirectory, String url) {
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