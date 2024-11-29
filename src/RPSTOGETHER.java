import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RPSTOGETHER extends JFrame implements ActionListener {
    private JFrame frame;
    private JPanel RPS;

    //for AI vs player popup
    private JPanel AI;
    private JButton rockButton;
    private JButton scissorsButton;
    private JButton paperButton;
    private JLabel resultlabel;
    private JButton EXITButton;
    private String usersChoice;
    private JLabel num_rounds;
    private int matchWinner = 0;
    private int rounds = 0;

    //for first panel popup
    private JPanel intro;
    private JLabel welcomeLabel;
    private JButton playerVSAIButton;
    private JButton playerVSPlayerButton;
    private JButton SETNAMESButton;
    private JLabel MatchWinnerLabel;
    private JLabel player;
    String name;
    String AI_name;


    public RPSTOGETHER(){
        frame = new JFrame();
        setVisible(true);
        setSize(1920,1080);
        setContentPane(RPS);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        intro.setVisible(true);
        AI.setVisible(false);

        //for intro popup
        SETNAMESButton.addActionListener(this);
        playerVSAIButton.addActionListener(this);

        //ai popup
        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);
        EXITButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SETNAMESButton) {
            name = JOptionPane.showInputDialog(null, "What is Your Name?");
            playerVSAIButton.setText(name + " VS " + "AI");
            playerVSPlayerButton.setText(name + " VS " + "Player");
            int askPlayer2 = JOptionPane.showConfirmDialog(null, "Do you have another Player?");
            if (askPlayer2 == JOptionPane.YES_OPTION) {
                String name_two = JOptionPane.showInputDialog(null, "Player 2 What Is Your Name?");
                playerVSPlayerButton.setText(name + " VS " + name_two);
            }
            int askAI = JOptionPane.showConfirmDialog(null, "Do you want to name the AI?");
            if (askAI == JOptionPane.YES_OPTION) {
                AI_name = JOptionPane.showInputDialog(null, "What do you want the AI to be named?");
                playerVSAIButton.setText(name + " VS " + AI_name);
            }
        }
        //start of AI
    if(e.getSource() == playerVSAIButton){
        intro.setVisible(false);
        AI.setVisible(true);
        this.rounds = 0;
        this.matchWinner = 0;
        resultlabel.setText("Result: ");
    }
        if(e.getSource() == rockButton){
            usersChoice = "Rock";
        }
        else if(e.getSource()== paperButton){
            usersChoice = "Paper";
        }
        else if(e.getSource() == scissorsButton){
            usersChoice = "Scissors";
        }
        else if(e.getSource() == EXITButton){
            AI.setVisible(false);
            intro.setVisible(true);
        }
        if(usersChoice != null) {
            String comChoice = getComChoice();

            String result = winner(usersChoice, comChoice);

            resultlabel.setText("Your Choice: " + usersChoice + " ||Computer's Choice: " + comChoice + " ||Result:" + result);

           if(rounds == 3) {
               AI.setVisible(false);
               intro.setVisible(true);
           }
            if(matchWinner < 0 ){
                if(AI_name != null){
                    MatchWinnerLabel.setText("Match Winner: " + AI_name);
                }
                else{
                    MatchWinnerLabel.setText(("Match Winner: AI"));
                }
            }
            else{
                if(name != null){
                    MatchWinnerLabel.setText(("Match Winner: " + name ));
                }
                else{
                    MatchWinnerLabel.setText(("Match Winner: Player"));
                }
            }
        }
    }//action listener end

    //AI Method
    public String getComChoice(){
        String[] choices = {"Paper","Rock","Scissors"};
        Random rand = new Random();
        return choices[rand.nextInt(3)];//something new I found from google
    }
    //AI Method
    public String winner(String uC,String cC){
        if (uC.equals(cC)) {
            return "It's a tie!";
        } else if ((uC.equals("Rock") && cC.equals("Scissors")) ||
                (uC.equals("Paper") && cC.equals("Rock")) ||
                (uC.equals("Scissors") && cC.equals("Paper"))) {
            this.rounds++;
            this.matchWinner++;
            num_rounds.setText("Rounds: " + rounds);
            return "You win!";
        } else {
            this.rounds++;
            this.matchWinner--;
            num_rounds.setText("Rounds: " + rounds);
            return "You lose!";
        }
    }

    public static void main(String[] args){
        new RPSTOGETHER();
    }//main

}//end of game
