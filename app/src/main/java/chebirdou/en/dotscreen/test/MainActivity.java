package chebirdou.en.dotscreen.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button logIn;
    private EditText player1, player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        player1 = (EditText) findViewById(R.id.editTextPlayer1);
        player2  = (EditText) findViewById(R.id.editTextPlayer2);
        logIn = findViewById(R.id.buttonLogin);

        logIn.setOnClickListener(view -> go());
    }

    private void go() {
        String p1;
        String p2;
        p1 = player1.getText().toString();
        p2 = player2.getText().toString();
        if (p1.equals("")){
            p1 = "Player1";
        }
        if (p2.equals("")){
            p2 = "Player2";
        }
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        Bundle b = new Bundle();
        b.putString("p1", p1);
        b.putString("p2", p2);
        intent.putExtras(b);
        startActivity(intent);
        //startActivity(new Intent(MainActivity.this, MainActivity2.class));
    }
}