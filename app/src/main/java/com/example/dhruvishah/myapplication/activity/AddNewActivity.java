package com.example.dhruvishah.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dhruvishah.myapplication.R;
import com.example.dhruvishah.myapplication.adapter.GOTAdapter;
import com.example.dhruvishah.myapplication.database.DataBaseHandler;
import com.example.dhruvishah.myapplication.model.GOTHouses;
import com.example.dhruvishah.myapplication.utils.GotUtils;

import java.io.Serializable;

import static android.R.attr.id;

//import static android.R.attr.id;

public class AddNewActivity extends AppCompatActivity {

    Button addentry;
    EditText name, housename;
    DataBaseHandler db = new DataBaseHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        name = (EditText) findViewById(R.id.name);
        housename = (EditText) findViewById(R.id.housename);
        addentry = (Button) findViewById(R.id.addentry);

        addentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                GOTHouses gotHouses = new GOTHouses(name.getText().toString(), housename.getText().toString());
                Long id = db.addNewRow(gotHouses);
                gotHouses.setId(id);
                intent.putExtra(GotUtils.GOTHOUSE_EXTRA, gotHouses);
                setResult(1, intent);
                finish();
            }
        });
    }
}
