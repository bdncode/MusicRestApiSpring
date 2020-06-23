package org.mypackage.musicLibrarySpring;

import org.mypackage.musicLibrarySpring.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/music")
public class ArtistController {

    @Autowired
    private ArtistDao artistDao;

    @PostMapping(value = "/artist")
    public void postArtist(@RequestBody Artist artist) {
        artistDao.save(artist);
    }

    @GetMapping(value = "/artists")
    public List<Artist> getArtists() {
        return (List<Artist>) artistDao.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteArtist(@PathVariable int id) {
        artistDao.deleteById(id);
    }
}
