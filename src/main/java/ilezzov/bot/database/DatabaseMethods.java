package ilezzov.bot.database;

import ilezzov.bot.Main;

import java.sql.*;
import java.util.Date;

import static java.lang.StringTemplate.STR;

public class DatabaseMethods {
    private final static Connection connection = Main.connection;

    public static boolean checkUser(Long userId) {
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT userId FROM users WHERE userId = " + userId);

            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void newUser(Long userId, String[] activation) {
        try {
            connection.createStatement().execute(STR."INSERT INTO users VALUES ('\{userId}', 'default', 'start', '1', 0)");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO statsNewUsers VALUES (?, ?, ?, ?)");
            preparedStatement.setLong(1, userId);
            preparedStatement.setString(2, activation[0]);
            preparedStatement.setString(3, activation[1]);
            preparedStatement.setString(4, new Date().toString());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateMessageId(Long userId, Integer messageId) {
        try {
            connection.createStatement().execute(STR."UPDATE users SET messageId = \{messageId} WHERE userId = \{userId}");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFlag(Long userId) {
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT flag FROM users WHERE userId = " + userId);
            resultSet.next();

            return resultSet.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static ResultSet getAdmins() {
        try {
            return connection.createStatement().executeQuery("SELECT userId FROM users WHERE staff_group = admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateFlag(Long userId, String flag) {
        try {
            connection.createStatement().execute(STR."UPDATE users SET flag = '\{flag}' WHERE userId = '\{userId}'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void disableMailing(Long userId) {
        try {
            connection.createStatement().execute(STR."UPDATE users SET canMailing = '0' WHERE userId = '\{userId}'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void enableMailing(Long userId) {
        try {
            connection.createStatement().execute(STR."UPDATE users SET canMailing = '1' WHERE userId = '\{userId}'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer getMessageId(Long userId) {
        try {
            ResultSet messageId = connection.createStatement().executeQuery(STR."SELECT messageId FROM users WHERE userId = '\{userId}'");
            messageId.next();

            return messageId.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer getMailingStatus(Long userId) {
        try {
            ResultSet mailingStatus = connection.createStatement().executeQuery(STR."SELECT canMailing FROM users WHERE userId = '\{userId}'");
            mailingStatus.next();

            return mailingStatus.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
