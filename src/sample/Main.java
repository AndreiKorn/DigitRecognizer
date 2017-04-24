package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileReader;
import com.csvreader.CsvReader;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        CsvReader csvReader = new CsvReader("D:\\Учёба\\Магистратура\\Интеллектуальные системы\\NeuralNetwork\\src\\sample\\train.csv");

        csvReader.readHeaders();
        String[] headers = csvReader.getHeaders();
        System.out.println(headers[1]);

//        while (csvReader.readRecord()) {
        csvReader.readRecord();
            String label = csvReader.get("label");
        System.out.println(label);
            int[] pixels = new int[784];
            String base = "pixel";

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = Integer.parseInt(csvReader.get(base.concat(Integer.toString(i))));
        }

        for (int i = 0; i < pixels.length; i++) {
            System.out.println(pixels[i]);
        }
//        }


//        CSVReader reader = new CSVReader(new FileReader("D:\\Учёба\\Магистратура\\Интеллектуальные системы\\NeuralNetwork\\src\\sample\\train.csv"));
//        String[] header = reader.readNext();
//        String[] nextLine;
//        int i = 0;
//        while ((nextLine = reader.readNext()) != null) {
//            System.out.println(nextLine[i]);
//        }
//        String[] lastLine = reader.;
//        System.out.println(lastLine[0]);

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Network network = new Network();
        network.train();
        network.check();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
