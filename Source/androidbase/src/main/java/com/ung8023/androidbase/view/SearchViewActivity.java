package com.ung8023.androidbase.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;

import com.ung8023.androidbase.R;

public class SearchViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        removeUnderLine();
        removeUnderLineWithSearchIcon();
        addFocus();
    }

    private void removeUnderLine() {
        SearchView searchView = findViewById(R.id.sv_without_underline);
        View viewById = searchView.findViewById(android.support.v7.appcompat.R.id.search_plate);
        if (viewById != null) {
            viewById.setBackgroundColor(Color.TRANSPARENT);
        }

        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    private void removeUnderLineWithSearchIcon() {
        final SearchView searchView = findViewById(R.id.sv_without_underline_with_search_icon);
        View viewById = searchView.findViewById(android.support.v7.appcompat.R.id.search_plate);
        if (viewById != null) {
            viewById.setBackgroundColor(Color.TRANSPARENT);
        }

    }

    private void addFocus() {
        final SearchView searchView = findViewById(R.id.sv_focus);
        searchView.setSubmitButtonEnabled(true);

    }
}
