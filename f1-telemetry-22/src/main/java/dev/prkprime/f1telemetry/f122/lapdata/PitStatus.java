package dev.prkprime.f1telemetry.f122.lapdata;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 pit statuses
 */
@Getter
@RequiredArgsConstructor
public enum PitStatus {

    NONE(0),
    PITTING(1),
    IN_PIT_AREA(2);

    private final int id;

    /**
     * Get a PitStatus from its numeric value
     *
     * @param id numeric identifier
     * @return corresponding PitStatus
     */
    public static PitStatus fromId(int id) {
        for (PitStatus status : values()) {
            if (status.id == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid pit status ID: " + id);
    }
}