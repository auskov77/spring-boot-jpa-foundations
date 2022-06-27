package ru.itsjava.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itsjava.domain.Film;
import ru.itsjava.rest.dto.FilmDto;
import ru.itsjava.services.FilmService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FilmController {
    private final FilmService filmService;

    @GetMapping("/film")
    public String filmsPage(Model model) {
        List<Film> allFilms = filmService.getAllFilms();
        List<FilmDto> filmDtos = new ArrayList<>();

        for (Film film : allFilms) {
            filmDtos.add(FilmDto.toDto(film));
        }

        model.addAttribute("films", filmDtos);
        return "films-page";
    }
}
