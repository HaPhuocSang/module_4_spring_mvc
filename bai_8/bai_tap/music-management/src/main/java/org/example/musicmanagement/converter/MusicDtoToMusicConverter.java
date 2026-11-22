package org.example.musicmanagement.converter;

import org.example.musicmanagement.dto.MusicDto;
import org.example.musicmanagement.entity.Music;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MusicDtoToMusicConverter implements Converter<MusicDto, Music> {

    @Override
    public Music convert(MusicDto musicDto) {
        return new Music(musicDto.getId(), musicDto.getSongTitle(), musicDto.getPerformingArtist(),  musicDto.getMusicGenre());
    }
}
