package enums;

public enum SeatCategory {
    PREMIUM(200.0),
    REGULAR(100.0);

    private final Double price;

    SeatCategory(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
}
