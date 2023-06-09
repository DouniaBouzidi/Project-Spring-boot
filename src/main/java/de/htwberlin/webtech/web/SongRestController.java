package de.htwberlin.webtech.web;


import de.htwberlin.webtech.service.SongService;
import de.htwberlin.webtech.web.api.Song;
import de.htwberlin.webtech.web.api.SongCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SongRestController {
    @Autowired
    private final SongService songService;

    public SongRestController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping(path = "/api/v1/songs")
    public ResponseEntity<List<Song>> fetchSongs() {
        return ResponseEntity.ok(songService.findAll());
    }

    @GetMapping(path = "/api/v1/songs/favorites")
    public ResponseEntity<List<Song>> fetchFavoriteSongs() {
        return ResponseEntity.ok(songService.findAllIsFavoriteTrue());
    }

    @GetMapping(path = "/api/v1/songs/{id}")
    public ResponseEntity<Song> fetchSongsById(@PathVariable Long id) {
        var song = songService.findById(id);
        return song != null ? ResponseEntity.ok(song) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/songs")
    public ResponseEntity<Long> createSong(@RequestBody SongCreateRequest request) {
        var song = songService.create(request);
        return ResponseEntity.ok(song.getId());
    }

    @PutMapping(path = "/api/v1/songs/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id, @RequestBody SongCreateRequest request) {
        var song = songService.update(id, request);
        return song != null ? ResponseEntity.ok(song) : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/api/v1/songs/favorites/{id}")
    public ResponseEntity<Song> updateIsFavorite(@PathVariable Long id, @RequestBody SongCreateRequest request) {
        var song = songService.updateIsFavorite(id, request);
        return song != null ? ResponseEntity.ok(song) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/songs/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        boolean successful = songService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
