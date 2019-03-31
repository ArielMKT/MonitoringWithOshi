package operatingSystem;

import menu.Init;

import javax.swing.*;

public class OperationalSystem {

    public static void print(){
        JOptionPane.showMessageDialog(
                null,
                Init.os,
                "Sistema Operacional",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

}
