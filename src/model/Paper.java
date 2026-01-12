package model;

public class Paper {
    private int id;
    private String title;
    private int year;
    private int authorId;

    public Paper(int id, String title, int year, int authorId) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.authorId = authorId;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getYear() { return year; }
    public int getAuthorId() { return authorId; }

    public void setTitle(String title) { this.title = title; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return "Paper{id=" + id + ", title='" + title + "', year=" + year + "}";
    }
}
