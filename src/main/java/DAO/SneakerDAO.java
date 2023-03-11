package DAO;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Util.ConnectionSingleton;
import Model.Sneaker;

public class SneakerDAO {
    public List<Sneaker> getAllSneakers() {
        Connection connection = ConnectionSingleton.getConnection();
        List<Sneaker> sneakers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM sneaker";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Sneaker sneaker = new Sneaker(resultSet.getString("name"), resultSet.getString("brand"),
                        resultSet.getString("color"), resultSet.getString("price"));
                sneakers.add(sneaker);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sneakers;
    }

    public List<Sneaker> getSneakersByBrand(String brand){
        Connection connection = ConnectionSingleton.getConnection();
        List<Sneaker> sneakers = new ArrayList<>();
        try{
            String sql = " SELECT * FROM sneaker WHERE brand = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, brand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Sneaker sneaker = new Sneaker(resultSet.getString("name"), resultSet.getString("brand"),
                        resultSet.getString("color"), resultSet.getString("price"));
                sneakers.add(sneaker);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sneakers;
    }

    public List<Sneaker> getSneakersByColor(String color){
        Connection connection = ConnectionSingleton.getConnection();
        List<Sneaker> sneakers = new ArrayList<>();
        try{
            String sql = " SELECT * FROM sneaker WHERE color = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, color);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Sneaker sneaker = new Sneaker(resultSet.getString("name"), resultSet.getString("brand"),
                        resultSet.getString("color"), resultSet.getString("price"));
                sneakers.add(sneaker);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sneakers;
    }

    public Sneaker addNewSneaker(Sneaker sneaker){
        Connection connection = ConnectionSingleton.getConnection();
        try {
            String sql = "INSERT INTO sneaker (name, brand, color, price) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sneaker.name);
            preparedStatement.setString(2, sneaker.brand);
            preparedStatement.setString(3, sneaker.color);
            preparedStatement.setString(4, sneaker.price);
            int resultSet = preparedStatement.executeUpdate();

            return sneaker;
        }
        catch (SQLException e) {
            System.out.println( e.getMessage());

            return null;
        }

    }
    public void updateSneaker(Sneaker sneaker) {
        Connection conn = ConnectionSingleton.getConnection();
        try {
            String sql = "UPDATE sneaker SET brand = ?, color = ?, price =? WHERE name=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, sneaker.brand);
            preparedStatement.setString(2, sneaker.color);
            preparedStatement.setString(3, sneaker.price);
            preparedStatement.setString(4, sneaker.name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
