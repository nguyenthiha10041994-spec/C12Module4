package com.example.ss8songmanagement.controller;

import com.example.ss8songmanagement.entity.Song;
import com.example.ss8songmanagement.service.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "song/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("song", new Song());
        return "song/create";
    }

    @PostMapping("/create")
    public String create(
            @Valid @ModelAttribute("song") Song song,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "song/create";
        }

        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model) {

        model.addAttribute("song", songService.findById(id));
        return "song/edit";
    }
    @PostMapping("/edit")
    public String edit(
            @Valid @ModelAttribute("song") Song song,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "song/edit";
        }

        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        songService.delete(id);
        return "redirect:/songs";
    }
}