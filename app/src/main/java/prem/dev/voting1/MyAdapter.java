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

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    int p;
    String pdf ,oto;
    DownloadManager manager;



    ArrayList<Model> mList;
    Context context;

    public MyAdapter(Context context , ArrayList<Model> mList){

        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item , parent ,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        model model = (prem.dev.voting1.model) mList.get(position);

        p = position ;

        holder.age.setText(model.getCage());
        holder.gender.setText(model.getCgender());
        holder.feed.setText(model.getFeed());

        holder.partyname.setText(model.getCpartyname());
        holder.name.setText(model.getCname());

        Glide.with(context).load(((model) mList.get(position)).getcPhoto()).into(holder.imageView);

//         holder.manifetch.setText(model.getMani());

//         String value = holder.manifetch.toString();



        holder.downloadmani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.surname.setText(model.getMani());

                 pdf =  holder.surname.getText().toString();
               Log.d("ManiFest Value","value");



                initDownload();




              // downloadFile();

               /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    manager = (DownloadManager) context.getSystemService(DOWNLOAD_SERVICE);
                }



                Uri uri = Uri.parse(pdf);
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                long reference = manager.enqueue(request);*/


            }
        });
        /*Glide.with(context).load(((model) mList.get(position)).getAadharCard()).into(holder.A);
        Glide.with(context).load(((model) mList.get(position)).getBirthCertificate()).into(holder.B);
        Glide.with(context).load(((model) mList.get(position)).getLeaving()).into(holder.L);
*/
       /* holder.address.setText(model.getAddress());
        holder.gender.setText(model.getGender());
        holder.age.setText(model.getAge());
        holder.birthday.setText(model.getBirthday());
        holder.mobile.setText(model.getMobile());
        holder.id.setText(model.getId());
        holder.isEnabled.setText(model.getIsEnabled());*/
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name , surname , email,partyname,manifetch,age,gender,feed;
        ImageView imageView;
        Button downloadmani;

//,address,age,gender,id,isEnabled,mobile,birthday
               // A,B,L;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);






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

            age = itemView.findViewById(R.id.cage_retrive_data);
            gender = itemView.findViewById(R.id.cgender_retrive_data);
            feed = itemView.findViewById(R.id.cfeed_retrive_data);
            imageView= itemView.findViewById(R.id.cimage);
            name = itemView.findViewById(R.id.name_retrive_data);
            partyname = itemView.findViewById(R.id.party_retrive_data);
            downloadmani = itemView.findViewById(R.id.retrive_manifesto);
            surname = itemView.findViewById(R.id.cfetchm);


        }



    }

    private void initDownload() {
        //String uri = "https://drive.google.com/uc?id=1gXJ7qf3XJz1Lly4SZJZRYasS3lbQbzuv&export=download";
        download(context.getApplicationContext(), "manifesto", ".pdf", "Downloads", pdf.trim());
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


}