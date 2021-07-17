package com.example.ejemplo14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] ciudades = { "Madrid", "Valencia", "Sevilla", "Zaragoza",
            "Malaga", "Gijón", "Palma", "Bilbao", "Alicante", "Vigo" };
    private String[] habitantes = { "3233527", "797028", "702355",
            "679624", "567433", "441354", "407648", "351629",
            "334678", "297355" };
    private TextView lblmensaje;
    private ListView lsv1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lblmensaje = (TextView)findViewById(R.id.lblmensaje);
        this.lsv1 = (ListView)findViewById(R.id.lsvciudades);
        try {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ciudades);
            this.lsv1.setAdapter(adapter);

            this.lsv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View view, int position, long id) {
                    lblmensaje.setText("La población de " + lsv1.getItemAtPosition(position) + " es " + habitantes[position]);
                }
            });
        }catch (Exception ex)
        {
            lblmensaje.setText("Error: " + ex);
        }
    }
}

