package dev.prkprime.f1telemetry.f122.cartelemetry;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 MFD panel types
 */
@Getter
@RequiredArgsConstructor
public enum MFDPanel {

    CAR_SETUP(0),
    PITS(1),
    DAMAGE(2),
    ENGINE(3),
    TEMPERATURES(4),
    CLOSED(255);

    private final int id;

    /**
     * Get a MFDPanel from its numeric value
     *
     * @param id numeric identifier
     * @return corresponding MFDPanel or CLOSED if not found
     */
    public static MFDPanel fromId(int id) {
        for (MFDPanel mfdPanel : values()) {
            if (mfdPanel.id == id) {
                return mfdPanel;
            }
        }
        return CLOSED;
    }
}