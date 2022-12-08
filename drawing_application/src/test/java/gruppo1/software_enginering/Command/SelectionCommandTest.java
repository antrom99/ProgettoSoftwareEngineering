package gruppo1.software_enginering.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import gruppo1.software_enginering.SelectionModel;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class SelectionCommandTest {

    @Test
    void testExecute() {
        Pane drawingSurface = new Pane();
        SelectionModel selection = new SelectionModel();
        //SelectionModel selection2 = new SelectionModel();
        Rectangle rectangle = new Rectangle();
        SelectionCommand selectionCommand = new SelectionCommand(selection, rectangle, drawingSurface);


        //assertEquals(true, selection.contains(rectangle));
        
        selectionCommand.execute();
        selection.add(rectangle);

        boolean isDraw = drawingSurface.getChildren().contains(rectangle);
        boolean contains = selection.contains(rectangle);
        assertEquals(contains, isDraw);



        

        
        



    }
}
