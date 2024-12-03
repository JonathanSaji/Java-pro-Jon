import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pet extends JFrame implements ActionListener {
    JFrame window;
    JPanel menu;
    JPanel tutorial_speech;
    private JButton tutorial;
    private JButton exit_menu;
    private JButton start_menu;;

    public Pet(){
        window = new JFrame();
        setTitle("Pet Simulator (By Jonathan Saji)");
        setVisible(true);
        setExtendedState(window.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setContentPane(menu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu.setVisible(true);
        tutorial_speech.setVisible(false);

        //menu
        start_menu.addActionListener(this);
        start_menu.setActionCommand("start_menu");

        tutorial.addActionListener(this);
        tutorial.setActionCommand("tutorial");

        exit_menu.addActionListener(this);
        exit_menu.setActionCommand("exit_menu");
        // e menu


    }
    @Override
    public void actionPerformed(ActionEvent e){
        String button = e.getActionCommand();
        switch(button){
            case "exit_menu":
                dispose();
                break;
            case "tutorial":
                tutorial_speech.setVisible(true);
                break;
            case "start_menu":
                tutorial_speech.setVisible(false);
                menu.setVisible(false);
                break;
        }

    }


    public static void main(String[] args) {
        new Pet();
    }

}
