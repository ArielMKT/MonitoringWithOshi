import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import information.Process;
import oshi.hardware.*;

import oshi.software.os.*;
import oshi.util.FormatUtil;

import java.util.Arrays;
import java.util.List;


public class Oshi {

    public static void main(String[] args) throws Exception{

        SystemInformation systemInformation = new SystemInformation();

        while(true) {
            System.out.println("CPU");
            System.out.println(systemInformation.getCpu().getCPUTemperature());
            System.out.println("GPU");
            System.out.println(systemInformation.getGpu().getTemperatureGPU());
            System.out.println("Core Value");
            System.out.println(systemInformation.getGpu().getGPUCoreValue());
            System.out.println("-------------------------");
            Thread.sleep(5000);
        }

//        System.out.println("Memoria");
//        System.out.println(systemInformation.getRam().getMemoryAvailable());
//        System.out.println(systemInformation.getRam().getMemoryUseInPercentage());
//        System.out.println(systemInformation.getRam().getTotalMemory());
//
//        System.out.println("Computer System");
//        System.out.println(systemInformation.getComputerSystem().getDescription());
//        System.out.println(systemInformation.getComputerSystem().getManufacturerBaseboard());
//        System.out.println(systemInformation.getComputerSystem().getManufacturerComputerSystem());
//        System.out.println(systemInformation.getComputerSystem().getModelBaseboard());
//        System.out.println(systemInformation.getComputerSystem().getName());
//        System.out.println(systemInformation.getComputerSystem().getManufacturerFirmware());
//        System.out.println(systemInformation.getComputerSystem().getModelComputerSystem());
//        System.out.println(systemInformation.getComputerSystem().getOperatingSystemToString());
//        System.out.println(systemInformation.getComputerSystem().getReleaseDate());
//        System.out.println(systemInformation.getComputerSystem().getSerialNumberBaseboard());
//        System.out.println(systemInformation.getComputerSystem().getSerialNumberComputerSystem());
//        System.out.println(systemInformation.getComputerSystem().getVersionBaseboard());
//        System.out.println(systemInformation.getComputerSystem().getVersionFirmware());
//        System.out.println(systemInformation.getComputerSystem().getReleaseDate());
//        System.out.println(systemInformation.getComputerSystem().getReleaseDate());
//
//        System.out.println("CPU");
//        System.out.println(systemInformation.getCpu().getContextSwitches());
//        System.out.println(systemInformation.getCpu().getCPUTemperature());
//        System.out.println(systemInformation.getCpu().getCPUVoltage());
//        System.out.println(systemInformation.getCpu().getFamily());
//        System.out.println(systemInformation.getCpu().getFansSpeed());
//        System.out.println(systemInformation.getCpu().getContextSwitches());
//        System.out.println(systemInformation.getCpu().getIdentifier());
//        System.out.println(systemInformation.getCpu().getInterrupts());
//        System.out.println(systemInformation.getCpu().getLogicalProcessorCount());
//        System.out.println(systemInformation.getCpu().getProcessor());
//        System.out.println(systemInformation.getCpu().getSystemCPULoad());

//        Process.print(systemInformation.getHardwareAbstractionLayer().getProcessor());
//        Cpu.print(systemInformation.getHardwareAbstractionLayer().getProcessor());
//        System.out.println(SystemInformation.os);

//        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "INFO");
//        System.setProperty(org.slf4j.impl.SimpleLogger.LOG_FILE_KEY, "System.err");
//        Logger LOG = LoggerFactory.getLogger(Oshi.class);
//
//        LOG.info("Initializing System...");
//        SystemInfo si = new SystemInfo();
//
//        HardwareAbstractionLayer hal = si.getHardware();
//        OperatingSystem os = si.getOperatingSystem();
//
//        System.out.println(os);
//
//        LOG.info("Checking computer system...");
//
//        LOG.info("Checking Process...");
//
//        LOG.info("Checking Memory...");
//
//        LOG.info("Checking CPU...");
//
//        LOG.info("Checking Processes...");
//        printProcesses2(os, hal.getMemory());
//
//        LOG.info("Checking Sensors...");
//        printSensors(hal.getSensors());
//
//        LOG.info("Checking Power sources...");
//        printPowerSources(hal.getPowerSources());
//
//        LOG.info("Checking Disks...");
//        printDisks(hal.getDiskStores());
//
//        LOG.info("Checking File System...");
//        printFileSystem(os.getFileSystem());
//
//        LOG.info("Checking Network interfaces...");
//        printNetworkInterfaces(hal.getNetworkIFs());
//
//        LOG.info("Checking Network parameterss...");
//        printNetworkParameters(os.getNetworkParams());
//
//        // information: displays
//        LOG.info("Checking Displays...");
//        printDisplays(hal.getDisplays());
//
//        // information: USB devices
//        LOG.info("Checking USB Devices...");
//        printUsbDevices(SystemInformation.hal.getUsbDevices(true));
//
//        LOG.info("Checking Sound Cards...");
//        printSoundCards(hal.getSoundCards());

    }

    private static void printSensors(Sensors sensors) {
        System.out.println("Sensors:");
        System.out.format(" CPU Temperature: %.1f°C%n", sensors.getCpuTemperature());
        System.out.println(" Fan Speeds: " + Arrays.toString(sensors.getFanSpeeds()));
        System.out.format(" CPU Voltage: %.1fV%n", sensors.getCpuVoltage());
    }

    private static void printPowerSources(PowerSource[] powerSources) {
        StringBuilder sb = new StringBuilder("Power: ");
        if (powerSources.length == 0) {
            sb.append("Unknown");
        } else {
            double timeRemaining = powerSources[0].getTimeRemaining();
            if (timeRemaining < -1d) {
                sb.append("Charging");
            } else if (timeRemaining < 0d) {
                sb.append("Calculating time remaining");
            } else {
                sb.append(String.format("%d:%02d remaining", (int) (timeRemaining / 3600),
                        (int) (timeRemaining / 60) % 60));
            }
        }
        for (PowerSource pSource : powerSources) {
            sb.append(String.format("%n %s @ %.1f%%", pSource.getName(), pSource.getRemainingCapacity() * 100d));
        }
        System.out.println(sb.toString());
    }

    private static void printDisks(HWDiskStore[] diskStores) {
        System.out.println("Disks:");
        for (HWDiskStore disk : diskStores) {
            boolean readwrite = disk.getReads() > 0 || disk.getWrites() > 0;
            System.out.format(" %s: (model: %s - S/N: %s) size: %s, reads: %s (%s), writes: %s (%s), xfer: %s ms%n",
                    disk.getName(), disk.getModel(), disk.getSerial(),
                    disk.getSize() > 0 ? FormatUtil.formatBytesDecimal(disk.getSize()) : "?",
                    readwrite ? disk.getReads() : "?", readwrite ? FormatUtil.formatBytes(disk.getReadBytes()) : "?",
                    readwrite ? disk.getWrites() : "?", readwrite ? FormatUtil.formatBytes(disk.getWriteBytes()) : "?",
                    readwrite ? disk.getTransferTime() : "?");
            HWPartition[] partitions = disk.getPartitions();
            if (partitions == null) {
                // TODO Remove when all OS's implemented
                continue;
            }
            for (HWPartition part : partitions) {
                System.out.format(" |-- %s: %s (%s) Maj:Min=%d:%d, size: %s%s%n", part.getIdentification(),
                        part.getName(), part.getType(), part.getMajor(), part.getMinor(),
                        FormatUtil.formatBytesDecimal(part.getSize()),
                        part.getMountPoint().isEmpty() ? "" : " @ " + part.getMountPoint());
            }
        }
    }

    private static void printFileSystem(FileSystem fileSystem) {
        System.out.println("File System:");

        System.out.format(" File Descriptors: %d/%d%n", fileSystem.getOpenFileDescriptors(),
                fileSystem.getMaxFileDescriptors());

        OSFileStore[] fsArray = fileSystem.getFileStores();
        for (OSFileStore fs : fsArray) {
            long usable = fs.getUsableSpace();
            long total = fs.getTotalSpace();
            System.out.format(
                    " %s (%s) [%s] %s of %s free (%.1f%%), %s of %s files free (%.1f%%) is %s "
                            + (fs.getLogicalVolume() != null && fs.getLogicalVolume().length() > 0 ? "[%s]" : "%s")
                            + " and is mounted at %s%n",
                    fs.getName(), fs.getDescription().isEmpty() ? "file system" : fs.getDescription(), fs.getType(),
                    FormatUtil.formatBytes(usable), FormatUtil.formatBytes(fs.getTotalSpace()), 100d * usable / total,
                    fs.getFreeInodes(), fs.getTotalInodes(), 100d * fs.getFreeInodes() / fs.getTotalInodes(),
                    fs.getVolume(), fs.getLogicalVolume(), fs.getMount());
        }
    }

    private static void printNetworkInterfaces(NetworkIF[] networkIFs) {
        System.out.println("Network interfaces:");
        for (NetworkIF net : networkIFs) {
            System.out.format(" Name: %s (%s)%n", net.getName(), net.getDisplayName());
            System.out.format("   MAC Address: %s %n", net.getMacaddr());
            System.out.format("   MTU: %s, Speed: %s %n", net.getMTU(), FormatUtil.formatValue(net.getSpeed(), "bps"));
            System.out.format("   IPv4: %s %n", Arrays.toString(net.getIPv4addr()));
            System.out.format("   IPv6: %s %n", Arrays.toString(net.getIPv6addr()));
            boolean hasData = net.getBytesRecv() > 0 || net.getBytesSent() > 0 || net.getPacketsRecv() > 0
                    || net.getPacketsSent() > 0;
            System.out.format("   Traffic: received %s/%s%s; transmitted %s/%s%s %n",
                    hasData ? net.getPacketsRecv() + " packets" : "?",
                    hasData ? FormatUtil.formatBytes(net.getBytesRecv()) : "?",
                    hasData ? " (" + net.getInErrors() + " err)" : "",
                    hasData ? net.getPacketsSent() + " packets" : "?",
                    hasData ? FormatUtil.formatBytes(net.getBytesSent()) : "?",
                    hasData ? " (" + net.getOutErrors() + " err)" : "");
        }
    }

    private static void printNetworkParameters(NetworkParams networkParams) {
        System.out.println("Network parameters:");
        System.out.format(" Host name: %s%n", networkParams.getHostName());
        System.out.format(" Domain name: %s%n", networkParams.getDomainName());
        System.out.format(" DNS servers: %s%n", Arrays.toString(networkParams.getDnsServers()));
        System.out.format(" IPv4 Gateway: %s%n", networkParams.getIpv4DefaultGateway());
        System.out.format(" IPv6 Gateway: %s%n", networkParams.getIpv6DefaultGateway());
    }

    private static void printDisplays(Display[] displays) {
        System.out.println("Displays:");
        int i = 0;
        for (Display display : displays) {
            System.out.println(" Display " + i + ":");
            System.out.println(display.toString());
            i++;
        }
    }

    private static void printUsbDevices(UsbDevice[] usbDevices) {
        System.out.println("USB Devices:");
        for (UsbDevice usbDevice : usbDevices) {
            System.out.println(usbDevice.toString());
        }
    }

    private static void printSoundCards(SoundCard[] cards) {
        System.out.println("Sound Cards:");
        for (SoundCard card : cards) {
            System.out.println(card.toString());
        }
    }

}
