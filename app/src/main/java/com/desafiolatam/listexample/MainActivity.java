package com.desafiolatam.listexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setUpAdapter();
    }

    private void setUpAdapter() {
        ListView listView = findViewById(R.id.mainList);
        MyAdapter adapter = new MyAdapter();
        adapter.setValues(llenarArrayList());
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("info", "onItemClick: " + adapter.getItem(i).toString());
                Toast.makeText(adapterView.getContext(),"Elemento seleccionado: " +
                        adapter.getItem(i).toString(),Toast.LENGTH_LONG).show();
            }
        });
    }


    private class MyAdapter extends BaseAdapter {
        private final List<String> values = new ArrayList<>();
        @Override
        public int getCount() {
            return values.size();
        }

        @Override
        public Object getItem(int i) {
            return values.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item, container, false);
            }
            String textToShow = getItem(position).toString();
            ((TextView) convertView.findViewById(R.id.titleText)).setText(textToShow);
            return convertView;
        }
        public void setValues(List<String> newValues) {
            values.clear();
            values.addAll(newValues);
        }
    }

    private ArrayList<String> llenarArrayList(){
        ArrayList<String> valores = new ArrayList<>();
        valores.add("Chile");
        valores.add("Brasil");
        valores.add("España");
        valores.add("Argentina");
        valores.add("Estados Unidos");
        valores.add("Francia");
        valores.add("Perú");
        valores.add("Canadá");
        valores.add("México");
        valores.add("Costa Rica");
        valores.add("Ecuador");
        valores.add("Ucrania");
        valores.add("Grecia");
        valores.add("Portugal");
        valores.add("Japón");
        valores.add("China");
        valores.add("Nueva Zelanda");
        valores.add("Dinamarca");
        valores.add("Suecia");
        valores.add("Rumania");
        valores.add("Rusia");
        valores.add("Filipinas");
        valores.add("Noruega");

        return valores;
    }
}