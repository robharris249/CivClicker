package com.example.civclicker;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Timer;
import java.util.TimerTask;

public class Civilisation {

    //People
    private int population;
    private int maxPopulation;
    private int unemployed;

    private int farmers;
    private int miners;
    private int woodcutters;

    private int tanners;
    private int blacksmiths;
    private int healers;
    private int clerics;
    private int soldiers;

    public Resources r;
    public Buildings b = new Buildings();
    public Upgrades u = new Upgrades();

    public Civilisation() {

        r = new Resources(this, this.u);
        r.setFood(50);
        ticker();
    }

    public void ticker() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updatePopulation();
                updateResources();
            }
        }, 0, 1000);//Update text every second
    }

    public void clickFood() {

        r.setFood(r.getFood() + 1);
        if(r.getFood() > b.getFoodCapacity()) {//clamp food to max current capacity
            r.setFood(b.getFoodCapacity());
        }
        r.setHide(r.getHide() + 0.25);
    }

    public void clickWood() {

        r.setWood(r.getWood() + 1);
        if(r.getWood() > b.getWoodCapacity()) {//clamp wood to max current capacity
            r.setWood(b.getWoodCapacity());
        }
        r.setHerbs(r.getHerbs() + 1);
    }

    public void clickStone() {


        r.setStone(r.getStone() + 1);
        if(r.getStone() > b.getStoneCapacity()) {//clamp stone to max current capacity
            r.setStone(b.getStoneCapacity());
        }
        r.setOre(r.getOre() + 1);
    }

    public void updateResources() {
        updateFood();
        updateWood();
        updateStone();

        updateLeather();
        updatePiety();
        updateIron();
    }

    public void updatePopulation() {
        population = unemployed + farmers + woodcutters + miners + tanners + blacksmiths + healers + clerics + soldiers;

        maxPopulation = b.getTents() + b.getWoodHuts()*3 + b.getCottages()*5 + b.getHouses()*10 + b.getMansions()*50;
    }

    public void updateFood() {

        r.setFood(r.getFood() + r.foodRate());

        if(r.getFood() > b.getFoodCapacity()) { //clamp to upper limit
            r.setFood(b.getFoodCapacity());
        }

        if(r.getFood() < 0) { //clamp to lower limit
            r.setFood(0);
        }

        if(u.isSkinning()) {// if the skinning upgrade has been purchased then farmers can collect hide
            r.setHide(r.getHide() + r.hideRate());
            if(r.getHide() < 0) {
                r.setHide(0);//Clamp to lower Limit
            }
        }

    }

    public void updateWood() {

        r.setWood(r.getWood() + r.woodRate());

        if(r.getWood() > b.getWoodCapacity()) { //clamp to upper limit
            r.setWood(b.getWoodCapacity());
        }

        if(r.getWood() < 0) { //clamp to lower limit
            r.setWood(0);
        }

        if(u.isHarvesting()) { //if the harvesting upgrade has been purchased then woodcutters can collect herbs
            r.setHerbs(r.getHerbs() + r.herbRate());
        }
    }

    public void updateStone() {

        r.setStone(r.getStone() + r.stoneRate());

        if(r.getStone() > b.getStoneCapacity()) { //clamp to upper limit
            r.setStone(b.getStoneCapacity());
        }

        if(r.getStone() < 0) { //clamp to lower limit
            r.setStone(0);
        }

        if(u.isProspecting()) { //if the prospecting upgrade has been purchased then miners can collect ore
            r.setOre(r.getOre() + r.oreRate());
            if(r.getOre() < 0) {
                r.setOre(0);//Clamp to lower limit
            }
        }
    }

    public void updateLeather() {
        if (tanners != 0) {
            if(r.getHide() > 0) {
                if(r.getHide() < tanners*2) {
                    r.setLeather(r.getLeather() + r.getHide());
                    r.setHide(0);
                } else {
                    r.setLeather(r. getLeather() + r.leatherRate());
                    r.setHide(r.getHide() - tanners*2);
                }
            }
        }
    }

    public void updatePiety() {
        if(clerics != 0) {
            r.setPiety(r.getPiety() + r.pietyRate());
        }
    }

    public void updateIron() {
        if(blacksmiths != 0) {
            if(r.getOre() > 0) {
                if(r.getOre() < blacksmiths * 5) {
                    r.setIron(r.getIron() + r.getOre());
                    r.setOre(0);
                } else {
                    r.setOre(r.getOre() - blacksmiths * 5);
                    r.setIron(r.getIron() + r.ironRate());
                }
            }
        }
    }

    public double roundResource(double resource) { //for rounding doubles to one decimal place
        BigDecimal bd = new BigDecimal(resource).setScale(1, RoundingMode.HALF_UP);
        resource = bd.doubleValue();
        return resource;
    }

    public int getMaxPopulation() {
        return maxPopulation;
    }

    public int getPopulation() {
        return population;
    }

    public int getUnemployed() {
        return unemployed;
    }

    public void setUnemployed(int unemployed) {
        this.unemployed = unemployed;
    }

    public int getFarmer() {
        return farmers;
    }

    public void setFarmer(int farmers) {
        this.farmers = farmers;
    }

    public int getMiner() {
        return miners;
    }

    public void setMiner(int miners) {
        this.miners = miners;
    }

    public int getWoodcutter() {
        return woodcutters;
    }

    public void setWoodcutter(int woodcutters) {
        this.woodcutters = woodcutters;
    }

    public int getTanners() {
        return tanners;
    }

    public void setTanners(int tanners) {
        this.tanners = tanners;
    }

    public int getBlacksmiths() {
        return blacksmiths;
    }

    public void setBlacksmiths(int blacksmiths) {
        this.blacksmiths = blacksmiths;
    }

    public int getHealers() {
        return healers;
    }

    public void setHealers(int healers) {
        this.healers = healers;
    }

    public int getClerics() {
        return clerics;
    }

    public void setClerics(int clerics) {
        this.clerics = clerics;
    }

    public int getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(int soldiers) {
        this.soldiers = soldiers;
    }
}
