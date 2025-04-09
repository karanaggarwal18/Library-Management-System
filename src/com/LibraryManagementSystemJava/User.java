class User {
    private int userID;
    private String name;

    public User(int userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    public int getUserID() { return userID; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return userID + "," + name;
    }

    public static User fromString(String data) {
        String[] parts = data.split(",");
        return new User(Integer.parseInt(parts[0]), parts[1]);
    }
}