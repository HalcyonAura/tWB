package cal.worrybook;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

/**
 * Created by C on 3/6/2018.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder>{

    //List of saved notes
    private List<NotesBuilder> notesList;

    OnItemClickListener mItemClickListener;
    public NotesAdapter(List<NotesBuilder> notes){
        this.notesList = notes;
    }

    //Create new views through layout manager
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        /*LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) itemView.getLayoutParams();
        params.height = 8;
        itemView.setLayoutParams(params);*/
        return new ViewHolder(itemView);
    }


    public void onBindViewHolder(ViewHolder holder, int position) {
        NotesBuilder note = notesList.get(position);
        holder.title.setText(note.getTitle());
        holder.content.setText(note.getContent());
    }

    //Allows for reference for each note
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title, content;
        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            title = (TextView) itemLayoutView.findViewById(R.id.title);
            content = (TextView) itemLayoutView.findViewById(R.id.content);
            itemLayoutView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            System.out.println("onClick");
            TextView tv = (TextView) v.findViewById(R.id.title);
            String id = tv.getText().toString();
            mItemClickListener.onItemClick(v, getAdapterPosition(), id); //OnItemClickListener mItemClickListener;
        }
    }
    public interface OnItemClickListener {
        public void onItemClick(View view, int position, String id);
    }
    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }
}