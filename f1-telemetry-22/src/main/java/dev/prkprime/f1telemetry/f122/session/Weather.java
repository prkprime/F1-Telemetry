package dev.prkprime.f1telemetry.f122.session;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 weather conditions
 */
@Getter
@RequiredArgsConstructor
public enum Weather {

    CLEAR(0),
    LIGHT_CLOUD(1),
    OVERCAST(2),
    LIGHT_RAIN(3),
    HEAVY_RAIN(4),
    STORM(5);

    private final int id;

    /**
     * Get a Weather from its numeric value
     *
     * @param id numeric identifier
     * @return corresponding Weather
     */
    public static Weather fromId(int id) {
        for (Weather weather : values()) {
            if (weather.id == id) {
                return weather;
            }
        }
        throw new IllegalArgumentException("Invalid weather ID: " + id);
    }
}