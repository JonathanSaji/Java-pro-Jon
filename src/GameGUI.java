import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameGUI extends JFrame implements ActionListener{
    pet base_pet = new pet();


    //intro menu
    private JLabel menu_background;
    private ImageIcon image  = new ImageIcon(getClass().getResource("menu_image.jpg"));

    private JLabel intro;
    private JButton start;
    private JButton exit;
    //e

    //start menu
    private JLabel start_background;
    private ImageIcon start_image = new ImageIcon(getClass().getResource("start_image.jpg"));
    private JButton SetName;
    private JLabel petStats;
    String pet_name;
    int choice;
    private JButton StartJourney;
        //e


    //play menu
    JButton feed;
    JButton play;
    JButton sleep;
    boolean checkIfDead;
    JLabel pet_status;

    //e

    //setting font
    Font f = new Font("Arial",Font.BOLD,72);

    public GameGUI(){

        setSize(1920,1080);
        setLayout(null);


        intro = new JLabel("<html>Welcome To"+ "<br>The Pet Sim");
        intro.setBounds(100, 550, 550, 550);
        intro.setFont(f);
        intro.setForeground(new Color(255, 255, 255));
        this.add(intro);

        start = new JButton("Click To Start");
        start.setBounds(100,250,550,550);
        start.setSize(500,100);
        start.setFont(f);
        start.setBackground(new Color(0, 0, 0, 255));
        start.setForeground(new Color(255, 255, 255, 255));
        this.add(start);

        exit_button(exit);

        setBackground(menu_background,image);

        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


        start.addActionListener(this);
        start.setActionCommand("start");

    }
    @Override
    public void actionPerformed(ActionEvent e){
        String button = e.getActionCommand();
        switch(button){
            case "exit":
                dispose();
                break;
            case "start":
                dispose();
                new GameGUI(1);
                break;
            case "SetName":
                int pet_choice = JOptionPane.showConfirmDialog(null,"Do You Want to Name Your Pet?");
                if(pet_choice == JOptionPane.YES_OPTION) {
                    pet_name = JOptionPane.showInputDialog("What is Your Pets Name?");
                }
                if(pet_name!=null){
                    base_pet.setName(pet_name);
                    StartJourney.setText("<html>Start "+pet_name+"'s"+"<br>Journey");
                    petStats.setText(base_pet.toString());
                    pet_status.setText(base_pet.statusCheck());
                }
                choice = JOptionPane.showConfirmDialog(null,"Do You want to Set Your Pets Base Stats?");
                if(choice == JOptionPane.YES_OPTION){
                    base_pet.setHappiness(JPaneSetter("happiness"));
                    base_pet.setHunger(JPaneSetter("hunger"));
                    base_pet.setTiredness(JPaneSetter("tiredness"));
                    petStats.setText(base_pet.toString());
                    pet_status.setText(base_pet.statusCheck());
                }
                break;
            case "StartJourney":
                StartJourney.setVisible(false);
                SetName.setVisible(false);
                play.setVisible(true);
                sleep.setVisible(true);
                feed.setVisible(true);
                break;
            case "play":
                base_pet.play();
                petStats.setText(base_pet.toString());
                checkIfDead = base_pet.checkIfDead();
                pet_status.setText(base_pet.statusCheck());
                checkDeath();

                break;
            case "sleep":
                base_pet.sleep();
                petStats.setText(base_pet.toString());
                checkIfDead = base_pet.checkIfDead();
                checkDeath();
                pet_status.setText(base_pet.statusCheck());

                break;
            case "feed":
                base_pet.feed();
                petStats.setText(base_pet.toString());
                checkIfDead = base_pet.checkIfDead();
                checkDeath();
                pet_status.setText(base_pet.statusCheck());
                break;
        }
    }
    //after clicked start this window will pop up
    public GameGUI(int n){
        GUICreator();

        pet_status = new JLabel(base_pet.statusCheck());
        pet_status.setBounds(1100,250,1000,1000);
        pet_status.setFont(f);
        pet_status.setBackground(new Color(0, 0, 0, 0));
        pet_status.setForeground(new Color(255, 255, 255, 255));
        this.add(pet_status);
        //setter name
        SetName = new JButton("Set Stats Of Your Pet");
        SetName.setBounds(100,250,800,100);
        SetName.setFont(f);
        SetName.setBackground(new Color(0, 0, 0, 255));
        SetName.setForeground(new Color(255, 255, 255, 255));
        this.add(SetName);

        SetName.addActionListener(this);
        SetName.setActionCommand("SetName");

        exit_button(exit);

        StartJourney = new JButton("<html>Start Your Pet's"+"<br> Journey");
        StartJourney.setBounds(1000,250,550,550);
        StartJourney.setSize(900,200);
        StartJourney.setFont(f);
        StartJourney.setBackground(new Color(0, 0, 0, 255));
        StartJourney.setForeground(new Color(255, 255, 255, 255));
        this.add(StartJourney);

        StartJourney.addActionListener(this);
        StartJourney.setActionCommand("StartJourney");

        feed = new JButton("Feed Your Pet");
        feed.setVisible(false);
        feed.setBounds(600,400,550,550);
        feed.setSize(800,100);
        feed.setFont(f);
        feed.setBackground(new Color(0, 0, 0, 255));
        feed.setForeground(new Color(255, 255, 255, 255));
        this.add(feed);

        feed.addActionListener(this);
        feed.setActionCommand("feed");

        play = new JButton("Play With Your Pet");
        play.setVisible(false);
        play.setBounds(600,300,550,550);
        play.setSize(800,100);
        play.setFont(f);
        play.setBackground(new Color(0, 0, 0, 255));
        play.setForeground(new Color(255, 255, 255, 255));
        this.add(play);

        play.addActionListener(this);
        play.setActionCommand("play");

        sleep = new JButton("Make Your Pet Sleep");
        sleep.setVisible(false);
        sleep.setBounds(600,200,550,550);
        sleep.setSize(800,100);
        sleep.setFont(f);
        sleep.setBackground(new Color(0, 0, 0, 255));
        sleep.setForeground(new Color(255, 255, 255, 255));
        this.add(sleep);

        sleep.addActionListener(this);
        sleep.setActionCommand("sleep");

        petStats = new JLabel(base_pet.toString());
        petStats.setBounds(100,200,550,550);
        petStats.setSize(1100,1000);
        petStats.setFont(f);
        petStats.setForeground(new Color(255,255,255,255));
        this.add(petStats);

        //start background
        setBackground(start_background,start_image);

    }

    public int JPaneSetter(String type){
        String[] Options = { "1","2","3","4","5"};
        int selection= JOptionPane.showOptionDialog(null,"Select for "+type,"Get Base Stats",0,3,null,Options,Options[0]);
        switch(selection){
            case 0:
                if(type.equals("happiness")){
                    return 1;
                }
                else if(type.equals("tiredness")) {
                    return 1;
                }
                else if(type.equals("hunger")) {
                    return 1;
                }
                break;
            case 1:
                if(type.equals("happiness")) {
                    return 2;
                }
                else if(type.equals("tiredness")) {
                    return 2;
                }
                else if(type.equals("hunger")) {
                    return 2;
                }
                break;
            case 2:
                if(type.equals("happiness")) {
                    return 3;
                }
                else if(type.equals("tiredness")) {
                    return 3;
                }
                else if(type.equals("hunger")) {
                    return 3;
                }
                break;
            case 3:
                if(type.equals("happiness")) {
                    return 4;
                }
                else if(type.equals("tiredness")) {
                    return 4;
                }
                else if(type.equals("hunger")) {
                    return 4;
                }
                break;
            case 4:
                if(type.equals("happiness")) {
                    return 5;
                }
                else if(type.equals("tiredness")) {
                    return 5;
                }
                else if(type.equals("hunger")) {
                    return 5;
                }
                break;
        }
        return 0;
    }


    public void checkDeath(){
        if(checkIfDead){
            new GameGUI();
            JOptionPane.showMessageDialog(null,"Your Pet Died :(");
        }
    }
        public void GUICreator(){
        setSize(1920,1080);
        setLayout(null);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void exit_button(JButton e){
        e = new JButton("Click To Exit");
        e.setBounds(100,100,550,550);
        e.setSize(500,100);
        e.setFont(f);
        e.setBackground(new Color(0, 0, 0, 255));
        e.setForeground(new Color(255, 255, 255, 255));
        this.add(e);

        e.addActionListener(this);
        e.setActionCommand("exit");
    }

    public void setBackground(JLabel l, ImageIcon i){
        l = new JLabel(i);
        l.setSize(1920,1080);
        add(l);
    }
    public static void main(String[] args) {
        new GameGUI();
    }

}