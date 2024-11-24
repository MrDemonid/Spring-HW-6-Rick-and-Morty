package mr.demonid.spring.hw6.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationLink {
    private Integer number;       // Номер страницы
    private Boolean current;  // Текущая страница
    private String url;       // URL для данной страницы

}
