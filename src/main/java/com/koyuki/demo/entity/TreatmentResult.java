package com.koyuki.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "treatment_results")
@Getter
@Setter
public class TreatmentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 来店記録との関連
    @OneToOne
    @JoinColumn(name = "visit_id", nullable = false)
    private Visit visit;

    @Column(name = "style_name")
    private String styleName;

    @Column(name = "color_name")
    private String colorName;

    @Column(name = "treatment_menu")
    private String treatmentMenu;

    @Column(name = "stylist_comment", columnDefinition = "TEXT")
    private String stylistComment;

    @Column(name = "customer_reaction", columnDefinition = "TEXT")
    private String customerReaction;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}