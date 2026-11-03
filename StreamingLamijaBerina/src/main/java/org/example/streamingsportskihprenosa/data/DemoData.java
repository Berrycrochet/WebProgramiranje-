
package org.example.streamingsportskihprenosa.data;

import org.springframework.stereotype.Component;
import org.example.streamingsportskihprenosa.Models.Match;
import org.example.streamingsportskihprenosa.Models.Team;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

@Component
public class DemoData {

    private final List<Team> teams = new ArrayList<>();
    private final List<Match> matches = new ArrayList<>();

    public DemoData() {

        // Kreiranje klubova
        Team t1 = new Team(1L, "Zeljeznicar", "Sarajevo", "Fudbal");
        Team t2 = new Team(2L, "Celik", "Zenica", "Fudbal");
        Team t3 = new Team(3L, "Velez", "Mostar", "Fudbal");

        teams.addAll(List.of(t1, t2, t3));

        // Video link za demonstracijski prenos
        String video = "https://www.youtube.com/watch?v=xWkvDKrSZ2k";

        // Kreiranje utakmica
        Match m1 = new Match(
                1L,
                "Zeljeznicar - Celik",
                LocalDateTime.of(2026, 11, 10, 18, 0),
                video
        );

        Match m2 = new Match(
                2L,
                "Celik - Velez",
                LocalDateTime.of(2026, 11, 12, 19, 0),
                video
        );

        Match m3 = new Match(
                3L,
                "Zeljeznicar - Velez",
                LocalDateTime.of(2026, 11, 15, 20, 0),
                video
        );

        // Povezivanje klubova i utakmica
        addMatch(m1, t1, t2);
        addMatch(m2, t2, t3);
        addMatch(m3, t1, t3);
    }

    // Dodavanje utakmice i povezivanje sa klubovima
    private void addMatch(Match match, Team first, Team second) {

        match.getTeams().add(first);
        match.getTeams().add(second);

        first.getMatches().add(match);
        second.getMatches().add(match);

        matches.add(match);
    }

    // Pronalazak svih klubova
    public List<Team> findAllTeams() {
        return teams;
    }

    // Pronalazak svih utakmica
    public List<Match> findAllMatches() {
        return matches;
    }

    // Pronalazak utakmice prema ID-u
    public Match findMatch(Long id) {

        for (Match match : matches) {

            if (match.getId().equals(id)) {
                return match;
            }
        }

        return null;
    }
}
