package eb.egonb.notedroidegon.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import eb.egonb.notedroidegon.R;
import eb.egonb.notedroidegon.model.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> implements Filterable {


    @Override
    public Filter getFilter() {
        return null;
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{

        final TextView tvTitel;
        final Button btnDetails;
        final TextView tvAanmaaktdatum;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitel = itemView.findViewById(R.id.tv_titel);
            btnDetails = itemView.findViewById(R.id.btn_detail);
            tvAanmaaktdatum = itemView.findViewById(R.id.tv_aanmaaktdatum);
        }
    }


    private ArrayList<Note> notes;




    public NoteAdapter(){
        notes = new ArrayList<>();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View card = layoutInflater.inflate(R.layout.note_card, parent, false);

        return new NoteViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.tvTitel.setText(currentNote.getTitel());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void addItems(ArrayList<Note> items){
        notes.clear();
        notes.addAll(items);
    }

}
