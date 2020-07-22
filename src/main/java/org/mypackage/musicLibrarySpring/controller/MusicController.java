package org.mypackage.musicLibrarySpring.controller;

import org.mypackage.musicLibrarySpring.model.Album;
import org.mypackage.musicLibrarySpring.model.Artist;
import org.mypackage.musicLibrarySpring.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = MusicController.BASE_URL)
public class MusicController {

    public static final String BASE_URL = "/api/v1/music";

    @Autowired
    private MusicService musicService;

    @GetMapping(value = "/artists")
    public List<Artist> getArtists() { return musicService.getArtists(); }

    @GetMapping(value = "/albums")
    public List<Album> getAlbums() {
        return musicService.getAlbums();
    }

    @GetMapping(value = "/albums/{year}")
    public List<Album> getAlbumsByYear(@PathVariable String year){ return musicService.getAlbumsByYear(year); }

    @PostMapping(value = "/artist")
    @ResponseStatus(HttpStatus.CREATED)
    public void postArtist(@RequestBody Artist artist) {
        musicService.postArtist(artist);
    }

    @PostMapping(value = "/album")
    @ResponseStatus(HttpStatus.CREATED)
    public void postAlbum(@RequestBody Album album) {
        musicService.postAlbum(album);
    }

    @PutMapping(value = "/artist/{id}")
    public void updateArtist(@PathVariable int id, @RequestBody Artist artist) throws Exception {
        musicService.updateArtist(id,artist);
    }

    @DeleteMapping(value = "/artist/{id}")
    public void deleteArtist(@PathVariable int id) {
        musicService.deleteArtist(id);
    }

    @DeleteMapping(value = "/album/{id}")
    public void deleteAlbum(@PathVariable int id) {
        musicService.deleteAlbum(id);
    }
}