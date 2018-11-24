package com.dz.Model.Library;

public class Library
{
    private int bookid;
    private String phoneNumber;
    private String name;
    private String password;
    private String email;
    private String bookName;
    private String firstname;
    private String lastname;
    private String book_issue;
    private String book_issuedate;
    private String book_auther;
    private int book_quantity;
    private String book_return;
    private int id;




    public String getBook_auther() {
        return book_auther;
    }

    public void setBook_auther(String book_auther) {
        this.book_auther = book_auther;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBook_issue() {
        return book_issue;
    }

    public void setBook_issue(String book_issue) {
        this.book_issue = book_issue;
    }

    public String getBook_issuedate() {
        return book_issuedate;
    }

    public void setBook_issuedate(String book_issuedate) {
        this.book_issuedate = book_issuedate;
    }

    public int getBook_quantity() {
        return book_quantity;
    }

    public void setBook_quantity(int book_quantity) {
        this.book_quantity = book_quantity;
    }

    public String getBook_return() {
        return book_return;
    }

    public void setBook_return(String book_return) {
        this.book_return = book_return;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





    public  Library()
    {

    }
   /*  public  Library( int id ,String password,String name,String email,String Firstname ,String Lastname,String Number ,String book_issue,String book_issuedate , int book_quantity, String book_return)
     {
         this.name=name;
         this.email=email;
         this.password=password;
         this.firstname =Firstname;
         this.Number= Number;
         this.lastname =Lastname;
         this.email=email;
         this.password=password;
          this.book_issue=book_issue;
          this.book_issuedate=book_issuedate;
          this.book_quantity=book_quantity;
          this.book_return=book_return;
          this.id=id;
     }*/

}
