package org.example.musicmanagement.service;

import org.example.musicmanagement.dto.MusicDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IMusicService {
    Page<MusicDto> findAll(Integer page, Integer size);
    boolean create(MusicDto musicDto);
    Optional<MusicDto> findById(Long id);
    boolean update(MusicDto musicDto);
    boolean delete(Long id);

}
