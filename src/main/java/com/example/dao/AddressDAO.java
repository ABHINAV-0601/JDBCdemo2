package com.example.dao;

import com.example.data.Address;
import com.example.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressDAO {

    public int insertIntoAddress(Address address) throws SQLException, ClassNotFoundException {
        int rows = 0;

        Connection connection = DbConnection.getConnection();

        String sql = "insert into address_tbl (flat_no,building_name,street,city,state,pincode,country) values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,address.getFlatNo());
        preparedStatement.setString(2,address.getBuildingName());
        preparedStatement.setString(3,address.getStreet());
        preparedStatement.setString(4,address.getCity());
        preparedStatement.setString(5,address.getState());
        preparedStatement.setInt(6,address.getPinCode());
        preparedStatement.setString(7,address.getCountry());

        rows = preparedStatement.executeUpdate();

        return rows;
    }
}