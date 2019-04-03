package hardware;

import oshi.hardware.CentralProcessor;

import javax.swing.JOptionPane;

public class Processor {

    public static void print(CentralProcessor processor) {

        JOptionPane.showMessageDialog(
                null,
                processor +
                        "" + processor.getPhysicalPackageCount() + " physical CPU package(s) \n" +
                        processor.getPhysicalProcessorCount() + " physical CPU core(s) \n" +
                        processor.getLogicalProcessorCount() + " logical CPU(s) \n" +
                        "Identifier: " + processor.getIdentifier() + "\n" +
                        "ProcessorID: " + processor.getProcessorID(),
                "Processador",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

}
