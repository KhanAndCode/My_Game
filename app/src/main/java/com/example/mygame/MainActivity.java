package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int yellow;
    int orange;
    View[][] tiles = new View[4][4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources r = getResources();
        yellow = r.getColor(R.color.yellow);
        orange = r.getColor(R.color.orange);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String tID = "t" + i + j;
                int resID = getResources().getIdentifier(tID, "id", getPackageName());
                tiles[i][j] = findViewById(resID);
                Random random = new Random();
                int[] colors = {yellow, orange};
                int pos = random.nextInt(colors.length);
                tiles[i][j].setBackgroundColor(colors[pos]);
            }

        }
    }

    public void changeColor(View view) {
        ColorDrawable d = (ColorDrawable) view.getBackground();
        if (d.getColor() == orange) {
            view.setBackgroundColor(yellow);
        } else {
            view.setBackgroundColor(orange);
        }


    }

    public void onClick(View view) {
        changeColor(view);
        String tag = view.getTag().toString();
        int tagInt = Integer.parseInt(tag);
        System.out.println(tag);
        int x = tagInt/10, y = tagInt%10;

        for (int i = 0; i < 4; i++) {
            changeColor(tiles[x][i]);
            changeColor(tiles[i][y]);
        }

        int isWin = 0;
        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 4 ; j++) {
                ColorDrawable tile = (ColorDrawable) tiles[i][j].getBackground();
                if (tile.getColor()==yellow) isWin++;
            }
        }
        if (isWin==16){
            Context context = getApplicationContext();
            Toast.makeText(context, "YOU ARE WINNER!", Toast.LENGTH_LONG).show();
        }
        else if(isWin==0){
            Context context = getApplicationContext();
            Toast.makeText(context, "YOU ARE WINNER!", Toast.LENGTH_LONG).show();
        }

    }
}