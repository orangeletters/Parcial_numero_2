package com.example.parcial_numero_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.util.Arrays;
import java.util.List;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    private RecyclerView carouselRecyclerView;
    private CarouselAdapter adapter;
    private int currentIndex = 0;
    private final Handler autoScrollHandler = new Handler();
    private final int AUTO_SCROLL_INTERVAL = 3000; // milliseconds

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        carouselRecyclerView = view.findViewById(R.id.recyclerView);

        // Setup Carousel Layout Manager
        CarouselLayoutManager carouselLayoutManager = new CarouselLayoutManager();
        carouselRecyclerView.setLayoutManager(carouselLayoutManager);

        List<Integer> images = Arrays.asList(
                R.drawable.vacheronconstantin_logo,
                R.drawable.vacheronconstantin_logo,
                R.drawable.vacheronconstantin_logo,
                R.drawable.vacheronconstantin_logo,
                R.drawable.vacheronconstantin_logo
        );

        adapter = new CarouselAdapter(images);
        carouselRecyclerView.setAdapter(adapter);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(carouselRecyclerView);

        carouselRecyclerView.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    stopAutoScroll();
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    startAutoScroll();
                    break;
            }
            return false;
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        startAutoScroll();
    }

    @Override
    public void onPause() {
        super.onPause();
        stopAutoScroll();
    }

    private void startAutoScroll() {
        autoScrollHandler.postDelayed(autoScrollRunnable, AUTO_SCROLL_INTERVAL);
    }

    private void stopAutoScroll() {
        autoScrollHandler.removeCallbacks(autoScrollRunnable);
    }

    private final Runnable autoScrollRunnable = new Runnable() {
        @Override
        public void run() {
            if (adapter.getItemCount() == 0) return;

            currentIndex = (currentIndex + 1) % adapter.getItemCount();
            carouselRecyclerView.smoothScrollToPosition(currentIndex);

            autoScrollHandler.postDelayed(this, AUTO_SCROLL_INTERVAL);
        }
    };
}