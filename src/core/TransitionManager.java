package core;

public class TransitionManager {

    UserInterface ui;

    public TransitionManager(UserInterface userInt) {

        ui = userInt;

    }

    public void showMainScreen() {

        // Вывод главного меню
        ui.mainMenuPanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        // Скрытие игрового меню
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.statusPanel.setVisible(false);

    }

    public void showGameScreen() {

        // Скрытие главного меню
        ui.mainMenuPanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        // Вывод игрового меню
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.statusPanel.setVisible(true);

    }
}
