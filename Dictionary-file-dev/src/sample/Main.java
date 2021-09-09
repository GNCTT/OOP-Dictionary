package sample;

import Dictionary.DictionaryCommandline;
import Dictionary.Word;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static Dictionary.Dictionary.dictionary_list;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {

        DictionaryCommandline dcm = new DictionaryCommandline();
        Word a = new Word("hello", "xin chao");
        Word b = new Word("strange", "lạ lẫm");
        Word c = new Word("hand", "bàn tay");
        dictionary_list.add(a);
        dictionary_list.add(b);
        dictionary_list.add(c);
        dcm.dictionaryBasic();
        launch(args);
    }
}
