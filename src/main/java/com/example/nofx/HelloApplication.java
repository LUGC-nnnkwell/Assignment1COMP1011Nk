package com.example.nofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/LAB_5";
        String user = "student";
        String password = "student";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT firstName, lastName,age, major FROM Students";
            ResultSet rs = stmt.executeQuery(query);

            int total_count = 0;

            // Populate the chart with data from the database
            while (rs.next()) {
                String first_name = rs.getString("firstName");
                String last_name = rs.getString("lastName");
                int age_value = rs.getInt("age");
                String majordeep = rs.getString("major");

                // log all
                System.out.println("---------");
                System.out.println(first_name);
                System.out.println(last_name);
                System.out.println(age_value);
                System.out.println(majordeep);
                System.out.println("---------");

                total_count++;
            }

            // close it for a while
            rs.close();
            stmt.close();

            // close it for a beak or two
            conn.close();

            System.out.println(total_count);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // solved, finished!
        System.out.println("We're done!");

        launch();
    }
}