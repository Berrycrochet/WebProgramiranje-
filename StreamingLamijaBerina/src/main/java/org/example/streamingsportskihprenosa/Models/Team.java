
package org.example.streamingsportskihprenosa.Models;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private Long id;
    private String name;
    private String city;
    private String sport;

    private List<Match> matches = new ArrayList<>();

    public Team(Long id, String name, String city, String sport) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.sport = sport;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getSport() {
        return sport;
    }

    public List<Match> getMatches() {
        return matches;
    }
}
