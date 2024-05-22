package com.example.foodreceipe.RecyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodreceipe.R;
import com.example.foodreceipe.model.Recipe;

public class RecipeViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTextView;

    public RecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.textViewTitle);
    }

    public void bind(final Recipe recipe, final OnItemClickListener listener) {
        titleTextView.setText(recipe.getName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(recipe);
            }
        });
    }

    public class OnItemClickListener {
        public void onItemClick(Recipe recipe) {

        }
    }
}
