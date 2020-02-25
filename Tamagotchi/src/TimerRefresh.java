import javax.swing.*;
import java.util.TimerTask;

public class TimerRefresh extends TimerTask {

    private String name;
    private Controller controller;
    private JLabel jLabelTama;
    private JLabel jLabelNeedHunger;
    private JLabel jLabelNeedSleep;
    private JLabel jLabelNeedClean;
    private JLabel jLabelNeedEntertainment;
    private JProgressBar jProgressBarLove;
    private double counterHunger;
    private double counterDirtyness;
    private double counterEntertainment;
    private double counterSleepeness;

    private static final double timeWithRefresh = 0.25;
    private static final double timeDecreaseLove = 15;
    private static final double timekillTamaWithHunger= 222222;
    private static final double timekillTamaWithClean = 22222;
    private static final double timerNeedReset= 0;

    public TimerRefresh(String name, Controller controller, JLabel jLabelTama, JLabel jLabelNeedHunger, JLabel jLabelNeedSleep, JLabel jLabelNeedClean, JLabel jLabelNeedEntertainment, JProgressBar jProgressBarLove) {
        this.name = name;
        this.controller = controller;
        this.jLabelTama = jLabelTama;
        this.jLabelNeedHunger = jLabelNeedHunger;
        this.jLabelNeedSleep = jLabelNeedSleep;
        this.jLabelNeedClean = jLabelNeedClean;
        this.jLabelNeedEntertainment = jLabelNeedEntertainment;
        this.jProgressBarLove = jProgressBarLove;
        this.counterHunger = timerNeedReset;
        this.counterDirtyness = timerNeedReset;
        this.counterEntertainment = timerNeedReset;
        this.counterSleepeness = timerNeedReset;
    }

    public void run() {

        jLabelTama.setIcon(controller.getAnimationTamagotchi());

        if(controller.checkNeedSleep()) {
            jLabelNeedSleep.setIcon(new Animation("needSleep.gif").getPicture());
            counterSleepeness = (counterSleepeness + timeWithRefresh);
            if(counterSleepeness == timeDecreaseLove){
                controller.tamaDecreaseLove();
                counterSleepeness = timerNeedReset;
            }
        }else {
            jLabelNeedSleep.setIcon(new Animation("needSleep.png").getPicture());
            counterSleepeness = timerNeedReset;
        }

        if(controller.checkNeedEntertainment()) {
            jLabelNeedEntertainment.setIcon(new Animation("needEntertainment.gif").getPicture());
            counterEntertainment = (counterEntertainment + timeWithRefresh);
            if(counterEntertainment == timeDecreaseLove){
                controller.tamaDecreaseLove();
                counterEntertainment = timerNeedReset;
            }
        }else {
            jLabelNeedEntertainment.setIcon(new Animation("needEntertainment.png").getPicture());
            counterEntertainment = timerNeedReset;
        }

        if(controller.checkNeedHunger()) {
            jLabelNeedHunger.setIcon(new Animation("needHunger.gif").getPicture());
            counterHunger = (counterHunger + timeWithRefresh);
            if(counterHunger == timekillTamaWithHunger){
                controller.killTamagotchi();
            }
        }else {
            jLabelNeedHunger.setIcon(new Animation("needHunger.png").getPicture());
            counterHunger = timerNeedReset;
        }

        if(controller.checkNeedClean()) {
            jLabelNeedClean.setIcon(new Animation("needPoop.gif").getPicture());
            counterDirtyness = (counterDirtyness + timeWithRefresh);
            if(counterDirtyness == timekillTamaWithClean){
                controller.killTamagotchi();
            }
        }else {
            jLabelNeedClean.setIcon(new Animation("needPoop.png").getPicture());
            counterDirtyness = timerNeedReset;
        }

        jProgressBarLove.setValue(controller.getTamaLove());

        if(!this.controller.isAlive()){
            cancel();
            jLabelTama.setIcon(new Animation("tamaDead.gif").getPicture());
        }
    }
}
