package lk.ijse.gdse.Super.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SuperController implements Initializable {

    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnItem;

    @FXML
    private ImageView imagePane;

    @FXML
    private Button btnOrders;

    @FXML
    private AnchorPane loadAnchor;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane mainPane;

    @FXML
    private Label superLable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("image/pexels-taras-makarenko-188506-593172.jpg");
        Image image = new Image(file.toURI().toString());
        imagePane.setImage(image);

        System.out.println("Main Supermarket");
//        navigateTo("/view/CustomerView.fxml");
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
//        loadAnchor.getChildren().clear();
//        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/CustomerView.fxml"));
//        loadAnchor.getChildren().add(load);
          navigateTo("/view/CustomerView.fxml");
    }

    @FXML
    void btnItemOnAction(ActionEvent event) throws IOException {
//        loadAnchor.getChildren().clear();
//        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/Item.fxml"));
//        loadAnchor.getChildren().add(load);
          navigateTo("/view/Item.fxml");
    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) {

    }

    public void navigateTo(String fxmlPath)  {
        try {
            loadAnchor.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(fxmlPath));
            loadAnchor.getChildren().add(load);
        }catch (IOException e){
            new Alert(Alert.AlertType.ERROR,"Fail ui").show();
        }
    }
}
