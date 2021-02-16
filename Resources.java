package com.example.civclicker;

public class Resources {
    //Resources
    private double food;
    private double stone;
    private double wood;

    private double hide;
    private double herbs;
    private double ore;

    private double leather;
    private double piety;
    private double iron;
    private Civilisation c;
    private Upgrades u;

    public Resources(Civilisation c, Upgrades u) {
        this.c = c;
        this.u = u;
    }

    public double foodRate() {
        return (c.getFarmer() * u.foodMultiplier()) - c.getPopulation();
    }
    public double woodRate() {
        return c.getWoodcutter() * 0.5;
    }
    public double stoneRate() {
        return c.getMiner() * 0.2;
    }
    public double hideRate() {
        if(u.isSkinning()) {
            return (c.getFarmer() * 0.8 - 2 * c.getTanners());
        } else {
            return 0.0d;
        }
    }
    public double herbRate() {
        if(u.isHarvesting()) {
            return c.getWoodcutter() * 0.5;
        } else {
            return 0.0d;
        }
    }
    public double oreRate() {
        if(u.isProspecting()) {
            return c.getMiner() * 0.2 - 5 * c.getBlacksmiths();
        } else {
            return 0.0d;
        }
    }
    public double leatherRate() {
        return c.getTanners();
    }
    public double pietyRate() {
        return  c.getClerics() * 0.4;
    }
    public double ironRate() {
        return c.getBlacksmiths();
    }

    public double getFood() {
        return food;
    }
    public void setFood(double food) {
        this.food = food;
    }
    public double getStone() {
        return stone;
    }
    public void setStone(double stone) {
        this.stone = stone;
    }
    public double getWood() {
        return wood;
    }
    public void setWood(double wood) {
        this.wood = wood;
    }
    public double getHide() {
        return hide;
    }
    public void setHide(double hide) {
        this.hide = hide;
    }
    public double getHerbs() {
        return herbs;
    }
    public void setHerbs(double herbs) {
        this.herbs = herbs;
    }
    public double getOre() {
        return ore;
    }
    public void setOre(double ore) {
        this.ore = ore;
    }
    public double getLeather() {
        return leather;
    }
    public void setLeather(double leather) {
        this.leather = leather;
    }
    public double getPiety() {
        return piety;
    }
    public void setPiety(double piety) {
        this.piety = piety;
    }
    public double getIron() {
        return iron;
    }
    public void setIron(double iron) {
        this.iron = iron;
    }
}
