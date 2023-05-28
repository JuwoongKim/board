package com.juwoong.board.repository;

import com.juwoong.board.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository <ArticleComment, Long>{

}
