package ip.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPValidatorTest {

    private IPValidator ipValidator = new IPValidator();

    @Test
    public void testValidIpAddress() {
        String ipAddress = "1.1.1.1";
        Assertions.assertTrue(ipValidator.ValidateIpv4Address(ipAddress));
    }

    @Test
    public void testInvalidIpAddressWithTooFewByteBlocks() {
        String ipAddress = "10.0.1";
        Assertions.assertFalse(ipValidator.ValidateIpv4Address(ipAddress));
    }

    @Test
    public void testInvalidIpAddressWithTooManyByteBlocks() {
        String ipAddress = "192.168.1.1.1";
        Assertions.assertFalse(ipValidator.ValidateIpv4Address(ipAddress));
    }

    @Test
    public void testInvalidIpAddressWithOutOfRangeByteBlock() {
        String ipAddress = "192.168.1.256";
        Assertions.assertFalse(ipValidator.ValidateIpv4Address(ipAddress));
    }

    @Test
    public void testInvalidIpAddressWithNegativeByteBlock() {
        String ipAddress = "192.168.1.-1";
        Assertions.assertFalse(ipValidator.ValidateIpv4Address(ipAddress));
    }

    @Test
    public void testInvalidIpAddressEndingWithZero() {
        String ipAddress = "0.0.0.0";
        Assertions.assertFalse(ipValidator.ValidateIpv4Address(ipAddress));
    }

    @Test
    public void testInvalidIpAddressEndingWith255() {
        String ipAddress = "255.255.255.255";
        Assertions.assertFalse(ipValidator.ValidateIpv4Address(ipAddress));
    }
}