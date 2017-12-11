/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @authy luis@
 */
public class PersonFile {

    private String filename;
    private PrintWriter output;
    private File file;

    public void createFile(String name) throws FileNotFoundException {
        this.filename = name;
        this.file = new File(this.filename);

        if (!this.file.exists()) {
            this.output = new PrintWriter(new FileOutputStream(this.file, true));
        } else {
            System.out.println("the file already exists");
        }
    }

    public void WritePerson(String dni, String name, String lastName, String birthDay, String place) throws FileNotFoundException {
        this.output = new PrintWriter(new FileOutputStream(this.file, true));
        this.output.println(dni + "\t" + name + "\t" + lastName + "\t" + birthDay + "\t" + place);
        this.output.close();
    }

    public String ReadPerson() throws FileNotFoundException 
    {
        Scanner scan = null;
            try {
                scan = new Scanner(new File(filename));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PersonFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            String line="";
        while(scan.hasNextLine()){
             line += scan.nextLine() + "\n";
            //Here you can manipulate the string the way you want
        }
        return line;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        PersonFile objPersona=new PersonFile();
        
        int respuesta=1;
        
        while(respuesta>=1 && respuesta<4)
        {
            String Mensaje = JOptionPane.showInputDialog("Seleccione Un Numero: \n 1.Crear archivo \n 2.Escriba Datos \n 3.Leer archivo \n 4.Salir de consola");       
        
            respuesta = Integer.parseInt(Mensaje);
            String ruta="";
            switch(respuesta)
            {
                case 1:
                    ruta=JOptionPane.showInputDialog("Escriba la ruta del archivo");
                    objPersona.createFile(ruta);
                    break;
                case 2:
                    String clave = JOptionPane.showInputDialog("Escriba la clave de la persona");
                    String nombre = JOptionPane.showInputDialog("Escriba el nombre de la persona");
                    String apellido = JOptionPane.showInputDialog("Escriba el apellido de la persona");
                    String fecha = JOptionPane.showInputDialog("Escriba la fecha de nacimiento de la persona");
                    String plasa = JOptionPane.showInputDialog("Escriba la plasa de la persona");
                    objPersona.WritePerson(clave, nombre, apellido, fecha, plasa);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Las Personas registradas son:\n" + objPersona.ReadPerson());
                    break;
            }
        }
        System.exit(0);
        
    }

}
