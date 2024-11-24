package mr.demonid.spring.hw6.exceptions;

public class CharacterNotFoundException extends AppBaseException {

    private Long id;

    public CharacterNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Персонаж с ID = " + id + " не найден!";
    }
}
