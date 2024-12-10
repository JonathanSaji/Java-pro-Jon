import javax.swing.*;

public class pet {
    private int happiness;
    private int tiredness;
    private int hunger;
    private String name;

    public pet(){
       this.happiness = 3;
       this.hunger = 0;
       this.tiredness = 0;
       name = "Pet";
    }
    public pet(int hap,int tired, int hung,String na){
        hunger = hung;
        happiness = hap;
        tiredness = tired;
        name = na;
    }

    public void feed(){
        if(hunger > 0 || happiness < 5) {
            hunger -= 1;
            happiness -=1;
        }
        else{
            JOptionPane.showMessageDialog(null,"Hunger Sufficient");
        }
    }
    public void play(){
        if(happiness !=5) {
            hunger += 1;
            tiredness += 1;
            happiness += 1;
        }
        else{
            tiredness += 1;
            happiness += 1;
            JOptionPane.showMessageDialog(null,"Happiness Sufficient");
            }
    }
    public void sleep(){
            if(tiredness > 0) {
                hunger += 1;
                tiredness -= 1;
            }
            else{
                hunger+=1;
            JOptionPane.showMessageDialog(null,"Sleep Sufficient");

        }
    }

    public void setHappiness(int hap){
        happiness = hap;
    }
    public void setTiredness(int tire){
        tiredness = tire;
    }

    public void setHunger(int hun) {
        this.hunger = hun;
    }
    public void setName(String na){
        name = na;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getHunger() {
        return hunger;
    }

    public int getTiredness() {
        return tiredness;
    }
    public String getname(){
        return name;
    }

    public boolean checkIfDead(){
        if(getHunger() > 5 || getTiredness() > 5 || getHappiness() < 0){
            return true;
        }
        else{
            return false;
        }
    }

    public String statusCheck(){
        if(happiness == 0){
            return "<html>   ___"
                    + "<br>(/ . . \\) "
                    + "<br> (  ^  )   /)"
                    + "<br> |      \\ /) "
                    + "<br> |_|__|_|/) " +"Your "+getname()+ " is Depressed";
        }
        else if(tiredness == 5){
            return "<html>___      z z ..." +
                    "<br>(/ - - )  z ..." +
                    "<br> (  -  )__" +
                    "<br> (_(___(__)\\\\)" + "<br>Your "+getname()+ " Needs Sleep";
        }
        else if(hunger == 5){
            return "<html>   ___"
                    + "<br>(/ . . \\) "
                    + "<br> (  ^  )   /)"
                    + "<br> |      \\ /) "
                    + "<br> |_|__|_|/) " + "<br>Your "+getname()+ " Needs Food";
        }
        else{
            return "<html>  ___"
                    + "<br>(/ , , \\) "
                    + "<br>(   U  ) /)"
                    + "<br>|      \\ /) "
                    + "<br>|_|__|_|/) " + "<br>Your "+getname()+ " is All Good";
        }

    }


    public String toString() {
        return "<html>These Are Your "+getname()+"'s Stats:"+"<br>Happiness: "+getHappiness()+"<br>Hunger: "+getHunger()+"<br>Tiredness: "+getTiredness();
    }
}
