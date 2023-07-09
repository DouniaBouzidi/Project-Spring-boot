package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.SongEntity;
import de.htwberlin.webtech.persistence.SongRepository;
import de.htwberlin.webtech.web.api.Song;
import de.htwberlin.webtech.web.api.SongCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {
   @Autowired
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> findAll() {
        List<SongEntity> songs = songRepository.findAll();
        return songs.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public List<Song> findAllIsFavoriteTrue() {
        List<SongEntity> songs = songRepository.findAllByIsFavoriteTrue();
        return songs.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }


    public Song findById(Long id) {
        var songEntity = songRepository.findById(id);
        return songEntity.map(this::transformEntity).orElse(null);
    }

    public Song create(SongCreateRequest request) {
        var songEntity = new SongEntity(request.getTitle(), request.getAuthor(), request.getReleaseYear(), request.getSongLink(), request.getIsFavorite());
        songEntity = songRepository.save(songEntity);
        return transformEntity(songEntity);
    }


    public Song update(Long id, SongCreateRequest request) {
        var songEntityOptional = songRepository.findById(id);
        if (songEntityOptional.isEmpty()) {
            return null;
        }
        var songEntity = songEntityOptional.get();
        songEntity.setTitle(request.getTitle());
        songEntity.setAuthor(request.getAuthor());
        songEntity.setReleaseYear(request.getReleaseYear());
        songEntity.setSongLink(request.getSongLink());
        songRepository.save(songEntity);

        return transformEntity(songEntity);
    }

    public Song updateIsFavorite(Long id, SongCreateRequest request) {
        var songEntityOptional = songRepository.findById(id);
        if (songEntityOptional.isEmpty()) {
            return null;
        }
        var songEntity = songEntityOptional.get();
        songEntity.setIsFavorite(request.getIsFavorite());
        songRepository.save(songEntity);

        return transformEntity(songEntity);
    }


    public boolean deleteById(Long id) {
        if (!songRepository.existsById(id)) {
            return false;
        }
        songRepository.deleteById(id);
        return true;
    }


    private Song transformEntity(SongEntity songEntity) {
        return new Song(
                songEntity.getId(),
                songEntity.getTitle(),
                songEntity.getAuthor(),
                songEntity.getReleaseYear(),
                songEntity.getSongLink(),
                songEntity.getIsFavorie());
    }
}
