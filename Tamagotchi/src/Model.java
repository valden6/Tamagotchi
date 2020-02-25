import javax.swing.*;
import java.util.Timer;

public class Model {

    private static final int timeSleeping = 8000; // The time during the tamagotchi need to sleep for being restfull
    private static final int timeAgeing = 300000; // The time between each phase of tamagotchi ageing
    private static final int timeHunger = 30000; // The time between each phase of tamagotchi ageing
    private static final int timeDirtyness = 10000; // The time between each phase of tamagotchi ageing
    private static final int timeSleep = 40000; // The time between each phase of tamagotchi ageing
    private static final int timeEntertainment = 20000; // The time between each phase of tamagotchi ageing
    private static final int timeEntertaining = 5000; // The time between each phase of tamagotchi ageing

    private Tamagotchi tamagotchi;

    public Model(Tamagotchi tamagotchiInit) {
        this.tamagotchi = tamagotchiInit;

        Timer timerAgeing = new Timer();
        timerAgeing.schedule(new TimerAgeing("Timer Ageing",this.tamagotchi),timeAgeing,timeAgeing); // delay en ms 1000 ms = 1 sec

        Timer timerHunger = new Timer();
        timerHunger.schedule(new TimerHunger("Tamagotchi Hunger", this.tamagotchi),timeHunger); // delay en ms 1000 ms = 1 sec

        Timer timerDirtyness = new Timer();
        timerDirtyness.schedule(new TimerDirtyness("Tamagotchi Dirtyness", this.tamagotchi),timeDirtyness); // delay en ms 1000 ms = 1 sec

        Timer timerSleep = new Timer();
        timerSleep.schedule(new TimerSleep("Tamagotchi Sleep", this.tamagotchi),timeSleep); // delay en ms 1000 ms = 1 sec

        Timer timerEntertainment = new Timer();
        timerEntertainment.schedule(new TimerEntertainment("Tamagotchi Sleep", this.tamagotchi),timeEntertainment); // delay en ms 1000 ms = 1 sec
    }

    @Override
    public String toString() {
        return "Model{" +
                "tamagotchi=" + tamagotchi +
                '}';
    }

    public void cleanTamagotchi() {
        if(tamagotchi.isAlive()) {
            if (tamagotchi.isDirtyness()) {
                tamagotchi.setDirtyness(false);
                tamagotchi.setPicture(tamagotchi.getPictureAge());
                Timer timerDirtyness = new Timer();
                timerDirtyness.schedule(new TimerDirtyness("Tamagotchi Dirtyness", this.tamagotchi), timeDirtyness); // delay en ms 1000 ms = 1 sec
                System.out.println(tamagotchi.getName() + " cleaned !");
            } else
                System.out.println(tamagotchi.getName() + " has already cleaned !");
        }

    }

    public void feedTamagotchi() {
        if(tamagotchi.isAlive()) {
            if (tamagotchi.isHunger()) {
                tamagotchi.setHunger(false);
                tamagotchi.setPicture(tamagotchi.getPictureAge());
                Timer timerHunger = new Timer();
                timerHunger.schedule(new TimerHunger("Tamagotchi Hunger", this.tamagotchi), timeHunger); // delay en ms 1000 ms = 1 sec
                System.out.println(tamagotchi.getName() + " fed !");
            } else
                System.out.println(tamagotchi.getName() + " has already eaten !");
        }
    }

    public void sleepTamagotchi() {
        if(tamagotchi.isAlive()) {
            if (tamagotchi.isSleepiness()) {
                Timer timer = new Timer();
                timer.schedule(new TimerSleeping("Tamagotchi Sleeping", this.tamagotchi), timeSleeping); // delay en ms 1000 ms = 1 sec
                System.out.println(tamagotchi.getName() + " begin to sleep !");
            } else
                System.out.println(tamagotchi.getName() + " has already slept !");
        }
    }

    public void entertainTamagotchi() {
        if(tamagotchi.isAlive()) {
            if (tamagotchi.isEntertainment()) {
                Timer timer = new Timer();
                timer.schedule(new TimerEntertaining("Tamagotchi Entertaining", this.tamagotchi), timeEntertaining); // delay en ms 1000 ms = 1 sec
                System.out.println(tamagotchi.getName() + " begin to play !");
            } else
                System.out.println(tamagotchi.getName() + " has already play !");
        }
    }

    public Icon getAnimationTamagotchi() {
       return tamagotchi.getPicture().getPicture();
    }

    public boolean isAlive() {
        return tamagotchi.isAlive();
    }

    public boolean isHungry(){
        return tamagotchi.isHunger();
    }

    public boolean isDirty(){
        return tamagotchi.isDirtyness();
    }

    public boolean isSleepeless(){
        return tamagotchi.isSleepiness();
    }

    public void killTamagotchi() {
        tamagotchi.setAlive(false);
    }

    public boolean isEntertain() {
        return tamagotchi.isEntertainment();
    }

    public int getTamaLove() {
        return tamagotchi.getLove();
    }

    public void tamaDecreaseLove() {
        tamagotchi.decreaseLove();
    }
}
