package com.example.numberguessinggame;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    public TextField guessNumberTf;
    public Button guessBn;
    public Label resultL, scoreL,scoreTitleL;

    private OptionalMethod method;
    int attempt = 5, totalPoint = 0;
    int answer = (int) (Math.random() * 100) + 1;

	private static final String RESTART_GAME  = "RESTART GAME";
	private static final String GUESS_GAME  = "GUESS";

    int correctCount = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        method = new OptionalMethod();
		totalPoint = attempt*2;
    }

    public void guessBnClick(ActionEvent actionEvent) {

		if (Objects.equals(guessBn.getText(), RESTART_GAME)){
			guessBn.setText(GUESS_GAME);
			guessNumberTf.setDisable(false);
			resultL.setText("");
			scoreL.setText("");
			scoreTitleL.setText("");
			return;
		}

        String num = guessNumberTf.getText();
        if (num.isEmpty()) {
            method.show_popup("Please enter guess", guessNumberTf);
            return;
        }

        int guess = 0;
        try {
            guess = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            method.show_popup("Please enter valid number", guessNumberTf);
            return;
        }

        if (attempt > 0) {

            if (guess == answer) {
				resultL.setTextFill(Color.GREEN);
                resultL.setText("You guessed the number!");
                correctCount += 1;
                return;
            } else if (guess > answer) {
                resultL.setText("Your guess is too high.\nYou have " + (attempt - 1) + " tries left.");
            } else {
                resultL.setText("Your guess is too low.\nYou have " + (attempt - 1) + " tries left.");
            }

            attempt--;

        }

		guessNumberTf.setText("");

        if (attempt == 0) {
            if (correctCount == 0) {
				resultL.setTextFill(Color.RED);
                resultL.setText("You ran out of attempt.\nYou lose!");
            }else {
				resultL.setText("....");
			}

			correctCount = 0;
			attempt = 5;

			scoreTitleL.setText("Your score:");

			scoreL.setText("You got "+correctCount*2+" points out of "+totalPoint+" points");

			guessBn.setText(RESTART_GAME);
			guessNumberTf.setDisable(true);

		}

		guessNumberTf.setFocusTraversable(true);
    }
}
