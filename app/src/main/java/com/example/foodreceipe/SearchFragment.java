package com.example.foodreceipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodreceipe.api.ApiClient;
import com.example.foodreceipe.api.SpoonacularApi;
import com.example.foodreceipe.model.Recipe;
import com.example.foodreceipe.model.RecipeResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecipeAdapter recipeAdapter;
    private List<Recipe> recipeList;
    private boolean isLoading = false;
    private int pageNumber = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recipeList = new ArrayList<>();
        recipeAdapter = new RecipeAdapter(recipeList, new RecipeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Recipe recipe) {
                // Tindakan ketika item diklik
                // Misalnya, buka detail resep
                showRecipeDetail(recipe);
            }
        });

        recyclerView.setAdapter(recipeAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (!isLoading && linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == recipeList.size() - 1) {
                    // Pengguna mencapai akhir daftar, ambil lebih banyak data
                    fetchMoreRecipes();
                    isLoading = true;
                }
            }
        });

        fetchRecipes();

        return view;
    }

    public void fetchRecipes() {
        isLoading = true;
        SpoonacularApi api = ApiClient.getClient().create(SpoonacularApi.class);
        // Memanggil metode getRecipes dengan empat parameter (termasuk nomor halaman)
        Call<RecipeResponse> call = api.getRecipes("0d0ab41b7123474e8c0ba25c5643af04 ", "", 200, pageNumber, "id-ID");// Ambil lebih banyak data berdasarkan halaman

        call.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Recipe> recipes = response.body().getResults();
                    recipeList.addAll(recipes);
                    recipeAdapter.notifyDataSetChanged();
                }
                isLoading = false;
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                // Log error here since request failed
                isLoading = false;
            }
        });
    }

    public void fetchMoreRecipes() {
        pageNumber++; // Increment halaman untuk mengambil data berikutnya
        SpoonacularApi api = ApiClient.getClient().create(SpoonacularApi.class);
        Call<RecipeResponse> call = api.getRecipes("df86d4df34514de9bbd06d5dabed50c4", "pastatz", 200, pageNumber, "id-ID");
        // Ambil lebih banyak data berdasarkan halaman

        call.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Recipe> recipes = response.body().getResults();
                    recipeList.addAll(recipes);
                    recipeAdapter.notifyDataSetChanged();
                }
                isLoading = false;
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                // Log error here since request failed
                isLoading = false;
            }
        });
    }

    public void showRecipeDetail(Recipe recipe) {
        // Implementasikan logika untuk menampilkan detail resep
        // M
    }}