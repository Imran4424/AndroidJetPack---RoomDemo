package com.imran.android.roomdemo;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imran.android.roomdemo.model.MainData;
import com.imran.android.roomdemo.model.RoomDB;

import java.util.List;

/**
 * Created by Shah Md Imran Hossain on 30, November, 2020
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {
    private final Context context;
    private final List<MainData> dataList;
    private RoomDB databse;

    public MainRecyclerAdapter(Context context, List<MainData> dataList) {
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
        // Initialize main data
        MainData data = dataList.get(position);
        // Initialize database
        databse = RoomDB.getInstance(context);
        // set text
        holder.textView.setText(data.getText());

        holder.editButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // initialize main data
                MainData dataEdit = dataList.get(holder.getAdapterPosition());
                // get id
                int sID = dataEdit.getID();

                // get text
                String sText = dataEdit.getText();

                // create dialog
                Dialog dialog = new Dialog(context);
                // set content view
                dialog.setContentView(R.layout.dialog_update);
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setLayout(width, height);
                
            }
        });
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
            textView = itemView.findViewById(R.id.textView);
            editButtonImage = itemView.findViewById(R.id.editImage);
            deleteButtonImage = textView.findViewById(R.id.deleteImage);
        }
    }
}
