package com.example.ss8songmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát không được quá 800 ký tự")
    @Pattern(
            regexp = "^[a-zA-ZÀ-ỹ0-9\\s]+$",
            message = "Tên bài hát không được chứa ký tự đặc biệt"
    )
    private String name;

    @NotBlank(message = "Nghệ sĩ không được để trống")
    @Size(max = 300, message = "Nghệ sĩ không được quá 300 ký tự")
    @Pattern(
            regexp = "^[a-zA-ZÀ-ỹ0-9\\s]+$",
            message = "Nghệ sĩ không được chứa ký tự đặc biệt"
    )
    private String artist;

    @NotBlank(message = "Thể loại không được để trống")
    @Size(max = 1000, message = "Thể loại không được quá 1000 ký tự")
    @Pattern(
            regexp = "^[a-zA-ZÀ-ỹ0-9\\s,]+$",
            message = "Thể loại chỉ được chứa chữ, số, khoảng trắng và dấu phẩy"
    )
    private String genre;

    public Song() {
    }

    public Song(Long id, String name, String artist, String genre) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}