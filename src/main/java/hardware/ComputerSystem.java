package hardware;

import oshi.hardware.Baseboard;
import oshi.hardware.Firmware;

import javax.swing.JOptionPane;

public class ComputerSystem {

     public static void print(final oshi.hardware.ComputerSystem computerSystem) {

        final Firmware firmware = computerSystem.getFirmware();
        final Baseboard baseboard = computerSystem.getBaseboard();

        JOptionPane.showMessageDialog(
                null,
                "manufacturer: " + computerSystem.getManufacturer() +
                        "\nmodel: " + computerSystem.getModel() +
                        "\nserialnumber: " + computerSystem.getSerialNumber() +
                        "\n\nfirmware:" +
                        "\nmanufacturer: " + firmware.getManufacturer() +
                        "\nname: " + firmware.getName() +
                        "\ndescription: " + firmware.getDescription() +
                        "\nversion: " + firmware.getVersion() +
                        "\nrelease date: " + (firmware.getReleaseDate() == null ? "unknown"
                              : firmware.getReleaseDate() == null ? "unknown" : firmware.getReleaseDate()) +
                        "\n\nbaseboard:" +
                        "\nmanufacturer: " + baseboard.getManufacturer() +
                        "\nmodel: " + baseboard.getModel() +
                        "\nversion: " + baseboard.getVersion() +
                        "\nserialnumber: " + baseboard.getSerialNumber(),
                "Sistema computacional",
                JOptionPane.INFORMATION_MESSAGE
                );
    }

}
