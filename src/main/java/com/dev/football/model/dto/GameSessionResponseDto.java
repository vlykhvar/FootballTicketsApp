package com.dev.football.model.dto;

public class GameSessionResponseDto {
    private Long id;
    private String gameTitle;
    private String showTime;
    private Long stadiumId;
    private String stadiumDescription;

    public String getGameSessionDescription() {
        return stadiumDescription;
    }

    public void setGameSessionDescription(String stadiumDescription) {
        this.stadiumDescription = stadiumDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public Long getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(Long stadiumId) {
        this.stadiumId = stadiumId;
    }
}
