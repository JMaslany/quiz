package com.example.quiz;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView pyt;
    RadioButton rad1;
    RadioButton rad2;
    RadioButton rad3;
    Button btn;

    private int[] zdjecia = {
            R.drawable.zad1,
            R.drawable.zad2,
            R.drawable.zad3
    };
    private PytanieZamkniete[] pytania = {
            new PytanieZamkniete("Ktore to schronisko?",zdjecia[0] ,"Na Rysiance.","Na Wielkiej Raczy.","Na Wielkiej Rycerzowej",'B'),
            new PytanieZamkniete("Zwierzę na zdjęciu to",zdjecia[1] ,"owczarek.","wilk.","kozica.",'A'),
            new PytanieZamkniete("W oddali są widoczne",zdjecia[2] ,"Tatry.","Himalaje.","Alpy.",'C')
};
    private int punkty = 0;
    private int iterator = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rad1 = findViewById(R.id.radioButton1);
        rad2 = findViewById(R.id.radioButton2);
        rad3 = findViewById(R.id.radioButton3);
        pyt = findViewById(R.id.textView);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {

            }
        });
    }
}