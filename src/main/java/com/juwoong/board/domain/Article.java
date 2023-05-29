package com.juwoong.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})
@Entity
public class Article extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String title;
    @Setter
    @Column(nullable = false, length =10000)
    private String content;
    @Setter
    private String hashtag;

    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<ArticleComment> articleComments = new LinkedHashSet<>();

    protected  Article(){}

    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static  Article of (String title, String content, String hashtag) {
        return new Article(title, content, hashtag);
    }

    //@EqualsAnsHashCode 안씀... 모든 컬럼을 따 쓸 수 없다.


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
