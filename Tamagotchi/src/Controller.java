import javax.swing.*;

public class Controller {

    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public String getInfoTamagotchi(){
        return model.toString();
    }

    public void cleanTamagotchi() {
        model.cleanTamagotchi();
    }

    public void feedTamagotchi() {
        model.feedTamagotchi();
    }

    public void sleepTamagotchi() {
        model.sleepTamagotchi();
    }

    public void entertainmentTamagotchi() {
        model.entertainTamagotchi();
    }

    public Icon getAnimationTamagotchi() {
       return model.getAnimationTamagotchi();
    }

    public boolean checkNeedHunger() {
        boolean hungry = false;
        if(!model.isHungry())
            hungry = false;
        else
            hungry = true;
        return hungry;
    }

    public boolean isAlive(){
        boolean alive = true;
        if(!model.isAlive())
            alive = false;
        else
            alive = true;
        return alive;
    }

    public boolean checkNeedSleep() {
        boolean sleep = false;
        if(!model.isSleepeless())
            sleep = false;
        else
            sleep = true;
        return sleep;
    }

    public boolean checkNeedClean() {
        boolean clean = false;
        if(!model.isDirty())
            clean = false;
        else
            clean = true;
        return clean;
    }

    public void killTamagotchi() {
        model.killTamagotchi();
    }

    public boolean checkNeedEntertainment() {
        boolean entertainment = false;
        if(!model.isEntertain())
            entertainment = false;
        else
            entertainment = true;
        return entertainment;
    }

    public int getTamaLove() {
        return model.getTamaLove();
    }

    public void tamaDecreaseLove() {
        model.tamaDecreaseLove();
    }
}
