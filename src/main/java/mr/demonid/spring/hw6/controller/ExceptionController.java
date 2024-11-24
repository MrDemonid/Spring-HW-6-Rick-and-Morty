package mr.demonid.spring.hw6.controller;

import mr.demonid.spring.hw6.exceptions.AppBaseException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Обработчик исключений.
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(AppBaseException.class)
    public String handleAppBaseException(AppBaseException e, Model model) {
        model.addAttribute("errorMessage", "Ошибка загрузки данных");
        model.addAttribute("errorDetails", e.getMessage());
        return "error";
    }

}
