package com.example.dhruvishah.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;

import com.example.dhruvishah.myapplication.R;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by DhruviShah on 16-12-2016.
 */
public class Nextpage extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextpage);
        String newString= getIntent().getStringExtra("keyName");
    }


}
