package mr.demonid.spring.hw6.util;

import lombok.Data;
import mr.demonid.spring.hw6.config.ConfigUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для создания кнопок перехода по страницам.
 */
@Component
@Data
public class Pagination {

    @Autowired
    ConfigUI config;

    List<PaginationLink> pages = new ArrayList<>();

    public void clear() {
        pages.clear();
    }

    public void addPage(Integer number, Boolean current, String url)
    {
        pages.add(new PaginationLink(number, current, url));
    }

    /**
     * Настройка пагинатора
     * @param page       Текущая страница
     * @param totalPages Всего страниц
     */
    public void calculate(Integer page, Integer totalPages, String url) {
        int maxButtons = config.getWindowPageSize();
        int startPage = Math.max(1, page - maxButtons / 2);
        int endPage = Math.min(totalPages, startPage + maxButtons - 1);
        if (endPage - startPage + 1 < maxButtons) {
            startPage = Math.max(1, endPage - maxButtons + 1);
        }
        clear();
        for (int i = startPage; i <= endPage; i++) {
            addPage(i, page == i, url + i);
        }
    }

}
