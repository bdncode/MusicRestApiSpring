package org.mypackage.musicLibrarySpring.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Albums")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Album {
    @Id
    @GeneratedValue
    private int id;
    private int artist;
    @Column(name = "albumname")
    private String albumName;
    @Column(name = "releaseyear")
    private String releaseYear;
    @Column(name = "storedindb")
    private Date storedInDb = new Date();
}
