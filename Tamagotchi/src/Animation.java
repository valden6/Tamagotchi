import javax.swing.*;

public class Animation {

    private Icon picture;

    public Animation() {
        this.picture = new ImageIcon( "C:\\Users\\gbozon\\private\\Tamagotchi\\img\\tamaEgg.gif");
    }

    public Animation(String nameAndExtension) {
        this.picture = new ImageIcon( "C:\\Users\\gbozon\\private\\Tamagotchi\\img\\" + nameAndExtension);
    }

    public Icon getPicture() {
        return picture;
    }

    public void setPicture(String nameAndExtension) {
        String pathPicture = "C:\\Users\\gbozon\\private\\Tamagotchi\\img\\" + nameAndExtension;
        this.picture = new ImageIcon(pathPicture);
    }

    @Override
    public String toString() {
        return "Animation{" +
                "picture=" + picture +
                '}';
    }
}
