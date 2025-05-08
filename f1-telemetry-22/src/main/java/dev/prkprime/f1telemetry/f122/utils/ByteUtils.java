package dev.prkprime.f1telemetry.f122.utils;

import lombok.experimental.UtilityClass;

/**
 * Utility class for parsing little-endian bytes into Java types
 */
@UtilityClass
public class ByteUtils {

    /**
     * Converts little-endian bytes to a signed 8-bit integer
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return signed 8-bit integer value
     */
    public byte toInt8(byte[] data, int offset) {
        return data[offset];
    }

    /**
     * Converts little-endian bytes to an unsigned 8-bit integer
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return unsigned 8-bit integer value as a short
     */
    public short toUInt8(byte[] data, int offset) {
        return (short) (data[offset] & 0xFF);
    }

    /**
     * Converts little-endian bytes to a signed 16-bit integer
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return signed 16-bit integer value
     */
    public short toInt16(byte[] data, int offset) {
        return (short) ((data[offset] & 0xFF) | ((data[offset + 1] & 0xFF) << 8));
    }

    /**
     * Converts little-endian bytes to an unsigned 16-bit integer
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return unsigned 16-bit integer value as an int
     */
    public int toUInt16(byte[] data, int offset) {
        return (data[offset] & 0xFF) | ((data[offset + 1] & 0xFF) << 8);
    }

    /**
     * Converts little-endian bytes to a signed 32-bit integer
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return signed 32-bit integer value
     */
    public int toInt32(byte[] data, int offset) {
        return (data[offset] & 0xFF) |
                ((data[offset + 1] & 0xFF) << 8) |
                ((data[offset + 2] & 0xFF) << 16) |
                ((data[offset + 3] & 0xFF) << 24);
    }

    /**
     * Converts little-endian bytes to an unsigned 32-bit integer
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return unsigned 32-bit integer value as a long
     */
    public long toUInt32(byte[] data, int offset) {
        return ((long) (data[offset] & 0xFF)) |
                ((long) (data[offset + 1] & 0xFF) << 8) |
                ((long) (data[offset + 2] & 0xFF) << 16) |
                ((long) (data[offset + 3] & 0xFF) << 24);
    }

    /**
     * Converts little-endian bytes to a 32-bit floating point number
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return 32-bit floating point value
     */
    public float toFloat(byte[] data, int offset) {
        int bits = toInt32(data, offset);
        return Float.intBitsToFloat(bits);
    }

    /**
     * Converts little-endian bytes to a 64-bit floating point number
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return 64-bit floating point value
     */
    public double toDouble(byte[] data, int offset) {
        long bits = (((long) toInt32(data, offset)) & 0xFFFFFFFFL) |
                (((long) toInt32(data, offset + 4)) << 32);
        return Double.longBitsToDouble(bits);
    }

    /**
     * Extracts a string from a byte array
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @param length length of the string in bytes
     * @return string value
     */
    public String toString(byte[] data, int offset, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = (char) (data[offset + i] & 0xFF);
            if (c == 0) break; // Stop at null terminator
            sb.append(c);
        }
        return sb.toString();
    }
}