package com.kharitonov.text_editor.main;

import com.kharitonov.text_editor.connector.SqlConnector;
import com.kharitonov.text_editor.entity.Trip;
import com.kharitonov.text_editor.entity.TruckDriver;
import com.kharitonov.text_editor.exception.ProjectException;
import com.kharitonov.text_editor.file.parser.TripParser;
import com.kharitonov.text_editor.file.reader.DosFileReader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DosFileReader reader = new DosFileReader();
        String data = reader.read("resources\\JULY52");
        TripParser parser = new TripParser();
        List<Trip> tripList = parser.parse(data);
        List<TruckDriver> drivers = new ArrayList<>();
        String sql_find = "SELECT id_driver, name FROM drivers";
        try (Connection connection = SqlConnector.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql_find)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id_driver");
                String name = resultSet.getString("name");
                TruckDriver driver = new TruckDriver(id, name);
                drivers.add(driver);
            }
        } catch (SQLException | ProjectException e) {
            e.printStackTrace();
        }
    }
}
