package com.example.administrator.jackwaiting_greendao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.jackwaiting_greendao.R;
import com.example.administrator.jackwaiting_greendao.been.User;

import java.util.List;

/**
 * Created by JackWaiting on 2016/8/5.
 */
public class GreenDaoListAdapter extends BaseAdapter {

    private List<User> users;
    private Context context;


    public GreenDaoListAdapter(Context context,List<User> users){
        this.users = users;
        this.context = context;
    }

    public void GreenDaoListAdapter(){
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_item, null);
            viewHolder.tvId = (TextView) convertView.findViewById(R.id.id);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.tvAge = (TextView) convertView.findViewById(R.id.age);
            convertView.setTag(viewHolder);
        }else{
            viewHolder  = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvId.setText(users.get(position).getId()+"");
        viewHolder.tvName.setText(users.get(position).getName()+"");
        viewHolder.tvAge.setText(users.get(position).getAge()+"");
        return convertView;
    }

    private class ViewHolder{
        TextView tvId,tvName,tvAge;
    }
}
