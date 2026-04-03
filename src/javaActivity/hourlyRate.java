package javaActivity;

/**
 * Enum representing the three possible hourly rates for an employee.
 * Each constant holds its numeric value in euros per hour.
 *
 * LOW    -> 24 EUR/h
 * MEDIUM -> 28 EUR/h
 * HIGH   -> 32 EUR/h
 */
public enum hourlyRate {

    LOW(24),
    MEDIUM(28),
    HIGH(32);

    private final int value;

    hourlyRate(int v) {
        this.value = v;
    }

    /**
     * Returns the numeric hourly rate value in euros.
     */
    public int hourlyRate() {
        return value;
    }
}
