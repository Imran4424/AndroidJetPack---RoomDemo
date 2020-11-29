package com.imran.android.roomdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imran.android.roomdemo.model.RoomDB;

import java.util.List;

/**
 * Created by Shah Md Imran Hossain on 30, November, 2020
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {
    private final Context context;
    private final LayoutInflater layoutInflater;
    private final List<String> dataList;
    private RoomDB databse;

    public MainRecyclerAdapter(Context context, List<String> dataList) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
