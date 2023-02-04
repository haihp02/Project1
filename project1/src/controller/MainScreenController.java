package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainScreenController{
	
	public void showEvaluator(ActionEvent event) throws IOException {
		Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());
		Parent root = FXMLLoader.load(getClass().getResource("/view/EvaluatorScreen.fxml"));
		Scene scene = new Scene(root,600,400);
		stage.setScene(scene);
		stage.show();
		System.out.println("Show Evaluator");
	}
	
	public void showConverter(ActionEvent event) throws IOException {
		Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());
		Parent root = FXMLLoader.load(getClass().getResource("/view/ConverterScreen.fxml"));
		Scene scene = new Scene(root,600,400);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		System.out.println("Show Converter");
	}
	
	public void showInstruction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/view/icon.png")));
        stage.setTitle("My calculator😊");
        Parent root = FXMLLoader.load(getClass().getResource("/view/InstructionScreen.fxml"));
        Scene scene = new Scene(root,400,400);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        System.out.println("Show Instruction");
    }
}
