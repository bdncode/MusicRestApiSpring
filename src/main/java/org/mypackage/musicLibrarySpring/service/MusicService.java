package org.mypackage.musicLibrarySpring.service;

import org.mypackage.musicLibrarySpring.model.Artist;
import org.mypackage.musicLibrarySpring.repository.AlbumDao;
import org.mypackage.musicLibrarySpring.model.Album;
import org.mypackage.musicLibrarySpring.repository.ArtistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MusicService {

    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private ArtistDao artistDao;

    public List<Artist> getArtists() {
        return (List<Artist>) artistDao.findAll();
    }

    public List<Album> getAlbums() {
        return (List<Album>) albumDao.findAll();
    }

    public List<Album> getAlbumsByYear(String year){
        return albumDao.findByReleaseYearOrderByAlbumName(year);
    }

    public void postArtist(Artist artist) {
        artistDao.save(artist);
    }

    public void postAlbum(Album album) { albumDao.save(album); }

    public void updateArtist(int id, Artist artist) throws Exception {
        Artist findArtist = artistDao.findById(id).
                orElseThrow(() -> new Exception("Data not found for this id"));

        findArtist.setArtistName(artist.getArtistName());
        findArtist.setGenre(artist.getGenre());
        artistDao.save(findArtist);
    }

    public void deleteArtist(int id) {
        artistDao.deleteById(id);
    }

    public void deleteAlbum(int id) { albumDao.deleteById(id); }
}
