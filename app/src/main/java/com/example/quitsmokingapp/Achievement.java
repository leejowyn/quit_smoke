package com.example.quitsmokingapp;

public class Achievement {
    private String title, hint, reward, achievementid;


    //getter
    public String getTitle() {
        return title;
    }

    public String getHint() {
        return hint;
    }

    public String getReward() {
        return reward;
    }

    public String getAchievementid() {
        return achievementid;
    }

    //setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public void setAchievementid(String achievementid) {
        this.achievementid = achievementid;
    }
}
