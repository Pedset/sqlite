package com.example.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyExListAdapter extends BaseExpandableListAdapter  {


        Context context;
        ArrayList<Integer> intList;
        ArrayList<String> stringList;

    public MyExListAdapter(Context context, ArrayList<Integer> intList, ArrayList<String> stringList) {
        this.context = context;
        this.intList = intList;
        this.stringList = stringList;
    }

    @Override
    public int getGroupCount() {
        return stringList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return stringList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return "Product ID: " +intList.get(groupPosition).toString();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
       String lang = (String) getGroup(groupPosition);
       if(convertView ==null)  {
           LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_parent,null);
       }
        TextView txtParent = (TextView) convertView.findViewById(R.id.txtParent);
       txtParent.setText(lang);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
       String topic = (String) getChild(groupPosition,childPosition);
        if(convertView ==null)  {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_child,null);
        }
        TextView txtChild = (TextView) convertView.findViewById(R.id.txtChild);
        txtChild.setText(topic);


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
