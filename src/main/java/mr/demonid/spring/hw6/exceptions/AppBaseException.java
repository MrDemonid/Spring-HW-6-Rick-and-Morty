package mr.demonid.spring.hw6.exceptions;

public abstract class AppBaseException  extends RuntimeException {

    public AppBaseException() {
    }

    public AppBaseException(String message) {
        super(message);
    }

}
