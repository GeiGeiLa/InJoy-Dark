package com.example.injoy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
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
    /**
     * https://medium.com/@archerwei/android-popupwindow-%E5%BD%88%E5%87%BA%E8%A6%96%E7%AA%97-4d3b0b6f834c
     */
    PopupWindow popupWindow;
    View containerView;
    BottomNavigationView navbar;
    ImageView popup_close_btn;
    int firstDayOfThisWeek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        initUI();

    }
    ImageView[] bubbles = new ImageView[5];
    private void initUI()
    {
//        loadBubbles();
        bubbleCounter = 0;
        navbar = findViewById(R.id.bottomNavigationView);
        drinkButton = findViewById(R.id.drink_button);
        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("F","Clicked drink");

                Snackbar sb = Snackbar.make(v, "First date: "+firstDayOfThisWeek , Snackbar.LENGTH_LONG)
                        .setAction("Action", null);
                // prevent snackbar message blocking the nav bar
                sb.setAnchorView(navbar);
                sb.show();
                loadPopup();
            }
        }); // end setOnClickListener
        // make sure that "home" is selected on app start
        navbar.setSelectedItemId(R.id.home);

    }
    private void changeBubbleColors()
    {
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
    private void loadPopup()
    {
        containerView = LayoutInflater.from(this).inflate(R.layout.popup_container, null);
        popupWindow = new PopupWindow(containerView);
        // Must explicitly set w and h
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // null
//        popup_close_btn = findViewById(R.id.close_btn);
        popup_close_btn = containerView.findViewById(R.id.close_btn);
        popup_close_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                popupWindow.dismiss();
            }
        });

        popupWindow.showAtLocation(containerView, Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    private void loadBubbles()
    {
        bubbles[0] = findViewById(R.id.bubble0);
        bubbles[1] = findViewById(R.id.bubble1);
        bubbles[2] = findViewById(R.id.bubble3);
        bubbles[3] = findViewById(R.id.bubble4);
    }
}