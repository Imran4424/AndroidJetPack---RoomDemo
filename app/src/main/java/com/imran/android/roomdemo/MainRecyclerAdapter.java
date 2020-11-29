package com.imran.android.roomdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imran.android.roomdemo.model.RoomDB;

import java.util.List;

/**
 * Created by Shah Md Imran Hossain on 30, November, 2020
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {
    private final Context context;
    private final List<String> dataList;
    private RoomDB databse;

    public MainRecyclerAdapter(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_recyler_view, parent, true);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView editButtonImage;
        ImageView deleteButtonImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.)
        }
    }
}
