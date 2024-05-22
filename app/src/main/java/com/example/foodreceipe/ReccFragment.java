package com.example.foodreceipe;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodreceipe.RecyclerView.RecipeAdapter;
import com.example.foodreceipe.api.ApiClient;
import com.example.foodreceipe.api.SpoonacularApi;
import com.example.foodreceipe.model.Recipe;
import com.example.foodreceipe.model.RecipeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReccFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private static final String API_KEY = "df86d4df34514de9bbd06d5dabed50c4";
    private RecyclerView recyclerView;
    private RecipeAdapter adapter;

    public ReccFragment() {
        // Required empty public constructor
    }

    public static ReccFragment newInstance(String param1, String param2) {
        ReccFragment fragment = new ReccFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


}
