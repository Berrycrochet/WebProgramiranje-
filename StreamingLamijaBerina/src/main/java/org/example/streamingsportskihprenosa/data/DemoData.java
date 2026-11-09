
package org.example.streamingsportskihprenosa.data;

import org.springframework.stereotype.Component;
import org.example.streamingsportskihprenosa.Models.Match;
import org.example.streamingsportskihprenosa.Models.Team;
import org.example.streamingsportskihprenosa.repository.MatchRepository;
import org.example.streamingsportskihprenosa.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.time.LocalDateTime;

@Component
public class DemoData implements CommandLineRunner{

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    public DemoData(
            MatchRepository matchRepository,
            TeamRepository teamRepository
    ){

        this.matchRepository = matchRepository;
        this.teamRepository=teamRepository;
    }


    @Override
    @Transactional
    public void  run(String... args) {
        if (matchRepository.count() > 0 || teamRepository.count() > 0) {
            return;
        }


        // Kreiranje klubova
        Team t1 = teamRepository.save(new Team(null, "Zeljeznicar", "Sarajevo", "Fudbal"));
        Team t2 = teamRepository.save(new Team(null, "Celik", "Zenica", "Fudbal"));
        Team t3 = teamRepository.save(new Team(null, "Velez", "Mostar", "Fudbal"));


        // Povezivanje klubova i utakmica
        addMatch("Zeljeznicar - Celik", LocalDateTime.of(2026, 11, 10, 18, 0), t1, t2);
        addMatch("Celik - Velez", LocalDateTime.of(2026, 11, 12, 19, 0), t2, t3);
        addMatch("Zeljeznicar - Velez", LocalDateTime.of(2026, 11, 15, 20, 0), t1, t3);

    }

    // Dodavanje utakmice i povezivanje sa klubovima
    private void addMatch(String title, LocalDateTime startTime, Team first, Team second) {

        Match match = new Match(
                null,
                title,
                startTime,
                "https://www.youtube.com/watch?v=xWkvDKrSZ2k"
        );

        match.getTeams().add(first);
        match.getTeams().add(second);
        matchRepository.save(match);
    }

    // Pronalazak svih klubova
    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }

    // Pronalazak svih utakmica
    public List<Match> findAllMatches() {
        return matchRepository.findAll();
    }

    // Pronalazak utakmice prema ID-u
    public Match findMatch(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    public void saveMatch(Match match){
        matchRepository.save(match);
    }
}

