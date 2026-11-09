package org.example.streamingsportskihprenosa.repository;

import org.example.streamingsportskihprenosa.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}