package com.example.okutech.tablelayoutwithcheckedtextviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TableLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TableLayout bhkTL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bhkTL = (TableLayout) findViewById(R.id.bhkTL);
        getCheckedTextView(bhkTL);
    }

    private void getCheckedTextView(View view) {
        if (view instanceof CheckedTextView) {
            CheckedTextView checkedTextView = (CheckedTextView) view;
            checkedTextView.setOnClickListener(this);
            if (checkedTextView.isChecked()) {
//                arrayList.add(checkedTextView.getTag().toString());
            }
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                getCheckedTextView(child);
            }
        }
    }

    private void showLastSelectedForBhkCatFur(TableLayout tableLayout, ArrayList<String> jsonArray) {
        try {
            for (int i = 0; i < jsonArray.size(); i++) {
                CheckedTextView view = (CheckedTextView) tableLayout.findViewWithTag(jsonArray.get(i));//this is used to get checked textView by tag.
                if (view.isChecked()) {
                    view.setChecked(false);
                } else {
                    view.setChecked(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default: {
                if (view instanceof CheckedTextView) {
                    CheckedTextView checkedTextView = (CheckedTextView) view;
                    if (checkedTextView.isChecked())
                        checkedTextView.setChecked(false);
                    else
                        checkedTextView.setChecked(true);
                }
            }
        }

    }
}
