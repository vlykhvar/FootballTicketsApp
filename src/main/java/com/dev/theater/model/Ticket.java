package com.dev.theater.model;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @Column(nullable = false)
    private MovieSession movieSession;
    @OneToOne
    @Column(nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieSession getMovieSession() {
        return movieSession;
    }

    public void setMovieSession(MovieSession movieSession) {
        this.movieSession = movieSession;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
