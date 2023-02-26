package com.example.gamabubakar.listgrid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    public ArrayList<AdapterItems> myitems=new ArrayList<AdapterItems>();
    public MyCustomAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView lv=findViewById(R.id.listview);
        myitems.add(new AdapterItems(R.drawable.bohemia,"Developer","Develop App"));
        myitems.add(new AdapterItems(R.drawable.ting,"Tester","Develop App"));
        myitems.add(new AdapterItems(R.drawable.windows,"Admin","Develop App"));
        myadapter=new MyCustomAdapter(myitems);
        lv.setAdapter(myadapter);
    }

    public void ClickMe(View view) {
        myitems.add(new AdapterItems(R.drawable.windows,"Admin","Develop App"));
        myadapter.notifyDataSetChanged();
    }

    private class MyCustomAdapter extends BaseAdapter{
        public ArrayList<AdapterItems> myitems=new ArrayList<AdapterItems>();
        MyCustomAdapter(ArrayList<AdapterItems> myitems){
            this.myitems=myitems;
        }
        @Override
        public int getCount() {
            return myitems.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view1=inflater.inflate(R.layout.list_desc,null);
            ImageView ID=view1.findViewById(R.id.id);
            TextView title=view1.findViewById(R.id.title);
            TextView description=view1.findViewById(R.id.description);
            final AdapterItems s=myitems.get(position);
            ID.setImageResource(s.ID);
            title.setText(s.Title);
            description.setText(s.Description);
            return view1;
        }
    }
}
