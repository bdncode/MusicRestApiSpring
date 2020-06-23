package org.mypackage.musicLibrarySpring;

import org.mypackage.musicLibrarySpring.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/music")
public class AlbumController {

    @Autowired
    private AlbumDao albumDao;

    @PostMapping(value = "/album")
    public void postAlbum(@RequestBody Album album) {
        albumDao.save(album);
    }

    @GetMapping(value = "/albums")
    public List<Album> getAlbums() {
        return (List<Album>) albumDao.findAll();
    }

    @RequestMapping(value = "/albums/{year}",method = RequestMethod.GET)
    public List<Album> getAll(@PathVariable String year){
        return albumDao.findByReleaseYearOrderByAlbumName(year);
    }

    @DeleteMapping(value = "/deletealbum/{id}")
    public void deleteAlbum(@PathVariable int id) {
        albumDao.deleteById(id);
    }
}
