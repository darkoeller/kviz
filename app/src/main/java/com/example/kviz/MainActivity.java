package com.example.kviz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.kviz.databinding.ActivityMainBinding;
import com.example.kviz.model.Pitanja;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int indexPitanja = 0;

    //kreira objekt array klase Pitanja
    private Pitanja[] pitanja = new Pitanja[]{
            new Pitanja(R.string.pitanje_br1, true),
            new Pitanja(R.string.pitanje_br2, false),
            new Pitanja(R.string.pitanje_br3, false),
            new Pitanja(R.string.pitanje_br4, false),
            new Pitanja(R.string.pitanje_br5, true),
            new Pitanja(R.string.pitanje_br6, true),
            new Pitanja(R.string.pitanje_br7, false),
            new Pitanja(R.string.pitanje_br8, true),
            new Pitanja(R.string.pitanje_br9, true),
            new Pitanja(R.string.pitanje_br10, true)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.txtPitanje.setText(pitanja[indexPitanja].getPitanjeId());

        binding.btnNext.setOnClickListener(view -> {
            indexPitanja = (indexPitanja + 1) % pitanja.length;
            novoPitanje();
        });

        binding.btnPrev.setOnClickListener(view -> {
            indexPitanja = (indexPitanja - 1) % pitanja.length;
            if (indexPitanja == -1){
                indexPitanja = 0;
            }
            novoPitanje();
        });

        binding.btnTrue.setOnClickListener(view -> provjeriTocnostPitanja(true));
        binding.btnFalse.setOnClickListener(view -> provjeriTocnostPitanja(false));
    }

    private void novoPitanje() {
        binding.txtPitanje.setText(pitanja[indexPitanja].getPitanjeId());
    }

    private void provjeriTocnostPitanja(boolean korisnikovOdgovor){
        boolean tocanOdgovor = pitanja[indexPitanja].isTocanOdgovor();
        int tocnoNetocno;
        if (korisnikovOdgovor == tocanOdgovor){
            tocnoNetocno = R.string.tocan_odgovor;
        }else{
            tocnoNetocno = R.string.netocan_odgovor;
        }
        Snackbar.make(binding.imgRobot, tocnoNetocno, Snackbar.LENGTH_SHORT).show();
    }
}