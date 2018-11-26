package com.dz.Model.Library;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * In this we done all operation
 */
public class LibraryOperation {
    private DBconfig dBconfig;
    private Connection connection;
    private Logger logger = Logger.getLogger(LibraryOperation.class.getName());

    public String userlogin(Library library) throws NullPointerException {
        dBconfig = new DBconfig();
        connection = dBconfig.getconnection();


        try {

            String query = "insert into logindata (uid,username,userpass,book_name,book_issuedate,book_quantity,book_return) values(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            String username = library.getName();
            String password = library.getPassword();
            String book_issue = library.getBook_issue();
            String book_issuedate = library.getBook_issuedate();
            int book_quantity = library.getBook_quantity();
            String book_return = library.getBook_return();
            String usernameDB = "";
            String userpassword = "";
            String roleDB = "";
            System.out.println("user login");
            String query1 = "select max(uid) from logindata";
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            ResultSet resultSet = preparedStatement1.executeQuery();

            resultSet.next();
            preparedStatement.setInt(1, resultSet.getInt(1) + 1);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, book_issue);
            preparedStatement.setString(5, book_issuedate);
            preparedStatement.setInt(6, book_quantity);
            preparedStatement.setString(7, book_return);
            preparedStatement.execute();

            while ((resultSet.next())) {

                usernameDB = resultSet.getString("username");
                userpassword = resultSet.getString("password");
                roleDB = resultSet.getString("role");
                if (username.equals(usernameDB) && password.equals(userpassword) && roleDB.equals("Admin"))
                    return "Admin_Role";

                if (username.equals(usernameDB) && password.equals(userpassword) && roleDB.equals("User"))
                    return "User_Role";
                System.out.println("user login");
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "invalid user ";
    }

    /**
     * here we registrstion
     *
     * @param library
     */
    public void registration(Library library) {
        dBconfig = new DBconfig();
        connection = dBconfig.getconnection();
        System.out.println("aa gya");
        try {

            String data = "insert into registration  values(?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(data);

            int id = maxId();


            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, library.getFirstname());
            preparedStatement.setString(3, library.getLastname());
            preparedStatement.setString(4, library.getPhoneNumber());
            preparedStatement.setString(5, library.getEmail());
            preparedStatement.setString(6, library.getPassword());
            preparedStatement.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * In this we add book data
     *
     * @param library
     */
    public void addbook(Library library) {
        dBconfig = new DBconfig();
        connection = dBconfig.getconnection();

        try {
            String query = "insert into book values(?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            int id = bookmaxId();
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, library.getBookName());
            preparedStatement.setString(3, library.getBook_auther());
            preparedStatement.setInt(4, library.getBook_quantity());
            preparedStatement.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public int deletedata(int id) {

        dBconfig = new DBconfig();
        connection = dBconfig.getconnection();
        try {
            Statement statement = connection.createStatement();
            int count = statement.executeUpdate(String.format("DELETE FROM book where id=" + id + ";"));
            logger.info(count + " record deleted");

        } catch (SQLException e) {

        }
        return id;
    }


    public int maxId() throws SQLException {
        dBconfig = new DBconfig();
        connection = dBconfig.getconnection();
        String query4 = "select max(id) from registration";
        PreparedStatement preparedStatement1 = connection.prepareStatement(query4);

        ResultSet resultSet = preparedStatement1.executeQuery();
        resultSet.next();
        int id = resultSet.getInt(1) + 1;

        return id;
    }

    public int bookmaxId() throws SQLException {
        dBconfig = new DBconfig();
        connection = dBconfig.getconnection();
        String query = "select max(id) from book";
        PreparedStatement preparedStatement1 = connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement1.executeQuery();
        resultSet.next();
        int id = resultSet.getInt(1) + 1;
        return id;
    }

    public List<Library> display() {

        List<Library> libraryList = new ArrayList<>();
        try {
            dBconfig = new DBconfig();
            PreparedStatement preparedStatement = dBconfig.getconnection().prepareStatement("select * from book");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Library library = new Library();
                library.setBookid(rs.getInt(1));
                library.setBookName(rs.getString(2));
                library.setBook_auther(rs.getString(3));
                library.setBook_quantity(rs.getInt(4));
                libraryList.add(library);

            }
            return libraryList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * to show the User List from data Base
     */
    public List<User> showUserList() {

        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dBconfig.getconnection().prepareStatement("select username,userpass,uid from logindata");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();

                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("userpass"));
                user.setUid(rs.getInt("uid"));

                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public List<Library> getbookbyid(int id) {
        dBconfig = new DBconfig();
        try {
            PreparedStatement preparedStatement = dBconfig.getconnection().prepareStatement("select id,book_name,book_quantity from book where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();


            List<Library> libraryList = new ArrayList<>();
            while (rs.next()) {
                Library library = new Library();
                library.setBookid(rs.getInt(1));
                library.setBookName(rs.getString(2));
                ;
                library.setBook_quantity(rs.getInt(3));
                System.out.println(library.getBookName() + "  " + library.getBookid() + "the message form dao" + library.getBook_quantity());
                libraryList.add(library);
            }
            return libraryList;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public void updatebookquantity(int issuebookquantity, int id, int uid) {
        dBconfig = new DBconfig();
        String dbbookname = "";

        try {
            PreparedStatement preparedStatement = dBconfig.getconnection().prepareStatement("select book_quantity,book_name from book where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            int dbbookquantity = rs.getInt(1) - issuebookquantity;
            dbbookname = rs.getString(2);

            PreparedStatement preparedStatement1 = dBconfig.getconnection().prepareStatement("update book set book_quantity=? where id=?");
            preparedStatement1.setInt(1, dbbookquantity);
            preparedStatement1.setInt(2, id);
            preparedStatement1.execute();

            System.out.println("try to insert in issued book");
            PreparedStatement preparedStatementIssuedeBookData = dBconfig.getconnection().prepareStatement("select * from issuedbook");

            ResultSet resultSet1 = preparedStatementIssuedeBookData.executeQuery();
            if (resultSet1.next()) {
                ResultSet resultSetIssuedBook = preparedStatementIssuedeBookData.executeQuery();
                while (resultSetIssuedBook.next()) {
                    System.out.println("in while loop issued book");
                    if (resultSetIssuedBook.getInt(1) != id && resultSetIssuedBook.getInt("user_id") != uid) {
                        System.out.println("in else  loop issued book");
                        String date = date();
                        PreparedStatement preparedStatement2 = dBconfig.getconnection().prepareStatement("insert into issuedbook values(?,?,?,?,?)");
                        preparedStatement2.setInt(1, id);
                        preparedStatement2.setString(2, dbbookname);
                        preparedStatement2.setInt(3, issuebookquantity);
                        preparedStatement2.setInt(4, uid);
                        preparedStatement2.setString(5, date);
                        preparedStatement2.execute();

                    } else {

                        int qunt = resultSetIssuedBook.getInt(3);
                        qunt = qunt + issuebookquantity;
                        PreparedStatement preparedStatement3 = dBconfig.getconnection().prepareStatement("update issuedbook set book_quantity=? where user_id=? AND book_id=?");
                        preparedStatement3.setInt(1, qunt);
                        preparedStatement3.setInt(2, uid);
                        preparedStatement3.setInt(3, id);
                        preparedStatement3.execute();
                    }
                }
            } else {
                System.out.println("always new insert");
                String date = date();
                PreparedStatement preparedStatement2 = dBconfig.getconnection().prepareStatement("insert into issuedbook values(?,?,?,?,?)");
                preparedStatement2.setInt(1, id);
                preparedStatement2.setString(2, dbbookname);
                preparedStatement2.setInt(3, issuebookquantity);
                preparedStatement2.setInt(4, uid);
                preparedStatement2.setString(5, date);
                preparedStatement2.execute();

            }
           /* PreparedStatement preparedStatement2 = dBconfig.getconnection().prepareStatement("update logindata set book_name=?,book_issuedate=?,book_quantity=?,book_id=? where uid=?");

            preparedStatement2.setString(1, dbbookname);
            preparedStatement2.setString(2, issuedate);
            preparedStatement2.setInt(3, issuebookquantity);
            preparedStatement2.setInt(4, id);
            preparedStatement2.setInt(5, uid);
            preparedStatement2.execute();*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnbookquantity(int uid, int bookid, int dbbookquantity, int bookquantity) throws SQLException {
        dBconfig = new DBconfig();
        dbbookquantity = dbbookquantity - bookquantity;
        PreparedStatement preparedStatement = dBconfig.getconnection().prepareStatement("update issuedbook set book_quantity=? where book_id=? And user_id=?");
        preparedStatement.setInt(1, dbbookquantity);
        preparedStatement.setInt(2, bookid);
        preparedStatement.setInt(3, uid);
        preparedStatement.execute();

        PreparedStatement preparedStatement1 = dBconfig.getconnection().prepareStatement("select * from book where id=?");
        preparedStatement1.setInt(1, bookid);
        ResultSet resultSet = preparedStatement1.executeQuery();
        resultSet.next();
        int dbquantity = resultSet.getInt(4);
        dbquantity = dbquantity + bookquantity;

        PreparedStatement preparedStatement2 = dBconfig.getconnection().prepareStatement("update book set book_quantity=? where id=?");
        preparedStatement2.setInt(1, dbquantity);
        preparedStatement2.setInt(2, bookid);
        preparedStatement2.execute();
    }


    public List<User> getbookbyuserid(int uid) {
        dBconfig = new DBconfig();
        try {
            PreparedStatement preparedStatement = dBconfig.getconnection().prepareStatement("select * from issuedbook where user_id=?");
            preparedStatement.setInt(1, uid);
            ResultSet rs = preparedStatement.executeQuery();


            List<User> libraryList = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getInt(4));
                user.setBookid(rs.getInt(1));
                user.setBookName(rs.getString(2));
                user.setQuantity(rs.getInt(3));
                user.setIssue_date(rs.getString(5));
                libraryList.add(user);
            }
            for (User user : libraryList) {
                System.out.println(user.getUsername() + " " + user.getUid() + " " + user.getQuantity() + " " + user.getIssue_date());
            }
            return libraryList;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }


    public String date() {
        Calendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        month += 1;
        return year + "-" + month + "-" + day;
    }

}









