package mr.demonid.spring.hw6.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Мои простенькие утилитки для работы с URL
 */
@Component
public class UrlUtil {

    public String getPageNumber(String url) {
        Map<String, String> params = getParameters(url);
        String res = params.get("PAGE");
        if (res == null)
            res = "";
        return res;
    }

    /**
     * Извлекает из URL все параметры и их значения
     * @param url Адрес, вида xxxxxx?param=value[&param=value[&...]]
     * @return Извлеченные параметры, в HashMap (ключ/значение)
     */
    public Map<String, String> getParameters(String url) {
        Map<String, String> res = new HashMap<>();
        if (url != null)
        {
            int idx = url.indexOf("?");
            if (idx >= 0)
            {
                String paramsUrl = url.substring(idx+1);
                String[] params = paramsUrl.split("&");
                for (String param : params) {
                    idx = param.indexOf('=');
                    if (idx > 0) {
                        String name = param.substring(0, idx);
                        String val = param.substring(idx+1);
                        res.put(name.toUpperCase(), val);
                    } else {
                        res.put(param, "");     // пустой параметр
                    }
                }
            }
        }
        return res;
    }

    public Integer stringToInteger(String value) {
        try {
            return Integer.valueOf(value, 10);
        } catch (NumberFormatException | NullPointerException e) {
            return null;
        }
    }
}
