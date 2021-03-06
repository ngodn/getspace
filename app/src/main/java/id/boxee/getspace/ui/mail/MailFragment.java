package id.boxee.getspace.ui.mail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import id.boxee.getspace.R;

public class MailFragment extends Fragment {

    private MailViewModel mailViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mailViewModel =
                ViewModelProviders.of(this).get(MailViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mail, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        mailViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    public static MailFragment newInstance() {
        return new MailFragment();
    }
}