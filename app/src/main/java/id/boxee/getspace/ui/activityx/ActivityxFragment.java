package id.boxee.getspace.ui.activityx;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import id.boxee.getspace.R;

import java.util.ArrayList;

public class ActivityxFragment extends Fragment {

    private ActivityxViewModel activityxViewModel;
    private FloatingActionButton fabMain;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ActivityxListAdapter activityxListAdapter;
    private ArrayList<ActivityxListItem> activityxListItemArrayList;

    private LinearLayout    emptyState;
    private TextView        emptyStateText;

    Handler handler;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_activity, container, false);

        emptyState  = root.findViewById(R.id.empty_state);
        emptyStateText  = root.findViewById(R.id.empty_state_text);
        recyclerView    = root.findViewById(R.id.recycler_view_activity_list);

        addData();


        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                recyclerView.setVisibility(View.VISIBLE);
                emptyState.setVisibility(View.GONE);
                emptyStateText.setVisibility(View.GONE);

                layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                activityxListAdapter   = new ActivityxListAdapter(activityxListItemArrayList);
                recyclerView.setAdapter(activityxListAdapter);

            }
        },3000);

        return root;
    }

    public static ActivityxFragment newInstance() {
        return new ActivityxFragment();
    }

    void addData(){
        activityxListItemArrayList = new ArrayList<>();
        activityxListItemArrayList.add(new ActivityxListItem("Files", "Teguh sent a file", "FY-Report-2019.xlsx", "17:36", R.drawable.ic_paper));
        activityxListItemArrayList.add(new ActivityxListItem("Messenger", "Denny posted a message", "Demo siap dipresentasikan!", "12:01", R.drawable.ic_nav_chat));

    }


}