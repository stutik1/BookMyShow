package com.stuti.model;

public class Seats {
    public Seats() {

    }

    public void setShowId(long id) {
    }

        public enum SeatStatus {
            AVAILABLE, OCCUPIED, OUT_OF_SERVICE, BOOKED
        }


        private Long seatId;
        private String seatRow;
        private Integer seatColumn;
        private SeatStatus status;
        private Double price;
        private Shows showId;

    public Seats(Long seatId, String seatRow, Integer seatColumn, SeatStatus status, Double price, Shows showId) {
        this.seatId = seatId;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.status = status;
        this.price = price;
        this.showId = showId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public Integer getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(Integer seatColumn) {
        this.seatColumn = seatColumn;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Shows getShowId() {
        return showId;
    }

    public void setShowId(Shows showId) {
        this.showId = showId;
    }
}

