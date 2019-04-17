package com.news.newsapp.Model;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.bumptech.glide.Glide;
import com.news.newsapp.Content;
import com.news.newsapp.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Myviewholder> {

    ArrayList<NewsDto> arrayList=new ArrayList<NewsDto>();
    Context ctx;
    //public ImageView networkImageView;
    ImageLoader imageLoader;

    public NewsAdapter (ArrayList<NewsDto> arrayList, Context ctx){
        this.arrayList=arrayList;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.single_article_view, viewGroup, false);
        RecyclerView.ViewHolder vh;
        vh = new Myviewholder(v,ctx,arrayList);
        return (Myviewholder) vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder myviewholder, final int i) {
        Glide.with(ctx)
                .load(arrayList.get(i).getImage())
                .asBitmap()
                .into(myviewholder.imageView);

        myviewholder.tvtitle.setText(arrayList.get(i).getTitle());
        myviewholder.tvsource.setText(arrayList.get(i).getSource());

        myviewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ctx, Content.class);
                intent.putExtra("url",arrayList.get(i).getUrl());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);
            }
        });
    }

    public class Myviewholder extends RecyclerView.ViewHolder {

        TextView tvsource,tvtitle;
        ArrayList<NewsDto> arrayList=new ArrayList<NewsDto>();
        Context ctx;
        LinearLayout linearLayout;
        ImageView imageView;

        public Myviewholder(View itemView, Context ctx, ArrayList<NewsDto> information) {
            super(itemView);
            this.arrayList=information;
            this.ctx=ctx;
            tvsource= (TextView) itemView.findViewById(R.id.tvsource);
            imageView= (ImageView) itemView.findViewById(R.id.imageview);
            tvtitle= (TextView) itemView.findViewById(R.id.tvtitle);

            //linearLayout=(LinearLayout) itemView.findViewById(R.id.lnholder);



        }
    }




    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
