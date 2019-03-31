package menu;

import hardware.*;
import operatingSystem.OperationalSystem;

import javax.swing.JOptionPane;

public class Menu {

    private String options[] = {
            "Sistema operacional",
            "Sistema computacional",
            "Processador",
            "RAM",
            "Dispositivos USB",
            "Sair"};
    private boolean cont = true;

    public void menu(){
        while(cont) {
            chosenOption(
                    JOptionPane.showOptionDialog(
                            null,
                            "O que deseja verificar?",
                            "Itens",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            options,
                            options[0]
                    )
            );
        }
    }

    private void chosenOption(int chosenOption){
        switch (chosenOption){
            case 0:
                OperationalSystem.print();
                break;
            case 1:
                ComputerSystem.print(Init.hal.getComputerSystem());
                break;
            case 2:
                Processor.print(Init.hal.getProcessor());
                break;
            case 3:
                Ram.print(Init.hal.getMemory());
                break;
            case 4:
                UsbDevices.print(Init.hal.getUsbDevices(true));
                break;
            default:
                cont = false;
        }
    }

}
