class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieManagementSystem {
    Movie head;
    Movie tail;

    MovieManagementSystem() {
        head = null;
        tail = null;
    }

    void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = newMovie;
            tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = newMovie;
            tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position == 0) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        Movie current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of range");
                return;
            }
            current = current.next;
        }
        newMovie.next = current.next;
        newMovie.prev = current;
        if (current.next != null) {
            current.next.prev = newMovie;
        } else {
            tail = newMovie;
        }
        current.next = newMovie;
    }

    void removeByTitle(String title) {
        Movie current = head;
        while (current != null && !current.title.equals(title)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Movie not found");
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

    Movie searchByDirector(String director) {
        Movie current = head;
        while (current != null) {
            if (current.director.equals(director)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    Movie searchByRating(double rating) {
        Movie current = head;
        while (current != null) {
            if (current.rating == rating) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for movie: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found");
    }

    void displayForward() {
        if (head == null) {
            System.out.println("No records available");
            return;
        }
        Movie current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    void displayReverse() {
        if (tail == null) {
            System.out.println("No records available");
            return;
        }
        Movie current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }
}

public  class Movie2 {
    public static void main(String[] args) {
        MovieManagementSystem movieManager = new MovieManagementSystem();

        movieManager.addAtBeginning("Titanic", "James Cameron", 1997, 7.8);
        movieManager.addAtEnd("Pushpa", "Sukumar", 2021, 8.0);
        movieManager.addAtPosition(1, "Lana", "N/A", 2023, 7.5);

        System.out.println("All Movie Records (Forward):");
        movieManager.displayForward();

        Movie movie = movieManager.searchByDirector("Sukumar");
        if (movie != null) {
            System.out.println("Found movie by director: " + movie.title + ", Rating: " + movie.rating);
        } else {
            System.out.println("Movie not found");
        }

        movieManager.updateRating("Titanic", 8.0);

        System.out.println("\nUpdated Movie Records (Forward):");
        movieManager.displayForward();

        movieManager.removeByTitle("Lana");

        System.out.println("\nMovie Records After Deletion (Forward):");
        movieManager.displayForward();

        System.out.println("\nMovie Records (Reverse):");
        movieManager.displayReverse();
    }
}
