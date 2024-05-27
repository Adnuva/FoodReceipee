package com.example.foodreceipe.api;
import com.example.foodreceipe.model.RecipeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpoonacularApi {

    @GET("recipes/complexSearch")
    Call<RecipeResponse> getRecipes(
            @Query("apiKey") String apiKey,
            @Query("query") String query,
            @Query("number") int number,
            @Query("offset") int offset,
            @Query("language") String language
    );
}
