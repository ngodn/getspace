package id.boxee.getspace.ui.apps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import id.boxee.getspace.R;
import id.boxee.getspace.ui.activityx.ActivityxViewModel;

public class AppsFragment extends Fragment {

    private FloatingActionButton fabMain;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_apps, container, false);


        return root;
    }

    public static AppsFragment newInstance() {
        return new AppsFragment();
    }


}