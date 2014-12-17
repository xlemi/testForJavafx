package view;

import java.io.*;

import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import model.*;

public class PersonView {
	@FXML
	private TableView<Person> tblPerson;
	@FXML
	private TableColumn<Person, Integer> colCode;
	@FXML
	private Label lbName;
	@FXML
	private Label lbHome;
	
	private int mIndex;
	
	@FXML
	public void editClicked(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/Edit_view.fxml"));
		AnchorPane  pane=null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scene scene = new Scene(pane);
		Stage stage = new Stage();
		stage.setScene(scene);
		
		EditView editView = loader.getController();
		editView.setStage(stage);
		mIndex = tblPerson.getSelectionModel().getSelectedIndex();
		Person person = tblPerson.getItems().get(mIndex);
		editView.setPerson(person);
		stage.showAndWait();
		if(editView.isOk()){
			editView.getPerson(person);
			tblPerson.getItems().set(mIndex, person);
			setPerson(person);
		}
		
	}
	@FXML
	public void deleteClicked(){
		mIndex = tblPerson.getSelectionModel().getSelectedIndex();
		if(mIndex >=0)
			tblPerson.getItems().remove(mIndex);
		
	}
	@FXML
	public void initialize(){
		tblPerson.getSelectionModel().selectedItemProperty().addListener(
				(e,old,neo) -> setPerson(neo)
				);
		colCode.setCellValueFactory(
				e->e.getValue().codeProperty().asObject()
				);
	}
	
	
	public void setTblPerson(ObservableList<Person> list){
		tblPerson.setItems(list);
	}
	
	public void setPerson(Person person){
		if(person != null) {
			lbName.setText(person.getName());
			lbHome.setText(person.getHome());
		}
	}
	public void getPerson(Person person){
		person.setName(lbName.getText());
		person.setHome(lbHome.getText());
	}
}
