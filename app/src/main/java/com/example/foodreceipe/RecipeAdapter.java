package com.example.foodreceipe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodreceipe.model.Recipe;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private List<Recipe> recipeList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Recipe recipe);
    }

    public RecipeAdapter(List<Recipe> recipeList, OnItemClickListener listener) {
        this.recipeList = recipeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.bind(recipe, listener);
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView titleTextView;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.textViewName);
        }

        public void bind(final Recipe recipe, final OnItemClickListener listener) {
            // Bind data to UI elements
            Glide.with(itemView.getContext()).load(recipe.getImageUrl()).into(imageView);
            titleTextView.setText(recipe.getName());

            // Set click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(recipe);
                }
            });
        }
    }
}
