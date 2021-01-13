package cn.edu.hcnu.dao.impl;

import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.dao.IFlightDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class FlightDaoIml implements IFlightDao {

    @Override
    public void insertFlight(Flight flight) throws SQLException {

        String url="jdbac:oracle:thin:@localhost:1521:orcl";
        String username="opts";
        String password="opts1234";
        Connection conn= DriverManager.getConnection(url,username,password);
        String sql="insert into flight values(?,?,?,?,?,?,?)";

        PreparedStatement pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,flight.getId());
        pstmt.setString(2,flight.getFlightId());
        pstmt.setString(3,flight.getPlaneType());
        pstmt.setInt(4,flight.getCurrentSeatsNum());
        pstmt.setString(5,flight.getDepartureAirPort());
        pstmt.setString(6,flight.getDestinationAirPort());
        pstmt.setString(7,flight.getDepartureTime());

        pstmt.executeUpdate();

    }

    @Override
    public Set<Flight> getAllFLight() {
        return null;
    }

    @Override
    public Flight getFlightByDepartureTime(String departureTime) {
        return null;
    }

    @Override
    public Flight getFlightByDepartureAirport(String departureAirPort) {
        return null;
    }

    @Override
    public Flight getFlightByDestinationAirPort(String destinationAirPort) {
        return null;
    }

    @Override
    public void updateFlight(Flight flight) {

    }
}
