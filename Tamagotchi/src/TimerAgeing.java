import java.util.TimerTask;

public class TimerAgeing extends TimerTask {
    private String name;
    private Tamagotchi tamagotchi;

    public TimerAgeing(String name, Tamagotchi tamagotchiInit) {
        this.name = name;
        this.tamagotchi = tamagotchiInit;
    }

    public void run() {
        if(tamagotchi.getAge() < Tamagotchi.getLimitedAge()-1) {
            tamagotchi.setAge(tamagotchi.getAge() + 1);
            System.out.println(tamagotchi.getName() + " ageing !");

            switch (tamagotchi.getAge()){
                case 1:
                    tamagotchi.setPicture(tamagotchi.getPictureAge());
                    System.out.println(tamagotchi.getName() + " became a baby !");
                    break;
                case 2:
                    tamagotchi.setPicture(tamagotchi.getPictureAge());
                    System.out.println(tamagotchi.getName() + " became a child !");
                    break;
                case 3:
                    tamagotchi.setPicture(tamagotchi.getPictureAge());
                    System.out.println(tamagotchi.getName() + " became an adult !");
                    break;
                case 4:
                    tamagotchi.setPicture(tamagotchi.getPictureAge());
                    System.out.println(tamagotchi.getName() + " became a senior !");
                    break;
            }

        }else if (tamagotchi.getAge() == Tamagotchi.getLimitedAge()-1){
            cancel();
            tamagotchi.setPicture("tamaDead.gif");
            tamagotchi.setAlive(false);
            System.out.println(tamagotchi.getName() + " is dead !");
        }
    }
}