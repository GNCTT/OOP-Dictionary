package sample;

import Dictionary.DictionaryCommandline;
import Dictionary.DictionaryManagement;
import Dictionary.Word;
import com.sun.java.accessibility.util.Translator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.File;

import static Dictionary.Dictionary.dictionary_list;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws FileNotFoundException,IOException {

        DictionaryCommandline dcm1 = new DictionaryCommandline();
        dcm1.DictionaryAdvance();
        Scanner sc =new Scanner(System.in);
        String input = sc.nextLine();
        dcm1.dictionarySearcher(input);
        dcm1.Speech("hello");
        launch(args);
    }
}
