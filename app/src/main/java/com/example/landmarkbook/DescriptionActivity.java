package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ImageView wonderful=findViewById(R.id.imageWonderful);
        TextView tvTitle=findViewById(R.id.textViewWonderfulTitle);
        TextView tvDescription=findViewById(R.id.textviewWonderful);

        //gelen intent alındı
        Intent intent=getIntent();

        //gelen title dizisi , gerekli yerlere atama işlemi yapılıyor.
        String titles=intent.getStringExtra("title");
        tvTitle.setText(titles);

        //gelen description dizisi , gerekli yerlere atama işlemi yapılıyor.
        String descriptiones=intent.getStringExtra("description");
        tvDescription.setText(descriptiones);


        Singleton singleton=Singleton.getInstance();
        wonderful.setImageBitmap(singleton.getSelectedItem());


    }
}