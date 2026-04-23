package org.example;

import java.sql.*;

import org.h2.tools.Server;

public class JdbcDemo {

    private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            Server webServer = Server.createWebServer("-webPort", "8083", "-tcpAllowOthers").start();
            System.out.println("H2 Console started at: http://localhost:8083");

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                System.out.println("Connected to H2 in-memory database.\n");

                createTable(connection);

                insertMovie(connection, "Inception", "Christopher Nolan", 2010, "Sci-Fi");
                insertMovie(connection, "Interstellar", "Christopher Nolan", 2014, "Sci-Fi");
                insertMovie(connection, "The Matrix", "Wachowski Sisters", 1999, "Action");

                System.out.println("=== ALL MOVIES AFTER INSERT ===");
                printAllMovies(connection);

                updateMovieGenre(connection, 2, "Adventure");
                System.out.println("\n=== ALL MOVIES AFTER UPDATE ===");
                printAllMovies(connection);

                deleteMovie(connection, 1);
                System.out.println("\n=== ALL MOVIES AFTER DELETE ===");
                printAllMovies(connection);

                System.out.println("\nOpen the H2 console in your browser!");
                System.out.println("JDBC URL: " + URL);
                System.out.println("User: sa (no password)");
                System.out.println("\nPress ENTER to exit...");
                System.in.read();
            }

            webServer.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = """
            CREATE TABLE movies (
                id INT AUTO_INCREMENT PRIMARY KEY,
                title VARCHAR(100) NOT NULL,
                director VARCHAR(100) NOT NULL,
                release_year INT NOT NULL,
                genre VARCHAR(50) NOT NULL
            )
            """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Table 'movies' created.");
        }
    }

    private static void insertMovie(Connection connection, String title, String director, int releaseYear, String genre) throws SQLException {
        String sql = "INSERT INTO movies (title, director, release_year, genre) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, director);
            ps.setInt(3, releaseYear);
            ps.setString(4, genre);

            ps.executeUpdate();
            System.out.println("Inserted: " + title);
        }
    }

    private static void printAllMovies(Connection connection) throws SQLException {
        String sql = "SELECT id, title, director, release_year, genre FROM movies ORDER BY id";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("director") + " | " +
                                rs.getInt("release_year") + " | " +
                                rs.getString("genre")
                );
            }
        }
    }

    private static void updateMovieGenre(Connection connection, int id, String newGenre) throws SQLException {
        String sql = "UPDATE movies SET genre = ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newGenre);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Updated movie id " + id);
        }
    }

    private static void deleteMovie(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM movies WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Deleted movie id " + id);
        }
    }
}