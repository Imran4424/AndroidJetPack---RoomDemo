package com.imran.android.roomdemo;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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
    private final RoomDB database;

    public MainRecyclerAdapter(Context context, List<MainData> dataList) {
        this.context = context;
        this.dataList = dataList;
        // Initialize database
        database = RoomDB.getInstance(context);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_recyler_view, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerAdapter.ViewHolder holder, int position) {
        // Initialize main data
        MainData data = dataList.get(position);

        // set text
        holder.textView.setText(data.getText());
        // set position
        holder.position = position;

        holder.deleteButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize main data
                MainData dataDelete = dataList.get(position);

                // delete text from the database
                database.mainDao().delete(dataDelete);

                // notify when data is deleted
                dataList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, dataList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final TextView textView;
        public  final ImageView editButtonImage;
        public final ImageView deleteButtonImage;
        public int position;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.cellTextView);
            editButtonImage = itemView.findViewById(R.id.cellEditImage);
            deleteButtonImage = itemView.findViewById(R.id.cellDeleteImage);

                editButtonImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // initialize main data
                    MainData dataEdit = dataList.get(position);
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
                    dialog.show();

                    EditText editText = dialog.findViewById(R.id.updateText);
                    Button buttonUpdate = dialog.findViewById(R.id.buttonUpdate);

                    editText.setText(sText);

                    buttonUpdate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // dismiss dialog
                            dialog.dismiss();

                            // get updated text from edit text
                            String updatedText = editText.getText().toString().trim();

                            // update text in database
                            database.mainDao().update(sID, updatedText);

                            // Notify when data is updated
                            dataList.clear();
                            dataList.addAll(database.mainDao().getAll());
                            notifyDataSetChanged();
                        }
                    });
                }
            });
        }
    }
}
