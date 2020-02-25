import java.util.Timer;
import java.util.TimerTask;

public class TimerSleeping extends TimerTask {

    private static final int timeSleep = 8000; // The time between each phase of tamagotchi sleeping

    private String name;
    private Tamagotchi tamagotchi;

    public TimerSleeping(String name, Tamagotchi tamagotchiInit) {
        this.name = name;
        this.tamagotchi = tamagotchiInit;
    }

    public void run() {
        tamagotchi.setSleepiness(false);
        tamagotchi.increaseLove();
        // tamagotchi.setPicture(tamagotchi.getPictureAge());
        Timer timerSleep = new Timer();
        timerSleep.schedule(new TimerSleep("Tamagotchi Sleep", this.tamagotchi),timeSleep); // delay en ms 1000 ms = 1 sec
        if(!this.tamagotchi.isAlive()){
            cancel();
        }
        System.out.println(tamagotchi.getName() + " sleep !");
    }
}
