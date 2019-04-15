package information;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import oshi.hardware.CentralProcessor;
import oshi.hardware.Sensors;
import oshi.util.FormatUtil;
import oshi.util.Util;

import java.util.Arrays;
import java.util.List;

public class Cpu {

    private CentralProcessor processor;
    private Sensors sensors;

    public Cpu(CentralProcessor processor, Sensors sensors) {
        this.processor = processor;
        this.sensors = sensors;
    }

    public String getCPUTemperature() {
        List<com.profesorfalken.jsensors.model.components.Cpu> cpus = JSensors.get.components().cpus;
        if(cpus.isEmpty())
            return "Not Available";

        Double totalTemp = 0.0;
        Double quantCPU = 0.0;

        for (final com.profesorfalken.jsensors.model.components.Cpu cpu : cpus) {
            if(cpu.sensors != null) {
                List<Temperature> temps = cpu.sensors.temperatures;
                for (final Temperature temp : temps) {
                    totalTemp += temp.value;
                    quantCPU++;
                }
            }
        }

        totalTemp /= quantCPU;

        return String.valueOf(totalTemp);
    }

    public String getProcessor() {
        return processor.toString();
    }

    public String getPhysicalProcessorCount() {
        return String.valueOf(processor.getPhysicalProcessorCount());
    }

    public String getLogicalProcessorCount() {
        return String.valueOf(processor.getLogicalProcessorCount());
    }

    public String getProcessorID() {
        return processor.getProcessorID();
    }

    public String getIdentifier() {
        return processor.getIdentifier();
    }

    public String getFamily() {
        return processor.getFamily();
    }

    public String getInterrupts() {
        Long interrupts = processor.getInterrupts();
        return interrupts.toString();
    }

    public String getContextSwitches() {
        Long contextSwitches = processor.getContextSwitches();
        return contextSwitches.toString();
    }

    public String getUpTime() {
        return FormatUtil.formatElapsedSecs(processor.getSystemUptime());
    }

    public String getSystemCPULoad() {
        Double cpuLoad = processor.getSystemCpuLoad() * 100;
        return cpuLoad.toString();
    }

    public String getMaxFrequency() {
        long freq = processor.getVendorFreq();
        return FormatUtil.formatHertz(freq);
    }

    public String getFansSpeed() {
        return Arrays.toString(sensors.getFanSpeeds());
    }

    public String getCPUVoltage() {
        return String.valueOf(sensors.getCpuVoltage());
    }

    //    List<com.profesorfalken.jsensors.model.components.Cpu> cpus = components.cpus;
//    if (cpus != null) {
//        for (final com.profesorfalken.jsensors.model.components.Cpu cpu : cpus) {
//            System.out.println("Found CPU component: " + cpu.name);
//            if (cpu.sensors != null) {
//                System.out.println("Sensors: ");
//
//                //Print temperatures
//                List<Temperature> temps = cpu.sensors.temperatures;
//                for (final Temperature temp : temps) {
//                    System.out.println(temp.name + ": " + temp.value + " C");
//                }
//
//                //Print fan speed
//                List<Fan> fans = cpu.sensors.fans;
//                for (final Fan fan : fans) {
//                    System.out.println(fan.name + ": " + fan.value + " RPM");
//                }
//            }
//        }
//    }

}
