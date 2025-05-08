package dev.prkprime.f1telemetry.f122.session;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 safety car statuses
 */
@Getter
@RequiredArgsConstructor
public enum SafetyCarStatus {

    NO_SAFETY_CAR(0),
    FULL_SAFETY_CAR(1),
    VIRTUAL_SAFETY_CAR(2),
    FORMATION_LAP(3);

    private final int id;

    /**
     * Get a SafetyCarStatus from its numeric value
     *
     * @param id numeric identifier
     * @return corresponding SafetyCarStatus
     */
    public static SafetyCarStatus fromId(int id) {
        for (SafetyCarStatus status : values()) {
            if (status.id == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid safety car status ID: " + id);
    }
}