package dev.prkprime.f1telemetry.f122.lapdata;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 driver statuses
 */
@Getter
@RequiredArgsConstructor
public enum DriverStatus {

    IN_GARAGE(0),
    FLYING_LAP(1),
    IN_LAP(2),
    OUT_LAP(3),
    ON_TRACK(4);

    private final int id;

    /**
     * Get a DriverStatus from its numeric value
     *
     * @param id numeric identifier
     * @return corresponding DriverStatus
     */
    public static DriverStatus fromId(int id) {
        for (DriverStatus status : values()) {
            if (status.id == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid driver status ID: " + id);
    }
}