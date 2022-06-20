package chebirdou.en.dotscreen.test.game;

import android.os.CountDownTimer;

import chebirdou.en.dotscreen.test.MainActivity2;

/**
 * Created by Assia HACHICHI on 20/06/2022
 */
public class Game {
    private Player pl1, pl2;
    private boolean turn ;
    private int[][] tab;
    private static int cpTurn =1;

    public Game(Player pl1, Player pl2, boolean turn) {
        this.pl1 = pl1;
        this.pl2 = pl2;
        this.turn = turn;
        this.tab = new int[3][3];
        init();
        new CountDownTimer(180000, 1000) {

            public void onTick(long millisUntilFinished) {
                String heure, p;
                int h = (int) millisUntilFinished/1000;
                int m = h/60;
                int s = h%60;
                if (s <10) p= ":0"+s; else p =":"+s;
                heure = "0"+m+p ;
                MainActivity2.updateTimer(heure);
            }

            public void onFinish() {
                MainActivity2.end();
                System.out.println("done!");
            }
        }.start();
    }

    public void setTab(int i, int j, int value) {
        this.tab [i][j]= value;
    }

    public Player getPlayer1() {
        return pl1;
    }

    public Player getPlayer2() {
        return pl2;
    }

    public boolean isTurn() {
        return turn;
    }

    public void init(){
        cpTurn = 0;
        turn = true;
        int i = 0,j;
        while (i<3){
            j = 0;
            while (j<3){
                this.tab[i][j]=0;
                j++;
            }
            i++;
        }
        MainActivity2.displayArrow(turn);
    }

    /**
     *
     * @return 0 no, 1 player1, 2 player2
     */

    public void isThereWinner() {
        boolean win = false;
        if (turn){
            win = checkPlayer(pl1.getIndex());
            if (win){
                pl1.setScore(pl1.getScore()+1);
                MainActivity2.showMessage("Congratulations " +pl1.getName());
            }
        }else{
            win = checkPlayer(pl2.getIndex());
            if (win){
                pl2.setScore(pl2.getScore()+1);
                MainActivity2.showMessage("Congratulations "+ pl2.getName());
            }
        }
        if (cpTurn==8)MainActivity2.showMessage("Sorry! Please play again");
        if ((win)||(cpTurn==8)){
            MainActivity2.updateDisplayScore();
            MainActivity2.newGame();
            init();


        }else {
           turn = !turn;
           cpTurn++;
        }
        MainActivity2.displayArrow(turn);
    }


    private boolean checkPlayer(int p){
        boolean win = false;
        if ((this.tab[0][0] == p) && (this.tab[1][1] == p)&&(this.tab[2][2] == p)){
            win = true;
        }else{
            if ((this.tab[0][0] == p) && (this.tab[0][1] == p)&&(this.tab[0][2] == p)){
                win = true;
            } else {
                if ( (this.tab[0][0] == p) && (this.tab[1][0] == p)&&(this.tab[2][0] == p)){
                    win = true;
                }else{
                    if ((this.tab[2][0] == p) && (this.tab[2][1] == p)&&(this.tab[2][2] == p)){
                        win = true;///
                    } else {
                        if ((this.tab[1][0] == p) && (this.tab[1][1] == p)&&(this.tab[1][2] == p)) {
                            win = true;
                        } else {
                            if ((this.tab[2][0] == p) && (this.tab[1][1] == p)&&(this.tab[0][2] == p)) {
                                win = true;
                            }else {
                                if ((this.tab[0][1] == p) && (this.tab[1][1] == p) && (this.tab[2][1] == p)) {
                                    win = true;
                                }else{
                                    if ((this.tab[0][2] == p) && (this.tab[1][2] == p) && (this.tab[2][2] == p)) {
                                        win = true;

                                    }}
                            }
                        }}}}}
        return win;
    }



}
