package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class WinController implements Initializable{
    @FXML Label label;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void setMsg(String msg) {
		// TODO Auto-generated method stub
		label.setText(msg+" wins");
	}

}
