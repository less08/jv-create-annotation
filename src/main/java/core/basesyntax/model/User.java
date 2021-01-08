package core.basesyntax.model;

public class User {
    private String name;
    private String favSport;

    public User(String name, String favSport) {
        this.name = name;
        this.favSport = favSport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavSport() {
        return favSport;
    }

    public void setFavSport(String favSport) {
        this.favSport = favSport;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", favSport='" + favSport + '\''
                + '}';
    }
}
