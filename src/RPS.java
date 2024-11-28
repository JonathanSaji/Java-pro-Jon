import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RPS extends JFrame implements ActionListener{
    private JFrame frame;
    private JPanel GAME;
    private JButton rockButton;
    private JButton scissorsButton;
    private JButton paperButton;
    private JLabel resultlabel;
    private String usersChoice;

    public RPS(){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(1920,1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(GAME);

        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == rockButton){
            usersChoice = "Rock";
        }
        else if(e.getSource()== paperButton){
            usersChoice = "Paper";
        }
        else if(e.getSource() == scissorsButton){
            usersChoice = "Scissors";
        }

        String comChoice = getComChoice();

        String result = winner(usersChoice, comChoice);

        resultlabel.setText("Your Choice:" + usersChoice + "Computer's Choice: " + comChoice + "Result:" + result);

    }

    public String getComChoice(){
        String[] choices = {"Paper","Rock","Scissors"};
        Random rand = new Random();
        return choices[rand.nextInt(3)];//something new I found from google
    }

    public String winner(String uC,String cC){
        if (uC.equals(cC)) {
            return "It's a tie!";
        } else if ((uC.equals("Rock") && cC.equals("Scissors")) ||
                (uC.equals("Paper") && cC.equals("Rock")) ||
                (uC.equals("Scissors") && cC.equals("Paper"))) {
            return "You win!";
        } else {
            return "You lose!";
        }
    }

    public static void main(String[] args){
        new RPS();
    }


}
