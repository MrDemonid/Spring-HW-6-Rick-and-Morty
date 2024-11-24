package mr.demonid.spring.hw6.exceptions;

public class PageNotFoundException extends AppBaseException {
    private Integer pageNumber;

    public PageNotFoundException(Integer page) {
        pageNumber = page;
    }

    @Override
    public String getMessage() {
        return "Страница " + pageNumber + " не найдена!";
    }
}
