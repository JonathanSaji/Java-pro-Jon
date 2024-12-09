public class pet {
    private int happiness;
    private int tiredness;
    private int hunger;

    public pet(){
       this.happiness = 5;
       this.hunger = 0;
       this.tiredness = 0;
    }
    public pet(int hap,int tired, int hung){

        hunger = hung;
        happiness = hap;
        tiredness = tired;

    }

    public void feed(){
        if(hunger !=1) {
            hunger -= 1;
        }
    }
    public void play(){
        if(happiness !=5) {
            hunger += 1;
            tiredness += 1;
            happiness += 1;
        }
    }
    public void sleep(){
        if(hunger!=1 && tiredness !=1) {
            hunger += 1;
            tiredness -= 1;
        }
        else{
            System.out.println("Sleep Sufficient");
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
        if(hunger > 5 || tiredness > 5 || happiness < 0){
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
