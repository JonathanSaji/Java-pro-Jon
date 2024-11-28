import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissors extends JFrame implements ActionListener{

    private JButton rockButton,paperButton,scissorsButton;
    private JLabel resultlabel;
    private String usersChoice, ComChoice;

    public RockPaperScissors(){
        //creates the title for the frame
        setTitle("Rock Paper Scissors");

        //creation of layout
        setLayout(new FlowLayout());

        //creation of the buttons
        rockButton = new JButton("Pick Rock");
        paperButton = new JButton("Pick Paper");
        scissorsButton = new JButton("Pick Scissors");

        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        add(rockButton);
        add(paperButton);
        add(scissorsButton);

        resultlabel = new JLabel("Make Your Move!");
        add(resultlabel);

        setSize(1920,1080);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        ComChoice = getComChoice();

        String result = winner(usersChoice,ComChoice);

        resultlabel.setText("Your Choice:" + usersChoice + "Computer's Choice: " + ComChoice + "Result:" + result);

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
        new RockPaperScissors();
    }



}
