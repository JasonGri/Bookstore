package jasongri;

import java.util.InputMismatchException;

public class memberType {
    private String name;
    private String memberID;
    private int booksPurchased;
    private double totalAmountSpent;

    // Constructor for members
    public memberType(String name, String memberID, int booksPurchased, double totalAmountSpent) {
        this.name = name;
        this.memberID = memberID;
        this.booksPurchased = booksPurchased;
        this.totalAmountSpent = totalAmountSpent;
    }
    // Constructor for new members or members that we are unaware of their purchasing activity.
    public  memberType(String name) {
        this.name = name;
        booksPurchased = 0;
        totalAmountSpent = 0;
    }

    // Name Methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // MemberID Methods
    public String getMemberID() {
        return memberID;
    }
    public void setMemberID(String memberID) {
        this.memberID=memberID;
    }

    // BooksPurchased Methods
    public int getBooksPurchased() {
        return booksPurchased;
    }
    public void setBooksPurchased (int booksPurchased) throws InputMismatchException {
        if (booksPurchased>=0) {
            this.booksPurchased = booksPurchased;
        } else throw new InputMismatchException("You've entered: "+booksPurchased+"\nPlease enter only positive integers.");
    }

    // TotalAmountSpent Methods
    public double getTotalAmountSpent() {
        return totalAmountSpent;
    }
    public void setTotalAmountSpent(double totalAmountSpent) throws InputMismatchException {
        if (totalAmountSpent>=0) {
            this.totalAmountSpent = totalAmountSpent;
        } else throw new InputMismatchException("You've entered: "+totalAmountSpent+"\nPlease enter only positive numbers.");
    }


    // toString method//
    @Override
    public String toString() {
        return String.format("Name: %s\nMember ID: %s\nBooks purchased: %d\nTotal amount spent: %.2f", name,memberID,booksPurchased,totalAmountSpent);
    }

}