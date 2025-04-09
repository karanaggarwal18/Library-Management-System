class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookID, String title, String author, boolean isAvailable) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public int getBookID() { return bookID; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void borrowBook() { isAvailable = false; }
    public void returnBook() { isAvailable = true; }

    @Override
    public String toString() {
        return bookID + "," + title + "," + author + "," + isAvailable;
    }

    public static Book fromString(String data) {
        String[] parts = data.split(",");
        return new Book(Integer.parseInt(parts[0]), parts[1], parts[2], Boolean.parseBoolean(parts[3]));
    }
}