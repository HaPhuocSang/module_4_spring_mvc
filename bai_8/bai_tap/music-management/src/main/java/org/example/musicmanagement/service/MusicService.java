package org.example.musicmanagement.service;

import org.example.musicmanagement.converter.MusicDtoToMusicConverter;
import org.example.musicmanagement.converter.MusicToMusicDtoConverter;
import org.example.musicmanagement.dto.MusicDto;
import org.example.musicmanagement.entity.Music;
import org.example.musicmanagement.repository.IMusicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class MusicService implements IMusicService {
    private final IMusicRepository musicRepository;
    private final MusicDtoToMusicConverter musicDtoToMusicConverter;
    private final MusicToMusicDtoConverter musicToMusicDtoConverter;

    public MusicService(IMusicRepository musicRepository, MusicDtoToMusicConverter musicDtoToMusicConverter, MusicToMusicDtoConverter musicToMusicDtoConverter) {
        this.musicRepository = musicRepository;
        this.musicDtoToMusicConverter = musicDtoToMusicConverter;
        this.musicToMusicDtoConverter = musicToMusicDtoConverter;
    }

    @Override
    public Page<MusicDto> findAll(Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Music> musicPage = musicRepository.findAll(pageable);
        return musicPage.map(musicToMusicDtoConverter::convert);
    }

    @Override
    public boolean create(MusicDto musicDto) {
        if (musicDto.getId() != null) {
            return false;
        }
        musicRepository.save(Objects.requireNonNull(musicDtoToMusicConverter.convert(musicDto)));
        return true;
    }

    @Override
    public Optional<MusicDto> findById(Long id) {
        Optional<Music> musicOptional = musicRepository.findById(id);
        return musicOptional.map(musicToMusicDtoConverter::convert);
    }

    @Override
    public boolean update(MusicDto musicDto) {
        if (musicRepository.findById(musicDto.getId()).isPresent()) {
            musicRepository.save(Objects.requireNonNull(musicDtoToMusicConverter.convert(musicDto)));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (musicRepository.findById(id).isPresent()) {
            musicRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
