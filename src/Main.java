import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<Block> blockchain = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/sample.fxml"));
        primaryStage.setTitle("blockchain-demo");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();

    }

    private Boolean isChainValid(){
        Block currentBlock;
        Block previousBlock;

        // Check hashes
        for (int i=1;i<blockchain.size();i++){
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            // Compare registered hash and calculated hash
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())){
                System.out.println("Current hash does not match");
                return false;
            }
            // Compare previous hash and
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())){
                System.out.println("Previous hash does not match");
            }
        }
        return true;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
