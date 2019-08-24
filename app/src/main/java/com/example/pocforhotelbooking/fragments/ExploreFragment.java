package com.example.pocforhotelbooking.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pocforhotelbooking.R;
import com.example.pocforhotelbooking.adapters.SearchAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ExploreFragment extends Fragment {
    public static ExploreFragment newInstance() {

        Bundle args = new Bundle();

        ExploreFragment fragment = new ExploreFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore,container,false);

        Button btnFilters = view.findViewById(R.id.btn_filters);
        btnFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        View dialogView = getLayoutInflater().inflate(R.layout.filter_bottom_sheet,null);
                        BottomSheetDialog dialog = new BottomSheetDialog(view.getContext());
                        dialog.setContentView(dialogView);
                        dialog.show();

            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SearchAdapter searchAdapter = new SearchAdapter();

        RecyclerView rvTopSearches = view.findViewById(R.id.rv_top_searches);
        rvTopSearches.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        rvTopSearches.setAdapter(searchAdapter);

        RecyclerView rvRecentSearches = view.findViewById(R.id.rv_recent_searches);
        rvRecentSearches.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        rvRecentSearches.setAdapter(searchAdapter);

    }


}
