package de.htwberlin.webtech.persistence;
import javax.persistence.*;

@Entity(name = "songs")
public class SongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "releaseYear")
    private long releaseYear;

    @Column(name = "songLink", nullable = false)
    private String songLink;


    @Column(name = "isFavorite", nullable = false)
    private boolean isFavorite;

    public SongEntity(String title, String author, long releaseYear, String songLink, boolean isFavorite) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(long releaseYear) {
        this.releaseYear = releaseYear;
    }


    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }

    public boolean getIsFavorie() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}
