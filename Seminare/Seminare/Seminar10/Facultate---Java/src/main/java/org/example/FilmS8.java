package org.example;

import java.sql.*;

public class FilmS8 {

    private static final String URL = "jdbc:sqlite:filme.db";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            System.out.println("Connected to SQLite database.\n");

            createTable(connection);

            insertFilm(connection, "American Sniper", 140, 9.3);
            insertFilm(connection, "Peaky Blinders", 200, 7.8);
            insertFilm(connection, "Narcos", 500, 9.9);

            System.out.println("\n== Toate filmele din baza de date ==");
            printAll(connection);

            updateFilm(connection, 2, 5.0);
            System.out.println("\n== Toate filmele dupa update ==");
            printAll(connection);

            deleteFilm(connection, 1);
            System.out.println("\n== Toate filmele dupa delete ==");
            printAll(connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS filme (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    denumire TEXT NOT NULL,
                    durata INTEGER NOT NULL,
                    rating REAL NOT NULL CHECK (rating BETWEEN 0 AND 10)
                )
                """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Tabela filme a fost creata.");
        }
    }

    private static void insertFilm(Connection connection, String denumire, int durata, double rating) throws SQLException {
        String sql = "INSERT INTO filme (denumire, durata, rating) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, denumire);
            ps.setInt(2, durata);
            ps.setDouble(3, rating);
            ps.executeUpdate();

            System.out.println("A fost inserat filmul: " + denumire);
        }
    }

    private static void printAll(Connection connection) throws SQLException {
        String sql = "SELECT * FROM filme ORDER BY id";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("denumire") + " | " +
                                rs.getInt("durata") + " | " +
                                rs.getDouble("rating")
                );
            }
        }
    }

    private static void updateFilm(Connection connection, int id, double rating) throws SQLException {
        String sql = "UPDATE filme SET rating = ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, rating);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("\nA fost modificat ratingul filmului cu id-ul: " + id);
        }
    }

    private static void deleteFilm(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM filme WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("\nA fost sters filmul cu id-ul: " + id);
        }
    }
}