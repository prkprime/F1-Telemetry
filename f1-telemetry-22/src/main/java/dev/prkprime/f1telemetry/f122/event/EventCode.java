package dev.prkprime.f1telemetry.f122.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 event codes
 */
@Getter
@RequiredArgsConstructor
public enum EventCode {

    SESSION_STARTED("SSTA"),
    SESSION_ENDED("SEND"),
    FASTEST_LAP("FTLP"),
    RETIREMENT("RTMT"),
    DRS_ENABLED("DRSE"),
    DRS_DISABLED("DRSD"),
    TEAM_MATE_IN_PITS("TMPT"),
    CHEQUERED_FLAG("CHQF"),
    RACE_WINNER("RCWN"),
    PENALTY_ISSUED("PENA"),
    SPEED_TRAP_TRIGGERED("SPTP"),
    START_LIGHTS("STLG"),
    LIGHTS_OUT("LGOT"),
    DRIVE_THROUGH_SERVED("DTSV"),
    STOP_GO_SERVED("SGSV"),
    FLASHBACK("FLBK"),
    BUTTON_STATUS("BUTN");

    private final String code;

    /**
     * Get an EventCode from its string code
     *
     * @param code string code
     * @return corresponding EventCode
     */
    public static EventCode fromCode(String code) {
        for (EventCode eventCode : values()) {
            if (eventCode.code.equals(code)) {
                return eventCode;
            }
        }
        throw new IllegalArgumentException("Invalid event code: " + code);
    }
}