package com.example.injoy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;
import java.util.Calendar;
import android.graphics.Color.*;

public class MainPage extends AppCompatActivity {
    int bubbleCounter;
    FloatingActionButton drinkButton;
    TextView[] tv;
    Calendar cal = Calendar.getInstance();
    BottomNavigationView navbar;
    int firstDayOfThisWeek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        initUI();
        short[] dateNumbers = new short[7];

    }
    ImageView[] bubbles = new ImageView[5];
    private void initUI()
    {
        loadBubbles();
        bubbleCounter = 0;
        navbar = findViewById(R.id.bottomNavigationView);
        drinkButton = findViewById(R.id.drink_button);
        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("F","Clicked drink");

                Snackbar sb = Snackbar.make(v, "First date: "+firstDayOfThisWeek , Snackbar.LENGTH_LONG)
                        .setAction("Action", null);
                // prevent snackbar message covering the nav bar
                sb.setAnchorView(navbar);
                sb.show();
                switch(bubbleCounter)
                {
                    case 0:
                        bubbles[0].setColorFilter(Color.rgb(145,217,253));
                        break;
                    case 1:
                        bubbles[1].setColorFilter(Color.rgb(227 ,195,81));
                        break;
                    case 2:
                        bubbles[2].setColorFilter(Color.rgb(255,128,128));
                        break;
                    case 3:
                        bubbles[3].setColorFilter(Color.rgb(159,255,175));
                        break;
                    case 4:
                        for(int i = 0; i < 4; i++)
                        {
                            bubbles[i].setColorFilter(Color.rgb(229,229,229));
                        }
                        bubbleCounter = -1;
                        break;
                }
                bubbleCounter++;
            }
        }); // end setOnClickListener
        // make sure that "home" is selected on app start
        navbar.setSelectedItemId(R.id.home);

    }
    private void loadBubbles()
    {
        bubbles[0] = findViewById(R.id.bubble0);
        bubbles[1] = findViewById(R.id.bubble1);
        bubbles[2] = findViewById(R.id.bubble3);
        bubbles[3] = findViewById(R.id.bubble4);
    }
}