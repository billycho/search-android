package com.qwersoft.searchdemo.Model;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qwersoft.searchdemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by IT02106 on 01/07/2018.
 */

public class MItemAdapter  extends ArrayAdapter<MItem>{
    Context mContext;
    private List<MItem> mItemList;
    LayoutInflater inflater;

    public MItemAdapter(Context context, int layoutResourceId, List<MItem> data)
    {
        super(context, layoutResourceId,data);
        mContext = context;
        mItemList = data;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        ViewHolder holder = null;

        if(row == null)
        {
            row = inflater.inflate(R.layout.custom_row,parent,false);

            holder = new ViewHolder();
            holder.loginName = (TextView) row.findViewById(R.id.loginName);
            holder.avatar = (ImageView) row.findViewById(R.id.avatar);
            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }

        holder.loginName.setText(mItemList.get(position).getLogin());
        Picasso.with(mContext).load(mItemList.get(position).getAvatarUrl()).into(holder.avatar);
        return row;
    }

    public void populateData(List<MItem> mItems)
    {
        mItemList.clear();
        mItemList.addAll(mItems);

        notifyDataSetChanged();
    }

    static class ViewHolder
    {
        TextView loginName;
        ImageView avatar;
    }
}
