package id.boxee.getspace;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

import id.boxee.getspace.ui.activityx.ActivityxFragment;
import id.boxee.getspace.ui.calendar.CalendarFragment;
import id.boxee.getspace.ui.chat.ChatFragment;
import id.boxee.getspace.ui.mail.MailFragment;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        removeActionBar();
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_activity, R.id.navigation_messenger, R.id.navigation_space, R.id.navigation_calendar, R.id.navigation_mail)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_space:
                        Toast.makeText(getApplicationContext(), "FAB", Toast.LENGTH_SHORT).show();
                        item.setChecked(true);
                        break;
                    case R.id.navigation_activity:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, ActivityxFragment.newInstance(), "frag_activityx")
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.navigation_messenger:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, ChatFragment.newInstance(), "frag_chat")
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.navigation_calendar:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, CalendarFragment.newInstance(), "frag_calendar")
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.navigation_mail:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, MailFragment.newInstance(), "frag_wallet")
                                .addToBackStack(null)
                                .commit();
                        break;
                }
                return false;
            }
        });
    }


    public void removeActionBar() {
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
    }


}
