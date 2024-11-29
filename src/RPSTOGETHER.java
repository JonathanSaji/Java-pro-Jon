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
    private JLabel player;
    private int matchWinner = 0;
    private int rounds = 0;
    String comChoice;
    String result;

    //for first panel popup
    private JPanel intro;
    private JLabel welcomeLabel;
    private JButton playerVSAIButton;
    private JButton playerVSPlayerButton;
    private JButton SETNAMESButton;
    private JLabel MatchWinnerLabel;
    private JButton exit_btn;
    private JButton howToPlayButton;
    private JPanel tutorial;
    String name_two;
    String name;
    String AI_name;

    //for pvp panel popup
    private JPanel PVP;
    private JPanel player1;
    private JPanel player2;
    private JButton rock_player1;
    private JButton scissors_player1;
    private JButton paper_player1;
    private JLabel resultlabel_pvp;
    private JLabel player1_label;
    private JButton rock_player2;
    private JButton paper_player2;
    private JButton scissors_player2;
    private JLabel player2_label_pvp;
    private JButton exitBTNPVP;
    private int PVP_rounds = 0;
    private String pvp_choice_player1, pvp_choice_player2;


    public RPSTOGETHER(){
        frame = new JFrame();
        setTitle("RPS GAME (By Jonathan Saji)");
        setVisible(true);
        setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setContentPane(RPS);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        intro.setVisible(true);
        AI.setVisible(false);
        PVP.setVisible(false);
        tutorial.setVisible(false);


        //for intro popup
        SETNAMESButton.addActionListener(this);
        exit_btn.addActionListener(this);
        playerVSAIButton.addActionListener(this);
        playerVSPlayerButton.addActionListener(this);
        howToPlayButton.addActionListener(this);

        //ai popup
        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);
        EXITButton.addActionListener(this);

        //pvp popup
        rock_player1.addActionListener(this);
        paper_player1.addActionListener(this);
        scissors_player1.addActionListener(this);
        rock_player2.addActionListener(this);
        paper_player2.addActionListener(this);
        scissors_player2.addActionListener(this);
        exitBTNPVP.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == howToPlayButton){
            tutorial.setVisible(true);
        }
        if (e.getSource() == SETNAMESButton) {
            name = JOptionPane.showInputDialog(null, "What is Your Name?");
            playerVSAIButton.setText(name + " VS " + "AI");
            playerVSPlayerButton.setText(name + " VS " + "Player");
            player.setText("Pick One, " + name);
            player1_label.setText("Pick: " + name);
            int askPlayer2 = JOptionPane.showConfirmDialog(null, "Do you have another Player?");
            if (askPlayer2 == JOptionPane.YES_OPTION) {
                name_two = JOptionPane.showInputDialog(null, "Player 2 What Is Your Name?");
                playerVSPlayerButton.setText(name + " VS " + name_two);
                player2_label_pvp.setText("Pick: " + name_two);
            }
            int askAI = JOptionPane.showConfirmDialog(null, "Do you want to name the AI?");
            if (askAI == JOptionPane.YES_OPTION) {
                AI_name = JOptionPane.showInputDialog(null, "What do you want the AI to be named?");
                playerVSAIButton.setText(name + " VS " + AI_name);
            }
        }
        else if(e.getSource() == exit_btn){
            dispose();
        }
        //start of AI
    if(e.getSource() == playerVSAIButton){
        this.rounds = 0;
        this.matchWinner = 0;
        AI.setVisible(true);
        intro.setVisible(false);
        tutorial.setVisible(false);
    }
        if(e.getSource() == rockButton){
            usersChoice = "Rock";
            addAIRounds();
        }
        else if(e.getSource()== paperButton){
            usersChoice = "Paper";
            addAIRounds();
        }
        else if(e.getSource() == scissorsButton){
            usersChoice = "Scissors";
            addAIRounds();
        }
        else if(e.getSource() == EXITButton){
            AI.setVisible(false);
            intro.setVisible(true);
        }
        if(usersChoice != null) {
            comChoice = getComChoice();

            result = winner(usersChoice, comChoice);

            resultlabel.setText("Your Choice: " + usersChoice + " ||Computer's Choice: " + comChoice + " ||Result:" + result);
        }

           if(rounds == 3) {
               rounds = 0;
               AI.setVisible(false);
               intro.setVisible(true);

               if (matchWinner < 0) {
                   if (AI_name != null) {
                       MatchWinnerLabel.setText("Match Winner: " + AI_name);
                   } else {
                       MatchWinnerLabel.setText(("Match Winner: AI"));
                   }
               } else {
                   if (name != null) {
                       MatchWinnerLabel.setText(("Match Winner: " + name));
                   } else {
                       MatchWinnerLabel.setText(("Match Winner: Player"));
                   }
               }
           }

        //beginning of PVP
        if(e.getSource() == playerVSPlayerButton){
            tutorial.setVisible(false);
            intro.setVisible(false);
            PVP.setVisible(true);
            player1.setVisible(true);
            player2.setVisible(false);
            this.PVP_rounds = 0;
            this.matchWinner = 0;
        }
        if(e.getSource() == rock_player1){
            pvp_choice_player1 = "Rock";
            player1.setVisible(false);
            player2.setVisible(true);
        }
        else if(e.getSource() == paper_player1){
            pvp_choice_player1 = "Paper";
            player1.setVisible(false);
            player2.setVisible(true);
        }
        else if(e.getSource() == scissors_player1){
            pvp_choice_player1 = "Scissors";
            player1.setVisible(false);
            player2.setVisible(true);
        }
        else if(e.getSource() == rock_player2){
            pvp_choice_player2 = "Rock";
            player1.setVisible(true);
            player2.setVisible(false);
            addPVPRounds();
        }
        else if(e.getSource() == paper_player2){
            pvp_choice_player2 = "Paper";
            player1.setVisible(true);
            player2.setVisible(false);
            addPVPRounds();
        }
        else if(e.getSource() == scissors_player2){
            pvp_choice_player2 = "Scissors";
            player1.setVisible(true);
            player2.setVisible(false);
            addPVPRounds();
        }
        else if(e.getSource() == exitBTNPVP){
            intro.setVisible(true);
            PVP.setVisible(false);
        }
        if(pvp_choice_player1 !=null && pvp_choice_player2 !=null){
            String result_pvp = winner(pvp_choice_player1, pvp_choice_player2);

            if(name == null && name_two == null ) {
                resultlabel_pvp.setText("Player 1's " + pvp_choice_player1 + " ||Player 2's Choice: " + pvp_choice_player2 + " ||Result: Player 1" + result_pvp);
            }
            else if(name != null && name_two !=null){
                resultlabel_pvp.setText(name + "'s Choice: " + pvp_choice_player1 + name_two +   "'s Choice: " + pvp_choice_player2 + " ||Result: " + name + result_pvp);
            }
            else if(name != null && name_two == null){
                resultlabel_pvp.setText(name + "'s Choice: " + pvp_choice_player1 +" Player 2's Choice: " + pvp_choice_player2 + " ||Result: " + name + result_pvp);
            }
            else{
                resultlabel_pvp.setText("Player 1's Choice: " + pvp_choice_player1 + name_two + pvp_choice_player2 + " ||Result: Player 1 " + result_pvp);
            }
            if(PVP_rounds == 3) {
                this.PVP_rounds = 0;
                PVP.setVisible(false);
                intro.setVisible(true);
                AI.setVisible(false);
                if (matchWinner > 0) {
                    if (name != null) {
                        MatchWinnerLabel.setText("Match Winner: " + name);
                    } else {
                        MatchWinnerLabel.setText(("Match Winner: Player 1"));
                    }
                } else {
                    if (name_two != null) {
                        MatchWinnerLabel.setText(("Match Winner: " + name_two));
                    } else {
                        MatchWinnerLabel.setText(("Match Winner: Player 2"));
                    }
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
            return " It's a tie!";
        } else if ((uC.equals("Rock") && cC.equals("Scissors")) ||
                (uC.equals("Paper") && cC.equals("Rock")) ||
                (uC.equals("Scissors") && cC.equals("Paper"))) {
            this.matchWinner++;
            return " won!";
        } else {
            this.matchWinner--;
            return " lost!";
        }
    }

    public void addPVPRounds(){
        if(!pvp_choice_player1.equals(pvp_choice_player2)){
            this.PVP_rounds++;
        }
    }


    public void addAIRounds(){
        if(!usersChoice.equals(getComChoice())){
            this.rounds++;
            this.num_rounds.setText("Rounds: " + rounds);
        }
    }
    public static void main(String[] args){
        new RPSTOGETHER();
    }//main

}//end of game
