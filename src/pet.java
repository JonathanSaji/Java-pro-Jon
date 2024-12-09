import javax.swing.*;

public class pet {
    private int happiness;
    private int tiredness;
    private int hunger;

    public pet(){
       this.happiness = 3;
       this.hunger = 0;
       this.tiredness = 0;
    }
    public pet(int hap,int tired, int hung){
        hunger = hung;
        happiness = hap;
        tiredness = tired;
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
                JOptionPane.showMessageDialog(null,"Happiness Sufficient");
            }
    }
    public void sleep(){
            hunger += 1;
            tiredness -= 1;
            if(tiredness == 0){
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

    public int getHappiness() {
        return happiness;
    }

    public int getHunger() {
        return hunger;
    }

    public int getTiredness() {
        return tiredness;
    }

    public boolean checkIfDead(){
        if(getHunger() > 5 || getTiredness() > 5 || getHappiness() < 0){
            return true;
        }
        else{
            return false;
        }
    }


    public String toString() {
        return "<html>These Are Your Pets Stats:"+"<br>Happiness: "+getHappiness()+"<br>Hunger: "+getHunger()+"<br>Tiredness: "+getTiredness();
    }
}
