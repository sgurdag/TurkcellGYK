package com.sagu.turkcellgyk.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import com.sagu.turkcellgyk.R;

public class GYKActivity extends AppCompatActivity {

    // Activity Yaşam Döngüsündeki Adımları LogCat'te görüntüleyebilmek için bu adımların içine Log ekliyoruz

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("GyK","ONRESUME");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("GyK","ONSTART");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("GyK","ONSTOP");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("GyK","ONDESTROY");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("GyK","ONPAUSE");

    }


    private EditText editText;
    private TextView textView;
    private Button button;
    private ImageView imageView;
    private ProgressBar progressBar;
    private SeekBar seekBar;
    private CheckBox checkBox;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyk);


        // Componentlerimiz ile mantıksal işlemlerimizi yapabilmek için id'leri ile erişerek değişkenlerimize atıyoruz.

        editText = findViewById(R.id.editText1);
        textView = findViewById(R.id.textView1);
        button = findViewById(R.id.showButton);
        imageView = findViewById(R.id.imageView1);
        progressBar = findViewById(R.id.progressBar);
        seekBar = findViewById(R.id.seekBar);
        checkBox = findViewById(R.id.checkBox);
        timePicker = findViewById(R.id.timePicker);



        // Butona tıklandığını algılamak için butonumuza bir Listener tanımlıyoruz..

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Butona tıklandığında EditTex içerisindeki metni TextView içerisinde görüntülüyoruz.

                String text = editText.getText().toString();
                textView.setText(text);

                imageView.setImageDrawable(getResources().getDrawable(R.drawable.sabah));

                // Altta yorum satırına alınan alanlar ProgressBar kullanımı için bir örnektir.

         /*       if (progressBar.getVisibility() == View.VISIBLE)
                    progressBar.setVisibility(View.GONE);
                else
                    progressBar.setVisibility(View.VISIBLE);
*/


         // Buton tıklanınca ListView ve Spinner üzerine Çalıştığımız sayfamıza yönleniyoruz.

                Intent i = new Intent(GYKActivity.this,ListActivity.class);
                startActivity(i);

            }
        });


        // SeekBar üzerinde yapılan değişiklikleri tespit edebilmek için bir Listener tanımlıyoruz.

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //SeekBar da yapılan değşikliği tespit edip textView ile kullanıcıya gösteriyoruz.

                textView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // CheckBox'ın seçili olup olamdığını tespit edebilmek için bir Listener tanımlıyoruz.

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

               // CheckBox seçili ise butonumuz tıklanabilir, değil ise tıklanamaz olsun istiyoruz..

                   button.setClickable(isChecked);
           }
       });

        // TimePicker üzerinde yapılan Tarih seçimini tespit edebilmek için bir Listener tanımlıyoruz.

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
           @Override
           public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

               // Seçili Tarihi Kullanıcıya gösteriyoruz.

               textView.setText("Saat : " + hourOfDay + "Dakika : " + minute);
           }
       });



    }
}
