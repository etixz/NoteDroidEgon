package eb.egonb.notedroidegon.model;

import java.time.LocalDate;
import java.util.Date;

public class Note {

    private String titel;
    private String inhoud;
    private LocalDate aanmaakDatum;

    public Note(String titel, String inhoud, LocalDate aanmaakDatum) {
        this.titel = titel;
        this.inhoud = inhoud;
        this.aanmaakDatum = aanmaakDatum;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getInhoud() {
        return inhoud;
    }

    public void setInhoud(String inhoud) {
        this.inhoud = inhoud;
    }

    public LocalDate getAanmaakDatum() {
        return aanmaakDatum;
    }

    public void setAanmaakDatum(LocalDate aanmaakDatum) {
        this.aanmaakDatum = aanmaakDatum;
    }
}
