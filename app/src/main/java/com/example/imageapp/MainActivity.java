package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView=findViewById(R.id.image);
        String filename="unnamed.png";
        InputStream inputStream=null;
        try{
            inputStream=getApplicationContext().getAssets().open(filename);
            Drawable d=Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(d);
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
        catch (IOException e){
           e.printStackTrace();
        }
        finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }

    }
}
