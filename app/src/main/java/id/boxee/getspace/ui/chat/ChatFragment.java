package id.boxee.getspace.ui.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import id.boxee.getspace.ContactPickerActivity;
import id.boxee.getspace.R;

public class ChatFragment extends Fragment {

    private ChatViewModel chatViewModel;
    private FloatingActionButton fabMain;

    private ImageView actionStartChat;
    private Button    buttonGetStarted;


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_chat, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        chatViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Toolbar toolbar = view.findViewById(getToolbarRes());
        toolbar.setVisibility(View.VISIBLE);

//        buttonGetStarted = view.findViewById(R.id.button_getstarted);
//        buttonGetStarted.setOnClickListener(v -> {
//            Toast.makeText(getContext(), "cont", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(getContext(), ContactPickerActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
//        });

        actionStartChat = view.findViewById(R.id.action_start_chat);
        actionStartChat.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ContactPickerActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }

    protected @IdRes
    int getToolbarRes() {
        return R.id.toolbar;
    }

    public static ChatFragment newInstance() {
        return new ChatFragment();
    }

}