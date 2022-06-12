package com.example.studentapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class calender_list_adapter extends RecyclerView.Adapter<calender_list_adapter.calendar_list_ViewHolder> {

    private String[] Event_data;
    private String[] Club_data;
    public calender_list_adapter(String[] Event_data , String[] Club_data)
    {
        this.Event_data = Event_data;
        this.Club_data = Club_data;
    }



    @NonNull
    @Override
    public calendar_list_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.calendar_list_layout, parent,false);
        return new calendar_list_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull calendar_list_ViewHolder holder, int position) {

        String Event_name = Event_data[position];
        String Club_name = Club_data[position];
        holder.EventName.setText(Event_name);
        holder.ClubName.setText(Club_name);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), holder.EventName.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return Club_data.length;
    }

    public class calendar_list_ViewHolder extends RecyclerView.ViewHolder{

        TextView EventName;
        TextView ClubName;
        public calendar_list_ViewHolder(@NonNull View itemView) {
            super(itemView);
            EventName = itemView.findViewById(R.id.eventName);
            ClubName = itemView.findViewById(R.id.clubName);
        }
    }


}
