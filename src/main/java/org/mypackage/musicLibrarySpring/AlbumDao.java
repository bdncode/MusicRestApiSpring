package org.mypackage.musicLibrarySpring;

import org.mypackage.musicLibrarySpring.model.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumDao extends CrudRepository<Album,Integer> {
    List<Album> findByReleaseYearOrderByAlbumName(String year);
}
