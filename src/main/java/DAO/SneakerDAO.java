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
                        resultSet.getString("color"), resultSet.getDouble("price"));
                sneakers.add(sneaker);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sneakers;
    }
}
