package id.boxee.getspace.ui.activityx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.boxee.getspace.R;

public class ActivityxListAdapter extends RecyclerView.Adapter<ActivityxListAdapter.ContactListItemViewHolder> {


    private ArrayList<ActivityxListItem> dataList;

    public ActivityxListAdapter(ArrayList<ActivityxListItem> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ContactListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_activity_list, parent, false);
        return new ContactListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactListItemViewHolder holder, int position) {
        holder.taskName.setText(dataList.get(position).getTaskName());
        holder.userAction.setText(dataList.get(position).getUserAction());
        holder.description.setText(dataList.get(position).getDescription());
        holder.activityTime.setText(dataList.get(position).getActivityTime());
        holder.activityIcon.setImageResource(dataList.get(position).getActivityIcon());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ContactListItemViewHolder extends RecyclerView.ViewHolder{
        private TextView taskName, userAction, description, activityTime;
        private ImageView activityIcon;

        public ContactListItemViewHolder(View itemView) {
            super(itemView);
            taskName = (TextView) itemView.findViewById(R.id.taskName);
            userAction = (TextView) itemView.findViewById(R.id.user_action_text);
            description = (TextView) itemView.findViewById(R.id.description_text);
            activityTime = (TextView) itemView.findViewById(R.id.activity_time);
            activityIcon = (ImageView) itemView.findViewById(R.id.activity_icon);
        }
    }
}
