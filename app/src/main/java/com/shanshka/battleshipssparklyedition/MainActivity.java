package com.shanshka.battleshipssparklyedition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
    }

    public void welcomeDone(View v) {
        setContentView(R.layout.place_ships_activity);
        /*
        Show the (empty) board. Show below all Ships that should be placed.
        It would be cool if one could drag and drop the ships to the field.
        Somehow it should be possible to change the orientation of the ships.
        If all ships are placed only then it should be possible to click the
        continue button.
         */
    }

    public void placeShipsDone(View v) {
        /*
        For all ships try to add them to the board. If there is an error,
        display a message. Think about how to handle it besides from that.
        If there is no error show the new Content.
         */
        setContentView(R.layout.main_activity);
        /*
        Display two boards: Above the one of the enemy,
        below the one of the player.
        It should be only possible to click on the enemies board
        and it should be only possible to do so if it's the players turn.
         */
    }
}
