package com.nrj.bottomsheetdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mbtnOpenBottomDialog;
    private ListView mProductList;
    private ArrayList<String> mProductNameList;
    String[] mProductTypes = new String[] { "Men", "Women", "kids","Mobile & Accessories"};
    private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setListeners();
//        setAdaptors();
    }

    private void setAdaptors() {
        mProductNameList = new ArrayList<String>();
        for (int i = 0; i < mProductTypes.length; ++i) {
            mProductNameList.add(mProductTypes[i]);
        }
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, mProductNameList);
        mProductList.setAdapter(adapter);
    }

    private View.OnClickListener editProductHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
            bottomSheetDialog.setContentView(R.layout.product_menu);
            mProductList = bottomSheetDialog.findViewById(R.id.listProduct);
            setAdaptors();
            bottomSheetDialog.show();
        }
    };

    private void setListeners() {
        mbtnOpenBottomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Way -1 to launch Bottomsheet
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
                bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog);
                TextView txtView = bottomSheetDialog.findViewById(R.id.lblEditProduct);
                txtView.setOnClickListener(editProductHandler);
                bottomSheetDialog.show();

            }
        });
    }

    private void init(){
        mbtnOpenBottomDialog = findViewById(R.id.btnOpenBottomDialog);
    }

}