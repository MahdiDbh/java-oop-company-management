package javaActivity;

// The 3 possible hourly rates: LOW=24, MEDIUM=28, HIGH=32 (EUR/h)
public enum hourlyRate {

    LOW(24),
    MEDIUM(28),
    HIGH(32);

    private final int value;

    hourlyRate(int v) {
        this.value = v;
    }

    // Returns the value in euros
    public int hourlyRate() {
        return value;
    }
}
