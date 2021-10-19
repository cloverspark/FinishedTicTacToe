package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button TopLeftBtn;
    private Button TopMidBtn;
    private Button TopRightBtn;
    private Button MidLeftBtn;
    private Button CenterBtn;
    private Button MidRightBtn;
    private Button BottomLeftBtn;
    private Button BottomMidBtn;
    private Button BottomRightBtn;
    private Button NewGameBtn;
    private Button[] Buttons;
    private String UnusedBtn;
    private  int playerTurn;
    private TextView PlayersTxtBox;
    private  int clickCounter;
    private  boolean clickable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UnusedBtn = "";
        TopLeftBtn = findViewById(R.id.TopLeftBtn);
        TopMidBtn = findViewById(R.id.TopMidBtn);
        TopRightBtn = findViewById(R.id.TopRightBtn);
        MidLeftBtn = findViewById(R.id.MidLeftBtn);
        CenterBtn = findViewById(R.id.CenterBtn);
        MidRightBtn = findViewById(R.id.MidRightBtn);
        BottomLeftBtn = findViewById(R.id.BottomLeftBtn);
        BottomMidBtn = findViewById(R.id.BottomMidBtn);
        BottomRightBtn = findViewById(R.id.BottomRightBtn);
        Buttons = new Button[] {TopLeftBtn,TopMidBtn,TopRightBtn,MidLeftBtn,CenterBtn,MidRightBtn,BottomLeftBtn,BottomMidBtn,BottomRightBtn };
        NewGameBtn = findViewById(R.id.NewGameBtn);
        PlayersTxtBox = findViewById(R.id.PlayersTxtBox);
        clickCounter = 0;
        clickable = true;


    }
    public void resetOnClick(View view){
        for(int i = 0; i < Buttons.length; i++){
            Buttons[i].setText("");
        }
        PlayersTxtBox.setText("Player X's turn");
        playerTurn = 0;
        clickCounter = 0;
        clickable = true;
    }
    public void player0(){
        PlayersTxtBox.setText("Player X's turn");
        playerTurn = 0;
    }
    public void player1(){
        PlayersTxtBox.setText("Player O's turn");;
        playerTurn = 1;
    }

    public void onClick(View view) {

        Button clickedButton = (Button) findViewById(view.getId());
        if (PlayersTxtBox.getText().equals("Player O Wins")){
            PlayersTxtBox.setText(" Player O won Start new game");
        }
        if (PlayersTxtBox.getText().equals("Player X Wins")){
            PlayersTxtBox.setText(" Player X won Start new game");
        }
        if (UnusedBtn.contentEquals(clickedButton.getText()) && playerTurn == 0 && clickable == true) {
            clickedButton.setText("X");
            player1();
            clickCounter++;
            winner();

        }
        if (UnusedBtn.contentEquals(clickedButton.getText()) && playerTurn == 1 && clickable == true) {
            clickedButton.setText("O");
            player0();
            clickCounter++;
            winner();
        }
    }


    public void winner() {
        if(clickCounter == 9){
            PlayersTxtBox.setText("Draw");
        }
        if(Buttons[0].getText().equals("O") && Buttons[1].getText().equals("O") && Buttons[2].getText().equals("O")||
           Buttons[3].getText().equals("O") && Buttons[4].getText().equals("O") && Buttons[5].getText().equals("O")||
           Buttons[6].getText().equals("O") && Buttons[7].getText().equals("O") && Buttons[8].getText().equals("O")||
           Buttons[0].getText().equals("O") && Buttons[3].getText().equals("O") && Buttons[6].getText().equals("O")||
           Buttons[1].getText().equals("O") && Buttons[4].getText().equals("O") && Buttons[7].getText().equals("O")||
           Buttons[2].getText().equals("O") && Buttons[5].getText().equals("O") && Buttons[8].getText().equals("O")||
           Buttons[0].getText().equals("O") && Buttons[4].getText().equals("O") && Buttons[8].getText().equals("O")||
           Buttons[2].getText().equals("O") && Buttons[4].getText().equals("O") && Buttons[6].getText().equals("O")
        ){
            PlayersTxtBox.setText("Player O Wins");
            clickable = false;
        }
        if(Buttons[0].getText().equals("X") && Buttons[1].getText().equals("X") && Buttons[2].getText().equals("X")||
           Buttons[3].getText().equals("X") && Buttons[4].getText().equals("X") && Buttons[5].getText().equals("X")||
           Buttons[6].getText().equals("X") && Buttons[7].getText().equals("X") && Buttons[8].getText().equals("X")||
           Buttons[0].getText().equals("X") && Buttons[3].getText().equals("X") && Buttons[6].getText().equals("X")||
           Buttons[1].getText().equals("X") && Buttons[4].getText().equals("X") && Buttons[7].getText().equals("X")||
           Buttons[2].getText().equals("X") && Buttons[5].getText().equals("X") && Buttons[8].getText().equals("X")||
           Buttons[0].getText().equals("X") && Buttons[4].getText().equals("X") && Buttons[8].getText().equals("X")||
           Buttons[2].getText().equals("X") && Buttons[4].getText().equals("X") && Buttons[6].getText().equals("X")
        ){
            PlayersTxtBox.setText("Player X Wins");
            clickable = false;
        }
    }
}