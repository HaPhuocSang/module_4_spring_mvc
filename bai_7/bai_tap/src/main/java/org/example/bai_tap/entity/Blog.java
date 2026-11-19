package org.example.bai_tap.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "blogs")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Column(name = "content", nullable = false, columnDefinition = "longtext")
    private String content;
    @Column(name = "created_at", columnDefinition = "datetime default current_timestamp")
    private LocalDate createdAt;
    @Column(name = "updated_at", columnDefinition = "datetime default current_timestamp on update current_timestamp")
    private LocalDate updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Blog(Long id, String title, String content, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
    }
}
