package core;

import assets.*;

public class Story {

    Game game;
    UserInterface ui;
    TransitionManager tm;
    Player player = new Player();
    SuperBandit bandit;

    boolean daggerFound;
    boolean cloakFound;
    boolean isDepleted;
    boolean isKilled;

    public Story(Game g, UserInterface userInt, TransitionManager transManager) {

        game = g;
        ui = userInt;
        tm = transManager;

    }

    public void defaultInventory() {

        player.hp = 20;
        ui.hpNumberLabel.setText("" + player.hp);
        player.playerWeapon = new Weapon_LongSword();
        ui.weaponNameLabel.setText(player.playerWeapon.name);
        daggerFound = false;
        cloakFound = false;
        isDepleted = false;
        isKilled = false;

    }

    public void selectLocation(String playerLocation) {

        switch(playerLocation) {

            case "townGate":
                townGate();
                break;
            case "talkToGuard":
                talkToGuard();
                break;
            case "attackGuard":
                attackGuard();
                break;
            case "crossroad":
                crossroad();
                break;
            case "south":
                south();
                break;
            case "west":
                west();
                break;
            case "east":
                east();
                break;
            case "fight":
                fight();
                break;
            case "attack":
                attack();
                break;
            case "banditAttack":
                banditAttack();
                break;
            case "win":
                win();
                break;
            case "lose":
                lose();
                break;
            case "getDagger":
                getDagger();
                break;
            case "toMainMenu":
                toMainMenu();
                break;

        }
    }

    public void townGate() {

        ui.mainTextArea.setText("Вы стоите перед огромными вратами города Невервинтер. \nСтража перед вами не выглядят приветливой... \n\nЧто вы будете делать?");
        ui.choice1.setText("Поговорить со стражей");
        ui.choice2.setText("Атаковать стражу");
        ui.choice3.setText("Уйти");
        ui.choice4.setText("");

        game.playerLocation1 = "talkToGuard";
        game.playerLocation2 = "attackGuard";
        game.playerLocation3 = "crossroad";
        game.playerLocation4 = "";
    }

    public void talkToGuard() {

        if (daggerFound && cloakFound) {

            ending();

        } else {

            ui.mainTextArea.setText("Стражник: Приветствую, странник! Сейчас в Невервинтере царит чума. Обычным проходимцам вход в город воспрещен.");
            ui.choice1.setText("—>");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.playerLocation1 = "townGate";
            game.playerLocation2 = "";
            game.playerLocation3 = "";
            game.playerLocation4 = "";
        }
    }

    public void attackGuard() {

            ui.mainTextArea.setText("Разница в навыках слишком высока. \nСтражник ударил вас тупой стороной меча и прогнал от врат. \n(Вы получили 5 урона)");
            player.hp -= 5;

            if (player.hp <1){

                game.playerLocation1 = "toMainMenu";
                game.playerLocation2 = "";
                game.playerLocation3 = "";
                game.playerLocation4 = "";
                lose();

            } else {

                game.playerLocation1 = "townGate";
                game.playerLocation2 = "";
                game.playerLocation3 = "";
                game.playerLocation4 = "";

            }

            ui.hpNumberLabel.setText("" +player.hp);
            ui.choice1.setText("—>");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

    }

    public void getDagger() {

        if (daggerFound) {

            ui.mainTextArea.setText("На теле больше ничего нет.");
            ui.choice1.setText("Уйти");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.playerLocation1 = "crossroad";
            game.playerLocation2 = "";
            game.playerLocation3 = "";
            game.playerLocation4 = "";

        } else {

            player.playerWeapon = new Weapon_Dagger();
            ui.weaponNameLabel.setText(player.playerWeapon.name);
            daggerFound = true;
            ui.mainTextArea.setText("На теле вы нашли светящийся кинжал. Вероятно, зачарованный.");

        }
    }

    public void fight() {

        ui.mainTextArea.setText(bandit.name + ": " + bandit.hp + "\n\nЧто вы будете делать?");
        ui.choice1.setText("Атаковать");
        ui.choice2.setText("Бежать");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.playerLocation1 = "attack";
        game.playerLocation2 = "crossroad";
        game.playerLocation3 = "";
        game.playerLocation4 = "";

    }

    public void attack() {

        int playerDamage = new java.util.Random().nextInt(player.playerWeapon.damage);

        ui.mainTextArea.setText("Вы нанесли " +playerDamage+ " урона");

        bandit.hp -= playerDamage;

        ui.choice1.setText("—>");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (bandit.hp > 0) {
            game.playerLocation1 = "banditAttack";
            game.playerLocation2 = "";
            game.playerLocation3 = "";
            game.playerLocation4 = "";
        } else {
            game.playerLocation1 = "win";
            game.playerLocation2 = "";
            game.playerLocation3 = "";
            game.playerLocation4 = "";
        }

    }

    public void banditAttack() {

        int banditDamage = new java.util.Random().nextInt(bandit.damage);

        player.hp -= banditDamage;

        ui.mainTextArea.setText("Бандит нанес " + banditDamage + " урона");
        ui.hpNumberLabel.setText("" + player.hp);
        ui.choice1.setText("—>");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (player.hp > 0) {
            game.playerLocation1 = "fight";
            game.playerLocation2 = "";
            game.playerLocation3 = "";
            game.playerLocation4 = "";
        } else if (player.hp < 1) {
            game.playerLocation1 = "lose";
            game.playerLocation2 = "";
            game.playerLocation3 = "";
            game.playerLocation4 = "";
        }
    }

    public void win() {

        isKilled = true;
        player.playerCloak = new Cloak_CloakOfEndurance();
        cloakFound = true;
        player.hp += player.playerCloak.buff;
        ui.hpNumberLabel.setText(""+ player.hp);

        ui.mainTextArea.setText("Вы победили бандита. \nС его тела вы сняли зачарованный плащ. \n\n(Вы получили Плащ Выносливости +1)");
        ui.choice1.setText("Уйти");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.playerLocation1 = "crossroad";
        game.playerLocation2 = "";
        game.playerLocation3 = "";
        game.playerLocation4 = "";

    }

    public void lose() {

        ui.mainTextArea.setText("Вы мертвы. \n\nИгра закончена");
        ui.choice1.setText("В главное меню");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.playerLocation1 = "toMainMenu";
        game.playerLocation2 = "";
        game.playerLocation3 = "";
        game.playerLocation4 = "";

    }

    public void ending() {

        ui.mainTextArea.setText("Стражник: Ох, я вижу, вы уважаемый путник. \nДобро пожаловать в Невервинтер!\n\nКонец игры");
        ui.choice1.setVisible(false);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);

    }

    public void toMainMenu() {

        defaultInventory();
        tm.showMainScreen();

    }

    public void crossroad() {

        ui.mainTextArea.setText("Вы стоите на перекрестке. \n\nКуда вы хотите пойти?");
        ui.choice1.setText("Назад к вратам");
        ui.choice2.setText("На юг");
        ui.choice3.setText("На запад");
        ui.choice4.setText("На восток");

        game.playerLocation1 = "townGate";
        game.playerLocation2 = "south";
        game.playerLocation3 = "west";
        game.playerLocation4 = "east";

    }

    public void south() {

        if (isKilled) {

            ui.mainTextArea.setText("Здесь больше никого нет.");
            ui.choice1.setText("Уйти");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.playerLocation1 = "crossroad";
            game.playerLocation2 = "";
            game.playerLocation3 = "";
            game.playerLocation4 = "";

        } else {

            bandit = new Bandit_DefaultBandit();

            ui.mainTextArea.setText("Вы наткнулись на лагерь бандитов. В темноте они пока вас не заметили. \n\n Что вы хотите сделать?");
            ui.choice1.setText("Напасть");
            ui.choice2.setText("Уйти");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.playerLocation1 = "fight";
            game.playerLocation2 = "crossroad";
            game.playerLocation3 = "";
            game.playerLocation4 = "";

        }
    }

    public void west() {

        ui.mainTextArea.setText("У обочины дороги вы заметили тело умершего путника. \n\n Что вы хотите сделать?");
        ui.choice1.setText("Обыскать");
        ui.choice2.setText("Уйти");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.playerLocation1 = "getDagger";
        game.playerLocation2 = "crossroad";
        game.playerLocation3 = "";
        game.playerLocation4 = "";

    }

    public void east() {

        if (isDepleted) {

            ui.mainTextArea.setText("Вы больше не можете помолиться.");
            ui.choice1.setText("Уйти");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

        } else {

            player.hp += 5;

            ui.hpNumberLabel.setText(""+ player.hp);
            ui.mainTextArea.setText("Вы наткнулись на святилище Латандера и преклонили колено пред богом Весны.\n\n (Вы получили +5 здоровья)");
            ui.choice1.setText("Уйти");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

        }
        isDepleted = true;

        game.playerLocation1 = "crossroad";
        game.playerLocation2 = "";
        game.playerLocation3 = "";
        game.playerLocation4 = "";
    }
}
