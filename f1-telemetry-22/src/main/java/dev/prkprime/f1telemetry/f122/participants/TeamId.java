package dev.prkprime.f1telemetry.f122.participants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 team IDs
 */
@Getter
@RequiredArgsConstructor
public enum TeamId {

    MERCEDES(0),
    FERRARI(1),
    RED_BULL_RACING(2),
    WILLIAMS(3),
    ASTON_MARTIN(4),
    ALPINE(5),
    ALPHATAURI(6),
    HAAS(7),
    MCLAREN(8),
    ALFA_ROMEO(9),
    MERCEDES_2020(85),
    FERRARI_2020(86),
    RED_BULL_2020(87),
    WILLIAMS_2020(88),
    RACING_POINT_2020(89),
    RENAULT_2020(90),
    ALPHATAURI_2020(91),
    HAAS_2020(92),
    MCLAREN_2020(93),
    ALFA_ROMEO_2020(94),
    ASTON_MARTIN_DB11_V12(95),
    ASTON_MARTIN_VANTAGE_F1_EDITION(96),
    ASTON_MARTIN_VANTAGE_SAFETY_CAR(97),
    FERRARI_F8_TRIBUTO(98),
    FERRARI_ROMA(99),
    MCLAREN_720S(100),
    MCLAREN_ARTURA(101),
    MERCEDES_AMG_GT_BLACK_SERIES_SAFETY_CAR(102),
    MERCEDES_AMG_GTR_PRO(103),
    F1_CUSTOM_TEAM(104),
    PREMA_2021(106),
    UNI_VIRTUOSI_2021(107),
    CARLIN_2021(108),
    HITECH_2021(109),
    ART_GP_2021(110),
    MP_MOTORSPORT_2021(111),
    CHAROUZ_2021(112),
    DAMS_2021(113),
    CAMPOS_2021(114),
    BWT_2021(115),
    TRIDENT_2021(116),
    MERCEDES_AMG_GT_BLACK_SERIES(117),
    PREMA_2022(118),
    VIRTUOSI_2022(119),
    CARLIN_2022(120),
    HITECH_2022(121),
    ART_GP_2022(122),
    MP_MOTORSPORT_2022(123),
    CHAROUZ_2022(124),
    DAMS_2022(125),
    CAMPOS_2022(126),
    VAN_AMERSFOORT_RACING_2022(127),
    TRIDENT_2022(128),
    MY_TEAM(255);

    private final int id;

    /**
     * Get a TeamId from its numeric value
     *
     * @param id numeric identifier
     * @return corresponding TeamId or MY_TEAM if not found
     */
    public static TeamId fromId(int id) {
        for (TeamId teamId : values()) {
            if (teamId.id == id) {
                return teamId;
            }
        }
        return MY_TEAM;
    }
}