package dev.prkprime.f1telemetry.f122.lapdata;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 result statuses
 */
@Getter
@RequiredArgsConstructor
public enum ResultStatus {

    INVALID(0),
    INACTIVE(1),
    ACTIVE(2),
    FINISHED(3),
    DID_NOT_FINISH(4),
    DISQUALIFIED(5),
    NOT_CLASSIFIED(6),
    RETIRED(7);

    private final int id;

    /**
     * Get a ResultStatus from its numeric value
     *
     * @param id numeric identifier
     * @return corresponding ResultStatus
     */
    public static ResultStatus fromId(int id) {
        for (ResultStatus status : values()) {
            if (status.id == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid result status ID: " + id);
    }
}