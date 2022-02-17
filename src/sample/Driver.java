package sample;

import javafx.application.Platform;

import javax.swing.*;

public class Driver extends Thread {
    public static int pos = 0;
    public static boolean[][] egg = new boolean[4][5];
    public static int score = 0;
    public static int cracked = 0;

    @Override
    public void run() {

        while(!this.isInterrupted()){
            for(int i = 0; i < 4; i++){
                if(egg[i][0]){
                    if(pos==i) {
                        score++;
                        Platform.runLater(Main::update_score);

                    }
                    else{
                        cracked++;
                        switch(cracked){
                            case 1:
                                Platform.runLater(Main::first_k);
                                break;
                            case 2:
                                Platform.runLater(Main::second_k);
                                break;
                            case 3:
                                Platform.runLater(Main::third_k);
                                break;
                            default:
                                Thread.currentThread().interrupt();
                                JOptionPane.showInputDialog("Twój wynik to " + score + "! Wpisz swoje imię!", null);
                                Thread.currentThread().stop();
                        }
                    }
                }
                egg[i][0]=false;
            }
            for(int i = 0; i < 4; i++){
                for(int j = 1; j < 5; j++){
                    if(egg[i][j]){
                        egg[i][j]=false;
                        egg[i][j-1]=true;
                    }
                }
            }
            int p = (int)(Math.random()*4);
            egg[p][4] = true;
            switch(p){
                case 0:
                    Platform.runLater(Main::egg_lu);
                    break;
                case 1:
                    Platform.runLater(Main::egg_ll);
                    break;
                case 2:
                    Platform.runLater(Main::egg_ru);
                    break;
                case 3:
                    Platform.runLater(Main::egg_rl);
                    break;

            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
