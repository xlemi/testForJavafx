package view;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;
import model.*;

public class EditView {
	@FXML
	private Label lbCode;
	@FXML
	private TextField tfName;
	@FXML
	private TextField tfHome;
	
	private Stage stage;
	private boolean bOk;
	
	@FXML
	public void okClicked(){
		bOk = true;
		stage.close();
	}
	@FXML
	public void cancelClicked(){
		stage.close();
	}
	public boolean isOk(){
		return bOk;
	}
	public void setPerson(Person person){
		lbCode.setText(Integer.toString(person.getCode()));
		tfName.setText(person.getName());
		tfHome.setText(person.getHome());
	}
	
	public void getPerson(Person person){
		person.setName(tfName.getText());
		person.setHome(tfHome.getText());
	}
	
	public void setStage(Stage stage){
		this.stage = stage;
	}
}
