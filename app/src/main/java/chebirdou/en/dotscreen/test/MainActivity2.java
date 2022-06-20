package chebirdou.en.dotscreen.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import chebirdou.en.dotscreen.test.game.Game;
import chebirdou.en.dotscreen.test.game.Player;

public class MainActivity2<priavte> extends AppCompatActivity {


    private static ImageView arrow1, arrow2;
    private static Game game;
    private static EditText edScorePlayer1, edScorePlayer2,edNamePlayer1, edNamePlayer2  ;

    private static ImageView v11, v12, v21, v31, v22, v33, v13, v32, v23;
    private static Drawable nothing;
    GridLayout grid;
    public static Context context;
    public static EditText edHeure;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle b = getIntent().getExtras();
        String p1="Player1", p2="Player2";
        context = getApplicationContext();
        if(b != null){
            p1 = b.getString("p1");
            p2 = b.getString("p2");
        }

        nothing = getDrawable(R.drawable.ic_nothing);

        edHeure = findViewById(R.id.ed_heure);
        arrow1 = findViewById(R.id.arrow_player1);
        arrow2 = findViewById(R.id.arrow_player2);

        edScorePlayer1 = findViewById(R.id.edittext_score_player1);
        edScorePlayer2 = findViewById(R.id.edittext_score_player2);

        edNamePlayer1 = findViewById(R.id.edittext_name_player1);
        edNamePlayer2 = findViewById(R.id.edittext_name_player2);
        v11 = findViewById(R.id.v11);
        v12 = findViewById(R.id.v12);
        v13 = findViewById(R.id.v13);
        v21 = findViewById(R.id.v21);
        v22 = findViewById(R.id.v22);
        v23 = findViewById(R.id.v23);
        v31 = findViewById(R.id.v31);
        v32 = findViewById(R.id.v32);
        v33 = findViewById(R.id.v33);

        v11.setOnClickListener(view -> clickPlayV(view));
        v12.setOnClickListener(view -> clickPlayV(view));
        v13.setOnClickListener(view -> clickPlayV(view));
        v21.setOnClickListener(view -> clickPlayV(view));
        v22.setOnClickListener(view -> clickPlayV(view));
        v23.setOnClickListener(view -> clickPlayV(view));
        v31.setOnClickListener(view -> clickPlayV(view));
        v32.setOnClickListener(view -> clickPlayV(view));
        v33.setOnClickListener(view -> clickPlayV(view));

        grid = findViewById(R.id.grid);







        Player pl1 = new Player(1, p1,0,R.drawable.ic_close);
        Player pl2 = new Player(2, p2, 0, R.drawable.ic_eye);
        game = new Game(pl1, pl2, true);
        game.init();


        displayArrow(game.isTurn());
        displayName();
        updateDisplayScore();
        newGame();
    }

    private void displayName() {
        edNamePlayer1.setText(game.getPlayer1().getName()+"");
        edNamePlayer2.setText(game.getPlayer2().getName()+"");
    }


    public static void displayArrow(boolean turn) {
        if (turn) {
            arrow1.setVisibility(View.VISIBLE);
            arrow2.setVisibility(View.INVISIBLE);
        }else{
            arrow1.setVisibility(View.INVISIBLE);
            arrow2.setVisibility(View.VISIBLE);
        }
    }

    public static void updateDisplayScore() {

        edScorePlayer1.setText(game.getPlayer1().getScore()+"");
        edScorePlayer2.setText(game.getPlayer2().getScore()+"");
    }

    public static void newGame(){
        v11.setImageDrawable(nothing);
        v12.setImageDrawable(nothing);
        v13.setImageDrawable(nothing);
        v21.setImageDrawable(nothing);
        v22.setImageDrawable(nothing);
        v23.setImageDrawable(nothing);
        v31.setImageDrawable(nothing);
        v32.setImageDrawable(nothing);
        v33.setImageDrawable(nothing);

        v11.setEnabled(true);
        v12.setEnabled(true);
        v13.setEnabled(true);
        v21.setEnabled(true);
        v22.setEnabled(true);
        v23.setEnabled(true);
        v33.setEnabled(true);
        v31.setEnabled(true);
        v32.setEnabled(true);
    }




    private void clickPlayV(View v) {
        //already used
        ImageView v2 = (ImageView) v;
        int img, value;

        if (game.isTurn()) {
                img = game.getPlayer1().getImage();
                value = game.getPlayer1().getIndex();
            } else {
                img = game.getPlayer2().getImage();
                value = game.getPlayer2().getIndex();
            }

            String s[] = v2.getTag().toString().split(" ");

            game.setTab(Integer.parseInt(s[0]),Integer.parseInt(s[1]), value);
            v2.setImageDrawable(getDrawable(img));
            v2.setEnabled(false);
            game.isThereWinner();
        }

    public static void showMessage(String name) {
        Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
    }

    public static void updateTimer(String msg){
        edHeure.setText(msg);
    }

    public static void end(){
        v11.setEnabled(false);
        v12.setEnabled(false);
        v13.setEnabled(false);
        v21.setEnabled(false);
        v22.setEnabled(false);
        v23.setEnabled(false);
        v33.setEnabled(false);
        v31.setEnabled(false);
        v32.setEnabled(false);
    }
}