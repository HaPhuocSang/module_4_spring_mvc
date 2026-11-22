package org.example.musicmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "song_title", nullable = false)
    private String songTitle;
    @Column(name = "performing_artist", nullable = false)
    private String performingArtist;
    @Column(name = "music_genre", nullable = false)
    private String musicGenre;
}
