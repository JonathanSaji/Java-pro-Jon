import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//test lets gooo
public class Main implements ActionListener {

    private int count = 0;

    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JButton button;

    public Main(){

        frame = new JFrame();

        panel = new JPanel();

        button = new JButton("Click Me");
        button.addActionListener(this);

        label = new JLabel("Number of Clicks: 0");


        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Welcome");
        frame.pack();
        frame.setVisible(true);


    }


    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of Clicks:"+count);
    }
}