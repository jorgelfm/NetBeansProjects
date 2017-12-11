/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apirequest;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 *
 * @author luis_
 */
public class ApiRequest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {

//        try {
//            URL url = new URL("https://api.darksky.net/forecast/bc41cd6eb3ef6ccc95e5ece63d762e8f/25.36285,-107.54986");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
//
//            if (conn.getResponseCode() != 200) {
//                throw new RuntimeException("Failded: HTTP error code: " + conn.getResponseCode());
//            }
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//
//            String output = "";
//
//            String JSONData = "";
//            JSONParser parser = new JSONParser();
//
//            while ((output = br.readLine()) != null) {
//                System.out.println(output);
//                JSONData += output;
//
//            }
//
//            Object object = parser.parse(JSONData);
//            JSONObject jObejct = (JSONObject) object;
//            Double latidud = (Double) jObejct.get("latitude");
//            Double longitude = (Double) jObejct.get("longitude");
//            String timeZone = (String) jObejct.get("timezone");
//            System.out.println(latidud);
//            System.out.println(longitude);
//            System.out.println(timeZone);
//
//            JSONObject c = (JSONObject) jObejct;
//            Object cu = (Object) c.get("currently");
//            JSONObject cur = (JSONObject) cu;
//            String summary = (String) cur.get("summary");
//            String icon = (String) cur.get("icon");
//            System.out.println(summary);
//            System.out.println(icon);
//
//        } catch (MalformedURLException ex) {
//            JOptionPane.showMessageDialog(null, "Mal formEDURL Verify" + ex.getMessage());
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, "IOException" + ex.getMessage());
//
//        } catch (ParseException ex) {
//            Logger.getLogger(ApiRequest.class.getName()).log(Level.SEVERE, null, ex);
//        }

       
          Clima cli = new Clima();
          cli.setVisible(true);
    }
}

//buscar una libreria de java que se llama  org.json.simple.*
//geocode
