package com.example.dhruvishah.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dhruvishah.myapplication.R;
import com.example.dhruvishah.myapplication.database.DataBaseHandler;
import com.example.dhruvishah.myapplication.model.GOTHouses;

import java.util.ArrayList;

/**
 * Created by DhruviShah on 22-12-2016.
 */

public class GOTAdapter extends RecyclerView.Adapter<GOTAdapter.ViewHolder> {
    private ArrayList<GOTHouses> gotList;
    private Context mContext;


    public GOTAdapter(Context context, ArrayList<GOTHouses> gotList) {
        this.gotList = gotList;
        this.mContext = context;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View ItemView = LayoutInflater.from(mContext).inflate(R.layout.list_rows, parent, false);
        return new ViewHolder(ItemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return gotList.size();
    }

//    public void swap(int firstPos, int secondPos){
//        Collections.swap(gotList, firstPos, secondPos);
//        notifyItemMoved(firstPos, secondPos);
//    }

    public void remove(int position) {
        GOTHouses gotHouses = gotList.get(position);
        gotList.remove(position);
        long id = gotHouses.getId();
        DataBaseHandler db = new DataBaseHandler(mContext);
        notifyItemRemoved(position);
        db.delete(id);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private TextView txtHouse;

        ViewHolder(View v) {
            super(v);
            txtName = (TextView) v.findViewById(R.id.name);
            txtHouse = (TextView) v.findViewById(R.id.housename);
        }

        void bind(int position) {
            GOTHouses got = gotList.get(position);
            txtName.setText(got.getName());
            txtHouse.setText(got.getHouseName());
        }
    }
}


// Custom Adapter program
/* public class GOTAdapter extends ArrayAdapter {

    private int resource;
    private LayoutInflater inflater;
    private Context context;

    public GOTAdapter(Context ctx, int resourceId, List l1) {

        super(ctx, resourceId, l1);
        resource = resourceId;
        inflater = LayoutInflater.from(ctx);
        context = ctx;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(resource, null);
        GOTHouses got = (GOTHouses) getItem(position);
        TextView txtName = (TextView) convertView.findViewById(R.id.name);
        txtName.setText(got.getName());
        TextView txtHouse = (TextView)convertView.findViewById(R.id.housename);
        txtHouse.setText(got.getHouseName());

        return convertView;


    }

} */
