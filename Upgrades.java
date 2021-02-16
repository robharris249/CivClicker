package com.example.civclicker;

public class Upgrades {
    //Block 0
    private boolean skinning; 			// - Farmers can collect skins  (1 in 100 chance per farmer) - cost: 10 skins
    private boolean harvesting; 		// - Wood cutters can collect herbs - cost: 10 herbs
    private boolean prospecting; 		// - Miners can collect ore - cost: 10 ore

    //block 1
    private boolean domestication; 		// - Increase farmer food output - cost: 20 leather
    private boolean ploughshares; 		// - Increase farmer food output - cost:  20 iron
    private boolean irrigation; 		// - Increase farmer food output - cost: 500 wood, 200 stone

    public double foodMultiplier() {

        double modifier = 1.2;

        if(isDomestication()) {
            modifier *= 1.2;
        }

        if(isPloughshares()) {
            modifier *= 1.2;
        }

        if(isIrrigation()) {
            modifier *= 1.2;
        }

        return modifier;
    }

    public boolean isSkinning() {
        return skinning;
    }
    public void setSkinning(boolean skinning) {
        this.skinning = skinning;
    }
    public boolean isHarvesting() {
        return harvesting;
    }
    public void setHarvesting(boolean harvesting) {
        this.harvesting = harvesting;
    }
    public boolean isProspecting() {
        return prospecting;
    }
    public void setProspecting(boolean prospecting) {
        this.prospecting = prospecting;
    }
    public boolean isDomestication() {
        return domestication;
    }
    public void setDomestication(boolean domestication) {
        this.domestication = domestication;
    }
    public boolean isPloughshares() {
        return ploughshares;
    }
    public void setPloughshares(boolean ploughshares) {
        this.ploughshares = ploughshares;
    }
    public boolean isIrrigation() {
        return irrigation;
    }
    public void setIrrigation(boolean irrigation) {
        this.irrigation = irrigation;
    }
}
