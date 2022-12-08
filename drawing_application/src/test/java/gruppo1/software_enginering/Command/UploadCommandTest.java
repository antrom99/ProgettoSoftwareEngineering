package gruppo1.software_enginering.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;


import javafx.scene.layout.Pane;




public class UploadCommandTest {




    @Test
    public void UploadRectangleTest(){

        

        File file = new File("/home/antonionocerino/Documenti/GitHub/ProgettoSoftwareEngineering/drawing_application/src/test/java/gruppo1/software_enginering/Command/FileTest/ProvaSave");
        Pane drawingSurface = new Pane();

        UploadCommand upload = new UploadCommand(drawingSurface, file);
        upload.execute();




        try(Scanner scanner = new Scanner(file)){

            int i=0;

            while(scanner.hasNext()){

                String text = scanner.nextLine();

                assertEquals(text, drawingSurface.getChildren().get(i).toString());
                System.out.println("Current String from Load File : "+text+"\n"+"Check with toString() of SHAPE on drawingSurface : "+drawingSurface.getChildren().get(i).toString()); 
                i++;

            }

        }catch(FileNotFoundException e){
            System.out.println("File not found !!");
        }


        System.out.println("Check of shapes number adding to drawingSurface :"+drawingSurface.getChildren().size());



    }


}
