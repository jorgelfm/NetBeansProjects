/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writereadobject;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author luis
 */
public class WriteReadObject {

    private String fileName;

    public void crearObjeto() {
        // Writes an object to a binary file
        ObjectOutputStream fileOut;
        TestObject obj = new TestObject(1, "test1", 2);//se crea un ubjeto de tipo test y recibe el archivo de la clase
        this.fileName = JOptionPane.showInputDialog("Enter the file's name") + ".data";
        try {
            fileOut = new ObjectOutputStream(new FileOutputStream(this.fileName));
            fileOut.writeObject(obj);
            fileOut.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error de FileNotFoundException " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de IOException " + ex.getMessage());
        }
    }
    // End write

    public void escribirObjeto(int id, String texto, double number) {//se escribe el objeto
        ObjectOutputStream fileOut;
        TestObject text = new TestObject(id, texto, number);//se crea un nuevo objeto
        try {
            fileOut = new ObjectOutputStream(new FileOutputStream(this.fileName));
            fileOut.writeObject(text);
            fileOut.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error de FileNotFoundException " + ex.getMessage());//error
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de IOException " + ex.getMessage());
        }
    }

    public void readObjeto() {
        //Se lee el objeto del archivo binario
        TestObject objIn;//"In" de entrada
        try {
            ObjectInputStream fileInt = new ObjectInputStream(new FileInputStream(this.fileName));
            String output = "";

            objIn = (TestObject) fileInt.readObject();
            objIn.display();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error de FileNotFoundException " + ex.getMessage());//se espesifican los errores correspondientes
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de IOException " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error de ClassNotFoundException " + ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int estado;//mse inicia el menu(se crea el int para saber si esta en 0,1 o en lo que sea)
        WriteReadObject WRO = new WriteReadObject();//se llama a llamar los metodos de la clase
        int id = 0;
        String texto = null;
        double number = 0;
        do {
            estado = Integer.parseInt(JOptionPane.showInputDialog("menu \n 1.Create Binary Text File \n 2.write Text File \n 3.Read Text File \n 4.Exit"));//lo que dice en el menu
            switch (estado) {
                case 1:
                    WRO.crearObjeto();
                    break;
                case 2:
                    id = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Id", id));
                    texto = JOptionPane.showInputDialog("Ingresa el texto", texto);
                    number = Double.valueOf(JOptionPane.showInputDialog("Ingresa un nuemro Double", number));
                    WRO.escribirObjeto(id, texto, number);
                    break;
                case 3:
                    WRO.readObjeto();
                    break;
            }
        } while (estado != 4);
    }
}
