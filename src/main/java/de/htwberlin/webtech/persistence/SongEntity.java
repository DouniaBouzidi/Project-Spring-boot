package de.htwberlin.webtech.persistence;
import javax.persistence.*;

@Entity(name = "songs")
public class SongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titel;
    private long releaseYear;
    private String autor;
    private String songLink;
    private boolean isFavorite;

    public SongEntity( String titel, long releaseYear, String autor, String songLink, boolean isFavorite) {
        this.titel = titel;
        this.releaseYear = releaseYear;
        this.autor = autor;
        this.songLink = songLink;
        this.isFavorite = isFavorite;
    }

    protected SongEntity() {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(long releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
