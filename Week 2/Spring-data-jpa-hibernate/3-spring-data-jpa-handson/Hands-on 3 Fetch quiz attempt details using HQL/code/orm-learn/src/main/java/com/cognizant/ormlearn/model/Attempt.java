package com.cognizant.ormlearn.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "attempt")
public class Attempt {

    @Id
    @Column(name = "at_id")
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "at_date")
    private Date attemptDate;

    @Column(name = "at_score")
    private double score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "at_us_id")
    private User user;

    @OneToMany(
            mappedBy = "attempt",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<AttemptQuestion> attemptQuestions;
}