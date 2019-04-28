package information;

import oshi.hardware.GlobalMemory;
import oshi.util.FormatUtil;

import javax.swing.JOptionPane;

public class Ram {

    private GlobalMemory globalMemory;

    public Ram(GlobalMemory memory) {
        globalMemory = memory;
    }

    public String getMemoryAvailable() {
        return FormatUtil.formatBytes(globalMemory.getAvailable());
    }

    public String getTotalMemory() {
        return FormatUtil.formatBytes(globalMemory.getTotal());
    }

    public String getMemoryUseInPercentage() {
        Long inUse = globalMemory.getTotal() - globalMemory.getAvailable();
        Long total = globalMemory.getTotal();
        Double percentage = (inUse.doubleValue()/total)*100;
        return String.valueOf(percentage.intValue());
    }
}
