package main;

import java.io.*;

import javafx.application.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import model.*;
import view.*;

public class Main extends Application {
	Stage primaryStage;
	ObservableList<Person> listPerson = FXCollections.observableArrayList();
	
	public Main(){
		listPerson.add(new Person("xlemi01","space01"));
		listPerson.add(new Person("xlemi02","space02"));
		listPerson.add(new Person("xlemi03","space03"));
		listPerson.add(new Person("xlemi04","space04"));
		listPerson.add(new Person("xlemi05","space05"));
		listPerson.add(new Person("xlemi06","space06"));
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		String file = new String("/view/Person_view.fxml");
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(file));
		AnchorPane pane=null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		PersonView personView = loader.getController();
		personView.setTblPerson(listPerson);
	}

	public static void main(String[] args) {
		launch(args);
	}
}