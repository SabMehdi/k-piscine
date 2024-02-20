package ip.validator;

import java.util.function.Predicate;

public class IPValidator {
    public boolean ValidateIpv4Address(String ipAddress) {

        String[] byteBlocks = ipAddress.split("\\.");

        if (byteBlocks.length != 4) {
            return false;
        }

        for (String byteBlock : byteBlocks) {
            try {
                int blockValue = Integer.parseInt(byteBlock);
                if (blockValue < 0 || blockValue > 255) {
                    return false;
                }
                if (blockValue == 0 || blockValue == 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

            return true;
        }
}