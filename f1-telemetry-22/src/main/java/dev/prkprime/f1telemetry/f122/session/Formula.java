package dev.prkprime.f1telemetry.f122.session;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 formula types
 */
@Getter
@RequiredArgsConstructor
public enum Formula {

    F1_MODERN(0),
    F1_CLASSIC(1),
    F2(2),
    F1_GENERIC(3);

    private final int id;

    /**
     * Get a Formula from its numeric value
     *
     * @param id numeric identifier
     * @return corresponding Formula
     */
    public static Formula fromId(int id) {
        for (Formula formula : values()) {
            if (formula.id == id) {
                return formula;
            }
        }
        throw new IllegalArgumentException("Invalid formula ID: " + id);
    }
}