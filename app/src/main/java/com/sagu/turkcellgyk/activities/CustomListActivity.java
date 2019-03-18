package com.sagu.turkcellgyk.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.sagu.turkcellgyk.adapters.CustomListAdapter;
import com.sagu.turkcellgyk.models.Haber;
import com.sagu.turkcellgyk.R;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);


        listView = findViewById(R.id.haberList);

        // Listemiz içerisinde göstermek istediğimiz, kendi olşturduğumuz Haber objesinden bir liste oluşturuyoruz.

        ArrayList<Haber> haberler = new ArrayList<>();
        haberler.add(new Haber("Hurriyet",R.drawable.hurriyet,1));
        haberler.add(new Haber("Sabah",R.drawable.sabah,2));

        // Haber listemizi ListView içerisinde görüntüleyebilmek için Custom Adapter'ımıza gönderiyoruz.

        CustomListAdapter adapter = new CustomListAdapter(haberler,CustomListActivity.this);
        listView.setAdapter(adapter);

    }
}
