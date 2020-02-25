import java.util.TimerTask;

public class TimerDirtyness extends TimerTask {
    private String name;
    private Tamagotchi tamagotchi;

    public TimerDirtyness(String name, Tamagotchi tamagotchiInit) {
        this.name = name;
        this.tamagotchi = tamagotchiInit;
    }

    public void run() {
        tamagotchi.setDirtyness(true);
        //tamagotchi.setPicture("tamaPoop1.gif");
        if(!this.tamagotchi.isAlive()){
            cancel();
        }
        System.out.println(tamagotchi.getName() + " is dirty !");
    }
}
