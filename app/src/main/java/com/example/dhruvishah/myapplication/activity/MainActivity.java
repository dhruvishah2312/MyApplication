package com.example.dhruvishah.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.dhruvishah.myapplication.R;
import com.example.dhruvishah.myapplication.adapter.GOTAdapter;
import com.example.dhruvishah.myapplication.database.DataBaseHandler;
import com.example.dhruvishah.myapplication.model.GOTHouses;
import com.example.dhruvishah.myapplication.utils.GotUtils;
import com.example.dhruvishah.myapplication.utils.PreferenceUtils;
import com.example.dhruvishah.myapplication.GOTTouchHelper;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //ArrayAdapter GOTAdapter;
    private RecyclerView mRecyclerView;
    private GOTAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<GOTHouses> gotList = new ArrayList<>();
    private FloatingActionButton fab;
    private static final String TAG = MainActivity.class.getCanonicalName();
    DataBaseHandler db = new DataBaseHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.got_list);
        gotList = db.getList();
        mAdapter = new GOTAdapter(this, gotList);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        ItemTouchHelper.Callback callback = new GOTTouchHelper(mAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mRecyclerView);



        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNewActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_FIRST_USER) {
            GOTHouses g = (GOTHouses) data.getSerializableExtra(GotUtils.GOTHOUSE_EXTRA);
            gotList.add(g);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                PreferenceUtils.setIsRegistered(this, false);
                Intent goBack = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(goBack);
                break;

        }
        return true;
    }





}
