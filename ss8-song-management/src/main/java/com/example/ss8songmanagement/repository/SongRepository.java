package com.example.ss8songmanagement.repository;

import com.example.ss8songmanagement.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}