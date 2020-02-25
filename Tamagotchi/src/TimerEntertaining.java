import java.util.Timer;
import java.util.TimerTask;

public class TimerEntertaining extends TimerTask {

    private static final int timeEntertaining= 5000; // The time between each phase of tamagotchi playing

    private String name;
    private Tamagotchi tamagotchi;

    public TimerEntertaining(String name, Tamagotchi tamagotchiInit) {
        this.name = name;
        this.tamagotchi = tamagotchiInit;
    }

    public void run() {
        tamagotchi.setEntertainment(false);
        tamagotchi.increaseLove();
       // tamagotchi.setPicture(tamagotchi.getPictureAge());
        Timer timerEntertainment = new Timer();
        timerEntertainment.schedule(new TimerEntertainment("Tamagotchi Entertainment", this.tamagotchi),timeEntertaining); // delay en ms 1000 ms = 1 sec
        if(!this.tamagotchi.isAlive()){
            cancel();
        }
        System.out.println(tamagotchi.getName() + " play !");
    }
}
