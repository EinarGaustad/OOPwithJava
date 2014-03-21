//package grafikk;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//public class MinimalApplication extends Application {
//
//    public void start(Stage stage) throws Exception {
//         
//        BorderPane root = new BorderPane(); // Root of the scene graph
//         
//        // Add one Text node in each region
//        root.setTop(new Text("top"));
//        root.setBottom(new Text("bottom"));
//        root.setLeft(new Text("left"));
//        root.setRight(new Text("right"));
//        root.setCenter(new Text("center"));
//         
//        Scene scene = new Scene(root, 500, 500);
//     
//        stage.setScene(scene);
//        stage.setTitle("BorderPaneApplication");
//        stage.show();
//    }
//    public static void main(String[] args) {
//        launch(MinimalApplication.class, args);
//    }
//}
