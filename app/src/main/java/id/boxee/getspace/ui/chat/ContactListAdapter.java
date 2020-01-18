package id.boxee.getspace.ui.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import id.boxee.getspace.ContactPickerActivity;
import id.boxee.getspace.R;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactListItemViewHolder> {


    private ArrayList<ContactListItem> dataList;

    public ContactListAdapter(ArrayList<ContactListItem> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ContactListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.contact_list_item, parent, false);
        return new ContactListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactListItemViewHolder holder, int position) {
        holder.contactName.setText(dataList.get(position).getContactName());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ContactListItemViewHolder extends RecyclerView.ViewHolder{
        private TextView contactName;

        public ContactListItemViewHolder(View itemView) {
            super(itemView);
            contactName = (TextView) itemView.findViewById(R.id.contactName);
        }
    }
}
