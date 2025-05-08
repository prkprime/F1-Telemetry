package dev.prkprime.f1telemetry.f122.lapdata;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 track sectors
 */
@Getter
@RequiredArgsConstructor
public enum Sector {

    SECTOR1(0),
    SECTOR2(1),
    SECTOR3(2);

    private final int id;

    /**
     * Get a Sector from its numeric value
     *
     * @param id numeric identifier
     * @return corresponding Sector
     */
    public static Sector fromId(int id) {
        for (Sector sector : values()) {
            if (sector.id == id) {
                return sector;
            }
        }
        throw new IllegalArgumentException("Invalid sector ID: " + id);
    }
}