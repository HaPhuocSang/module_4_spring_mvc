package org.example.bai_tap.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Column(name = "content",  nullable = false, columnDefinition = "longtext")
    private String content;
    @Column(name = "created_at", columnDefinition = "datetime default current_timestamp")
    private LocalDate createdAt;
    @Column(name = "updated_at", columnDefinition = "datetime default current_timestamp on update current_timestamp")
    private LocalDate updatedAt;

    public Blog() {
    }

    public Blog(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Blog(Integer id, String title, String content, LocalDate createAt, LocalDate updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
