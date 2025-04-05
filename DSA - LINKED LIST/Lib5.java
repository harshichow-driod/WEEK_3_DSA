class Book {
    String title;
    String author;
    String genre;
    String bookId;
    boolean availabilityStatus;
    Book next;
    Book prev;

    Book(String title, String author, String genre, String bookId, boolean availabilityStatus) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.next = null;
        this.prev = null;
    }
}

class Lib5 {
    Book head;
    Book tail;

    Lib5() {
        head = null;
        tail = null;
    }

    void addAtBeginning(String title, String author, String genre, String bookId, boolean availabilityStatus) {
        Book newBook = new Book(title, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = newBook;
            tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    void addAtEnd(String title, String author, String genre, String bookId, boolean availabilityStatus) {
        Book newBook = new Book(title, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = newBook;
            tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    void addAtPosition(int position, String title, String author, String genre, String bookId, boolean availabilityStatus) {
        if (position == 0) {
            addAtBeginning(title, author, genre, bookId, availabilityStatus);
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, availabilityStatus);
        Book current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of range");
                return;
            }
            current = current.next;
        }
        newBook.next = current.next;
        newBook.prev = current;
        if (current.next != null) {
            current.next.prev = newBook;
        }
        current.next = newBook;
    }

    void removeById(String bookId) {
        Book current = head;
        while (current != null && !current.bookId.equals(bookId)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book not found");
            return;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
    }

    Book searchByTitle(String title) {
        Book current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    Book searchByAuthor(String author) {
        Book current = head;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    void updateAvailabilityStatus(String bookId, boolean newStatus) {
        Book book = searchByTitle(bookId);
        if (book != null) {
            book.availabilityStatus = newStatus;
            System.out.println("Updated availability status for book: " + bookId);
        } else {
            System.out.println("Book not found");
        }
    }

    void displayForward() {
        if (head == null) {
            System.out.println("No books available");
            return;
        }
        Book current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", Book ID: " + current.bookId + ", Available: " + current.availabilityStatus);
            current = current.next;
        }
    }

    void displayReverse() {
        if (tail == null) {
            System.out.println("No books available");
            return;
        }
        Book current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", Book ID: " + current.bookId + ", Available: " + current.availabilityStatus);
            current = current.prev;
        }
    }

    int countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Lib5 library = new Lib5();

        library.addAtBeginning("Harry Potter", "J.K. Rowling", "Fantasy", "B001", true);
        library.addAtEnd("The Alchemist", "Paulo Coelho", "Fiction", "B002", true);
        library.addAtPosition(1, "To Kill a Mockingbird", "Harper Lee", "Fiction", "B003", true);

        System.out.println("All Books in Library (Forward):");
        library.displayForward();

        Book book = library.searchByTitle("The Alchemist");
        if (book != null) {
            System.out.println("\nFound book: " + book.title + ", Author: " + book.author);
        }

        library.updateAvailabilityStatus("B001", false);

        System.out.println("\nUpdated Book Records (Forward):");
        library.displayForward();

        library.removeById("B002");

        System.out.println("\nBook Records After Deletion (Forward):");
        library.displayForward();

        System.out.println("\nTotal Number of Books: " + library.countBooks());

        System.out.println("\nBook Records (Reverse):");
        library.displayReverse();
    }
}
