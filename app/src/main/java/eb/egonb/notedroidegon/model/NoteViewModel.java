package eb.egonb.notedroidegon.model;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class NoteViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Note>> notes;

    public MutableLiveData<ArrayList<Note>> getNotes(){
        if(notes == null){
            notes = new MutableLiveData<>();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                loadNotes();
            }
        }
        return notes;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void loadNotes(){
        ArrayList<Note> newNotes = new ArrayList<>();

        newNotes.add(new Note("Dit is een test", "test test test", LocalDate.now()));

        notes.setValue(newNotes);
    }
}
