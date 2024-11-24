package mr.demonid.spring.hw6.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import mr.demonid.spring.hw6.config.ConfigUI;
import mr.demonid.spring.hw6.domain.AllCharacters;
import mr.demonid.spring.hw6.domain.Characters;
import mr.demonid.spring.hw6.domain.Location;
import mr.demonid.spring.hw6.services.CharacterService;
import mr.demonid.spring.hw6.services.Filter;
import mr.demonid.spring.hw6.util.Pagination;
import mr.demonid.spring.hw6.util.UrlUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@Controller
public class ViewController {

    CharacterService characterService;
    UrlUtil urlUtil;
    Pagination pagenation;
    Filter filter;


    @GetMapping
    public String getFirstPage(Model model) {
        return "redirect:/characters?page=1";

    }

    /**
     * Отображает очередную страницу со списком персонажей.
     * @param page Номер страницы
     */
    @GetMapping("/characters")
    public String getPage(Model model, @RequestParam Integer page) {

        AllCharacters characters = characterService.getCharactersPage(page);

        // создаём список страниц для удобного перехода
        pagenation.calculate(page, characters.getInfo().getPages(), "/characters?page=");

        // URL для кнопок предыдущей и следующей страниц
        String prevPageUrl = getPage(characters.getInfo().getPrev());
        String nextPageUrl = getPage(characters.getInfo().getNext());

        // Добавляем данные в модель
        model.addAttribute("characters", characters);
        model.addAttribute("prevPageUrl", prevPageUrl);
        model.addAttribute("nextPageUrl", nextPageUrl);
        model.addAttribute("pages", pagenation.getPages());

        return "/page-characters";
    }

    /**
     * Страница с данными о персонаже
     * @param id Идентификатор персонажа
     */
    @GetMapping("characters/details/{id}")
    public String showCharacter(Model model, @PathVariable Long id) {
        Characters character = characterService.getCharacterById(id);
        model.addAttribute("character", character);
        return "/page-character";
    }

    /**
     * Страница с детализацией локации.
     */
    @PostMapping("/locations/details")
    public String showLocate(Model model, @ModelAttribute Location location) {
        model.addAttribute("location", location);
        return "/page-location";
    }

    @GetMapping("characters/filter")
    public String showCharacterFilter(Model model) {
        model.addAttribute("statuses", filter.getStatuses());
        model.addAttribute("genders", filter.getGenders());
        model.addAttribute("speciesList", filter.getSpecieses());
        return "/filter";
    }

    /**
     * Создание или сброс фильтра.
     */
    @PostMapping("/filter/apply")
    public String applyFilter(@RequestParam String status,
                              @RequestParam String gender,
                              @RequestParam String species,
                              @RequestParam String type) {
        filter.clear();
        if (!status.isBlank()) {
            filter.setCurrentStatus(status);
        }
        if (!gender.isBlank()) {
            filter.setCurrentGender(gender);
        }
        if (!species.isBlank()) {
            filter.setCurrentSpecies(species);
        }
        if (!type.isBlank()) {
            filter.setCurrentType(type);
        }
        return "redirect:/";        // новый фильтр начинаем с первой страницы.
    }

    /**
     * Извлекает из URL параметр page и формирует локальный адрес с номером страницы
     */
    private String getPage(String url) {
        try {
            return "/characters?page=" + UriComponentsBuilder.fromUriString(url).build().getQueryParams().get("page").get(0);
        } catch (Exception e) {
            return null;
        }
    }


}
