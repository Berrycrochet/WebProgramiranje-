package org.example.streamingsportskihprenosa.controller;

import org.example.streamingsportskihprenosa.repository.CommentRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/comments")
public class CommentRestController {

    private final CommentRepository commentRepository;

    public CommentRestController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping
    @Transactional(readOnly = true)
    public List<Map<String, Object>> findAll() {
        return commentRepository.findAll().stream()
                .map(comment -> Map.<String, Object>of(
                        "id", comment.getId(),
                        "author", comment.getAuthor(),
                        "text", comment.getText(),
                        "matchId", comment.getMatch().getId(),
                        "matchTitle", comment.getMatch().getTitle()
                ))
                .toList();
    }
}
