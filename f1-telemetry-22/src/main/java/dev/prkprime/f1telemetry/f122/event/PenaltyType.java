package dev.prkprime.f1telemetry.f122.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 penalty types
 */
@Getter
@RequiredArgsConstructor
public enum PenaltyType {

    DRIVE_THROUGH(0),
    STOP_GO(1),
    GRID_PENALTY(2),
    PENALTY(3),
    TIME_PENALTY(4),
    WARNING(5),
    DISQUALIFIED(6),
    REMOVED_FROM_FORMATION_LAP(7),
    PARKED_TOO_LONG_TIMER(8),
    TYRE_REGULATIONS(9),
    THIS_LAP_INVALIDATED(10),
    THIS_AND_NEXT_LAP_INVALIDATED(11),
    THIS_LAP_INVALIDATED_WITHOUT_REASON(12),
    THIS_AND_NEXT_LAP_INVALIDATED_WITHOUT_REASON(13),
    THIS_AND_PREVIOUS_LAP_INVALIDATED(14),
    THIS_AND_PREVIOUS_LAP_INVALIDATED_WITHOUT_REASON(15),
    RETIRED(16),
    BLACK_FLAG_TIMER(17);

    private final int id;

    /**
     * Get a PenaltyType from its numeric value
     *
     * @param id numeric identifier
     * @return corresponding PenaltyType
     */
    public static PenaltyType fromId(int id) {
        for (PenaltyType penaltyType : values()) {
            if (penaltyType.id == id) {
                return penaltyType;
            }
        }
        throw new IllegalArgumentException("Invalid penalty type ID: " + id);
    }
}