package org.example.musicmanagement.converter;

import org.example.musicmanagement.dto.MusicDto;
import org.example.musicmanagement.entity.Music;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MusicToMusicDtoConverter implements Converter<Music, MusicDto> {
    @Override
    public MusicDto convert(Music music) {
        return new MusicDto(music.getId(), music.getSongTitle(), music.getPerformingArtist(), music.getMusicGenre());
    }
}
