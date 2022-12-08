package gruppo1.software_enginering.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


import javafx.scene.shape.Rectangle;

public class MoveCommandTest {


    @Test
    void testExecute() {
        Rectangle rectangle = new Rectangle();
        //MouseEvent event = new MouseEvent(null, 0, 0, 0, 0, null, 0, false, false, false, false, false, false, false, false, false, false, null);

        double end_x, end_y;

        
        double x = 5.0, y = 7.0;
        end_x = 40;
        end_y = 150;

        MoveCommand moveCommand = new MoveCommand(rectangle, rectangle, end_x, end_y, x, y);
        moveCommand.execute();
      
        double actualx = rectangle.getTranslateX();
        double actualy = rectangle.getTranslateY();
        assertEquals(end_x-x, actualx);
        assertEquals(end_y-y, actualy);


        end_x = -1000;
        end_y = -5000;
        MoveCommand moveCommand1 = new MoveCommand(rectangle, rectangle, end_x, end_y, x, y);
        moveCommand1.execute();
      
        double actualx1 = rectangle.getTranslateX();
        double actualy1 = rectangle.getTranslateY();
        assertEquals(-0.0, actualx1);
        assertEquals(+26, actualy1);


    }
}
