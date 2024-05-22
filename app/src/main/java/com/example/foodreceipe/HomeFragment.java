package com.example.foodreceipe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import java.util.List;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    public class InfinityHorizontalScrollView extends HorizontalScrollView {

        private LinearLayout containerLayout;

        public InfinityHorizontalScrollView(Context context) {
            super(context);
            init();
        }

        public InfinityHorizontalScrollView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public InfinityHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init();
        }

        private void init() {
            containerLayout = new LinearLayout(getContext());
            containerLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            containerLayout.setOrientation(LinearLayout.HORIZONTAL);
            addView(containerLayout);
        }

        public void addViews(List<View> views) {
            for (View view : views) {
                containerLayout.addView(view);
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            return false; // Menonaktifkan sentuhan langsung pada HorizontalScrollView
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            return false; // Menonaktifkan intersep sentuhan pada HorizontalScrollView
        }

        @Override
        protected void onScrollChanged(int l, int t, int oldl, int oldt) {
            super.onScrollChanged(l, t, oldl, oldt);
            if (l == 0) { // Jika scroll ke ujung kiri
                // Tambahkan salinan elemen terakhir ke ujung kiri
                containerLayout.addView(containerLayout.getChildAt(containerLayout.getChildCount() - 1), 0);
            } else if (l + getWidth() >= containerLayout.getWidth()) { // Jika scroll ke ujung kanan
                // Tambahkan salinan elemen pertama ke ujung kanan
                containerLayout.addView(containerLayout.getChildAt(0));
            }
        }
    }

    public void onCardClick(View view) {
        Intent intent = new Intent(getActivity(), DetailResep.class); // Ganti DetailActivity dengan activity yang menampilkan detail card
        switch (view.getId()) {
            case R.id.salad:
                // Tentukan tindakan ketika CardView salad diklik
                intent.putExtra("recipe_type", "meatx"); // Mengirim informasi jenis resep yang harus ditampilkan di activity detail
                startActivity(intent); // Memulai activity detail
                break;
            case R.id.cookies:
                // Tentukan tindakan ketika CardView cookies diklik
                intent.putExtra("recipe_type", "Cookies"); // Mengirim informasi jenis resep yang harus ditampilkan di activity detail
                startActivity(intent); // Memulai activity detail
                break;
            case R.id.soup:
                // Tentukan tindakan ketika CardView soup diklik
                intent.putExtra("recipe_type", "Soup"); // Mengirim informasi jenis resep yang harus ditampilkan di activity detail
                startActivity(intent); // Memulai activity detail
                break;
            // Tambahkan case untuk CardView lainnya jika diperlukan
            //

            case R.id.meat:
                // Tentukan tindakan ketika CardView salad diklik
                intent.putExtra("recipe_type", "meatx"); // Mengirim informasi jenis resep yang harus ditampilkan di activity detail
                startActivity(intent); // Memulai activity detail
                break;
            case R.id.noodle:
                // Tentukan tindakan ketika CardView cookies diklik
                intent.putExtra("recipe_type", "Cookies"); // Mengirim informasi jenis resep yang harus ditampilkan di activity detail
                startActivity(intent); // Memulai activity detail
                break;
            case R.id.cake:
                // Tentukan tindakan ketika CardView soup diklik
                intent.putExtra("recipe_type", "Soup"); // Mengirim informasi jenis resep yang harus ditampilkan di activity detail
                startActivity(intent); // Memulai activity detail
                break;
            // Tambahkan case untuk CardView lainnya jika diperlukan
        }
    }


}