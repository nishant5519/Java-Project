package cloning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSqlExample {
	public static void main(String[] args) {
		
try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RialtoMarketing?currentSchema=rm_release21", "postgres", "nishant")) {
//try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/att_transactions?ssl=false&amp;sslmode=disable&amp;sslfactory=org.postgresql.ssl.NonValidatingFactory", "att_transactions_user", "nishant")) {
//try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RialtoMarketing?ssl=false&amp;sslmode=disable&amp;sslfactory=org.postgresql.ssl.NonValidatingFactory", "postgres", "nishant")) {
//try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/vcheck2_int?ssl=false&amp;sslmode=disable&amp;sslfactory=org.postgresql.ssl.NonValidatingFactory", "postgres", "nishant")) {

			System.out.println("Java JDBC PostgreSQL Example");
			
			 if (connection != null) {
	                System.out.println("Connected to the database!");
	            } else {
	                System.out.println("Failed to make connection!");
	            }
		} /*catch (ClassNotFoundException e) {
			System.out.println("PostgreSQL JDBC driver not found.");
			e.printStackTrace();
		}*/ catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}
	}
}
