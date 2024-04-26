package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable{

	
	private DepartmentService service;
	
	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML
	private TableColumn<Department, Integer> tableColmunId;
	@FXML
	private TableColumn<Department, String> tableColmunName;
	@FXML
	private Button btNew;
	
	private ObservableList<Department> obsList;
	
	@FXML
	public void onBrNewAction() {
		System.out.println("btnewaction");
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}
	
	public void setDeparmentService(DepartmentService service) {
		this.service = service;
	}


	private void initializeNodes() {
		tableColmunId.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		tableColmunName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage)Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}
	public void updateTableView() {
	if (service == null) {
		throw new IllegalStateException("Service was null");
	}
	List<Department> list = service.findAll();
	obsList = FXCollections.observableArrayList(list);
	tableViewDepartment.setItems(obsList);
}
	
}