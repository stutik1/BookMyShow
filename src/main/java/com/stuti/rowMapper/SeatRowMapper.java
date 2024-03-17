package com.stuti.rowMapper;

import com.stuti.Seats;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Seats seat = new Seats();
        seat.setSeatId(rs.getLong("seat_id"));
        seat.setSeatRow(rs.getString("seat_row"));
        seat.setSeatColumn(rs.getInt("seat_column"));
        seat.setStatus(Seats.SeatStatus.valueOf(rs.getString("status")));
        seat.setPrice(rs.getDouble("price"));
        seat.setShowId(rs.getLong("id"));
        return seat;
    }
}
