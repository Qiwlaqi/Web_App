package com.malets.clean.main;

import com.malets.clean.bean.Order;
import com.malets.clean.bean.User;
import com.malets.clean.dao.*;
import com.malets.clean.exception.DAoException;
import com.malets.clean.pool.CustomConnectionPool;
import com.malets.clean.util.PasswordManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class TestConnection {
    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws DAoException {
        /*String url = "jdbc:mysql://localhost/cleaning_company";
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "pass");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");
        try{

                //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cleaning_company", "root", "pass");

                //Connection connection = DriverManager.getConnection(url, properties);
                CustomConnectionPool.INSTANCE.createPool();
                Connection connection = CustomConnectionPool.INSTANCE.getConnection();
                Statement statement = connection.createStatement();
                //CustomConnectionPool.INSTANCE.releaseConnection(connection);

            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();
            while (resultSet.next()){
                String login = resultSet.getString(1);
                String pass = resultSet.getString(2);
                String name = resultSet.getString("name");
                String surname = resultSet.getString(4);
                int phone = resultSet.getInt("phone");
                users.add(new User(name, surname, login, pass, phone));
            }
            System.out.println(users);
            //ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            //System.out.println(resultSetMetaData.getColumnTypeName(4));
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getDatabaseProductVersion());
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        CustomConnectionPool.INSTANCE.getConnection();

        System.out.println(PasswordManager.INSTANCE.encrypt("pass"));
        System.out.println(PasswordManager.INSTANCE.encrypt("lolololo"));

        System.out.println(PasswordManager.INSTANCE.encrypt("lelelele"));


        //User user = new UserDAO().findUser(login);
        /*user.setLogin(login);
        user.setPassword("7777777");
        user.setName("newDen");*/
        //user.setSurname("NewMalets");
        //user.setPhone(2222222);
        //System.out.println(new UserDAO().update(user));
        //System.out.println(userDAO.findUserByLogin("arino4ka"));
        CustomConnectionPool.INSTANCE.destroyPool();

    }


}
