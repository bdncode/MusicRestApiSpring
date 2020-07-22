package org.mypackage.musicLibrarySpring.repository;

import org.mypackage.musicLibrarySpring.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistDao extends CrudRepository<Artist,Integer> {
}
