package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class mainController implements Initializable {
	int count,k=-1,m=-1;
	int arr[][]={{10,20},{10,20},{10,20},{10,20},{10,20}};
	int arr2[][]={{10,20},{10,20},{10,20},{10,20},{10,20}};;
    @FXML private Label label;
	
   public void winner(){
	   
	try {
		   Stage primaryStage = new Stage(); 
		   FXMLLoader loader=new FXMLLoader(); 
		   Pane root = loader.load(getClass().getResource("win.fxml").openStream());
	       WinController winController=(WinController)loader.getController();
	       winController.setMsg(label.getText());
			Scene scene = new Scene(root,150,50);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
    
    public void setA(String id) {
        k = k + 1;
        if (id.equals("a")) { arr[k][1] = 0; arr[k][0] = 0; }
        if (id.equals("b")) { arr[k][0] = 0; arr[k][1] = 1; }
        if (id.equals("c")) { arr[k][0] = 0; arr[k][1] = 2; }
        if (id.equals("d")) { arr[k][0] = 1; arr[k][1] = 0; }
        if (id.equals("e")) { arr[k][0] = 1; arr[k][1] = 1; }
        if (id.equals("f")) { arr[k][0] = 1; arr[k][1] = 2; }
        if (id.equals("g")) { arr[k][0] = 2; arr[k][1] = 0; }
        if (id.equals("h")) { arr[k][0] = 2; arr[k][1] = 1; }
        if (id.equals("i")) { arr[k][0] = 2; arr[k][1] = 2; }
        //winning condition


    }

    public void  setB(String id) {
        m = m + 1;
        if (id.equals("a")) { arr2[m][0] = 0; arr2[m][1] = 0;}
        if (id.equals("b")) { arr2[m][0] = 0; arr2[m][1] = 1;}
        if (id.equals("c")) { arr2[m][0] = 0; arr2[m][1] = 2; }
        if (id.equals("d")) { arr2[m][0] = 1; arr2[m][1] = 0; }
        if (id.equals("e")) { arr2[m][0] = 1; arr2[m][1] = 1; }
        if (id.equals("f")) { arr2[m][0] = 1; arr2[m][1] = 2; }
        if (id.equals("g")) { arr2[m][0] = 2; arr2[m][1] = 0; }
        if (id.equals("h")) { arr2[m][0] = 2; arr2[m][1] = 1; }
        if (id.equals("i")) { arr2[m][0] = 2; arr2[m][1] = 2; }

    }
    public void winCheckA() {
        int count1 = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[i][0] == arr[i][1]) {
                count1++;
            }
            if (count1 == 3) { winner();break;}
        }
        count1 = 0;
        for (int j = 0; j < 5; j++) {
            if (arr[0][0] == arr[j][0])
                count1++;
            if (count1 == 3)
            { winner();break;}
        }
        count1 = 0;
        for (int j = 0; j < 5; j++) {
            if (arr[0][1] == arr[j][1])
                count1++;
            if (count1 == 3)
            { winner();break;}
    }
           
    }
    public void winCheckB() {
        int count1 = 0;
        for (int i = 0; i < 5; i++) {
            if (arr2[i][0] == arr2[i][1]) {
                count1++;
            }
            if (count1 == 3) { winner();break; 
            }
        }
        count1 = 0;
        for (int j = 0; j < 5; j++) {
            if (arr2[0][0] == arr2[j][0])
                count1++;
            if (count1 == 3)
            {winner();break;}	
        }
        count1 = 0;
        for (int j = 0; j < 5; j++) {
            if (arr2[0][1] == arr2[j][1])
                count1++;
            if (count1 == 3)
            {  winner();break;
            }
            }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
          count=1;		
          
	}
	
	public void btnClick(ActionEvent event) throws Exception{
		String a=((Button)event.getSource()).getId();
	   if(((Button)event.getSource()).getText().equals(".")){	  
		  if(count%2!=0){
			 
			  ((Button)event.getSource()).setText("O");
			  count++;
			  setA(a);
			  winCheckA();
			  label.setText("Player X");
		  		}
		  else{ 
			((Button)event.getSource()).setText("X");
			count++;
			setB(a);
			winCheckB();
			label.setText("Player O");
		  }
	   }
	   else{
		   try {
				   Stage primaryStage = new Stage(); 
				   FXMLLoader loader=new FXMLLoader(); 
				   Pane root = loader.load(getClass().getResource("already.fxml"));
					Scene scene = new Scene(root,150,50);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
		   
	}
	public void newGame(ActionEvent event) throws Exception{
		((Node)event.getSource()).getScene().getWindow().hide();
		FXMLLoader loader=new FXMLLoader();
		Pane root=loader.load(getClass().getResource("main.fxml").openStream());
		Stage primaryStage =new Stage();
		Scene scene = new Scene(root,310,310);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
     }
	public void exitWin(){
		System.exit(0);
	}
	
}