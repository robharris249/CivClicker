package com.example.civclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class UpgradesActivity extends AppCompatActivity {

    ImageButton resourcesButton;
    ImageButton buildingsButton;
    ImageButton peopleButton;

    ImageButton skinningButton;
    ImageButton harvestingButton;
    ImageButton prospectingButton;
    ImageButton domesticationButton;
    ImageButton ploughsharesButton;
    ImageButton irrigationButton;

    TextView foodAmount;
    TextView woodAmount;
    TextView stoneAmount;
    TextView hideAmount;
    TextView herbsAmount;
    TextView oreAmount;
    TextView leatherAmount;
    TextView pietyAmount;
    TextView ironAmount;

    Civilisation c = MainActivity.c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrades);

        resourcesButton = findViewById(R.id.resoucesButton);
        resourcesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpgradesActivity.this, MainActivity.class));
                finish();
            }
        });

        buildingsButton = findViewById(R.id.buildingsButton);
        buildingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpgradesActivity.this, BuildingsActivity.class));
                finish();
            }
        });

        peopleButton = findViewById(R.id.peopleButton);
        peopleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpgradesActivity.this, PopulationActivity.class));
                finish();
            }
        });

        foodAmount = findViewById(R.id.foodAmount);
        foodAmount.setText("" + Math.round(c.r.getFood()));
        woodAmount = findViewById(R.id.woodAmount);
        woodAmount.setText("" + Math.round(c.r.getWood()));
        stoneAmount = findViewById(R.id.stoneAmount);
        stoneAmount.setText("" + Math.round(c.r.getStone()));
        hideAmount = findViewById(R.id.hideAmount);
        hideAmount.setText("" + Math.round(c.r.getHide()));
        herbsAmount = findViewById(R.id.herbsAmount);
        herbsAmount.setText("" + Math.round(c.r.getHerbs()));
        oreAmount = findViewById(R.id.oreAmount);
        oreAmount.setText("" + Math.round(c.r.getOre()));
        leatherAmount = findViewById(R.id.leatherAmount);
        leatherAmount.setText("" + Math.round(c.r.getLeather()));
        pietyAmount = findViewById(R.id.pietyAmount);
        pietyAmount.setText("" + Math.round(c.r.getPiety()));
        ironAmount = findViewById(R.id.ironAmount);
        ironAmount.setText("" + Math.round(c.r.getIron()));

        skinningButton = findViewById(R.id.skinningBuyButton);
        skinningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getHide() >= 10) {
                    c.u.setSkinning(true);
                    c.r.setHide(c.r.getHide() - 10);
                    skinningButton.setVisibility(View.GONE);
                    hideAmount.setText("" + Math.round(c.r.getHide()));
                }
            }
        });

        harvestingButton = findViewById(R.id.harvestingBuyButton);
        harvestingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getHerbs() >= 10) {
                    c.u.setHarvesting(true);
                    c.r.setHerbs(c.r.getHerbs() - 10);
                    harvestingButton.setVisibility(View.GONE);
                    herbsAmount.setText("" + Math.round(c.r.getHerbs()));
                }
            }
        });

        prospectingButton = findViewById(R.id.prospectingBuyButton);
        prospectingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getOre() >= 10) {
                    c.u.setProspecting(true);
                    c.r.setOre(c.r.getOre() - 10);
                    prospectingButton.setVisibility(View.GONE);
                    oreAmount.setText("" + Math.round(c.r.getOre()));
                }
            }
        });

        domesticationButton = findViewById(R.id.domesticationBuyButton);
        domesticationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getLeather() >= 20) {
                    c.u.setDomestication(true);
                    c.r.setLeather(c.r.getLeather() - 20);
                    domesticationButton.setVisibility(View.GONE);
                    leatherAmount.setText("" + Math.round(c.r.getLeather()));
                }
            }
        });

        ploughsharesButton = findViewById(R.id.ploughsharesBuyButton);
        ploughsharesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getIron() >= 20) {
                    c.u.setPloughshares(true);
                    c.r.setIron(c.r.getIron() - 20);
                    ploughsharesButton.setVisibility(View.GONE);
                    ironAmount.setText("" + Math.round(c.r.getIron()));
                }
            }
        });

        irrigationButton = findViewById(R.id.irrigationBuyButton);
        irrigationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 500 && c.r.getStone() >= 200) {
                    c.u.setIrrigation(true);
                    c.r.setWood(c.r.getWood() - 500);
                    c.r.setStone(c.r.getStone() - 200);
                    irrigationButton.setVisibility(View.GONE);
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });

        if(c.u.isSkinning()) {
            skinningButton.setVisibility(View.GONE);
        }
        if(c.u.isHarvesting()) {
            harvestingButton.setVisibility(View.GONE);
        }
        if(c.u.isProspecting()) {
            prospectingButton.setVisibility(View.GONE);
        }
        if(c.u.isDomestication()) {
            domesticationButton.setVisibility(View.GONE);
        }
        if(c.u.isPloughshares()) {
            ploughsharesButton.setVisibility(View.GONE);
        }
        if(c.u.isIrrigation()) {
            irrigationButton.setVisibility(View.GONE);
        }

        updateDisplay();
    }

    private void updateDisplay() {
        Timer populationTimer = new Timer();
        populationTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new TimerTask() {
                    @Override
                    public void run() {
                        foodAmount.setText("" + Math.round(c.r.getFood()));
                        woodAmount.setText("" + Math.round(c.r.getWood()));
                        stoneAmount.setText("" + Math.round(c.r.getStone()));
                        hideAmount.setText("" + Math.round(c.r.getHide()));
                        herbsAmount.setText("" + Math.round(c.r.getHerbs()));
                        oreAmount.setText("" + Math.round(c.r.getOre()));
                        leatherAmount.setText("" + Math.round(c.r.getLeather()));
                        pietyAmount.setText("" + Math.round(c.r.getPiety()));
                        ironAmount.setText("" + Math.round(c.r.getIron()));
                    }
                });
            }
        }, 0, 1000);//Update text every second
    }
}
