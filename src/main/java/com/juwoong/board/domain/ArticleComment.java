package com.juwoong.board.domain;

import java.time.LocalDateTime;

public class ArticleComment {
    private Long id;
    private Article article;
    private String content;

    private LocalDateTime createdAt;
    private String craetedBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
}
