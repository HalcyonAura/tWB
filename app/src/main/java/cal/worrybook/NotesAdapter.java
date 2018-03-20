package cal.worrybook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by C on 3/19/2018.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private List<Notes> notesList;

    private final Context mContext;
    itemClickListener listener;

    public NotesAdapter(List<Notes> notesList, Context mContext){
        this.mContext = mContext;
        this.notesList = notesList;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView fileName, fileContent;
        private final Context context;
        public ViewHolder(View v){
            super(v);
            context = v.getContext();
            fileName = (TextView) v.findViewById(R.id.fileName);
            fileContent = (TextView) v.findViewById(R.id.fileContent);
            v.setClickable(true);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            final Intent intent;
            int position = getAdapterPosition();
            intent = new Intent(context, NoteView.class).putExtra("fileName", notesList.get(position).getFileName());
            mContext.startActivity(intent);
        }
    }

    // Needed by layout manager

    // Replace the contents of a view
    // Create new views
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        final ViewHolder vh = new ViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, vh.getAdapterPosition());
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Notes note = notesList.get(position);
        holder.fileName.setText(note.getFileName());
        holder.fileContent.setText(note.getContent());
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    //TODO - To implement later
    /*public void notifyItemChanged(int position){
    }*/

    public interface itemClickListener {
        public void onItemClick(View v, int position);
    }
}