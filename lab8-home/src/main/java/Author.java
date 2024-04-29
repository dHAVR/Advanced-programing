public class Author {
    private int id;
    private String name;
    private String originCountry;
    private int age;

    // Constructor
    public Author(int id, String name, String originCountry, int age) {
        this.id = id;
        this.name = name;
        this.originCountry = originCountry;
        this.age = age;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
