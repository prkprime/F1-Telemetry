package dev.prkprime.f1telemetry.f122.session;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 session types
 */
@Getter
@RequiredArgsConstructor
public enum SessionType {

    UNKNOWN(0),
    PRACTICE_1(1),
    PRACTICE_2(2),
    PRACTICE_3(3),
    SHORT_PRACTICE(4),
    QUALIFYING_1(5),
    QUALIFYING_2(6),
    QUALIFYING_3(7),
    SHORT_QUALIFYING(8),
    ONE_SHOT_QUALIFYING(9),
    RACE(10),
    RACE_2(11),
    RACE_3(12),
    TIME_TRIAL(13);

    private final int id;

    /**
     * Get a SessionType from its numeric value
     *
     * @param id numeric identifier
     * @return corresponding SessionType
     */
    public static SessionType fromId(int id) {
        for (SessionType sessionType : values()) {
            if (sessionType.id == id) {
                return sessionType;
            }
        }
        return UNKNOWN;
    }
}