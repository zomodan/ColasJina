/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco_colas;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author uresh
 */
public class Cola {

    int tam = 10;
    String cola[] = new String[tam];

    int p = 0;
    int u = 0;

    int inicio = 0;
    int ingresado = 0;

    public Cola() {
        //nomas pa crear :3
    }

    public boolean insertar(String dato) {
        if (ingresado < tam) {
            int pos = (inicio + ingresado) % tam;
            cola[pos] = dato;
            ingresado++;
            System.out.println("se guardo " + cola[pos]);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error, ya no hay lugar en la fila, espere a que se desocupe un lugar");
            return false;
        }
    }

    public String eliminar() {
        String aux = null;
        if (ingresado == 0) {
            System.out.println("No hay boletos que eliminar");
          //  JOptionPane.showMessageDialog(null, "No hay boletos que eliminar");
        } else {
            //JOptionPane.showMessageDialog(null, "Se elimino " + cola[inicio]);
            aux = cola[inicio];
            cola[inicio] = null;
            ingresado--;
            inicio = (inicio + 1) % tam;

        }
        return aux;
    }

    public DefaultListModel imprimir() {
        DefaultListModel lista = new DefaultListModel();
        String lis[] = new String[ingresado];
        int auxIni = inicio;
        int auxIngre = ingresado;
        ////
        int i = 0;
        System.out.println("/////");
        while (auxIngre > 0) {
            lis[i] = cola[auxIni];
            System.out.println("lista" + lis[i]);
            auxIngre--;
            auxIni = (auxIni + 1) % tam;
            i++;
        }
        System.out.println("/////");
        ////
        for (int j = 0; j < lis.length; j++) {
            lista.addElement("Boleto "+lis[j]);

        }
        return lista;
    }

}
