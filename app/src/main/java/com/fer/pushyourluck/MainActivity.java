package com.fer.pushyourluck;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn01;
    ImageView img01;
    TextView txt01;
    String frases[];

    //variáveis para efeito sonoro e música
    SoundPool snd;
    MediaPlayer musica;
    boolean tocar = true;
    int click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn01 = findViewById(R.id.button);
        img01 = findViewById(R.id.imageView);
        txt01 = findViewById(R.id.textView);

        frases = new String[]
                {
                "A vida trará coisas boas \nse tiver paciência.",
                "Demonstre amor e alegria em todas\n as oportunidades e verá que a paz \nnasce dentro de si.",
                "Não compense na ira o que \nlhe falta na razão.",
                "Defeitos e virtudes são apenas \ndois lados da mesma moeda.",
                "A maior de todas as torres \ncomeça no solo.",
                "Não há que ser forte. \nHá que ser flexível.",
                "Todos os dias organiza os seus cabelos, \npor que não faz o mesmo com o coração?",
                "Há três coisas que jamais voltam; \na flecha lançada, a palavra dita e a oportunidade perdida.",
                "A juventude não é uma época da vida, \né um estado de espírito.",
                "Podemos escolher o que semear, \nmas somos obrigados a colher o que plantamos.",
                "Dê toda a atenção á formação dos \nseus filhos, sobretudo com bons exemplos da sua própria vida.",
                "Siga os bons e aprenda com eles.",
                "Não importa o tamanho da montanha, \nela não pode tapar o sol.",
                "O bom-senso vale mais \ndo que muito conhecimento.",
                "Quem quer colher rosas tem de \nestar preparado para suportar os espinhos.",
                "São os nossos amigos que nos ensinam \nas mais valiosas lições."
        };

        //Efeitos sonoros
        snd = new SoundPool(4, AudioManager.STREAM_MUSIC, 8);
        click = snd.load(MainActivity.this,R.raw.click,3);

        musica = MediaPlayer.create(MainActivity.this,R.raw.musica);
        musica.start();

        img01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tocar){
                    musica.pause();
                    img01.setImageResource(R.drawable.semsom);
                }else {
                    musica.start();
                    img01.setImageResource(R.drawable.som);
                }
                tocar = !tocar;
            }
        });

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random val = new Random();
                int valor = val.nextInt(15);
                txt01.setText(frases[valor]);
                snd.play(click,1,1,1,0,1);
            }
        });


    }
}