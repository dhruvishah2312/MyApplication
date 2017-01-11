package com.example.dhruvishah.myapplication;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.dhruvishah.myapplication.adapter.GOTAdapter;

/**
 * Created by DhruviShah on 02-01-2017.
 */

public class GOTTouchHelper extends ItemTouchHelper.SimpleCallback {

    private GOTAdapter mAdapter;

    public GOTTouchHelper(GOTAdapter mAdapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.mAdapter = mAdapter;
    }


    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
      return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.remove(viewHolder.getAdapterPosition());
    }

}
