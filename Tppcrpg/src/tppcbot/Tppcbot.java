/*
Feb 25, 2017
Tppcbot.java, Tppcbot, Joni Sikiö <joni.sikio@student.lut.fi> 
Kuvaus sisällöstä: 
Kehitysympäristö: NetBeans
Muutoshistoria:
Lisenssi: default

 */
package tppcbot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Joni Sikiö <joni.sikio@student.lut.fi>
 */
public class Tppcbot extends Application {
    trainerManager tm;
    WebDriver driver;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Tppcrpg bot");
        stage.getIcons().add(new Image(Tppcbot.class.getResource("/Pictures/icon.png").toExternalForm()));
        
        String css = Tppcbot.class.getResource("/Pictures/tppc.css").toExternalForm();
        scene.getStylesheets().clear();
        scene.getStylesheets().add(css);

        stage.show();
    }


    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void stop() {
        Account.saveLogToFile();
        Account.saveLogToFile2();
        tm = trainerManager.getInstance();
        tm.saveLogToFile();
        tm.getDriver().get("http://www.tppcrpg.net/logout.php");
        tm.getDriver().close();

    }
    
    
}
