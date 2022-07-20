package kanior.csyouth.domain.notes;

import kanior.csyouth.domain.BaseTimeEntity;
import kanior.csyouth.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Notes extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notes_id")
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Column(nullable = false)
    private User writer;

    @Builder
    public Notes(String content, User writer) {
        this.content = content;
        this.writer = writer;
    }

    public void update(String content) {
        this.content = content;
    }
}
