import java.util.TimerTask;

public class TimerHunger extends TimerTask {

    private String name;
    private Tamagotchi tamagotchi;

    public TimerHunger(String name, Tamagotchi tamagotchiInit) {
        this.name = name;
        this.tamagotchi = tamagotchiInit;
    }

    public void run() {
        tamagotchi.setHunger(true);
       // tamagotchi.setPicture("tamaOld.gif");
        if(!this.tamagotchi.isAlive()){
            cancel();
        }
        System.out.println(tamagotchi.getName() + " is hungry !");
    }
}
