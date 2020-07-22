package org.mypackage.musicLibrarySpring.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Artists")
@Data

public class Artist {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "artistname")
    private String artistName;
    private String genre;
}
