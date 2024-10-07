package lk.ijse.gdse.Super.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.Super.dto.CustomerDto;
import lk.ijse.gdse.Super.dto.tm.CustomerTM;
import lk.ijse.gdse.Super.model.CustomerModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnGenerateReport;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<CustomerTM,String> customerEmail;

    @FXML
    private TableColumn<CustomerTM,String> customerId;

    @FXML
    private TableColumn<CustomerTM,String> customerName;

    @FXML
    private TableColumn<CustomerTM,String> customerNic;

    @FXML
    private TableColumn<CustomerTM,String> customerPhone;

    @FXML
    private Label lblCust;

    @FXML
    private Label lblCustomerId;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblNIC;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPhone;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private TableView<CustomerTM> tblTable;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    void DeleteOnAction(ActionEvent event) {

    }

    @FXML
    void GenerateReportOnAction(ActionEvent event) {

    }

    @FXML
    void ResetOnAction(ActionEvent event) {

    }

    @FXML
    void UpdateOnAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        customerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        customerPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

//        CustomerTM customerTM1 = new CustomerTM("C001","Kamal","045004005043","Kamal@gmail.com","0765645654");
//        CustomerTM customerTM2 = new CustomerTM("C002","Nimal","045004004053","Nimal@gmail.com","0775645789");
//
//        ArrayList<CustomerTM> customertmsArray = new ArrayList<>();
//        customertmsArray.add(customerTM1);
//        customertmsArray.add(customerTM2);
//
//        ObservableList<CustomerTM> customerTMS = FXCollections.observableArrayList();
//
//        for(CustomerTM customer : customertmsArray){
//            customerTMS.add(customer);
//        }
//        tblTable.setItems(customerTMS);
        try{
            loadNextCustomerId();
        }catch(Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Fail Customer id").show();
        }
    }
    CustomerModel customerModel = new CustomerModel();
    public void loadNextCustomerId() throws SQLException, ClassNotFoundException {
        String nextCustomerId = customerModel.getNextCustomerId();
        lblCust.setText(nextCustomerId);
    }
    public void saveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String customerId = lblCust.getText();
        String name = txtName.getText();
        String nic = txtNIC.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();

        CustomerDto customerDto = new CustomerDto(
                customerId,
                name,
                nic,
                email,
                phone
        );

        boolean isSaved  = customerModel.saveCustomer(customerDto);
        if(isSaved){
            loadNextCustomerId();
            txtName.setText("");
            txtNIC.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
            new Alert(Alert.AlertType.INFORMATION,"Customer Saved").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Save fail").show();

        }
    }

}
