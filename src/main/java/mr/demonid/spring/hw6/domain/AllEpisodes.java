package mr.demonid.spring.hw6.domain;

import lombok.Data;

import java.util.List;

@Data
public class AllEpisodes {
    private Info info;
    private List<Episode> results;
}
