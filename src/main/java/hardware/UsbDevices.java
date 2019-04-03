package hardware;

import oshi.hardware.UsbDevice;

import javax.swing.JOptionPane;

public class UsbDevices {

    public static void print(UsbDevice[] usbDevices) {
        String devices = "";
        for (UsbDevice usbDevice : usbDevices) {
            devices += (usbDevice.toString() + "\n");
        }

        JOptionPane.showMessageDialog(
                null,
                "USB Devices: \n" +
                        devices,
                "Dispositivos USB",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

}
