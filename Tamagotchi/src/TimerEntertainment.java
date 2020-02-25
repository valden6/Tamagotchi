import java.util.TimerTask;

public class TimerEntertainment extends TimerTask {

    private String name;
    private Tamagotchi tamagotchi;

    public TimerEntertainment(String name, Tamagotchi tamagotchiInit) {
        this.name = name;
        this.tamagotchi = tamagotchiInit;
    }

    public void run() {
        tamagotchi.setEntertainment(true);
        if(!this.tamagotchi.isAlive()){
            cancel();
        }
        System.out.println(tamagotchi.getName() + " wants to play !");
    }
}