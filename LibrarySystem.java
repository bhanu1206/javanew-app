import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Book> books;
    private List<Member> members;

    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public void borrowBook(Member member, Book book) {
        if (books.contains(book) && book.isAvailable()) {
            member.borrowBook(book);
            book.setAvailable(false);
        }
    }

    public void returnBook(Member member, Book book) {
        if (member.getBooks().contains(book)) {
            member.returnBook(book);
            book.setAvailable(true);
        }
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        Book book1 = new Book("Harry Potter", "J.K. Rowling", "Fantasy");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "Fiction");

        library.addBook(book1);
        library.addBook(book2);

        Member member1 = new Member("John Doe", "jd123");
        Member member2 = new Member("Jane Smith", "js456");

        library.registerMember(member1);
        library.registerMember(member2);

        library.borrowBook(member1, book1);
        library.borrowBook(member2, book2);

        System.out.println("Books in the library:");
        for (Book book : library.books) {
            System.out.println(book);
        }

        System.out.println("Members in the library:");
        for (Member member : library.members) {
            System.out.println(member);
        }

        library.returnBook(member1, book1);
        library.returnBook(member2, book2);

        System.out.println("After returning books:");
        System.out.println(book1.getTitle() + " available? " + book1.isAvailable());
        System.out.println(book2.getTitle() + " available? " + book2.isAvailable());
    }
}

class Book {
    private String title;
    private String author;
    private String genre;
    private boolean available;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", available=" + available +
                '}';
    }

    // Getters and setters
}

class Member {
    private String name;
    private String memberId;
    private List<Book> borrowedBooks;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public List<Book> getBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
    }

    // Getters and setters
}
