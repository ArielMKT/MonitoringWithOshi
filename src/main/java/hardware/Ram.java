package hardware;

import oshi.hardware.GlobalMemory;
import oshi.util.FormatUtil;

import javax.swing.JOptionPane;

public class Ram {

    public static void print(GlobalMemory memory) {
        JOptionPane.showMessageDialog(
                null,
                "Memory: " +
                        FormatUtil.formatBytes(memory.getAvailable()) +
                        "/" +
                        FormatUtil.formatBytes(memory.getTotal()),
                "Memória RAM",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

}
