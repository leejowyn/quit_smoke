package com.example.quitsmokingapp;

public class Help {

    private String title;
    private String year;
    private String plot;
    private boolean expanded;

    public Help(String title, String year, String plot) {
        this.title = title;
        this.year = year;
        this.plot = plot;
        this.expanded = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    @Override
    public String toString() {
        return "Help{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", plot='" + plot + '\'' +
                ", expanded=" + expanded +
                '}';
    }
}
