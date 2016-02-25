package dao;

public class User {
    private String name;
    private Boolean marked;

    public User() {
    }

    public User(String name, Boolean marked) {
        this.name = name;
        this.marked = marked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getMarked() {
        return marked;
    }

    public void setMarked(Boolean marked) {
        this.marked = marked;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", marked=").append(marked);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return marked != null ? marked.equals(user.marked) : user.marked == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (marked != null ? marked.hashCode() : 0);
        return result;
    }
}
