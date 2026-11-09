
package org.example.streamingsportskihprenosa.Models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String sport;

    @ManyToMany(mappedBy = "teams")
    private List<Match> matches = new ArrayList<>();

    // Prazan konstruktor
    public Team() {
    }

    // Konstruktor
    public Team(Long id, String name, String city, String sport) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.sport = sport;
    }

    // Getteri
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
