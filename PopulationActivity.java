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

public class PopulationActivity extends AppCompatActivity {

    ImageButton resourcesButton;
    ImageButton buildingsButton;
    ImageButton upgradesButton;

    TextView foodRate;
    TextView woodRate;
    TextView stoneRate;
    TextView leatherRate;
    TextView pietyRate;
    TextView ironRate;

    TextView foodAmount;

    TextView population;
    TextView maxPopulation;
    TextView unemployedAmount;
    TextView farmerAmount;
    TextView woodCutterAmount;
    TextView minerAmount;
    TextView tannerAmount;
    TextView clericAmount;
    TextView blacksmithAmount;
    TextView healerAmount;
    TextView soldierAmount;

    Button unemployedIncrease1;
    Button unemployedIncrease10;
    Button farmerDecrease1;
    Button farmerDecrease10;
    Button farmerIncrease1;
    Button farmerIncrease10;
    Button woodcutterDecrease1;
    Button woodcutterDecrease10;
    Button woodcutterIncrease1;
    Button woodcutterIncrease10;
    Button minerDecrease1;
    Button minerDecrease10;
    Button minerIncrease1;
    Button minerIncrease10;
    Button tannerDecrease1;
    Button tannerDecrease10;
    Button tannerIncrease1;
    Button tannerIncrease10;
    Button healerDecrease1;
    Button healerDecrease10;
    Button healerIncrease1;
    Button healerIncrease10;
    Button blacksmithDecrease1;
    Button blacksmithDecrease10;
    Button blacksmithIncrease1;
    Button blacksmithIncrease10;
    Button clericDecrease1;
    Button clericDecrease10;
    Button clericIncrease1;
    Button clericIncrease10;
    Button soldierDecrease1;
    Button soldierDecrease10;
    Button soldierIncrease1;
    Button soldierIncrease10;

    Civilisation c = MainActivity.c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_population);

        resourcesButton = findViewById(R.id.resoucesButton);
        resourcesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buildingsButton = findViewById(R.id.buildingsButton);
        buildingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PopulationActivity.this, BuildingsActivity.class));
                finish();
            }
        });

        upgradesButton = findViewById(R.id.upgradesButton);
        upgradesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PopulationActivity.this, UpgradesActivity.class));
                finish();
            }
        });

        foodRate = findViewById(R.id.foodPerSec);
        woodRate = findViewById(R.id.woodPerSec);
        stoneRate = findViewById(R.id.stonePerSec);
        leatherRate = findViewById(R.id.leatherPerSec);
        pietyRate = findViewById(R.id.pietyPerSec);
        ironRate = findViewById(R.id.ironPerSec);

        population = findViewById(R.id.currentPopulationAmount);
        maxPopulation = findViewById(R.id.maxPopulationAmount);
        foodAmount = findViewById(R.id.foodAmount);
        unemployedAmount = findViewById(R.id.unemployedAmount);
        farmerAmount = findViewById(R.id.farmerAmount);
        woodCutterAmount = findViewById(R.id.woodcutterAmount);
        minerAmount = findViewById(R.id.minerAmount);
        tannerAmount = findViewById(R.id.tannerAmount);
        healerAmount = findViewById(R.id.healerAmount);
        blacksmithAmount = findViewById(R.id.blackSmithAmount);
        clericAmount = findViewById(R.id.clericAmount);
        soldierAmount = findViewById(R.id.soldierAmount);

        foodAmount.setText("" + Math.round(c.r.getFood()));
        foodRate.setText("" + c.roundResource(c.r.foodRate()) + "/s");
        woodRate.setText("" + c.roundResource(c.r.woodRate()) + "/s");
        stoneRate.setText("" + c.roundResource(c.r.stoneRate()) + "/s");
        leatherRate.setText("" + c.r.leatherRate() + "/s");
        pietyRate.setText("" + c.r.pietyRate() + "/s");
        ironRate.setText("" + c.r.ironRate() + "/s");

        population.setText("" + c.getPopulation());
        maxPopulation.setText("" + c.getMaxPopulation());
        unemployedAmount.setText("" + c.getUnemployed());
        farmerAmount.setText("" + c.getFarmer());
        woodCutterAmount.setText("" + c.getWoodcutter());
        minerAmount.setText("" + c.getMiner());
        tannerAmount.setText("" + c.getTanners());
        healerAmount.setText("" + c.getHealers());
        blacksmithAmount.setText("" + c.getBlacksmiths());
        clericAmount.setText("" + c.getClerics());
        soldierAmount.setText("" + c.getSoldiers());

        unemployedIncrease1 = findViewById(R.id.unemployedIncrease1);
        unemployedIncrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getFood() >= 20 && c.getPopulation() < c.getMaxPopulation()) {
                    System.out.println("here");
                    c.r.setFood(c.r.getFood() - 20);
                    c.setUnemployed(c.getUnemployed() + 1);
                    c.updatePopulation();
                    unemployedAmount.setText("" + c.getUnemployed());
                    population.setText("" +c.getPopulation());
                    foodRate.setText("" + c.roundResource(c.r.foodRate()) + "/s");
                }
            }
        });

        unemployedIncrease10 = findViewById(R.id.unemployedIncrease10);
        unemployedIncrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getFood() >= 200 && c.getPopulation() + 20 <= c.getMaxPopulation()) {
                    c.r.setFood(c.r.getFood() - 200);
                    c.setUnemployed(c.getUnemployed() + 10);
                    c.updatePopulation();
                    unemployedAmount.setText("" + c.getUnemployed());
                    population.setText("" + c.getPopulation());
                    foodRate.setText("" + c.roundResource(c.r.foodRate()) + "/s");
                }
            }
        });

        farmerDecrease1 = findViewById(R.id.FarmerDecrease1);
        farmerDecrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getFarmer() > 0) {
                    c.setFarmer(c.getFarmer() - 1);
                    c.setUnemployed(c.getUnemployed() + 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    farmerAmount.setText("" + c.getFarmer());
                    foodRate.setText("" + c.roundResource(c.r.foodRate()) + "/s");
                    foodRate.setText("" + c.roundResource(c.r.foodRate()) + "/s");
                }
            }
        });

        farmerDecrease10 = findViewById(R.id.FarmerDecrease10);
        farmerDecrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getFarmer() >= 10) {
                    c.setFarmer(c.getFarmer() - 10);
                    c.setUnemployed(c.getUnemployed() + 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    farmerAmount.setText("" + c.getFarmer());
                    foodRate.setText("" + c.roundResource(c.r.foodRate()) + "/s");
                }
            }
        });

        farmerIncrease1 = findViewById(R.id.FarmerIncrease1);
        farmerIncrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() > 0) {
                    c.setFarmer(c.getFarmer() + 1);
                    c.setUnemployed(c.getUnemployed() - 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    farmerAmount.setText("" + c.getFarmer());
                    foodRate.setText("" + c.roundResource(c.r.foodRate()) + "/s");
                }
            }
        });

        farmerIncrease10 = findViewById(R.id.FarmerIncrease10);
        farmerIncrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() >= 10) {
                    c.setFarmer(c.getFarmer() + 10);
                    c.setUnemployed(c.getUnemployed() - 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    farmerAmount.setText("" + c.getFarmer());
                    foodRate.setText("" + c.roundResource(c.r.foodRate()) + "/s");
                }
            }
        });

        woodcutterDecrease1 = findViewById(R.id.WoodcutterDecrease1);
        woodcutterDecrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getWoodcutter() > 0) {
                    c.setWoodcutter(c.getWoodcutter() - 1);
                    c.setUnemployed(c.getUnemployed() + 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    woodCutterAmount.setText("" + c.getWoodcutter());
                    woodRate.setText("" + c.roundResource(c.r.woodRate()) + "/s");
                }
            }
        });

        woodcutterDecrease10 = findViewById(R.id.WoodcutterDecrease10);
        woodcutterDecrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getWoodcutter() >= 10) {
                    c.setWoodcutter(c.getWoodcutter() - 10);
                    c.setUnemployed(c.getUnemployed() + 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    woodCutterAmount.setText("" + c.getWoodcutter());
                    woodRate.setText("" + c.roundResource(c.r.woodRate()) + "/s");
                }
            }
        });

        woodcutterIncrease1 = findViewById(R.id.WoodcutterIncrease1);
        woodcutterIncrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() > 0) {
                    c.setWoodcutter(c.getWoodcutter() + 1);
                    c.setUnemployed(c.getUnemployed() - 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    woodCutterAmount.setText("" + c.getWoodcutter());
                    woodRate.setText("" + c.roundResource(c.r.woodRate()) + "/s");
                }
            }
        });

        woodcutterIncrease10 = findViewById(R.id.WoodcutterIncrease10);
        woodcutterIncrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() >= 10) {
                    c.setWoodcutter(c.getWoodcutter() + 10);
                    c.setUnemployed(c.getUnemployed() - 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    woodCutterAmount.setText("" + c.getWoodcutter());
                    woodRate.setText("" + c.roundResource(c.r.woodRate()) + "/s");
                }
            }
        });

        minerDecrease1 = findViewById(R.id.MinerDecrease1);
        minerDecrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getMiner() > 0) {
                    c.setMiner(c.getMiner() - 1);
                    c.setUnemployed(c.getUnemployed() + 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    minerAmount.setText("" + c.getMiner());
                    stoneRate = findViewById(R.id.stonePerSec);
                }
            }
        });

        minerDecrease10 = findViewById(R.id.MinerDecrease10);
        minerDecrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getMiner() >= 10) {
                    c.setMiner(c.getMiner() - 10);
                    c.setUnemployed(c.getUnemployed() + 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    minerAmount.setText("" + c.getMiner());
                    stoneRate = findViewById(R.id.stonePerSec);
                }
            }
        });

        minerIncrease1 = findViewById(R.id.MinerIncrease1);
        minerIncrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() > 0) {
                    c.setMiner(c.getMiner() + 1);
                    c.setUnemployed(c.getUnemployed() - 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    minerAmount.setText("" + c.getMiner());
                    stoneRate = findViewById(R.id.stonePerSec);
                }
            }
        });

        minerIncrease10 = findViewById(R.id.MinerIncrease10);
        minerIncrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() >= 10) {
                    c.setMiner(c.getMiner() + 10);
                    c.setUnemployed(c.getUnemployed() - 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    minerAmount.setText("" + c.getMiner());
                    stoneRate = findViewById(R.id.stonePerSec);
                }
            }
        });

        tannerDecrease1 = findViewById(R.id.TannerDecrease1);
        tannerDecrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getTanners() > 0) {
                    c.setTanners(c.getTanners() - 1);
                    c.setUnemployed(c.getUnemployed() + 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    tannerAmount.setText("" + c.getTanners());
                    leatherRate = findViewById(R.id.leatherPerSec);
                }
            }
        });

        tannerDecrease10 = findViewById(R.id.TannerDecrease10);
        tannerDecrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getTanners() >= 10) {
                    c.setTanners(c.getTanners() - 10);
                    c.setUnemployed(c.getUnemployed() + 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    tannerAmount.setText("" + c.getTanners());
                    leatherRate = findViewById(R.id.leatherPerSec);
                }
            }
        });

        tannerIncrease1 = findViewById(R.id.TannerIncrease1);
        tannerIncrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() > 0 && c.getTanners() < c.b.getTanneries()) {
                    c.setTanners(c.getTanners() + 1);
                    c.setUnemployed(c.getUnemployed() - 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    tannerAmount.setText("" + c.getTanners());
                    leatherRate = findViewById(R.id.leatherPerSec);
                }
            }
        });

        tannerIncrease10 = findViewById(R.id.TannerIncrease10);
        tannerIncrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() >= 10 && c.getTanners()+10 < c.b.getTanneries()) {
                    c.setTanners(c.getTanners() + 10);
                    c.setUnemployed(c.getUnemployed() - 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    tannerAmount.setText("" + c.getTanners());
                    leatherRate = findViewById(R.id.leatherPerSec);
                }
            }
        });

        healerDecrease1 = findViewById(R.id.HealerDecrease1);
        healerDecrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getHealers() > 0) {
                    c.setHealers(c.getHealers() - 1);
                    c.setUnemployed(c.getUnemployed() + 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    healerAmount.setText("" + c.getHealers());
                }
            }
        });

        healerDecrease10 = findViewById(R.id.HealerDecrease10);
        healerDecrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getHealers() >= 10) {
                    c.setHealers(c.getHealers() - 10);
                    c.setUnemployed(c.getUnemployed() + 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    healerAmount.setText("" + c.getHealers());
                }
            }
        });

        healerIncrease1 = findViewById(R.id.HealerIncrease1);
        healerIncrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() > 0  && c.getHealers() < c.b.getApothecaries()) {
                    c.setHealers(c.getHealers() + 1);
                    c.setUnemployed(c.getUnemployed() - 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    healerAmount.setText("" + c.getHealers());
                }
            }
        });

        healerIncrease10 = findViewById(R.id.HealerIncrease10);
        healerIncrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() >= 10  && c.getHealers() + 10 < c.b.getApothecaries()) {
                    c.setHealers(c.getHealers() + 10);
                    c.setUnemployed(c.getUnemployed() - 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    healerAmount.setText("" + c.getHealers());
                }
            }
        });

        blacksmithDecrease1 = findViewById(R.id.BlackSmithDecrease1);
        blacksmithDecrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getBlacksmiths() > 0) {
                    c.setBlacksmiths(c.getBlacksmiths() - 1);
                    c.setUnemployed(c.getUnemployed() + 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    blacksmithAmount.setText("" + c.getBlacksmiths());
                    ironRate.setText("" + c.r.ironRate() + "/s");
                }
            }
        });

        blacksmithDecrease10 = findViewById(R.id.BlackSmithDecrease10);
        blacksmithDecrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getBlacksmiths() >= 10) {
                    c.setBlacksmiths(c.getBlacksmiths() - 10);
                    c.setUnemployed(c.getUnemployed() + 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    blacksmithAmount.setText("" + c.getBlacksmiths());
                    ironRate.setText("" + c.r.ironRate() + "/s");
                }
            }
        });

        blacksmithIncrease1 = findViewById(R.id.BlackSmithIncrease1);
        blacksmithIncrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() > 0 && c.getBlacksmiths() < c.b.getSmithies()) {
                    c.setBlacksmiths(c.getBlacksmiths() + 1);
                    c.setUnemployed(c.getUnemployed() - 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    blacksmithAmount.setText("" + c.getBlacksmiths());
                    ironRate.setText("" + c.r.ironRate() + "/s");
                }
            }
        });

        blacksmithIncrease10 = findViewById(R.id.BlackSmithIncrease10);
        blacksmithIncrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() >= 10 && c.getBlacksmiths() + 10 < c.b.getSmithies()) {
                    c.setBlacksmiths(c.getBlacksmiths() + 10);
                    c.setUnemployed(c.getUnemployed() - 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    blacksmithAmount.setText("" + c.getBlacksmiths());
                    ironRate.setText("" + c.r.ironRate() + "/s");
                }
            }
        });

        clericDecrease1 = findViewById(R.id.ClericDecrease1);
        clericDecrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getClerics() > 0) {
                    c.setClerics(c.getClerics() - 1);
                    c.setUnemployed(c.getUnemployed() + 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    clericAmount.setText("" + c.getClerics());
                    pietyRate.setText("" + c.r.pietyRate() + "/s");
                }
            }
        });

        clericDecrease10 = findViewById(R.id.ClericDecrease10);
        clericDecrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getClerics() >= 10) {
                    c.setClerics(c.getClerics() - 10);
                    c.setUnemployed(c.getUnemployed() + 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    clericAmount.setText("" + c.getClerics());
                    pietyRate.setText("" + c.r.pietyRate() + "/s");
                }
            }
        });

        clericIncrease1 = findViewById(R.id.ClericIncrease1);
        clericIncrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() > 0 && c.getClerics() < c.b.getTemples()) {
                    c.setClerics(c.getClerics() + 1);
                    c.setUnemployed(c.getUnemployed() - 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    clericAmount.setText("" + c.getClerics());
                    pietyRate.setText("" + c.r.pietyRate() + "/s");
                }
            }
        });

        clericIncrease10 = findViewById(R.id.ClericIncrease10);
        clericIncrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() >= 10 && c.getClerics() < c.b.getTemples()) {
                    c.setClerics(c.getClerics() + 10);
                    c.setUnemployed(c.getUnemployed() - 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    clericAmount.setText("" + c.getClerics());
                    pietyRate.setText("" + c.r.pietyRate() + "/s");
                }
            }
        });

        soldierDecrease1 = findViewById(R.id.SoldierDecrease1);
        soldierDecrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getSoldiers() > 0) {
                    c.setSoldiers(c.getSoldiers() - 1);
                    c.setUnemployed(c.getUnemployed() + 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    soldierAmount.setText("" + c.getSoldiers());
                }
            }
        });

        soldierDecrease10 = findViewById(R.id.SoldierDecrease10);
        soldierDecrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getSoldiers() >= 10) {
                    c.setSoldiers(c.getSoldiers() - 10);
                    c.setUnemployed(c.getUnemployed() + 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    soldierAmount.setText("" + c.getSoldiers());
                }
            }
        });

        soldierIncrease1 = findViewById(R.id.SoldierIncrease1);
        soldierIncrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() > 0 && c.getSoldiers() < c.b.getBarracks()) {
                    c.setSoldiers(c.getSoldiers() + 1);
                    c.setUnemployed(c.getUnemployed() - 1);
                    unemployedAmount.setText("" + c.getUnemployed());
                    soldierAmount.setText("" + c.getSoldiers());
                }
            }
        });

        soldierIncrease10 = findViewById(R.id.SoldierIncrease10);
        soldierIncrease10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.getUnemployed() >= 10 && c.getSoldiers() + 10 < c.b.getBarracks()) {
                    c.setSoldiers(c.getSoldiers() + 10);
                    c.setUnemployed(c.getUnemployed() - 10);
                    unemployedAmount.setText("" + c.getUnemployed());
                    soldierAmount.setText("" + c.getSoldiers());
                }
            }
        });

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
                        foodRate.setText("" + c.roundResource(c.r.foodRate()) + "/s");
                        woodRate.setText("" + c.roundResource(c.r.woodRate()) + "/s");
                        stoneRate.setText("" + c.roundResource(c.r.stoneRate()) + "/s");
                        leatherRate.setText("" + c.r.leatherRate() + "/s");
                        pietyRate.setText("" + c.r.pietyRate() + "/s");
                        ironRate.setText("" + c.r.ironRate() + "/s");
                    }
                });
            }
        }, 0, 1000);//Update text every second
    }
}
