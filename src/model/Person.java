package model;

import javafx.beans.property.*;

public class Person {
	private IntegerProperty code;
	private StringProperty name;
	private StringProperty home;
	
	private static int mCode;
	
	public Person(String name,String home){
		this.code = new SimpleIntegerProperty(++mCode);
		this.name = new SimpleStringProperty(name);
		this.home = new SimpleStringProperty(home);
	}

	public final IntegerProperty codeProperty() {
		return this.code;
	}

	public final int getCode() {
		return this.codeProperty().get();
	}

	public final void setCode(final int code) {
		this.codeProperty().set(code);
	}

	public final StringProperty nameProperty() {
		return this.name;
	}

	public final java.lang.String getName() {
		return this.nameProperty().get();
	}

	public final void setName(final java.lang.String name) {
		this.nameProperty().set(name);
	}

	public final StringProperty homeProperty() {
		return this.home;
	}

	public final java.lang.String getHome() {
		return this.homeProperty().get();
	}

	public final void setHome(final java.lang.String home) {
		this.homeProperty().set(home);
	}
	
	
}
