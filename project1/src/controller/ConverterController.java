package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import algo.Converter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import parser.ExpressionChecker;

public class ConverterController implements Initializable{
    
    @FXML
    TextField prefixField, infixField, postfixField;
    
    @FXML
    Button backToMainButton;
    

    public void convertInfix(ActionEvent event) {
        String input = infixField.getText();
        
        if(input.isBlank()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("");
            alert.setTitle("");
            alert.setContentText("Chưa nhập biểu thức cần đánh giá!");
            alert.show();
            return;
        }
        
        ExpressionChecker checker = new ExpressionChecker();
        String prefixResult, postfixResult;
        if(!checker.check(input)) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("");
            alert.setTitle("");
            alert.setContentText("Biểu thức sai định dạng!");
            alert.show();
            return;
        } else {
            try {
                prefixResult = Converter.infixToPrefix(input);
                postfixResult = Converter.infixToPostfix(input);
                prefixField.setText(prefixResult);
                postfixField.setText(postfixResult);
            }
            catch(Exception e) {
//                e.printStackTrace();
                Alert alert = new Alert(AlertType.WARNING);
                alert.setHeaderText("");
                alert.setTitle("");
                alert.setContentText("Biểu thức sai định dạng!");
                alert.show();
            }
        }
    }
    
    public void convertPrefix(ActionEvent event) {
        String input = prefixField.getText();
        
        if(input.isBlank()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("");
            alert.setTitle("");
            alert.setContentText("Chưa nhập biểu thức cần đánh giá!");
            alert.show();
            return;
        }
        
        ExpressionChecker checker = new ExpressionChecker();
        String infixResult, postfixResult;
        if(!checker.check(Converter.prefixToInfix(input))) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("");
            alert.setTitle("");
            alert.setContentText("Biểu thức sai định dạng!");
            alert.show();
        } else {
            try {
                infixResult = Converter.prefixToInfix(input);
                postfixResult = Converter.prefixToPostfix(input);
                postfixField.setText(postfixResult);
                infixField.setText(infixResult);
            }
            catch(Exception e) {
//                e.printStackTrace();
                Alert alert = new Alert(AlertType.WARNING);
                alert.setHeaderText("");
                alert.setTitle("");
                alert.setContentText("Biểu thức sai định dạng!");
                alert.show();
            }
        }
    }

    public void convertPostfix(ActionEvent event) {
        String input = postfixField.getText();
        
        if(input.isBlank()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("");
            alert.setTitle("");
            alert.setContentText("Chưa nhập biểu thức cần đánh giá!");
            alert.show();
            return;
        }
        
        ExpressionChecker checker = new ExpressionChecker();
        String infixResult, prefixResult;
        if(!checker.check(Converter.postfixToInfix(input))) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("");
            alert.setTitle("");
            alert.setContentText("Biểu thức sai định dạng!");
            alert.show();
        } else {
            try {
                infixResult = Converter.postfixToInfix(input);
                prefixResult = Converter.postfixToPrefix(input);
                prefixField.setText(prefixResult);
                infixField.setText(infixResult);
            }
            catch(Exception e) {
//              e.printStackTrace();
              Alert alert = new Alert(AlertType.WARNING);
              alert.setHeaderText("");
              alert.setTitle("");
              alert.setContentText("Biểu thức sai định dạng!");
              alert.show();
            }
        }
    }
    
    public void backToMain(ActionEvent event) throws IOException {
        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        Image backImage = new Image(getClass().getResourceAsStream("/view/backbutton.png"));
        ImageView backImageView = new ImageView(backImage);
        backImageView.setFitHeight(20);
        backImageView.setFitWidth(20);
        backToMainButton.setGraphic(backImageView);
    }
}
