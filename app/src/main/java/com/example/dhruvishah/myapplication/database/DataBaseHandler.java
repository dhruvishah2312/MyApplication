package com.example.dhruvishah.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dhruvishah.myapplication.model.GOTHouses;

import java.util.ArrayList;

/**
 * Created by DhruviShah on 28-12-2016.
 */

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "listMAnager";
    private static final String GOT_TABLE = "got_table";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String HOUSENAME = "housename";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + GOT_TABLE + " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME + " TEXT,"
                + HOUSENAME + " TEXT "
                + " )";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old, int revised) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + GOT_TABLE);
        onCreate(sqLiteDatabase);
    }

    //    adding new row
    public Long addRow(GOTHouses g) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID,g.getId());
        values.put(NAME, g.getName());
        values.put(HOUSENAME, g.getHouseName());
        long id = db.insert(GOT_TABLE, null, values);
        db.close();
        return id;
    }
    public Long addNewRow(GOTHouses g) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, g.getName());
        values.put(HOUSENAME, g.getHouseName());
        long id = db.insert(GOT_TABLE, null, values);
        db.close();
        return id;
    }

    //      reading
    public ArrayList<GOTHouses> getList() {
        ArrayList<GOTHouses> gotList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + GOT_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                GOTHouses g = new GOTHouses();
                g.setId(cursor.getLong(0));
                g.setName(cursor.getString(1));
                g.setHouseName(cursor.getString(2));
                gotList.add(g);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return gotList;
    }

//    delete row on swipe
    public void delete(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(GOT_TABLE, ID + " = ?", new String[]{String.valueOf(id)});

        db.close();
        }

    public void addData() {
        // List Data
        GOTHouses g1 = new GOTHouses(1, "Dany Targeryan", "Valyris");
        GOTHouses g2 = new GOTHouses(2, "Rob", "Winterfell");
        GOTHouses g3 = new GOTHouses(3, "Jon Snow", "Castle Black");
        GOTHouses g4 = new GOTHouses(4, "Tyrion Lannister", "King's Landing");
        addRow(g1);
        addRow(g2);
        addRow(g3);
        addRow(g4);
    }
}
