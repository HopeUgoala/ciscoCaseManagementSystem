package com.example.ciscocasemanagementsystem.cases;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Cases {
    @Id
    @SequenceGenerator(
            name = "cases_sequence",
            sequenceName = "cases_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cases_sequence"
    )
    private Long id;
    private String title;
    private String description;
    private String severity;
    private String status;
    private LocalDate creationDate;

    public Cases() {
    }

    public Cases(Long id,
                 String title,
                 String description,
                 String severity,
                 String status,
                 LocalDate creationDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.status = status;
        this.creationDate = creationDate;
    }

    public Cases(String title,
                 String description,
                 String severity,
                 String status,
                 LocalDate creationDate) {
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.status = status;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Cases{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", severity='" + severity + '\'' +
                ", status='" + status + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
