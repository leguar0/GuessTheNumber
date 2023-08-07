package leguar.guessingnumbers.game;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Button minButton;
    @FXML
    private Button closeButton;
    @FXML
    private Button startGameButton;
    @FXML
    private Button exitGameButton;
    @FXML
    private TextField answerTextField;
    @FXML
    private Button answerButton;
    @FXML
    private Button surrenderButton;
    @FXML
    private Label textGame;
    @FXML
    private GridPane backgroundPane;
    @FXML
    private GridPane menuBar;
    @FXML
    private GridPane gameBar;
    @FXML
    private Label textMenu;
    private Game game;

    //close the game
    public void setCloseButton(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    //close the game
    public void setExitGameButton(){
        Platform.exit();
    }

    //minimalize the game
    public void setMinButton(){
        Stage stage = (Stage) minButton.getScene().getWindow();
        stage.setIconified(true);
    }

    //start game
    public void setStartGameButton(){
        menuBar.setVisible(false);

        gameBar.setVisible(true);

        game = new Game();
    }

    public void setAnswerButton(){
        int userGuess;

        try{
            userGuess = Integer.parseInt(answerTextField.getText().replace(" ", ""));

            if(game.correctAnswer(userGuess)){
                textMenu.setText("Gratulacje, odgadłeś!");

                gameBar.setVisible(false);
                menuBar.setVisible(true);
            }else {
                if (game.getTrialCounter() != game.getCHANCES()) {
                    String answer = game.answer(userGuess);

                    textGame.setText("Próba: " + game.getTrialCounter() + "\n" + answer);
                }else{
                    textMenu.setText("Przegrałeś! Myslałem o " + game.getDrawnNumber());

                    gameBar.setVisible(false);
                    menuBar.setVisible(true);
                }
            }
        } catch (Exception e) {
            return;
        }
        answerTextField.clear();
    }

    public void setSurrenderButton(){
        textMenu.setText("Aha, poddałeś się. Słabiak");
        gameBar.setVisible(false);

        menuBar.setVisible(true);
    }
}