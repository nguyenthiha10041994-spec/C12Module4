package com.example.ss8songmanagement.service;

import com.example.ss8songmanagement.entity.Song;
import com.example.ss8songmanagement.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    public void save(Song song) {
        songRepository.save(song);
    }

    public void delete(Long id) {
        songRepository.deleteById(id);
    }
}