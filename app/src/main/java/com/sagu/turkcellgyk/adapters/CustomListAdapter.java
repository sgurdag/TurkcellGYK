package com.sagu.turkcellgyk.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sagu.turkcellgyk.models.Haber;
import com.sagu.turkcellgyk.R;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {

    ArrayList<Haber> haberler;
    Context context;

    public CustomListAdapter(ArrayList<Haber> haberler, Context context) {
        this.haberler = haberler;
        this.context = context;
    }

    @Override
    public int getCount() {
        return haberler.size();
    }

    @Override
    public Object getItem(int position) {
        return haberler.get(position);
    }

    @Override
    public long getItemId(int position) {
        Haber haber = haberler.get(position);
        return haber.getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Her Satırda kullanılmasını istediğimiz satır görünümünü id'si aracılığı ile View tipindeki bir değişkene atıyoruz.

        final View view = View.inflate(context, R.layout.haberler_satir, null);


        // Tanımladığımız view içerisinde component'lerimizi idleri ile ilgili değişkenlere atıyoruz.

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);

        Haber haber = haberler.get(position);

        // Satır görünümündeki componentlerimize ilgili bilgiler bağlıyoruz.

        imageView.setImageResource(haber.getAvatar());
        textView.setText(haber.getAd());

        return view;
    }
}
