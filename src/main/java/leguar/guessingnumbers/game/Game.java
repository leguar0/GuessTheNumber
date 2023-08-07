package leguar.guessingnumbers.game;

public class Game {
    private final int CHANCES = 10;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 100;
    private int trialCounter = 1;
    private final int drawnNumber;

    public Game(){
        drawnNumber = (int) (Math.random()*MAX_NUMBER+MIN_NUMBER);
    }

    public int getCHANCES() {
        return CHANCES;
    }

    public int getDrawnNumber(){
        return drawnNumber;
    }

    public int getTrialCounter(){
        return trialCounter;
    }

    public boolean correctAnswer(int number){
        if(number == drawnNumber){
            return true;
        }else {
            return false;
        }
    }

    public String answer(int number){
        trialCounter++;
        if(number > drawnNumber){
            return "Za duża liczba";
        }else {
            return "Za mała liczba";
        }
    }
}
