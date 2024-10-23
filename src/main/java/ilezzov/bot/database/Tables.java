package ilezzov.bot.database;

import ilezzov.bot.Main;
import java.sql.Connection;
import java.sql.SQLException;

public class Tables {
    private final static Connection connection = Main.connection;

    public static void checkTables() {
        usersTable();
        statsNewUserTable();
    }

    private static void usersTable() {
        try {
            connection.createStatement().execute("CREATE TABLE IF NOT EXISTS users (" +
                    "userId BIGINT, " +
                    "staff_group TEXT, " +
                    "flag TEXT, " +
                    "canMailing BIGINT " +
                    ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void statsNewUserTable() {
        try {
            connection.createStatement().execute("CREATE TABLE IF NOT EXISTS statsNewUsers (" +
                    "userId BIGINT, " +
                    "activation TEXT, " +
                    "date TEXT " +
                    ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 }
