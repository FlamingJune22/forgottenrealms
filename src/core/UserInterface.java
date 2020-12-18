package core;

import javax.swing.*;
import java.awt.*;

import core.Game.ChoiceHandler;

public class UserInterface {

    JFrame window;
    JPanel mainMenuPanel, startButtonPanel, mainTextPanel, choiceButtonPanel, statusPanel;
    JLabel mainMenuLabel, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;

    Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
    Font defaultFont = new Font("Times New Roman", Font.PLAIN, 20);

    public void drawUI(ChoiceHandler handler) {

        // Создание окна (фрейма)
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);

        // Создание главного меню
        mainMenuPanel = new JPanel();
        mainMenuPanel.setBounds(100,100,600,500);
        mainMenuPanel.setBackground(Color.black);
        mainMenuLabel = new JLabel("Forgotten Realms");
        mainMenuLabel.setForeground(Color.white);
        mainMenuLabel.setFont(titleFont);
        mainMenuPanel.add(mainMenuLabel);
        window.add(mainMenuPanel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(150, 400, 500, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("Отправиться на поиски приключений");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(defaultFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(handler);
        startButton.setActionCommand("start");
        startButtonPanel.add(startButton);
        window.add(startButtonPanel);

        // Создание игрового меню
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea("4343");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(defaultFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250,350,300,150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        window.add(choiceButtonPanel);

        choice1 = new JButton("");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(defaultFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(handler);
        choice1.setActionCommand("choice1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(defaultFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(handler);
        choice2.setActionCommand("choice2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(defaultFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(handler);
        choice3.setActionCommand("choice3");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(defaultFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(handler);
        choice4.setActionCommand("choice4");
        choiceButtonPanel.add(choice4);

        statusPanel = new JPanel();
        statusPanel.setBounds(100, 15, 600, 50);
        statusPanel.setBackground(Color.black);
        statusPanel.setLayout(new GridLayout(1,4 ));
        window.add(statusPanel);

        hpLabel = new JLabel("Здоровье:");
        hpLabel.setForeground(Color.white);
        hpLabel.setFont(defaultFont);
        statusPanel.add(hpLabel);
        hpNumberLabel = new JLabel();
        hpNumberLabel.setForeground(Color.white);
        hpNumberLabel.setFont(defaultFont);
        statusPanel.add(hpNumberLabel);
        weaponLabel = new JLabel("Оружие: ");
        weaponLabel.setForeground(Color.white);
        weaponLabel.setFont(defaultFont);
        statusPanel.add(weaponLabel);
        weaponNameLabel = new JLabel();
        weaponNameLabel.setForeground(Color.white);
        weaponNameLabel.setFont(defaultFont);
        statusPanel.add(weaponNameLabel);

    }
}
