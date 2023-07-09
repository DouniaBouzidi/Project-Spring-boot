package de.htwberlin.webtech.web.api;

public class SongCreateRequest {

    private String title;
    private String author;
    private long releaseYear;
    private String songLink;
    private boolean isFavorite;

    public SongCreateRequest(String title, String author, long releaseYear, String songLink, boolean isFavorite) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.songLink = songLink;
        this.isFavorite = isFavorite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}
