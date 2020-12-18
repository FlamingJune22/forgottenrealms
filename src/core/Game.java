package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    ChoiceHandler handler = new ChoiceHandler();
    UserInterface ui = new UserInterface();
    TransitionManager tm = new TransitionManager(ui);
    Story story = new Story(this, ui, tm);

    String playerLocation1, playerLocation2, playerLocation3, playerLocation4;

    public static void main(String[] args) {

        new Game();

    }

    public Game(){

        ui.drawUI(handler);
        story.defaultInventory();
        tm.showMainScreen();

    }

    public class ChoiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String playerChoice = e.getActionCommand();

            switch(playerChoice) {

                case "start":
                    tm.showGameScreen();
                    story.townGate();
                    break;
                case "choice1":
                    story.selectLocation(playerLocation1);
                    break;
                case "choice2":
                    story.selectLocation(playerLocation2);
                    break;
                case "choice3":
                    story.selectLocation(playerLocation3);
                    break;
                case "choice4":
                    story.selectLocation(playerLocation4);
                    break;

            }
        }
    }
}
