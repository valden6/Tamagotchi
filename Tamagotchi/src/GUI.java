import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import javax.swing.*;
import javax.swing.event.*;
import com.intellij.uiDesigner.core.*;
/*
 * Created by JFormDesigner on Thu Jul 11 16:21:56 IST 2019
 */



/**
 * @author Guillaume Bozon
 */
public class GUI extends JFrame {

    private Controller controller;
    private static final int timeRefresh = 250;

    public GUI() {
        initComponents();
    }

    private void buttonFeedActionPerformed(ActionEvent e) {
        controller.feedTamagotchi();
    }

    private void buttonNewActionPerformed(ActionEvent e) {

        boolean gender = true;
        String nameTamagotchi = textFieldName.getText();
        Animation genderPic = new Animation();

        if(comboBoxGender.getModel().getSelectedItem().equals("Male")){
            gender = true;
            genderPic.setPicture("male.png");
        }else if(comboBoxGender.getModel().getSelectedItem().equals("Female")){
            gender = false;
            genderPic.setPicture("female.png");
        }
        if(textFieldName.getText().equals("Name") || textFieldName.getText().equals(null) || textFieldName.getText().equals(""))
            nameTamagotchi = "Baba";

        controller = new Controller(new Model(new Tamagotchi(nameTamagotchi,gender)));


        java.util.Timer timerRefresh= new Timer();
        timerRefresh.schedule(new TimerRefresh("Timer Refresh",controller, labelTama,labelNeedFeed,labelNeedSleep,labelNeedClean, labelNeedEntertainment,progressBarTamaLove),0,timeRefresh); // delay en ms 1000 ms = 1 sec

        labelTama.setIcon(controller.getAnimationTamagotchi());
        labelTama.setVisible(true);
        labelNameTama.setText(nameTamagotchi);
        labelNameTama.setVisible(true);
        labelGenreTama.setIcon(genderPic.getPicture());
        labelGenreTama.setVisible(true);
        buttonNew.setVisible(false);
        labelMainPicture.setVisible(false);
        labelMainTitle.setVisible(false);
        textFieldName.setVisible(false);
        comboBoxGender.setVisible(false);
        buttonFeed.setVisible(true);
        buttonClean.setVisible(true);
        buttonSleep.setVisible(true);
        buttonPlay.setVisible(true);
        labelNeedClean.setVisible(true);
        labelNeedFeed.setVisible(true);
        labelNeedSleep.setVisible(true);
        labelNeedEntertainment.setVisible(true);
        progressBarTamaLove.setVisible(true);
        labelTextLove.setVisible(true);

        System.out.println("New Tamagotchi created: " + controller.getInfoTamagotchi());
    }

    private void buttonCleanActionPerformed(ActionEvent e) {
        controller.cleanTamagotchi();
    }

    private void buttonSleepActionPerformed(ActionEvent e) {
        controller.sleepTamagotchi();
    }

    private void buttonPlayActionPerformed(ActionEvent e) {
        controller.entertainmentTamagotchi();
    }

    private void menuItemQuitActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void menuItemDevelopperActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "This program was developed by Guillaume Bozon");
    }

    private void menuItemInfosActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "A Tamagotchi (たまごっち) is a Japanese virtual pet, created in 1996 by the Japanese company Bandai.\n " +
                "The game consists in simulating the education of an animal using a miniature console,\n" +
                "the size of a watch, equipped with a computer program.");
    }

    private void menuItemNewGameActionPerformed(ActionEvent e) {
        this.dispose();
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                //On crée une nouvelle instance de notre Jframe
                GUI newMainGUI = new GUI();
                newMainGUI.setVisible(true);//On la rend visible
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - hgth
        menuBar = new JMenuBar();
        menuGame = new JMenu();
        menuItemNewGame = new JMenuItem();
        menuItemQuit = new JMenuItem();
        menuAbout = new JMenu();
        menuItemDevelopper = new JMenuItem();
        menuItemInfos = new JMenuItem();
        buttonFeed = new JButton();
        buttonSleep = new JButton();
        buttonClean = new JButton();
        buttonPlay = new JButton();
        labelTama = new JLabel();
        buttonNew = new JButton();
        textFieldName = new JTextField();
        comboBoxGender = new JComboBox<>();
        labelNeedFeed = new JLabel();
        labelNeedSleep = new JLabel();
        labelNeedClean = new JLabel();
        labelNeedEntertainment = new JLabel();
        labelNameTama = new JLabel();
        labelGenreTama = new JLabel();
        labelMainPicture = new JLabel();
        labelMainTitle = new JLabel();
        progressBarTamaLove = new JProgressBar();
        labelTextLove = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Tamagotchi");
        setIconImage(new ImageIcon("C:\\Users\\gbozon\\private\\Tamagotchi\\img\\tamagotchi.png").getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar ========
        {

            //======== menuGame ========
            {
                menuGame.setText("Game");
                menuGame.setHorizontalAlignment(SwingConstants.CENTER);

                //---- menuItemNewGame ----
                menuItemNewGame.setText("New game");
                menuItemNewGame.setHorizontalAlignment(SwingConstants.LEFT);
                menuItemNewGame.addActionListener(e -> menuItemNewGameActionPerformed(e));
                menuGame.add(menuItemNewGame);

                //---- menuItemQuit ----
                menuItemQuit.setText("Quit");
                menuItemQuit.setHorizontalAlignment(SwingConstants.LEFT);
                menuItemQuit.addActionListener(e -> menuItemQuitActionPerformed(e));
                menuGame.add(menuItemQuit);
            }
            menuBar.add(menuGame);

            //======== menuAbout ========
            {
                menuAbout.setText("About");
                menuAbout.setHorizontalAlignment(SwingConstants.CENTER);

                //---- menuItemDevelopper ----
                menuItemDevelopper.setText("Developer");
                menuItemDevelopper.setHorizontalAlignment(SwingConstants.LEFT);
                menuItemDevelopper.addActionListener(e -> menuItemDevelopperActionPerformed(e));
                menuAbout.add(menuItemDevelopper);

                //---- menuItemInfos ----
                menuItemInfos.setText("Informations");
                menuItemInfos.setHorizontalAlignment(SwingConstants.LEFT);
                menuItemInfos.addActionListener(e -> menuItemInfosActionPerformed(e));
                menuAbout.add(menuItemInfos);
            }
            menuBar.add(menuAbout);
        }
        setJMenuBar(menuBar);

        //---- buttonFeed ----
        buttonFeed.setText("Feed");
        buttonFeed.setVisible(false);
        buttonFeed.addActionListener(e -> buttonFeedActionPerformed(e));
        contentPane.add(buttonFeed);
        buttonFeed.setBounds(10, 250, 70, 50);

        //---- buttonSleep ----
        buttonSleep.setText("Sleep");
        buttonSleep.setVisible(false);
        buttonSleep.addActionListener(e -> buttonSleepActionPerformed(e));
        contentPane.add(buttonSleep);
        buttonSleep.setBounds(90, 250, 70, 50);

        //---- buttonClean ----
        buttonClean.setText("Clean");
        buttonClean.setVisible(false);
        buttonClean.addActionListener(e -> buttonCleanActionPerformed(e));
        contentPane.add(buttonClean);
        buttonClean.setBounds(170, 250, 70, 50);

        //---- buttonPlay ----
        buttonPlay.setText("Play");
        buttonPlay.setVisible(false);
        buttonPlay.addActionListener(e -> {
			buttonCleanActionPerformed(e);
			buttonPlayActionPerformed(e);
		});
        contentPane.add(buttonPlay);
        buttonPlay.setBounds(250, 250, 70, 50);

        //---- labelTama ----
        labelTama.setHorizontalAlignment(SwingConstants.CENTER);
        labelTama.setVisible(false);
        contentPane.add(labelTama);
        labelTama.setBounds(105, 105, 129, 65);

        //---- buttonNew ----
        buttonNew.setText("New");
        buttonNew.addActionListener(e -> buttonNewActionPerformed(e));
        contentPane.add(buttonNew);
        buttonNew.setBounds(260, 225, 65, 25);

        //---- textFieldName ----
        textFieldName.setText("Name");
        contentPane.add(textFieldName);
        textFieldName.setBounds(10, 225, 145, textFieldName.getPreferredSize().height);

        //---- comboBoxGender ----
        comboBoxGender.setMaximumRowCount(2);
        comboBoxGender.setModel(new DefaultComboBoxModel<>(new String[] {
            "Male",
            "Female"
        }));
        contentPane.add(comboBoxGender);
        comboBoxGender.setBounds(new Rectangle(new Point(170, 225), comboBoxGender.getPreferredSize()));

        //---- labelNeedFeed ----
        labelNeedFeed.setIcon(new ImageIcon("C:\\Users\\gbozon\\private\\Tamagotchi\\img\\needHunger.png"));
        labelNeedFeed.setVisible(false);
        contentPane.add(labelNeedFeed);
        labelNeedFeed.setBounds(15, 20, 60, 55);

        //---- labelNeedSleep ----
        labelNeedSleep.setIcon(new ImageIcon("C:\\Users\\gbozon\\private\\Tamagotchi\\img\\needSleep.png"));
        labelNeedSleep.setVisible(false);
        contentPane.add(labelNeedSleep);
        labelNeedSleep.setBounds(95, 20, 60, 55);

        //---- labelNeedClean ----
        labelNeedClean.setIcon(new ImageIcon("C:\\Users\\gbozon\\private\\Tamagotchi\\img\\needPoop.png"));
        labelNeedClean.setVisible(false);
        contentPane.add(labelNeedClean);
        labelNeedClean.setBounds(180, 20, 60, 55);

        //---- labelNeedEntertainment ----
        labelNeedEntertainment.setIcon(new ImageIcon("C:\\Users\\gbozon\\private\\Tamagotchi\\img\\needEntertainment.png"));
        labelNeedEntertainment.setVisible(false);
        contentPane.add(labelNeedEntertainment);
        labelNeedEntertainment.setBounds(265, 20, 60, 55);

        //---- labelNameTama ----
        labelNameTama.setHorizontalAlignment(SwingConstants.CENTER);
        labelNameTama.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        labelNameTama.setVisible(false);
        contentPane.add(labelNameTama);
        labelNameTama.setBounds(120, 195, 70, 35);

        //---- labelGenreTama ----
        labelGenreTama.setHorizontalAlignment(SwingConstants.CENTER);
        labelGenreTama.setVisible(false);
        contentPane.add(labelGenreTama);
        labelGenreTama.setBounds(180, 205, 20, 20);

        //---- labelMainPicture ----
        labelMainPicture.setHorizontalAlignment(SwingConstants.CENTER);
        labelMainPicture.setIcon(new ImageIcon("C:\\Users\\gbozon\\private\\Tamagotchi\\img\\mainTamagotchi.png"));
        contentPane.add(labelMainPicture);
        labelMainPicture.setBounds(100, 60, 145, 145);

        //---- labelMainTitle ----
        labelMainTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelMainTitle.setIcon(new ImageIcon("C:\\Users\\gbozon\\private\\Tamagotchi\\img\\tamagotchiLogo.png"));
        contentPane.add(labelMainTitle);
        labelMainTitle.setBounds(55, 10, 225, 55);

        //---- progressBarTamaLove ----
        progressBarTamaLove.setOrientation(SwingConstants.VERTICAL);
        progressBarTamaLove.setValue(100);
        progressBarTamaLove.setVisible(false);
        contentPane.add(progressBarTamaLove);
        progressBarTamaLove.setBounds(50, 90, 20, 105);

        //---- labelTextLove ----
        labelTextLove.setText("Love");
        labelTextLove.setHorizontalAlignment(SwingConstants.CENTER);
        labelTextLove.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        labelTextLove.setVisible(false);
        contentPane.add(labelTextLove);
        labelTextLove.setBounds(40, 200, 40, labelTextLove.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(340, 350));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - hgth
    private JMenuBar menuBar;
    private JMenu menuGame;
    private JMenuItem menuItemNewGame;
    private JMenuItem menuItemQuit;
    private JMenu menuAbout;
    private JMenuItem menuItemDevelopper;
    private JMenuItem menuItemInfos;
    private JButton buttonFeed;
    private JButton buttonSleep;
    private JButton buttonClean;
    private JButton buttonPlay;
    private JLabel labelTama;
    private JButton buttonNew;
    private JTextField textFieldName;
    private JComboBox<String> comboBoxGender;
    private JLabel labelNeedFeed;
    private JLabel labelNeedSleep;
    private JLabel labelNeedClean;
    private JLabel labelNeedEntertainment;
    private JLabel labelNameTama;
    private JLabel labelGenreTama;
    private JLabel labelMainPicture;
    private JLabel labelMainTitle;
    private JProgressBar progressBarTamaLove;
    private JLabel labelTextLove;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
