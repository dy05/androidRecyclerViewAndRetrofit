package com.example.tppart1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.List;

public class PersonnageAdapter extends RecyclerView.Adapter<PersonnageAdapter.PersonnageViewHolder>{

    private Context context;
    private List<PersonnageModel> personnagesList;

    public PersonnageAdapter(Context context, List<PersonnageModel> personnagesList) {
        this.context = context;
        this.personnagesList = personnagesList;
    }

    @NonNull
    @Override
    public PersonnageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personnage_card, parent, false);
        return new PersonnageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonnageViewHolder holder, int position) {
        PersonnageModel personnageModel = personnagesList.get(position);
        holder.textName1.setText(personnageModel.getName());

        Glide.with(context)
                .load(personnageModel.getImageUrl())
                .placeholder(R.drawable.image1)
                .centerCrop()
                .into(holder.imgView1);
    }

    @Override
    public int getItemCount() {
        return personnagesList.size();
    }

    public static class PersonnageViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgView1;
        private TextView textName1;

        public PersonnageViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView1 = itemView.findViewById(R.id.image_path);
            textName1 = itemView.findViewById(R.id.name);
        }
    }
}
