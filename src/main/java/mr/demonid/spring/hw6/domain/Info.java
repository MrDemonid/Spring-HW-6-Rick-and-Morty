package mr.demonid.spring.hw6.domain;

import lombok.Data;

@Data
public class Info {
    private Integer count;  // The length of the response
    private Integer pages;  // The amount of pages
    private String next;    // Link to the next page (if it exists)
    private String prev;    // Link to the previous page (if it exists)
}

/*
Пример:
GET https://rickandmortyapi.com/api/character

return:
{
  "info": {
    "count": 826,
    "pages": 42,
    "next": "https://rickandmortyapi.com/api/character/?page=2",
    "prev": null
  },
  "results": [
    // ...
  ]
}

Запрос на определенную страницу:
https://rickandmortyapi.com/api/character/?page=19
 */
