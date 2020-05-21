package com.fashi.udacity_capstone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.fashi.udacity_capstone.R;
import com.fashi.udacity_capstone.database.ProfileEntry;

import java.util.ArrayList;
import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.TaskViewHolder>  {

    // Member variable to handle item clicks
    final private ItemClickListener mItemClickListener;
    // Class variables for the List that holds task data and the Context
    private List<ProfileEntry> mProfileEntries;
   // private List<ProfileEntry> mProfileEntriesFull;
    private Context mContext;

    public ProfileAdapter(Context context, ItemClickListener listener) {
        mContext = context;
        mItemClickListener = listener;
       // mProfileEntriesFull = new ArrayList<>(mProfileEntries);
    }


    /**
     * Called when ViewHolders are created to fill a RecyclerView.
     *
     * @return A new TaskViewHolder that holds the view for each task
     */
    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the task_layout to a view
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.list_item_home, parent, false);

        return new TaskViewHolder(view);
    }

    /**
     * Called by the RecyclerView to display data at a specified position in the Cursor.
     *
     * @param holder   The ViewHolder to bind Cursor data to
     * @param position The position of the data in the Cursor
     */
    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        // Determine the values of the wanted data
        ProfileEntry profileEntry = mProfileEntries.get(position);
        String description = profileEntry.getFirstName();

        holder.taskDescriptionView.setText(description);

    }

    /**
     * Returns the number of items to display.
     */
    @Override
    public int getItemCount() {
        if (mProfileEntries == null) {
            return 0;
        }
        return mProfileEntries.size();
    }

    public List<ProfileEntry> getProfiles() {
        return mProfileEntries;
    }

    /**
     * When data changes, this method updates the list of taskEntries
     * and notifies the adapter to use the new values on it
     */
    public void setTasks(List<ProfileEntry> profileEntries) {
        mProfileEntries = profileEntries;
        notifyDataSetChanged();
    }

    public interface ItemClickListener {
        void onItemClickListener(int itemId);
    }

    // Inner class for creating ViewHolders
    class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // Class variables for the task description and priority TextViews
        TextView taskDescriptionView;

        public TaskViewHolder(View itemView) {
            super(itemView);


            taskDescriptionView = itemView.findViewById(R.id.customerName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int elementId = mProfileEntries.get(getAdapterPosition()).getId();
            mItemClickListener.onItemClickListener(elementId);
        }
    }

//    @Override
//    public Filter getFilter() {
//        return profileFilter;
//    }
//
//    private Filter profileFilter = new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence charSequence) {
//            List<ProfileEntry> filteredList = new ArrayList<>();
//
//            if (charSequence == null || charSequence.length() == 0) {
//                filteredList.addAll(mProfileEntriesFull);
//            } else {
//                String filterPattern = charSequence.toString().toLowerCase().trim();
//
//                for (ProfileEntry item : mProfileEntriesFull) {
//                    if (item.getFirstName().toLowerCase().contains(filterPattern)) {
//                        filteredList.add(item);
//                    }
//
//                }
//            }
//            FilterResults results = new FilterResults();
//            results.values = filteredList;
//            return  results;
//        }
//
//
//        @Override
//        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//            mProfileEntries.clear();
//            mProfileEntries.addAll((List)filterResults.values);
//            notifyDataSetChanged();
//        }
//    };
}