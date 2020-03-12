package eb.egonb.notedroidegon.fragments;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import eb.egonb.notedroidegon.R;
import eb.egonb.notedroidegon.model.Note;
import eb.egonb.notedroidegon.model.NoteViewModel;
import eb.egonb.notedroidegon.util.NoteAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListFragment extends Fragment {

    private NoteAdapter adapter;

    public NoteListFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_note_list, container, false);

        RecyclerView rvNotes = rootView.findViewById(R.id.rv_notes);
        rvNotes.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        adapter = new NoteAdapter();
        rvNotes.setAdapter(adapter);


        NoteViewModel model = new ViewModelProvider(this).get(NoteViewModel.class);
        model.getNotes().observe(getViewLifecycleOwner(), new Observer<ArrayList<Note>>() {
            @Override
            public void onChanged(ArrayList<Note> notes) {
                adapter.addItems(notes);
            }
        });

        return rootView;
    }

}
