package dev.prkprime.f1telemetry.f122.session;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 track IDs
 */
@Getter
@RequiredArgsConstructor
public enum TrackId {

    MELBOURNE(0),
    PAUL_RICARD(1),
    SHANGHAI(2),
    BAHRAIN(3),
    CATALUNYA(4),
    MONACO(5),
    MONTREAL(6),
    SILVERSTONE(7),
    HOCKENHEIM(8),
    HUNGARORING(9),
    SPA(10),
    MONZA(11),
    SINGAPORE(12),
    SUZUKA(13),
    ABU_DHABI(14),
    TEXAS(15),
    BRAZIL(16),
    AUSTRIA(17),
    SOCHI(18),
    MEXICO(19),
    BAKU(20),
    SAKHIR_SHORT(21),
    SILVERSTONE_SHORT(22),
    TEXAS_SHORT(23),
    SUZUKA_SHORT(24),
    HANOI(25),
    ZANDVOORT(26),
    IMOLA(27),
    PORTIMAO(28),
    JEDDAH(29),
    MIAMI(30),
    UNKNOWN(-1);

    private final int id;

    /**
     * Get a TrackId from its numeric value
     *
     * @param id numeric identifier
     * @return corresponding TrackId
     */
    public static TrackId fromId(int id) {
        for (TrackId trackId : values()) {
            if (trackId.id == id) {
                return trackId;
            }
        }
        return UNKNOWN;
    }
}