package com.example.quiz;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    RadioGroup rg;
    Button btn;
    ImageView img;

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
        rg = findViewById(R.id.radioGroup);
        pyt = findViewById(R.id.textView);
        img = findViewById(R.id.imageView);

        pyt.setText(pytania[0].tresc);

        rad1.setText(pytania[0].odpA);
        rad2.setText(pytania[0].odpB);
        rad3.setText(pytania[0].odpC);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                if(rg.getCheckedRadioButtonId() != -1) {
                    char odp = 'A';
                    if(rad1.isChecked())
                        odp = 'A';
                    else if(rad2.isChecked())
                        odp = 'B';
                    else
                        odp = 'C';

                    rg.clearCheck();

                    if(pytania[iterator].sprawdz(odp) && !pytania[iterator].odpowiedzJest) {
                        punkty++;
                    }

                    if(iterator == 2)
                        iterator = 0;
                    else
                        iterator++;

                    pyt.setText(pytania[iterator].tresc);
                    img.setImageResource(zdjecia[iterator]);
                    rad1.setText(pytania[iterator].odpA);
                    rad2.setText(pytania[iterator].odpB);
                    rad3.setText(pytania[iterator].odpC);
                }
            }
        });
    }
}