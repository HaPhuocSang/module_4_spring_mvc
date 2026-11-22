package org.example.musicmanagement.controller;

import jakarta.validation.Valid;
import org.example.musicmanagement.dto.MusicDto;
import org.example.musicmanagement.entity.Music;
import org.example.musicmanagement.service.IMusicService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class MusicController {
    private final IMusicService musicService;

    public MusicController(IMusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping
    public String index(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "6") Integer size, Model model) {
        page = Math.max(page, 0);
        size = Math.max(1, Math.min(size, 50));
        Page<MusicDto> musicDtoPage = musicService.findAll(page, size);
        model.addAttribute("musicDtoPage", musicDtoPage);
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("musicDto") MusicDto musicDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        boolean confirm = musicService.create(musicDto);
        redirectAttributes.addFlashAttribute("message", confirm ? "Tạo mới thành công!" : "Tạo mới không thành công!");
        return "redirect:/";
    }

    @GetMapping("{id}/update")
    public String showUpdate(@PathVariable("id") Long id, Model model) {
        Optional<MusicDto> musicDto = musicService.findById(id);
        if (musicDto.isPresent()) {
            model.addAttribute("musicDto", musicDto.get());
            return "update";
        }
        return "404";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("musicDto") MusicDto musicDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        boolean confirm = musicService.update(musicDto);
        redirectAttributes.addFlashAttribute("message", confirm ? "Cập nhật thành công!" : "Cập nhật không thành công!");
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        boolean confirm = musicService.delete(id);
        redirectAttributes.addFlashAttribute("message", confirm ? "Xóa thành công!" : "Xóa không thành công!");
        return "redirect:/";
    }
}
