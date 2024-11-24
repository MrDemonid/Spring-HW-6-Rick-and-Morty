package mr.demonid.spring.hw6.services;

import lombok.AllArgsConstructor;
import mr.demonid.spring.hw6.config.UrlAPI;
import mr.demonid.spring.hw6.domain.AllCharacters;
import mr.demonid.spring.hw6.domain.Characters;
import mr.demonid.spring.hw6.domain.Location;
import mr.demonid.spring.hw6.exceptions.CharacterNotFoundException;
import mr.demonid.spring.hw6.exceptions.PageNotFoundException;
import mr.demonid.spring.hw6.exceptions.UnknownException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@AllArgsConstructor
@Service
public class CharacterServiceImpl implements CharacterService {

    private UrlAPI urlAPI;
    private RestTemplate restTemplate;      // для работы с внешними API
    private HttpHeaders httpHeaders;        // для формирования заголовков запросов
    private Filter filter;

    @Override
    public AllCharacters getCharactersPage(Integer page) {
        String url = urlAPI.getCharacters() + "?page=" + page;
        // добавляем фильтр, если он есть
        String curFilter = filter.getFilterString();
        if (!curFilter.isBlank()) {
            url += "&" + curFilter;
        }
        ResponseEntity<AllCharacters> response = loadObject(AllCharacters.class, url, new AllCharacters());
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        throw new PageNotFoundException(page);
    }

    @Override
    public Characters getCharacterById(Long id) {
        String url = urlAPI.getCharacters() + "/" + id;
        ResponseEntity<Characters> response = loadObject(Characters.class, url, new Characters());
        if (response.getStatusCode().is2xxSuccessful()) {
            // подгружаем локации, это упростит дальнейший код.
            Characters character = response.getBody();
            if (character != null) {
                character.setOriginLocation(loadObject(Location.class, character.getOrigin().getUrl(), new Location()).getBody());
                character.setCurrentLocation(loadObject(Location.class, character.getLocation().getUrl(), new Location()).getBody());
                return character;
            }
        }
        throw new CharacterNotFoundException(id);
    }


    /**
     * Подгружает объект с заданного URL.
     * @param clazz Класс объекта.
     * @param url   Адрес загрузки.
     * @return      Заполненный объект.
     */
    public <T> ResponseEntity<T> loadObject(Class<T> clazz, String url, T def) {
        if (url == null || url.isBlank())
            return ResponseEntity.ok(def);
        try {
            httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            return restTemplate.exchange(url, HttpMethod.GET, entity, clazz);
        } catch (Exception e) {
            throw new UnknownException("Ошибка: " + e.getMessage());
        }
    }

}
