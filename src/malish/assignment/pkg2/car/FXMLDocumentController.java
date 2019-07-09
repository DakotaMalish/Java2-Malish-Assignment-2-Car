/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malish.assignment.pkg2.car;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;



public class FXMLDocumentController implements Initializable {
    
    
    private String make;
    private String model;
    private String colorText;
    private java.awt.Color color; 
    private int speed = 0;
    //private int tempSpeedHolder = 0;
    
    
    @FXML
    private ComboBox<String> carMake;
    
    ObservableList<String> listCarMake = FXCollections.observableArrayList(
            "Dodge","Ford","Honda","Toyota");
    
    @FXML
    private ComboBox<String> carModel;
    ObservableList<String> listCarModel = FXCollections.observableArrayList(
            "Car","Truck","Motorcycle","Hatchback","Sports Utility");
    

    
    @FXML
    private Button carAccelerate;


    
    @FXML
    private Button carBrake;
   
    
    @FXML
    private Button programClose;
   
    
    @FXML
    private Label carMakeDisplay;
    
    
    @FXML
    private Label carSpeedDisplay;
    
    
    @FXML
    private Label carColorDisplay;
    
    
    @FXML
    private Label carModelDisplay;
    @FXML
    private RadioButton radioRed;
    @FXML
    private ToggleGroup colorGroup;
    @FXML
    private RadioButton radioBlue;
    @FXML
    private RadioButton radioGreen;
    @FXML
    private RadioButton radioSilver;
    @FXML
    private AnchorPane frameBackground;
    
    
    // initializes anything in here before the program is ran.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    carMake.setItems(listCarMake);
    carModel.setItems(listCarModel);
    //carColor.setItems(listCarColor);

    
    }    
    
    @FXML
    public void comboChanged(ActionEvent event){
    //sets the display up
    carMakeDisplay.setText(carMake.getValue());
    carModelDisplay.setText(carModel.getValue());
    //carColorDisplay.setText(carColor.getValue());
    //carColorDisplay.setText(colorText);

    //generates the speed label so the user can see how fast they are going
    carAccelerate.setOnAction(e -> {
        speed = speed + 5;        
        carSpeedDisplay.setText(Integer.toString(speed)); 
    });
    carBrake.setOnAction(e -> {
      
        if(speed > 0){
         speed = speed - 5; 
         carSpeedDisplay.setText(Integer.toString(speed));
        }
        else{
            JOptionPane.showMessageDialog(null, "You're Car is already stopped.");      
        };       
    });
    //closes program
    programClose.setOnAction(e -> {
       System.exit(0);
    });
//Color text and backgroud selection for car
//this part is really gross i was trying to get style sheets 
//working but im to new to GUI in java so ill liike into it'
        radioRed.setOnAction( (ActionEvent e) ->{
        colorText = "Red";
        carColorDisplay.setText(colorText);
        //frameBackground.setColor(Color.RED); 
        frameBackground.setBackground(new Background
        (new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
    });
        radioBlue.setOnAction( e ->{
        colorText = "Blue";
        carColorDisplay.setText(colorText);
        frameBackground.setBackground(new Background
        (new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));

    });
        radioGreen.setOnAction( e ->{
        colorText = "Green";
        carColorDisplay.setText(colorText);
        frameBackground.setBackground(new Background
        (new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
  
    });
        radioSilver.setOnAction( e ->{
        colorText = "Silver";
        carColorDisplay.setText(colorText);
        frameBackground.setBackground(new Background
        (new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, Insets.EMPTY)));

    });
    
    
    }
    
}