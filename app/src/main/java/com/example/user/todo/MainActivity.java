package com.example.user.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<String> item;
    ArrayAdapter<String> ia;
    Button b;
    EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=(ListView) findViewById(R.id.l1);
        item=new ArrayList<String>();
        ia=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,item);
        item.add("Wake up");
        item.add("Brush");
        list.setAdapter(ia);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item.remove(i);
                ia.notifyDataSetChanged();
                return true;

            }
        });








    }

    public void addItem(View view) {
        e=(EditText)findViewById(R.id.editText);
        ia.add(e.getText().toString());
        e.setText("");
    }
}
