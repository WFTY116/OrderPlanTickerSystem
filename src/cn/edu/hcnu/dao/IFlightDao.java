package cn.edu.hcnu.dao;

import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.dao.impl.FlightDaoIml;

import java.sql.SQLException;
import java.util.Set;

public interface IFlightDao {
    void insertFlight(Flight flight) throws SQLException;
    Set<Flight> getAllFLight();
    Flight getFlightByDepartureTime(String departureTime);
    Flight getFlightByDepartureAirport(String departureAirPort);
    Flight getFlightByDestinationAirPort(String destinationAirPort);
    void updateFlight(Flight flight);

}
