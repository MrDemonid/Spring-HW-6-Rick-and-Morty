package mr.demonid.spring.hw6.services;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Класс фильтрации данных.
 * Создаёт параметры для адресной строки запроса, например: status=Alive&genders=female
 */
@Component
@Data
public class Filter {

    private List<String> statuses = Arrays.asList("", "Alive", "Dead", "Unknown");
    private List<String> specieses = Arrays.asList("", "Human", "Alien", "Mythological Creature", "Robot", "Cronenberg", "Humanoid", "Animal");
    private List<String> genders = Arrays.asList("", "Male", "Female", "Genderless", "Unknown");

    private String currentStatus = "";
    private String currentSpecies = "";
    private String currentType = "";
    private String currentGender = "";

    /**
     * Возвращает итоговую строку фильтра для адресной строки
     */
    public String getFilterString() {
        StringBuilder sb = new StringBuilder();
        if (!currentStatus.isBlank()) {
            sb.append("status=").append(currentStatus).append("&");
        }
        if (!currentGender.isBlank()) {
            sb.append("gender=").append(currentGender).append("&");
        }
        if (!currentSpecies.isBlank()) {
            sb.append("species=").append(currentSpecies).append("&");
        }
        if (!currentType.isBlank()) {
            sb.append("type=").append(currentType).append("&");
        }
        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        return "";
    }

    public void clear() {
        currentStatus = "";
        currentSpecies = "";
        currentType = "";
        currentGender = "";
    }

}
