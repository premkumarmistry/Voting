package prem.dev.voting1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.Model;

import java.util.ArrayList;


// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
public class fetchCandidateListAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Model> mList;
    Context context;

    public fetchCandidateListAdapter(Context context , ArrayList<Model> mList){

        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item , parent ,false);
        return new MyAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        model model = (prem.dev.voting1.model) mList.get(position);
        holder.partyname.setText(model.getCpartyname());
        holder.name.setText(model.getName());
        Glide.with(context).load(((model) mList.get(position)).getImage()).into(holder.imageView);

    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name , surname , partyname,email;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.cimage);
            name = itemView.findViewById(R.id.name_retrive_data);
            partyname = itemView.findViewById(R.id.party_retrive_data);
        }
    }


}