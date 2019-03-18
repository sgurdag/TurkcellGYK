package com.sagu.turkcellgyk.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sagu.turkcellgyk.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {


    ArrayList<String> list; // Spinner içerisinde seçim yaptırmak istediğimiz liste. Aynı zamanda ListView içerisinde de listelediğimiz listedir.
    Spinner spinner;
    TextView spinnerTV;
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivty_list);


        // Componentlerimiz ile mantıksal işlemlerimizi yapabilmek için id'leri ile erişerek değişkenlerimize atıyoruz.

        spinner = findViewById(R.id.spinner);
        spinnerTV = findViewById(R.id.spinnerTextView);
        listView = findViewById(R.id.listView);


        // Listemizi oluşturup içeriğini dolduruyoruz.

        list = new ArrayList<>();
        list.add("item 1");
        list.add("item 2");
        list.add("item 3");
        list.add("item 4");
        list.add("item 5");
        list.add("item 6");

        // Spinner için bir Adapter oluşturup bu adapter'i Spinner Component'ine tanıtıyoruz.

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);

        // Spinner Component'ine seçilen elemanı bulmak için Listener tnaımlıyoruz.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Seçilen item ile ilgili bilgileri TextView içerisinde kullanıcıya gösteriyoruz.

                spinnerTV.setText("Position : " + position +" Id : " + id + "text :"+ spinner.getSelectedItem());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Custom bir adapter oluşturmadığımız takdirde Spinner için oluşturulmuş olan Adapter'ı Listview için de kullanabiliriz.

        listView.setAdapter(adapter);

        // Listview'de tıklanan elemanı bulmak için ListView'a bir Listener tanımlıyoruz.

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Seçilen elemanın bilgilerini AlertDialog içerisinde görüntülenmesi için ilgili fonksiyonumuzu çağırıyoruz.

                showAlertDialog(position, list.get(position));
            }
        });

    }

    // AlertDialog içerisinde Mesaj göstermemizi sağlayan fonksiyonumuz

    private void showAlertDialog(int position, String selectedItem){


        //AlertDialog içerisini özelleştirmek için bir Builder oluşturuyoruz.

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Ekranda görüntülenecek olan Mesajımızı belirtiyoruz.

        builder.setMessage("Tıklanan eleman : " + selectedItem + " Position : "+ position );

        //AlertDialog üzerindeki butonların metinlerini ve tıklandığında yapıalcak işlemleri tanımlıyoruz.

        builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent i = new Intent(ListActivity.this,CustomListActivity.class);
                startActivity(i);

            }
        });
        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ListActivity.this, String.valueOf(which), Toast.LENGTH_SHORT).show();
            }
        });

        //Hazırladığımız Builder ile bir AlertDialog oluşturuyoruz.

        AlertDialog alertDialog = builder.create();

        // AlertDialog'u ekranda gösteriyoruz.

        alertDialog.show();


    }

}
