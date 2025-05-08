package dev.prkprime.f1telemetry.f122.cartelemetry;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 surface types
 */
@Getter
@RequiredArgsConstructor
public enum SurfaceType {

    TARMAC(0),
    RUMBLE_STRIP(1),
    CONCRETE(2),
    ROCK(3),
    GRAVEL(4),
    MUD(5),
    SAND(6),
    GRASS(7),
    WATER(8),
    COBBLESTONE(9),
    METAL(10),
    RIDGED(11);

    private final int id;

    /**
     * Get a SurfaceType from its numeric value
     *
     * @param id numeric identifier
     * @return corresponding SurfaceType or TARMAC if not found
     */
    public static SurfaceType fromId(int id) {
        for (SurfaceType surfaceType : values()) {
            if (surfaceType.id == id) {
                return surfaceType;
            }
        }
        return TARMAC;
    }
}