package vn.com.stanford.springmvc.module;

import java.sql.*;
import java.util.ArrayList;

public class DAO {
    private ArrayList<User> users = new ArrayList<User>();
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String user = "root";
    private static String pass = "";
    private Connection connection;

    public DAO() {
        try {
            users = new ArrayList<User>();
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM `user`";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                users.add(new User(resultSet.getString("Username"), resultSet.getString("Password")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        try {
            String query = "INSERT INTO `user` (`Username`, `Password`) VALUES (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
