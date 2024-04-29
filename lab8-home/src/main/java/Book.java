import java.util.List;

public class Book {
    private int id;
    private String title;
    private String language;
    private String publicationDate;
    private int numberOfPages;
    private String authors;

    // Constructor
    public Book(int id, String title, String language, String publicationDate, int numberOfPages, String authors) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", authors='" + authors + '\'' +
                '}';
    }
}
