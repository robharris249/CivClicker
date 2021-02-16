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

public class BuildingsActivity extends AppCompatActivity {

    ImageButton resourcesButton;
    ImageButton peopleButton;
    ImageButton upgradesButton;

    TextView hideAmount;
    TextView woodAmount;
    TextView stoneAmount;

    TextView tentAmount;
    TextView woodhutAmount;
    TextView cottageAmount;
    TextView houseAmount;
    TextView mansionAmount;
    TextView barnAmount;
    TextView woodStockpileAmount;
    TextView stoneStockpileAmount;
    TextView tanneriesAmount;
    TextView apothecariesAmount;
    TextView smithiesAmount;
    TextView templesAmount;
    TextView barracksAmount;

    Button tentIncrease1Button;
    Button tentIncrease10Button;
    Button woodhutIncrease1Button;
    Button woodhutIncrease10Button;
    Button cottageIncrease1Button;
    Button cottageIncrease10Button;
    Button houseIncrease1Button;
    Button houseIncrease10Button;
    Button mansionIncrease1Button;
    Button mansionIncrease10Button;
    Button barnIncrease1Button;
    Button barnIncrease10Button;
    Button woodStockpileIncrease1Button;
    Button woodStockpileIncrease10Button;
    Button stoneStockpileIncrease1Button;
    Button stoneStockpileIncrease10Button;
    Button tanneryIncrease1Button;
    Button tanneryIncrease10Button;
    Button apothecaryIncrease1Button;
    Button apothecaryIncrease10Button;
    Button smithyIncrease1Button;
    Button smithyIncrease10Button;
    Button templeIncrease1Button;
    Button templeIncrease10Button;
    Button barracksIncrease1Button;
    Button barracksIncrease10Button;

    Civilisation c = MainActivity.c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buildings);

        resourcesButton = findViewById(R.id.resoucesButton);
        resourcesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        peopleButton = findViewById(R.id.peopleButton);
        peopleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuildingsActivity.this, PopulationActivity.class));
                finish();
            }
        });

        upgradesButton = findViewById(R.id.upgradesButton);
        upgradesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuildingsActivity.this, UpgradesActivity.class));
                finish();
            }
        });

        hideAmount = findViewById(R.id.hideAmount);
        hideAmount.setText("" + Math.round(c.r.getHide()));
        woodAmount = findViewById(R.id.woodAmount);
        woodAmount.setText("" + Math.round(c.r.getWood()));
        stoneAmount = findViewById(R.id.stoneAmount);
        stoneAmount.setText("" + Math.round(c.r.getStone()));

        tentAmount = findViewById(R.id.tentAmount);
        tentAmount.setText("" + c.b.getTents());
        tentIncrease1Button = findViewById(R.id.tentIncrease1);
        tentIncrease1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getHide() >= 2 && c.r.getWood() >= 2) {
                    c.b.setTents(c.b.getTents() + 1);
                    c.r.setHide(c.r.getHide() - 2);
                    c.r.setWood(c.r.getWood() - 2);
                    tentAmount.setText("" + c.b.getTents());
                    hideAmount.setText("" + Math.round(c.r.getHide()));
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                }
            }
        });
        tentIncrease10Button = findViewById(R.id.tentIncrease10);
        tentIncrease10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getHide() >= 20 && c.r.getWood() >= 20) {
                    c.b.setTents(c.b.getTents() + 10);
                    c.r.setHide(c.r.getHide() - 20);
                    c.r.setWood(c.r.getWood() - 20);
                    tentAmount.setText("" + c.b.getTents());
                    hideAmount.setText("" + Math.round(c.r.getHide()));
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                }
            }
        });

        woodhutAmount = findViewById(R.id.woodhutAmount);
        woodhutAmount.setText("" + c.b.getWoodHuts());
        woodhutIncrease1Button = findViewById(R.id.woodhutIncrease1);
        woodhutIncrease1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getHide() >= 1 && c.r.getWood() >= 20) {
                    c.b.setWoodHuts(c.b.getWoodHuts() + 1);
                    c.r.setHide(c.r.getHide() - 1);
                    c.r.setWood(c.r.getWood() - 20);
                    woodhutAmount.setText("" + c.b.getWoodHuts());
                    hideAmount.setText("" + Math.round(c.r.getHide()));
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                }
            }
        });
        woodhutIncrease10Button = findViewById(R.id.woodhutIncrease10);
        woodhutIncrease10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getHide() >= 10 && c.r.getWood() >= 20) {
                    c.b.setWoodHuts(c.b.getWoodHuts() + 10);
                    c.r.setHide(c.r.getHide() - 10);
                    c.r.setWood(c.r.getWood() - 200);
                    woodhutAmount.setText("" + c.b.getWoodHuts());
                    hideAmount.setText("" + Math.round(c.r.getHide()));
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                }
            }
        });

        cottageAmount = findViewById(R.id.cottageAmount);
        cottageAmount.setText("" + c.b.getCottages());
        cottageIncrease1Button = findViewById(R.id.cottageIncrease1);
        cottageIncrease1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 10 && c.r.getStone() >= 30) {
                    c.b.setCottages(c.b.getCottages() + 1);
                    c.r.setWood(c.r.getWood() - 10);
                    c.r.setStone(c.r.getStone() - 30);
                    cottageAmount.setText("" + c.b.getCottages());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });
        cottageIncrease10Button = findViewById(R.id.cottageIncrease10);
        cottageIncrease10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 100 && c.r.getStone() >= 300) {
                    c.b.setCottages(c.b.getCottages() + 10);
                    c.r.setWood(c.r.getWood() - 100);
                    c.r.setStone(c.r.getStone() - 300);
                    cottageAmount.setText("" + c.b.getCottages());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });

        houseAmount = findViewById(R.id.houseAmount);
        houseAmount.setText("" + c.b.getHouses());
        houseIncrease1Button = findViewById(R.id.houseIncrease1);
        houseIncrease1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 30 && c.r.getStone() >= 70) {
                    c.b.setHouses(c.b.getHouses() + 1);
                    c.r.setWood(c.r.getWood() - 30);
                    c.r.setStone(c.r.getStone() - 70);
                    houseAmount.setText("" + c.b.getHouses());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });
        houseIncrease10Button = findViewById(R.id.houseIncrease10);
        houseIncrease10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 300 && c.r.getStone() >= 700) {
                    c.b.setHouses(c.b.getHouses() + 10);
                    c.r.setWood(c.r.getWood() - 300);
                    c.r.setStone(c.r.getStone() - 700);
                    houseAmount.setText("" + c.b.getHouses());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });

        mansionAmount = findViewById(R.id.mansionAmount);
        mansionAmount.setText("" + c.b.getMansions());
        mansionIncrease1Button = findViewById(R.id.mansionIncrease1);
        mansionIncrease1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 200 && c.r.getStone() >= 200) {
                    c.b.setMansions(c.b.getMansions() + 1);
                    c.r.setWood(c.r.getWood() - 200);
                    c.r.setStone(c.r.getStone() - 200);
                    mansionAmount.setText("" + c.b.getMansions());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });
        mansionIncrease10Button = findViewById(R.id.mansionIncrease10);
        mansionIncrease10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 2000 && c.r.getStone() >= 2000) {
                    c.b.setMansions(c.b.getMansions() + 10);
                    c.r.setWood(c.r.getWood() - 2000);
                    c.r.setStone(c.r.getStone() - 2000);
                    mansionAmount.setText("" + c.b.getMansions());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });

        barnAmount = findViewById(R.id.barnAmount);
        barnAmount.setText("" + c.b.getBarn());
        barnIncrease1Button = findViewById(R.id.barnIncrease1);
        barnIncrease1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 100) {
                    c.b.setBarn(c.b.getBarn() + 1);
                    c.r.setWood(c.r.getWood() - 100);
                    barnAmount.setText("" + c.b.getBarn());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                }
            }
        });
        barnIncrease10Button = findViewById(R.id.barnIncrease10);
        barnIncrease10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 1000) {
                    c.b.setBarn(c.b.getBarn() + 10);
                    c.r.setWood(c.r.getWood() - 1000);
                    barnAmount.setText("" + c.b.getBarn());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                }
            }
        });

        woodStockpileAmount = findViewById(R.id.woodStockpileAmount);
        woodStockpileAmount.setText("" + c.b.getWoodStockpile());
        woodStockpileIncrease1Button = findViewById(R.id.woodStockpileIncrease1);
        woodStockpileIncrease1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 100) {
                    c.b.setWoodStockpile(c.b.getWoodStockpile() + 1);
                    c.r.setWood(c.r.getWood() - 100);
                    woodStockpileAmount.setText("" + c.b.getWoodStockpile());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                }
            }
        });
        woodStockpileIncrease10Button = findViewById(R.id.woodStockpileIncrease10);
        woodStockpileIncrease10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 1000) {
                    c.b.setWoodStockpile(c.b.getWoodStockpile() + 10);
                    c.r.setWood(c.r.getWood() - 1000);
                    woodStockpileAmount.setText("" + c.b.getWoodStockpile());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                }
            }
        });

        stoneStockpileAmount = findViewById(R.id.stoneStockpileAmount);
        stoneStockpileAmount.setText("" + c.b.getStoneStockpile());
        stoneStockpileIncrease1Button = findViewById(R.id.stoneStockpileIncrease1);
        stoneStockpileIncrease1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 100) {
                    c.b.setStoneStockpile(c.b.getStoneStockpile() + 1);
                    c.r.setWood(c.r.getWood() - 100);
                    stoneStockpileAmount.setText("" + c.b.getStoneStockpile());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                }
            }
        });
        stoneStockpileIncrease10Button = findViewById(R.id.stoneStockpileIncrease10);
        stoneStockpileIncrease10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 1000) {
                    c.b.setStoneStockpile(c.b.getStoneStockpile() + 10);
                    c.r.setWood(c.r.getWood() - 1000);
                    stoneStockpileAmount.setText("" + c.b.getStoneStockpile());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                }
            }
        });

        tanneriesAmount = findViewById(R.id.tanneryAmount);
        tanneriesAmount.setText("" + c.b.getTanneries());
        tanneryIncrease1Button = findViewById(R.id.tanneryIncrease1);
        tanneryIncrease1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 30 && c.r.getStone() >= 70) {
                    c.b.setTanneries(c.b.getTanneries() + 1);
                    c.r.setWood(c.r.getWood() - 30);
                    c.r.setStone(c.r.getStone() - 70);
                    tanneriesAmount.setText("" + c.b.getTanneries());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });
        tanneryIncrease10Button = findViewById(R.id.tanneryIncrease10);
        tanneryIncrease10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 300 && c.r.getStone() >= 700) {
                    c.b.setTanneries(c.b.getTanneries() + 10);
                    c.r.setWood(c.r.getWood() - 300);
                    c.r.setStone(c.r.getStone() - 700);
                    tanneriesAmount.setText("" + c.b.getTanneries());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });

        apothecariesAmount = findViewById(R.id.apothecaryAmount);
        apothecariesAmount.setText("" + c.b.getApothecaries());
        apothecaryIncrease1Button = findViewById(R.id.apothecaryIncrease1);
        apothecaryIncrease1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 30 && c.r.getStone() >= 70) {
                    c.b.setApothecaries(c.b.getApothecaries() + 1);
                    c.r.setWood(c.r.getWood() - 30);
                    c.r.setStone(c.r.getStone() - 70);
                    apothecariesAmount.setText("" + c.b.getApothecaries());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });
        apothecaryIncrease10Button = findViewById(R.id.apothecaryIncrease10);
        apothecaryIncrease10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 300 && c.r.getStone() >= 700) {
                    c.b.setApothecaries(c.b.getApothecaries() + 10);
                    c.r.setWood(c.r.getWood() - 300);
                    c.r.setStone(c.r.getStone() - 700);
                    apothecariesAmount.setText("" + c.b.getApothecaries());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });

        smithiesAmount = findViewById(R.id.smithyAmount);
        smithiesAmount.setText("" + c.b.getSmithies());
        smithyIncrease1Button = findViewById(R.id.smithyIncrease1);
        smithyIncrease1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 30 && c.r.getStone() >= 70) {
                    c.b.setSmithies(c.b.getSmithies() + 1);
                    c.r.setWood(c.r.getWood() - 30);
                    c.r.setStone(c.r.getStone() - 70);
                    smithiesAmount.setText("" + c.b.getSmithies());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });
        smithyIncrease10Button = findViewById(R.id.smithyIncrease10);
        smithyIncrease10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 300 && c.r.getStone() >= 700) {
                    c.b.setSmithies(c.b.getSmithies() + 10);
                    c.r.setWood(c.r.getWood() - 300);
                    c.r.setStone(c.r.getStone() - 700);
                    smithiesAmount.setText("" + c.b.getSmithies());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });

        templesAmount = findViewById(R.id.templeAmount);
        templesAmount.setText("" + c.b.getTemples());
        templeIncrease1Button = findViewById(R.id.templeIncrease1);
        templeIncrease1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 30 && c.r.getStone() >= 120) {
                    c.b.setTemples(c.b.getTemples() + 1);
                    c.r.setWood(c.r.getWood() - 30);
                    c.r.setStone(c.r.getStone() - 120);
                    templesAmount.setText("" + c.b.getTemples());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });
        templeIncrease10Button = findViewById(R.id.templeIncrease10);
        templeIncrease10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 300 && c.r.getStone() >= 1200) {
                    c.b.setTemples(c.b.getTemples() + 10);
                    c.r.setWood(c.r.getWood() - 300);
                    c.r.setStone(c.r.getStone() - 1200);
                    templesAmount.setText("" + c.b.getTemples());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });

        barracksAmount = findViewById(R.id.barracksAmount);
        barracksAmount.setText("" + c.b.getBarracks());
        barracksIncrease1Button = findViewById(R.id.barracksIncrease1);
        barracksIncrease1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 60 && c.r.getStone() >= 120) {
                    c.b.setBarracks(c.b.getBarracks() + 1);
                    c.r.setWood(c.r.getWood() - 60);
                    c.r.setStone(c.r.getStone() - 120);
                    barracksAmount.setText("" + c.b.getBarracks());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
                }
            }
        });
        barracksIncrease10Button = findViewById(R.id.barracksIncrease10);
        barracksIncrease10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.r.getWood() >= 600 && c.r.getStone() >= 1200) {
                    c.b.setBarracks(c.b.getBarracks() + 10);
                    c.r.setWood(c.r.getWood() - 600);
                    c.r.setStone(c.r.getStone() - 1200);
                    barracksAmount.setText("" + c.b.getBarracks());
                    woodAmount.setText("" + Math.round(c.r.getWood()));
                    stoneAmount.setText("" + Math.round(c.r.getStone()));
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
                        hideAmount.setText("" + Math.round(c.r.getHide()));
                        woodAmount.setText("" + Math.round(c.r.getWood()));
                        stoneAmount.setText("" + Math.round(c.r.getStone()));
                    }
                });
            }
        }, 0, 1000);//Update text every second
    }
}
