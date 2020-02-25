import java.util.TimerTask;

public class TimerSleep extends TimerTask {

    private String name;
    private Tamagotchi tamagotchi;

    public TimerSleep(String name, Tamagotchi tamagotchiInit) {
        this.name = name;
        this.tamagotchi = tamagotchiInit;
    }

    public void run() {
        tamagotchi.setSleepiness(true);
        if(!this.tamagotchi.isAlive()){
            cancel();
        }
        System.out.println(tamagotchi.getName() + " wants to sleep !");
    }
}