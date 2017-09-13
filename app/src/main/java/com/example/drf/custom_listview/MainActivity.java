package com.example.drf.custom_listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String [] titles = {"Title1","Title2","Title3"};
    String [] descr = {"item1","item2","item3"};
    int [] images = {R.drawable.dash, R.drawable.mobile,R.drawable.screen};
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(getApplicationContext(),titles,descr,images);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                      @Override
                                      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                          Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
                                      }
                                  }
        );
    }

    class MyAdapter extends ArrayAdapter {
        int [] imageArray;
        String [] titleArray;
        String [] descrArray;
        public MyAdapter(Context context, String[] title1, String[] descr1,int [] image1){
            super(context,R.layout.cuslistview_row,R.id.title,titles/* !!!!*/);
            this.descrArray = descr1;
            this.imageArray = image1;
            this.titleArray = title1;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater)  getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.cuslistview_row,parent,false);

            ImageView myImage = (ImageView) row.findViewById(R.id.pic);
            TextView myTitle = (TextView) row.findViewById(R.id.title);
            TextView myDescr = (TextView) row.findViewById(R.id.Descr);


            myImage.setImageResource(imageArray[position]);
            myTitle.setText(titleArray[position]);
            myDescr.setText(descrArray[position]);

            return  row;
        }
    }
}
