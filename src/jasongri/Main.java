package jasongri;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    // methods for the bookType testing program
    public static bookType searchByTitle(String bookTitle, ArrayList<bookType> bookList) {
        for (bookType i : bookList) {
            if (Objects.equals(i.getTitle(), bookTitle)) {
                return i;
            }
        }
        return null;
    }

    public static bookType searchByISBN(String bookISBN, ArrayList<bookType> bookList){
        for (bookType i : bookList) {
            if (Objects.equals(i.getISBN(), bookISBN)) {
                return i;
            }
        }
        return null;
    }

    public static ArrayList<bookType> searchByBudget(double budget, ArrayList<bookType> bookList) {
        ArrayList<bookType> withinBudget= new ArrayList<>();
        for (bookType i : bookList) {
            if (i.getPrice() <= budget) {
                withinBudget.add(i);
            }
        }
        return withinBudget;
    }

    public static void updateCopies(String bookTitle, int bookCopies, ArrayList<bookType> bookList) {
        bookType bookObj = searchByTitle(bookTitle, bookList);
        bookObj.setCopiesAvailable(bookCopies);
    }

    public static void applyDiscount(String bookTitle, double discountPer, ArrayList<bookType> bookList) {
        bookType bookObj = searchByTitle(bookTitle, bookList);
        double newPrice = bookObj.getPrice()-(bookObj.getPrice() * discountPer);
        bookObj.setPrice(newPrice);
    }

    // Ignore this method this is a user driven method to test multiple methods about the bookType objects
    public static void bookTypeTesting(ArrayList<bookType> bookList) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Please enter a number of the corresponding  operations(1-6): \n1) Find a book by its title.\n2) Find a book by its ISBN." +
                    "\n3) Find books that are within your budget.\n4) Update the book copies that are available.\n5) Apply discount for a specific book."
                    +"\n6) Exit the program.");

            if (sc.hasNextInt()) {
                int option = sc.nextInt();
                sc.nextLine();
                if (option == 1) {
                    System.out.println("Please enter the book's title-->");
                    String bookTitle = sc.nextLine();
                    System.out.println(searchByTitle(bookTitle, bookList));
                } else if (option == 2) {
                    System.out.println("Please enter the book's ISBN-->");
                    String bookISBN = sc.nextLine();
                    System.out.println(searchByISBN(bookISBN, bookList));
                } else if (option == 3) {
                    System.out.println("Please enter your budget-->");
                    double budget = sc.nextDouble();
                    System.out.println(searchByBudget(budget, bookList));
                } else if (option == 4) {
                    System.out.println("Please enter the title of the book you want to update the copies-->");
                    String bookTitle = sc.nextLine();
                    System.out.println("Please enter the number of copies-->");
                    int bookCopies = sc.nextInt();
                    updateCopies(bookTitle, bookCopies, bookList);
                } else if (option == 5) {
                    System.out.println("Please enter the title of the book you want to apply the discount to-->");
                    String bookTitle = sc.nextLine();
                    System.out.println("Please enter the discount percentage-->");
                    double discountPer = sc.nextDouble();
                    applyDiscount(bookTitle, discountPer, bookList);
                } else if (option == 6) {
                    break;
                } else {
                    System.out.println(String.format("Please enter an option between 1-6!\nYour input was %d.", option));
                }
            } else {
                System.out.println("I only accept integers!");
                sc.next();
            }



        }
    }





    //methods for the memberType testing program
    public static memberType searchByName(String memberName, ArrayList<memberType> memberList) {
        for (memberType i : memberList) {
            if (Objects.equals(i.getName(), memberName)){
                return i;
            }
        }
        return null;
    }

    public static memberType searchByID(String memberID, ArrayList<memberType> memberList) {
        for (memberType i : memberList) {
            if (Objects.equals(i.getMemberID(), memberID)){
                return i;
            }
        }
        return null;
    }

    // show average book price for the given member
    public static double showAverageBookPrice(String memberID, ArrayList<memberType> memberList) {
        memberType memberObj = searchByID(memberID, memberList);
        if (memberObj.getBooksPurchased()!=0) {
            return (memberObj.getTotalAmountSpent() / memberObj.getBooksPurchased());
        } return 0;
    }

    public static void updateBooksPurchased(String memberID, int booksPurchased, ArrayList<memberType> memberList) {
        memberType memberObj = searchByID(memberID, memberList);
        memberObj.setBooksPurchased(booksPurchased);
    }

    // Ignore this method this is a user driven method to test multiple methods about the memberType objects
    public static void memberTypeTesting(ArrayList<memberType> memberList){
        Scanner sc = new Scanner(System.in);



        while (true) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Please enter a number of the corresponding  operations(1-5): \n1) Find a member by its name." +
                    "\n2) Find a member by its ID." +
                    "\n3) Display the average price a specific member buys books." +
                    "\n4) Update the number of books a member has purchased."+"\n5) Exit the program.");
            if (sc.hasNextInt()) {
                int option = sc.nextInt();
                sc.nextLine();
                if (option == 1) {
                    System.out.println("Please the name of the member you want to find-->");
                    String memberName = sc.nextLine();
                    System.out.println(searchByName(memberName, memberList));
                } else if (option == 2) {
                    System.out.println("Please the ID of the member you want to find-->");
                    String memberID = sc.nextLine();
                    System.out.println(searchByID(memberID, memberList));
                } else if (option == 3) {
                    System.out.println("Please enter the ID of the member you want to find info about-->");
                    String memberID = sc.nextLine();
                    System.out.println(showAverageBookPrice(memberID , memberList));
                } else if (option == 4) {
                    System.out.println("Please enter the ID of the member you want to update the books purchased-->");
                    String memberID = sc.nextLine();
                    System.out.println("Please enter the number of books-->");
                    int booksPurchased = sc.nextInt();
                    updateBooksPurchased(memberID, booksPurchased, memberList);
                } else if (option == 5) {
                    break;
                } else {
                    System.out.println(String.format("Please enter an option between 1-5!\nYour input was %d.", option));
                }
            } else {
                System.out.println("I only accept integers!");
                sc.next();
            }

        }
    }


    // The actual program C.
    public static int validateInput(String menu) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);

        System.out.println(menu);

        try {
            sc.hasNextInt();
            return sc.nextInt();
        } catch (InputMismatchException e){
            System.out.println("I only accept integers!" + e);
            return 0;
        }
    }

    public static void displayCategories(ArrayList<bookType> bookList) {
        Category[] categories = Category.values();
        for (Category c : categories) {
            System.out.println("\n---------------------------------\nThis is the " + c + " section: ");
            for (bookType i : bookList) {
                if (i.getCategory() == c) {
                    System.out.println("\n" + i);
                }
            }
        }
    }

    public static memberType findCustomer(ArrayList<memberType> memberList) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to our bookstore!\nPlease identify yourself by entering your name -->");

            if (!sc.hasNextInt()) {
                String memberName = sc.nextLine();
                for (memberType i : memberList) {
                    if (Objects.equals(i.getName(), memberName)) {
                        System.out.println("Welcome back " + memberName);
                        return i;
                    }
                }
                System.out.println(String.format("We welcome you for the first time to our bookstore %s!", memberName));
                memberList.add(new memberType(memberName));
                return memberList.get(memberList.size() - 1);
            } else {
                System.out.println("I do not accept numbers as input!");
                sc.nextLine();
            }
        }
    }

    public static int generateRandomMemberID(){
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    public static void saveMembers(ArrayList<memberType> memberList) throws IOException{
        BufferedWriter fileOut = new BufferedWriter(new FileWriter("ListOfMembers.txt"));

        for (memberType i : memberList) {
            fileOut.write(i.getName()+", "+i.getMemberID()+", "+i.getBooksPurchased()+", "+i.getTotalAmountSpent()+"\n");
        }
        fileOut.close();
    }

    public static void loadMembers(ArrayList<memberType> memberList) throws IOException {
        memberList.clear();

        File file = new File("ListOfMembers.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while ((line = br.readLine())!=null){
            String[] parts = line.split(", ");
            String name = parts[0];
            String memberID;
            if (Objects.equals(parts[1], "null")){
                memberID = null;
            }else memberID = parts[1];
            int booksPurchased = Integer.parseInt(parts[2]);
            double totalAmountSpent = Double.parseDouble(parts[3]);
            memberList.add(new memberType(name, memberID, booksPurchased, totalAmountSpent));
        }

        br.close();
    }

    public static void bookstore(ArrayList<bookType> bookList, ArrayList<memberType> memberList) throws IOException {
        Scanner sc = new Scanner(System.in);

        loadMembers(memberList);

        // Gets the customer's name and finds him/ her or creates them.
        memberType currentCustomer = findCustomer(memberList);


        ArrayList<bookType> basket = new ArrayList<>();

        String menu = "--------------------------------------------------------------------------------------------------------\n"+
                "Please select one of the numbers(1-4) corresponding to the different possible processes to be executed.\n"+
                "1) Display book collection.\n"+
                "2) Check your info.\n"+
                "3) Become a member.\n"+
                "4) Exit the program.";

        String menu1 = """
                ------------------------------------------------------------------------------------------------------
                Please select one of the numbers(1-3) corresponding to the different possible processes to be executed.
                1) Add a book to your basket.
                2) Proceed to checkout.
                3) Return to main menu.""";

        String memberInfo = "To become a member you will have to pay a 10$ annual fee and you will receive" +
                " 5% discount on each of your purchase as well as extra discount on your 11th purchases.\n" +
                "Would you like to proceed?(1=Yes/0=No)";

        while (true) {
            int userInput = validateInput(menu);

            switch (userInput) {
                case 0:
                    break;
                case 1:
                    displayCategories(bookList);
                    boolean keepGoing = true;
                    while (keepGoing) {
                        int userInput1 = validateInput(menu1);


                        switch (userInput1) {
                            case 0:
                                break;
                            case 1:
                                System.out.println("Please enter the title of the book you want to add-->");
                                String bookTitle = sc.nextLine();
                                basket.add(searchByTitle(bookTitle, bookList));
                                break;
                            case 2:
                                double total=0;
                                int bookCounter=currentCustomer.getBooksPurchased();
                                double discount = 0;

                                if (currentCustomer.getMemberID()!=null) {
                                    System.out.println("These are the books you choose: ");
                                    for (bookType i : basket) {
                                        System.out.println("\n" + i);
                                        total += i.getPrice();
                                        currentCustomer.setBooksPurchased((currentCustomer.getBooksPurchased()+1));
                                    }
                                } else {
                                    System.out.println("These are the books you choose: ");
                                    for (bookType i : basket) {
                                        System.out.println("\n" + i);
                                        total += i.getPrice()-(i.getPrice()*0.05);
                                        currentCustomer.setBooksPurchased((currentCustomer.getBooksPurchased()+1));
                                        if ((bookCounter%10)==0&&bookCounter!=0) {
                                            discount = (currentCustomer.getTotalAmountSpent()/10);
                                            total -= discount;
                                            currentCustomer.setTotalAmountSpent(0);
                                        }
                                        bookCounter ++;
                                    }
                                }
                                System.out.println(String.format("\nThis is your total: %.2f$", total));
                                currentCustomer.setTotalAmountSpent((currentCustomer.getTotalAmountSpent()+total));
                                basket.clear();
                                break;
                            case 3:
                                keepGoing = false;
                                break;
                            default:
                                System.out.println(String.format("Please choose within the given range 1-3!\nYour input was: %d.", userInput1));

                        }
                    }
                    break;
                case 2:
                    System.out.println(String.format("\nThis is all the information about you %s:\n" + currentCustomer, currentCustomer.getName()));
                    break;
                case 3:
                    if (currentCustomer.getMemberID()==null) {
                        boolean keepGoing2 = true;
                        while (keepGoing2) {
                            int decision = validateInput(memberInfo);
                            switch (decision) {
                                case 0:
                                    keepGoing2 = false;
                                    break;
                                case 1:
                                    currentCustomer.setMemberID(String.valueOf(generateRandomMemberID()));
                                    currentCustomer.setTotalAmountSpent((currentCustomer.getTotalAmountSpent() + 10));
                                    System.out.println("Congratulations! You just became a member!");
                                    keepGoing2 = false;
                                    break;
                                default:
                                    System.out.println("Please enter 1 for yes or 0 for no!");
                            }
                        }

                    }else System.out.println(String.format("%s you are already a member!", currentCustomer.getName()));
                    break;
                case 4:
                    saveMembers(memberList);
                    System.exit(0);
                default:
                    System.out.println(String.format("Please choose within the given range 1-3!\nYour input was: %d.", userInput));
            }
        }

    }




    public static void main(String[] args) {

        ArrayList<bookType> bookList = new ArrayList<bookType>(100);

        // Create and Populate the list of authors
        ArrayList<String> authors1 = new ArrayList<String>(4);
        authors1.add("Auth1");
        authors1.add("Auth2");
        authors1.add("Auth3");
        authors1.add("Auth4");

        //Create book objects
        bookType b1 = new bookType("Title1", authors1, "Publisher1", "123-3123-31212-3123", 13.33, 34, Category.SCIFI);
        bookType b2 = new bookType("Title2", authors1, "Publisher2", "456-3123-31212-3123", 10, 56, Category.HORROR);
        bookType b3 = new bookType("Title3", authors1, "Publisher3", "907-3123-31212-3123", 12.5, 22, Category.ROMANCE);
        bookType b4 = new bookType("Title4", authors1, "Publisher4", "234-3123-31212-3123", 89.3, 10, Category.FANTASY);
        bookType b5 = new bookType("Title5", authors1, "Publisher5", "416-1234-31212-3123", 7.9, 9, Category.SCIFI);
        bookType b6 = new bookType("Title6", authors1, "Publisher6", "113-3123-23334-3123", 8, 34, Category.SCIFI);
        bookType b7 = new bookType("Title7", authors1, "Publisher7", "456-2141324-32-3123", 25.25, 56, Category.HORROR);
        bookType b8 = new bookType("Title8", authors1, "Publisher8", "987-3123-23412314-3", 95.1, 22, Category.ROMANCE);
        bookType b9 = new bookType("Title9", authors1, "Publisher9", "254-3123-31212-3123", 8.96, 10, Category.FANTASY);
        bookType b10 = new bookType("Title10", authors1, "Publisher10", "462341-3234-32-3123", Category.SCIFI);
        bookType b11 = new bookType("Title11", authors1, "Publisher11", "462341-3224-32-3123", Category.SCIFI);


        //Populate the book list
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);
        bookList.add(b5);
        bookList.add(b6);
        bookList.add(b7);
        bookList.add(b8);
        bookList.add(b9);
        bookList.add(b10);
        bookList.add(b11);


//        //Testing
//
//            //Getters
//        System.out.println("Title of b1:" + b1.getTitle());
//        System.out.println("Authors of b2:" +b2.getAuthors());
//        System.out.println("Publisher of b3:" +b3.getPublisher());
//        System.out.println("ISBN of b4:" +b4.getISBN());
//        System.out.println("Price of b5:" +b5.getPrice());
//        System.out.println("Copies Available of b6:" +b6.getCopiesAvailable());
//        System.out.println("Category of b7:" +b7.getCategory());
//            //toString
//        System.out.println("To string method for b8:\n" + b8.toString());
//            //Setters
//        b1.setTitle("NewTitle1");
//        System.out.println("Title of b1 after:" + b1.getTitle());
//
//        b2.removeAuthor(2);
//        try {
//            b2.addAuthor("NewAuthor");
//        } catch (bookType.CapacityException e) {
//            e.printStackTrace();
//        }
//        b2.replaceAuthor(1,"NewAuthor1");
//        System.out.println("Authors of b2 after:" +b2.getAuthors());
//
//        b3.setPublisher("NewPublisher3");
//        System.out.println("Publisher of b3 after:" +b3.getPublisher());
//
//        b4.setISBN("new-3212-12312-312");
//        System.out.println("ISBN of b4 after:" +b4.getISBN());
//
//        b5.setPrice(0.00);
//        System.out.println("Price of b5 after:" +b5.getPrice());
//
//        b6.setCopiesAvailable(999999);
//        System.out.println("Copies Available of b6 after:" +b6.getCopiesAvailable());
//
//        b7.setCategory(Category.FANTASY);
//        System.out.println("Category of b7 after:" +b7.getCategory());
//            // More methods
//        System.out.println("The book found by title: " + searchByTitle("Title11",bookList));
//        System.out.println("The book found by ISBN: " + searchByISBN("456-3123-31212-3123", bookList));
//        System.out.println("The books that fit your budget: " + searchByBudget(9.2, bookList));
//
//        updateCopies("Title2", 0, bookList);
//        System.out.println("Copies Available of b2:" +b2.getCopiesAvailable());
//
//        applyDiscount("Title3", 1, bookList);
//        System.out.println("Price of b3:" +b3.getPrice());




        ArrayList<memberType> memberList = new ArrayList<>(100);

        // Create member objects
        memberType m1 = new memberType("Jason", "7074", 0, 0);
        memberType m2 = new memberType("Chris");
        memberType m3 = new memberType("Helen", "9663", 23, 256.4);
        memberType m4 = new memberType("John", "3587", 8, 99.2);
        memberType m5 = new memberType("George");

        // Populate the member list
        memberList.add(m1);
        memberList.add(m2);
        memberList.add(m3);
        memberList.add(m4);
        memberList.add(m5);


//        // Testing
//            // Getters
//        System.out.println("Name of member 2: "+m2.getName());
//        System.out.println("Member ID of member 1: "+m1.getMemberID());
//        System.out.println("Books purchased for member 3: "+m3.getBooksPurchased());
//        System.out.println("Total Amount Spent for member 4: " + m4.getTotalAmountSpent());
//            // toString
//        System.out.println("ToString for member 1: \n"+m1.toString());
//            // Setters
//        m2.setName("NewName");
//        System.out.println("Name of member 2 after: "+m2.getName());
//
//        m1.setMemberID("NewMemberID");
//        System.out.println("Member ID of member 1 after: "+m1.getMemberID());
//
//        m3.setBooksPurchased(99999);
//        System.out.println("Books purchased for member 3 after: "+m3.getBooksPurchased());
//
//        m4.setTotalAmountSpent(1000.99);
//        System.out.println("Total Amount Spent for member 4 after: " + m4.getTotalAmountSpent());
//
//            // More Methods
//        System.out.println("This is the member found by name: "+searchByName("George",memberList));
//        System.out.println("This is the member found by memberID: "+searchByID("j-re635897",memberList));
//        System.out.println("Average book price for the specified member: "+showAverageBookPrice("h-di759663", memberList));
//
//        updateBooksPurchased("h-di759663", 0, memberList);
//        System.out.println("Books purchased for member 3 after UPDATE: "+m3.getBooksPurchased());


        try {
            bookstore(bookList, memberList);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
