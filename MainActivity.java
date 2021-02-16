package com.example.civclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageButton buildingsButton;
    ImageButton peopleButton;
    ImageButton upgradesButton;
    public static Civilisation c = new Civilisation();

    Button gatherFood;
    Button gatherWood;
    Button gatherStone;

    TextView foodAmount;
    TextView foodRate;

    TextView woodAmount;
    TextView woodRate;

    TextView stoneAmount;
    TextView stoneRate;

    TextView hideAmount;
    TextView hideRate;

    TextView herbsAmount;
    TextView herbsRate;

    TextView oreAmount;
    TextView oreRate;

    TextView leatherAmount;
    TextView leatherRate;

    TextView pietyAmount;
    TextView pietyRate;

    TextView ironAmount;
    TextView ironRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodAmount  = findViewById(R.id.foodAmount);
        foodRate = findViewById(R.id.foodRate);

        woodAmount = findViewById(R.id.woodAmount);
        woodRate = findViewById(R.id.woodRate);

        stoneAmount = findViewById(R.id.stoneAmount);
        stoneRate = findViewById(R.id.stoneRate);

        hideAmount = findViewById(R.id.hideAmount);
        hideRate = findViewById(R.id.hideRate);

        herbsAmount = findViewById(R.id.herbsAmount);
        herbsRate = findViewById(R.id.herbsRate);

        oreAmount = findViewById(R.id.oreAmount);
        oreRate = findViewById(R.id.oreRate);

        leatherAmount = findViewById(R.id.leatherAmount);
        leatherRate = findViewById(R.id.leatherRate);

        pietyAmount = findViewById(R.id.pietyAmount);
        pietyRate = findViewById(R.id.pietyRate);

        ironAmount = findViewById(R.id.ironAmount);
        ironRate = findViewById(R.id.ironRate);

        buildingsButton = findViewById(R.id.buildingsButton);
        buildingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BuildingsActivity.class));
            }
        });

        peopleButton = findViewById(R.id.peopleButton);
        peopleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PopulationActivity.class));
            }
        });

        upgradesButton = findViewById(R.id.upgradesButton);
        upgradesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UpgradesActivity.class));
            }
        });

        gatherFood = findViewById(R.id.gatherFood);
        gatherFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.clickFood();
                foodAmount.setText("" + Math.round(c.r.getFood()));
            }
        });
        gatherWood = findViewById(R.id.gatherWood);
        gatherWood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.clickWood();
                woodAmount.setText("" + Math.round(c.r.getWood()));
            }
        });
        gatherStone = findViewById(R.id.gatherStone);
        gatherStone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.clickStone();
                stoneAmount.setText("" + Math.round(c.r.getStone()));
            }
        });
        updateDisplay();
    }

    private void updateDisplay() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                foodAmount.setText("" + Math.round(c.r.getFood()));
                foodRate.setText("" + c.roundResource(c.r.foodRate()) + "/s");

                woodAmount.setText("" + Math.round(c.r.getWood()));
                woodRate.setText("" + c.roundResource(c.r.woodRate()) + "/s");

                stoneAmount.setText("" + Math.round(c.r.getStone()));
                stoneRate.setText("" + c.roundResource(c.r.stoneRate()) + "/s");

                hideAmount.setText("" + Math.round(c.r.getHide()));
                hideRate.setText("" + c.roundResource(c.r.hideRate()) + "/s");

                herbsAmount.setText("" + Math.round(c.r.getHerbs()));
                herbsRate.setText("" + c.roundResource(c.r.herbRate()) + "/s");

                oreAmount.setText("" + Math.round(c.r.getOre()));
                oreRate.setText("" + c.roundResource(c.r.oreRate()) + "/s");

                leatherAmount.setText("" + Math.round(c.r.getLeather()));
                leatherRate.setText("" + c.r.leatherRate() + "/s");

                pietyAmount.setText("" + Math.round(c.r.getPiety()));
                pietyRate.setText("" + c.r.pietyRate() + "/s");

                ironAmount.setText("" + Math.round(c.r.getIron()));
                ironRate.setText("" + c.r.ironRate() + "/s");
            }
        }, 0, 1000);//Update text every second
    }
}
