package id.boxee.getspace;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.boxee.getspace.ui.chat.ContactListAdapter;
import id.boxee.getspace.ui.chat.ContactListItem;

public class ContactPickerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ContactListAdapter contactListAdapter;
    private ArrayList<ContactListItem> contactListItemArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeActionBar();
        setContentView(R.layout.activity_contact_picker);

        addData();
        recyclerView    = (RecyclerView) findViewById(R.id.recycler_view_contact_list);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        contactListAdapter   = new ContactListAdapter(contactListItemArrayList);
        recyclerView.setAdapter(contactListAdapter);

    }

    public void removeActionBar() {
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
    }

    void addData(){
        contactListItemArrayList = new ArrayList<>();
        contactListItemArrayList.add(new ContactListItem("Denny"));
        contactListItemArrayList.add(new ContactListItem("Teguh"));
    }
}
