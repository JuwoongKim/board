package com.juwoong.board.repository;

import com.juwoong.board.config.JpaConfig;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DisplayName("ArticleComments CRUD  테스트")
@Import(JpaConfig.class)
@DataJpaTest
class ArticleCommentRepositoryTest {

    private final ArticleCommentRepository articleCommentRepository;

    public ArticleCommentRepositoryTest(@Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleCommentRepository = articleCommentRepository;
    }




}