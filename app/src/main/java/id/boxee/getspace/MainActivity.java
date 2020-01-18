package id.boxee.getspace;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import id.boxee.getspace.ui.components.BottomSheetDialogFragment;
import id.boxee.getspace.ui.activityx.ActivityxFragment;
import id.boxee.getspace.ui.calendar.CalendarFragment;
import id.boxee.getspace.ui.chat.ChatFragment;
import id.boxee.getspace.ui.mail.MailFragment;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabMain;
    private LinearLayout    linearLayout;
    private BottomSheetBehavior     bottomSheetBehavior;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        removeActionBar();
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = new AppBarConfiguration.Builder(
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
//                        Toast.makeText(getApplicationContext(), "FAB", Toast.LENGTH_SHORT).show();
                        showDialogFragmentBottomSheet();
//                        showFragmentBottomSheet();
                        item.setChecked(true);
                        break;
                    case R.id.navigation_activity:
                        item.setChecked(true);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, ActivityxFragment.newInstance(), "frag_activityx")
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.navigation_messenger:
                        item.setChecked(true);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, ChatFragment.newInstance(), "frag_chat")
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.navigation_calendar:
                        item.setChecked(true);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, CalendarFragment.newInstance(), "frag_calendar")
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.navigation_mail:
                        item.setChecked(true);
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_sweet, menu);
//        return true;
//    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        Toast.makeText(getApplicationContext(), "testest", Toast.LENGTH_LONG).show();
//        return true;
//    }


    public void removeActionBar() {
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
    }

    private void showDialogFragmentBottomSheet(){
        View dialogView = getLayoutInflater().inflate(R.layout.fragment_bottom_sheet, null);
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(dialogView);
        dialog.show();
    }

    private void showFragmentBottomSheet(){
        BottomSheetDialogFragment bottomSheetFragment = new BottomSheetDialogFragment();
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
    }



}
