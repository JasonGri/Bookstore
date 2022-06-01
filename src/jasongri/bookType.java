package jasongri;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class  bookType {
    private String title;
    private ArrayList<String> authors;
    private String publisher;
    private String ISBN;
    private double price;
    private int copiesAvailable;
    private Category category;

    // Constructor
    public bookType(String title,ArrayList<String> authors, String publisher, String ISBN, double price, int copiesAvailable, Category category) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.price = price;
        this.copiesAvailable = copiesAvailable;
        this.category = category;
    }
    // This constructor can be used to create a book object for just the bookstore owners without any commercial info yet.
    public bookType(String title, ArrayList<String> authors, String publisher, String ISBN,  Category category) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.category = category;
    }

    // Title Methods
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title=title;
    }

    // Authors Methods
    public String getAuthors() {
        return String.join(", ", authors);
    }
    public void replaceAuthor(int idx, String author) {
        authors.set(idx, author);
    }
    public void addAuthor(String author) throws CapacityException{
        if (authors.size()<4) {
            authors.add(author);
        } else throw new CapacityException("You cannot add more than 4 authors!");
    }
    public void removeAuthor(int idx) {
        authors.remove(idx);
    }

    // Publisher Methods
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher=publisher;
    }

    // ISBN Methods
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN=ISBN;
    }

    // Price Methods
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) throws InputMismatchException {
        if (price>=0) {
            this.price = price;
        } else throw new InputMismatchException("You should only enter positive integers!\n"+"You have entered: "+price);
    }

    // CopiesAvailable Methods
    public int getCopiesAvailable() {
        return copiesAvailable;
    }
    public void setCopiesAvailable(int copiesAvailable) throws InputMismatchException {
        if (copiesAvailable>=0) {
            this.copiesAvailable = copiesAvailable;
        } else throw new InputMismatchException("You should only enter positive integers!\n"+"You have entered: "+copiesAvailable);
    }

    // Category Methods
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category=category;
    }



    // toString method
    @Override
    public String toString() {
        return String.format("Title: %s\nAuthor(s): %s\nPublisher: %s\nISBN: %s\nPrice: %.2f\nNumber of copies available: %d\nCategory: %s",title,authors,publisher,ISBN,price,copiesAvailable,category);
    }


    // Inner class for a custom exception
    public class CapacityException extends Exception {
        public CapacityException(String str) {
            super(str);
        }
    }
}


