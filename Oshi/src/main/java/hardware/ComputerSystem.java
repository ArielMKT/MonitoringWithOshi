package hardware;

import oshi.hardware.Baseboard;
import oshi.hardware.Firmware;


import javax.swing.JOptionPane;

public class ComputerSystem {

    private oshi.hardware.ComputerSystem computerSystem;
    private Firmware firmware;
    private Baseboard baseboard;

    public void SetComputerSystem(oshi.hardware.ComputerSystem system) {
        computerSystem = system;
        firmware = computerSystem.getFirmware();
        baseboard = computerSystem.getBaseboard();
    }

    public String getManufacturerComputerSystem() {
        return computerSystem.getManufacturer();
    }

    public String getModelComputerSystem() {
        return computerSystem.getModel();
    }

    public String getSerialNumberComputerSystem() {
        return computerSystem.getSerialNumber();
    }

    public String getName() {
        return firmware.getName();
    }

    public String getManufacturerFirmware() {
        return firmware.getManufacturer();
    }

    public String getDescription() {
        return firmware.getDescription();
    }

    public String getVersionFirmware() {
        return firmware.getVersion();
    }

    public String getReleaseDate() {
        return (firmware.getReleaseDate() == null ? "unknown"
                : firmware.getReleaseDate() == null ? "unknown" : firmware.getReleaseDate());
    }

    public String getManufacturerBaseboard() {
        return baseboard.getManufacturer();
    }

    public String getModelBaseboard() {
        return baseboard.getModel();
    }

    public String getVersionBaseboard() {
        return baseboard.getVersion();
    }

    public String getSerialNumberBaseboard() {
        return baseboard.getSerialNumber();
    }

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
