package kanior.csyouth.domain.notes;

import kanior.csyouth.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@RequiredArgsConstructor
@Entity
public class Notes extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @Builder
    public Notes(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public void update(String content) {
        this.content = content;
    }
}
