package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //khung cua chuong trinh

    @FXML
    private AnchorPane Main_App;

    @FXML
    private AnchorPane Top_App;

    // các biến thao tác tìm kiếm từ

    @FXML
    private HBox Search_Box;

    @FXML
    private Pane Search_Pane;

    @FXML
    private TextField Search_Text_Field;

    @FXML
    private JFXButton Search_Cancel;

    @FXML
    private JFXButton Search_Button;

    @FXML
    private JFXListView<String> Search_ListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Search_ListView.getItems().add("hello");
        Search_ListView.getItems().add("strange");

//        Search_Text_Field.setOnKeyReleased(event -> {
//
//            if(Search_Text_Field.getLength() == 0) {
//                Search_Cancel.setVisible(false);
//                Search_ListView.setVisible(false);
//            }
//            else {
//                Search_Cancel.setVisible(true);
//                Search_ListView.setVisible(true);
//            }
//
//
//        });

        Search_Text_Field.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (Search_Text_Field.getLength() != 0) {
                    if (event.getCode().equals(KeyCode.ENTER)) {
                        Search_ListView.setVisible(false);
                    }
                    else {
                        Search_Cancel.setVisible(true);
                        Search_ListView.setVisible(true);
                    }
                }
                else {
                    Search_Cancel.setVisible(false);
                    Search_ListView.setVisible(false);
                }
            }
        });

        Search_Cancel.setOnMouseClicked(event -> {
            Search_Text_Field.setText("");
            Search_Cancel.setVisible(false);
            Search_ListView.setVisible(false);
        });

        Search_ListView.setOnMouseClicked(event -> {
            String Chosen_Word = Search_ListView.getSelectionModel().getSelectedItem();
            System.out.println(Chosen_Word);
            Search_Text_Field.setText(Chosen_Word);
            Search_ListView.setVisible(false);
        });

        Search_Button.setOnMouseClicked(event -> {
            if (Search_Text_Field.getLength() != 0) {
                Search_ListView.setVisible(false);
            }
        });

    }



}
