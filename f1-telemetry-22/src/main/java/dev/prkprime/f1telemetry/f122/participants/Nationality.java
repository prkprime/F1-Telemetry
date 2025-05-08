package dev.prkprime.f1telemetry.f122.participants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 nationalities
 */
@Getter
@RequiredArgsConstructor
public enum Nationality {

    AMERICAN(1),
    ARGENTINEAN(2),
    AUSTRALIAN(3),
    AUSTRIAN(4),
    AZERBAIJANI(5),
    BAHRAINI(6),
    BELGIAN(7),
    BOLIVIAN(8),
    BRAZILIAN(9),
    BRITISH(10),
    BULGARIAN(11),
    CAMEROONIAN(12),
    CANADIAN(13),
    CHILEAN(14),
    CHINESE(15),
    COLOMBIAN(16),
    COSTA_RICAN(17),
    CROATIAN(18),
    CYPRIOT(19),
    CZECH(20),
    DANISH(21),
    DUTCH(22),
    ECUADORIAN(23),
    ENGLISH(24),
    EMIRIAN(25),
    ESTONIAN(26),
    FINNISH(27),
    FRENCH(28),
    GERMAN(29),
    GHANAIAN(30),
    GREEK(31),
    GUATEMALAN(32),
    HONDURAN(33),
    HONG_KONGER(34),
    HUNGARIAN(35),
    ICELANDER(36),
    INDIAN(37),
    INDONESIAN(38),
    IRISH(39),
    ISRAELI(40),
    ITALIAN(41),
    JAMAICAN(42),
    JAPANESE(43),
    JORDANIAN(44),
    KUWAITI(45),
    LATVIAN(46),
    LEBANESE(47),
    LITHUANIAN(48),
    LUXEMBOURGER(49),
    MALAYSIAN(50),
    MALTESE(51),
    MEXICAN(52),
    MONEGASQUE(53),
    NEW_ZEALANDER(54),
    NICARAGUAN(55),
    NORTH_KOREAN(56),
    NORTHERN_IRISH(57),
    NORWEGIAN(58),
    OMANI(59),
    PAKISTANI(60),
    PANAMANIAN(61),
    PARAGUAYAN(62),
    PERUVIAN(63),
    POLISH(64),
    PORTUGUESE(65),
    QATARI(66),
    ROMANIAN(67),
    RUSSIAN(68),
    SALVADORAN(69),
    SAUDI(70),
    SCOTTISH(71),
    SERBIAN(72),
    SINGAPOREAN(73),
    SLOVAKIAN(74),
    SLOVENIAN(75),
    SOUTH_KOREAN(76),
    SOUTH_AFRICAN(77),
    SPANISH(78),
    SWEDISH(79),
    SWISS(80),
    THAI(81),
    TURKISH(82),
    URUGUAYAN(83),
    UKRAINIAN(84),
    VENEZUELAN(85),
    WELSH(86),
    BARBADIAN(87),
    VIETNAMESE(88),
    UNKNOWN(89);

    private final int id;

    /**
     * Get a Nationality from its numeric value
     *
     * @param id numeric identifier
     * @return corresponding Nationality or UNKNOWN if not found
     */
    public static Nationality fromId(int id) {
        for (Nationality nationality : values()) {
            if (nationality.id == id) {
                return nationality;
            }
        }
        return UNKNOWN;
    }
}