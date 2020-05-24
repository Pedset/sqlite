package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter listAdapter;






    EditText input;
    TextView textView;
    MyDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        input  = (EditText) findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);
        dbHandler = new MyDBHandler(this, null,null,1);
        printDatabase();
    }

    public void printDatabase(){
        Map<Integer, String> map = dbHandler.databaseToString();
       // String dbString = dbHandler.databaseToString();
        //textView.setText(dbString);
        //textView.setText();
        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
        ArrayList<String> valueList = new ArrayList<>(map.values());




        textView.setText(valueList.toString());
        expandableListView = (ExpandableListView) findViewById(R.id.eplist);
        listAdapter = new MyExListAdapter(this,keyList,valueList);
        expandableListView.setAdapter(listAdapter);
        input.setText("");
    }

    public void fillData (){




    }





    public void deleteThings(View view) {
    String inputText = input.getText().toString();
    dbHandler.deleteProduct(inputText);
        printDatabase();
    }

    public void addThings(View view) {
        Products products = new Products(input.getText().toString());
        dbHandler.addProduct(products);
        printDatabase();
    }
}
