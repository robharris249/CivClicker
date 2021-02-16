package com.example.civclicker;

public class Buildings {

    //Buildings
    private int barn;
    private int woodStockpile;
    private int stoneStockpile;

    //Accommodation
    private int tents;
    private int woodHuts;
    private int cottages;
    private int houses;
    private int mansions;

    //Businesses
    private int tanneries;
    private int smithies;
    private int apothecaries;
    private int temples;
    private int barracks;

    public int getBarn() {
        return barn;
    }
    public void setBarn(int barn) {
        this.barn = barn;
    }
    public int getFoodCapacity() {
        return barn * 200 + 200;
    }
    public int getWoodStockpile() {
        return woodStockpile;
    }
    public void setWoodStockpile(int woodStockpile) {
        this.woodStockpile = woodStockpile;
    }
    public int getWoodCapacity() {
        return woodStockpile * 200 + 200;
    }
    public int getStoneStockpile() {
        return stoneStockpile;
    }
    public void setStoneStockpile(int stoneStockpile) {
        this.stoneStockpile = stoneStockpile;
    }
    public int getStoneCapacity() {
        return stoneStockpile * 200 + 200;
    }

    public int getTents() {
        return tents;
    }
    public void setTents(int tents) {
        this.tents = tents;
    }
    public int getWoodHuts() {
        return woodHuts;
    }
    public void setWoodHuts(int woodHuts) {
        this.woodHuts = woodHuts;
    }
    public int getCottages() {
        return cottages;
    }
    public void setCottages(int cottages) {
        this.cottages = cottages;
    }
    public int getHouses() {
        return houses;
    }
    public void setHouses(int houses) {
        this.houses = houses;
    }
    public int getMansions() {
        return mansions;
    }
    public void setMansions(int mansions) {
        this.mansions = mansions;
    }
    public int getTanneries() {
        return tanneries;
    }
    public void setTanneries(int tanneries) {
        this.tanneries = tanneries;
    }
    public int getSmithies() {
        return smithies;
    }
    public void setSmithies(int smithies) {
        this.smithies = smithies;
    }
    public int getApothecaries() {
        return apothecaries;
    }
    public void setApothecaries(int apothecaries) {
        this.apothecaries = apothecaries;
    }
    public int getTemples() {
        return temples;
    }
    public void setTemples(int temples) {
        this.temples = temples;
    }
    public int getBarracks() {
        return barracks;
    }
    public void setBarracks(int barracks) {
        this.barracks = barracks;
    }
}
