package mr.demonid.spring.hw6.services;

import mr.demonid.spring.hw6.domain.AllCharacters;
import mr.demonid.spring.hw6.domain.Characters;

public interface CharacterService {

    /**
     * Возвращает список с персонажами для заданной страницы
     * @param page Страница (от 1 до info.pages).
     */
    AllCharacters getCharactersPage(Integer page);

    /**
     * Возвращает данные о конкретном персонаже.
     * @param id Идентификатор персонажа.
     */
    Characters getCharacterById(Long id);

}
