package dev.prkprime.f1telemetry.f122.event;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Button status event details
 */
@Getter
@Builder
@ToString
public class ButtonStatusData implements EventDetails {

    /**
     * Bit flags specifying which buttons are being pressed currently
     */
    private final long buttonStatus;

    @Override
    public EventCode getEventCode() {
        return EventCode.BUTTON_STATUS;
    }

    /**
     * Parse a byte array into a ButtonStatusData object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed ButtonStatusData
     */
    public static ButtonStatusData fromBytes(byte[] data, int offset) {
        return ButtonStatusData.builder()
                .buttonStatus(ByteUtils.toUInt32(data, offset))
                .build();
    }

    /**
     * Check if a specific button is pressed
     *
     * @param buttonFlag the button flag to check
     * @return true if the button is pressed, false otherwise
     */
    public boolean isButtonPressed(ButtonFlag buttonFlag) {
        return (buttonStatus & buttonFlag.getMask()) != 0;
    }

    /**
     * Enum for button flags
     */
    @Getter
    public enum ButtonFlag {
        CROSS_A(0x00000001),
        TRIANGLE_Y(0x00000002),
        CIRCLE_B(0x00000004),
        SQUARE_X(0x00000008),
        D_PAD_LEFT(0x00000010),
        D_PAD_RIGHT(0x00000020),
        D_PAD_UP(0x00000040),
        D_PAD_DOWN(0x00000080),
        OPTIONS_MENU(0x00000100),
        L1_LB(0x00000200),
        R1_RB(0x00000400),
        L2_LT(0x00000800),
        R2_RT(0x00001000),
        LEFT_STICK_CLICK(0x00002000),
        RIGHT_STICK_CLICK(0x00004000),
        RIGHT_STICK_LEFT(0x00008000),
        RIGHT_STICK_RIGHT(0x00010000),
        RIGHT_STICK_UP(0x00020000),
        RIGHT_STICK_DOWN(0x00040000),
        SPECIAL(0x00080000),
        UDP_ACTION_1(0x00100000),
        UDP_ACTION_2(0x00200000),
        UDP_ACTION_3(0x00400000),
        UDP_ACTION_4(0x00800000),
        UDP_ACTION_5(0x01000000),
        UDP_ACTION_6(0x02000000),
        UDP_ACTION_7(0x04000000),
        UDP_ACTION_8(0x08000000),
        UDP_ACTION_9(0x10000000),
        UDP_ACTION_10(0x20000000),
        UDP_ACTION_11(0x40000000),
        UDP_ACTION_12(0x80000000);

        private final long mask;

        ButtonFlag(long mask) {
            this.mask = mask;
        }
    }
}