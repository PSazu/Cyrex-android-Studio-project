package com.example.cyrex;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImagesDir = new ArrayList<>();
    private ArrayList<Model> data = new ArrayList<>();

    private Context mcontext;
    public RecyclerViewAdapter(Context context,ArrayList<Model> tempData){
        mcontext=context;
        data = tempData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scroll, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.image.setImageResource((Integer)data.get(position).getImageB());
        holder.title.setText((String)data.get(position).gettitle());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,GalleryActivity.class);
                intent.putExtra("imageB",data.get(position).getImage());
                intent.putExtra("title", data.get(position).gettitle());
                intent.putExtra("subText",data.get(position).getSubText());
                intent.putExtra("subText2",data.get(position).getSubText2());
                intent.putExtra("description",data.get(position).getDescription());
                intent.putExtra("trailer", data.get(position).getTrailer());
                intent.putExtra("youtubeId",data.get(position).getYoutubeId());
                intent.putExtra("web_url", data.get(position).getUrl());

                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view);
            title = itemView.findViewById(R.id.title_view);

        }
    }
}
