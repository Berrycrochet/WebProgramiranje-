
package org.example.streamingsportskihprenosa.controller;

import org.example.streamingsportskihprenosa.data.DemoData;
import org.example.streamingsportskihprenosa.Models.Match;
import org.example.streamingsportskihprenosa.Models.Comment;
import org.example.streamingsportskihprenosa.repository.CommentRepository;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AppController {

    private final DemoData data;
    private final CommentRepository commentRepository;

    public AppController(DemoData data, CommentRepository commentRepository) {
        this.data = data;
        this.commentRepository = commentRepository;
    }

    // Pocetna stranica
    @GetMapping("/")
    public String home() {
        return "redirect:/matches";
    }

    // Prikaz svih utakmica
    @GetMapping("/matches")
    public String matches(Model model) {
        model.addAttribute("matches", data.findAllMatches());
        return "matches";
    }

    // Prikaz svih klubova
    @GetMapping("/teams")
    public String teams(Model model) {
        model.addAttribute("teams", data.findAllTeams());
        return "teams";
    }

    // Prikaz detalja utakmice
    @GetMapping("/matches/action/{id}")
    public String action(@PathVariable Long id, Model model) {

        Match match = requireMatch(id);
        model.addAttribute("match", match);

        return "streaming";
    }

    // Pokretanje ili zaustavljanje prenosa
    @PostMapping("/matches/action/{id}")
    public String toggleStream(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes) {

        Match match = requireMatch(id);

        match.setStreaming(!match.isStreaming());
        data.saveMatch(match);

        String message;

        if (match.isStreaming()) {
            message = "Demo prenos je pokrenut.";
        } else {
            message = "Demo prenos je zaustavljen.";
        }

        redirectAttributes.addFlashAttribute("success", message);

        return "redirect:/matches/action/" + id;
    }


    // Prikaz svih komentara i forme za dodavanje
    @GetMapping("/comments")
    public String comments(Model model) {

        model.addAttribute("comments", commentRepository.findAll());
        model.addAttribute("matches", data.findAllMatches());
        model.addAttribute("comment", new Comment());

        return "comment";
    }

    // Dodavanje novog komentara
    @PostMapping("/comments")
    public String addComment(
            @ModelAttribute Comment comment,
            @RequestParam Long matchId) {

        Match match = requireMatch(matchId);

        comment.setMatch(match);

        commentRepository.save(comment);

        return "redirect:/comments";
    }

    // Provjera postoji li utakmica
    private Match requireMatch(Long id) {

        Match match = data.findMatch(id);

        if (match == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Utakmica nije pronadjena."
            );
        }

        return match;
    }
}
