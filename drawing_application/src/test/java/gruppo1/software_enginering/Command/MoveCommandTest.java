package gruppo1.software_enginering.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class MoveCommandTest {


    
    



        // input Move : Shape, Rectangle, startx, starty, endx, endy
        // Move command verfy the consistence of end_x and of end_y releated on the Width and the Heigth of Rectangle view that contain a shape
        //the view rappresent the scene that contain a shape



        //Good Case : (endx - startx) = offsetx of move =>  0<=view.getX+view.getWidth +offsetx<=773 =>  offsetx_expected = offsetX
        //Good Case : (endy - starty) = offsety of move =>  0<=view.getY+view.getHeigth +offsety<=670 =>  offsety_expected = offsetY
        //Limit Case : (endx - startx) = offsetx of move =>  view.getX+view.getWidth +offsetx>773 773 = Max Width of Drawing Surface => offsetx_expected = 773 - view.getWidh-view.getX
        //Limit Case : (endx - startx) = offsetx of move =>  view.getX+view.getWidth +offsetx<0= Min Width of Drawing Surface => offsetx_expected = 0-view.getX
        //Limit Case : (endy - starty) = offsety of move =>  view.getY+view.getHeigth +offsety>670 670 = Max Heigth of Drawing Surface => offsety_expected = 670 -view.getHeigth-view.getY
        //Limit Case : (endy - starty) = offsety of move =>  view.getY+view.getHeigth +offsety<0= Min Heigth of Drawing Surface => offsety_expected = 0-view.getY
        @Test
        public void executeMoveRectangleTest(){

            System.out.println("\n\n =============================TEST CASE RECTANGLE TO MOVE=========================\n\n");

            Shape shape_to_move = new Rectangle(10, 10, 50, 70);
            Rectangle view = new Rectangle (7,7,56,76);
            double expected_x;
            double expected_y;

            double start_x = 30;
            double start_y = 40;
            double limite_offset_x_sup=773-view.getWidth()-view.getX();
            double limite_offset_x_inf=-view.getX();
            double limite_offset_y_sup = 670 - view.getHeight()-view.getY();
            double limite_offset_y_inf = -view.getY();

            System.out.println("Rectangle that I  would move : " + shape_to_move);


            //Limit Case : (endx - startx) = offsetx of move =>  view.getX+view.getWidth +offsetx>773 773 = Max Width of Drawing Surface => offsetx_expected = 773 - view.getWidh-view.getX
            double end_x  = 800;

            expected_x=773- view.getX()- view.getWidth();
            //Limit Case : (endy - starty) = offsety of move =>  view.getY+view.getHeigth +offsety>670 670 = Max Heigth of Drawing Surface =>  670 -view.getHeigth-view.getY
            double end_y = 800;
            expected_y=670-view.getY()- view.getHeight();
            System.out.println(limite_offset_x_inf+" <= offsetx <= "+limite_offset_x_sup + " ==== "+ "traslate request: "+(end_x-start_x));
            System.out.println(limite_offset_y_inf+" <= offsety <= "+limite_offset_y_sup + " ==== "+ "traslate request: "+(end_y-start_y));
            System.out.println("----call a Move----");
            Command command = new MoveCommand(shape_to_move, view, end_x, end_y, start_x, start_y);
            command.execute();

            assertEquals(expected_x, shape_to_move.getTranslateX());
            assertEquals(expected_y, shape_to_move.getTranslateY());

            System.out.println("Rectangle "+shape_to_move +"\noffset after traslate --- actual x = " +shape_to_move.getTranslateX()+ " expected x = "+expected_x+ " --- actual y = " +shape_to_move.getTranslateY()+ " expected x = "+expected_y+"\n\n");



            System.out.println("Rectangle that I  would move : " + shape_to_move);
            //Good Case : (endx - startx) = offsetx of move =>  0<=view.getX+view.getWidth +offsetx<=773 =>  offsetx_expected = offsetX
            end_x = 50 ;
            expected_x = end_x-start_x;
            
            //Good Case : (endy - starty) = offsety of move =>  0<=view.getY+view.getHeigth +offsety<=670 =>  offsety_expected = offsetY
             end_y = 35;
             expected_y = end_y-start_y;
             System.out.println(limite_offset_x_inf+" <= offsetx <= "+limite_offset_x_sup + "===="+ "traslate request: "+(end_x-start_x));
            System.out.println(limite_offset_y_inf+" <= offsety <= "+limite_offset_y_sup + "===="+ "traslate request: "+(end_y-start_y));
            System.out.println("----call a Move----");
             command = new MoveCommand(shape_to_move, view, end_x, end_y, start_x, start_y);
             command.execute();
             assertEquals(expected_x, shape_to_move.getTranslateX());
            assertEquals(expected_y, shape_to_move.getTranslateY());
            System.out.println("Rectangle "+shape_to_move +"\noffset after traslate --- actual x = " +shape_to_move.getTranslateX()+ " expected x = "+expected_x+ " --- actual y = " +shape_to_move.getTranslateY()+ " expected x = "+expected_y+"\n\n");


            System.out.println("Rectangle that I  would move : " + shape_to_move);
            //Limit Case : (endx - startx) = offsetx of move =>  view.getX+view.getWidth +offsetx<0= Min Width of Drawing Surface => offsetx_expected =  0-view.getX
            end_x = -80;
            expected_x = -view.getX();
            

            //Limit Case : (endy - starty) = offsety of move =>  view.getY+view.getHeigth +offsety<0= Min Heigth of Drawing Surface => offsety_expected =  0-view.getY
            end_y = -90;
            expected_y = - view.getY();
            System.out.println(limite_offset_x_inf+" <= offsetx <= "+limite_offset_x_sup + "===="+ "traslate request: "+(end_x-start_x));
            System.out.println(limite_offset_y_inf+" <= offsety <= "+limite_offset_y_sup + "===="+ "traslate request: "+(end_y-start_y));
            System.out.println("----call a Move----");
            command = new MoveCommand(shape_to_move, view, end_x, end_y, start_x, start_y);
            command.execute();
            assertEquals(expected_x, shape_to_move.getTranslateX());
            assertEquals(expected_y, shape_to_move.getTranslateY());
            System.out.println("Rectangle "+shape_to_move +"\noffset after traslate --- actual x = " +shape_to_move.getTranslateX()+ " expected x = "+expected_x+ " --- actual y = " +shape_to_move.getTranslateY()+ " expected x = "+expected_y+"\n\n");

        }

        @Test
        public void executeMoveEllipse(){

            Shape shape_to_move = new  Ellipse(30,40,50,70);
            Rectangle view = new Rectangle (7,7,56,76);
            double expected_x;
            double expected_y;
            double limite_offset_x_sup=773-view.getWidth()-view.getX();
            double limite_offset_x_inf=-view.getX();
            double limite_offset_y_sup = 670 - view.getHeight()-view.getY();
            double limite_offset_y_inf = -view.getY();

            System.out.println("\n\n =============================TEST CASE ELLIPSE TO MOVE=========================\n\n");

            System.out.println("Ellipse that I  would move : " + shape_to_move);
            double start_x = 30;
            double start_y = 40;

            //Limit Case : (endx - startx) = offsetx of move =>  view.getX+view.getWidth +offsetx>773 773 = Max Width of Drawing Surface => offsetx_expected = 773 - view.getWidh-view.getX
            double end_x  = 800;
            expected_x=773- view.getX()- view.getWidth();
            //Limit Case : (endy - starty) = offsety of move =>  view.getY+view.getHeigth +offsety>670 670 = Max Heigth of Drawing Surface =>  670 -view.getHeigth-view.getY
            double end_y = 800;
            expected_y=670-view.getY()- view.getHeight();
            System.out.println(limite_offset_x_inf+" <= offsetx <= "+limite_offset_x_sup + " ==== "+ "traslate request: "+(end_x-start_x));
            System.out.println(limite_offset_y_inf+" <= offsety <= "+limite_offset_y_sup + " ==== "+ "traslate request: "+(end_y-start_y));
            System.out.println("----call a Move----");
            Command command = new MoveCommand(shape_to_move, view, end_x, end_y, start_x, start_y);
            command.execute();

            assertEquals(expected_x, shape_to_move.getTranslateX());
            assertEquals(expected_y, shape_to_move.getTranslateY());
            System.out.println("Ellipse "+shape_to_move +"\noffset after traslate --- actual x = " +shape_to_move.getTranslateX()+ " expected x = "+expected_x+ " --- actual y = " +shape_to_move.getTranslateY()+ " expected x = "+expected_y+"\n\n");

            System.out.println("Ellipse that I  would move : " + shape_to_move);

            //Good Case : (endx - startx) = offsetx of move =>  0<=view.getX+view.getWidth +offsetx<=773 =>  offsetx_expected = offsetX
            end_x = 50 ;
            expected_x = end_x-start_x;
            
            //Good Case : (endy - starty) = offsety of move =>  0<=view.getY+view.getHeigth +offsety<=670 =>  offsety_expected = offsetY
             end_y = 35;
             expected_y = end_y-start_y;
             System.out.println(limite_offset_x_inf+" <= offsetx <= "+limite_offset_x_sup + " ==== "+ "traslate request: "+(end_x-start_x));
            System.out.println(limite_offset_y_inf+" <= offsety <= "+limite_offset_y_sup + " ==== "+ "traslate request: "+(end_y-start_y));
            System.out.println("----call a Move----");
             command = new MoveCommand(shape_to_move, view, end_x, end_y, start_x, start_y);
             command.execute();
             assertEquals(expected_x, shape_to_move.getTranslateX());
            assertEquals(expected_y, shape_to_move.getTranslateY());
            System.out.println("Ellipse "+shape_to_move +"\noffset after traslate --- actual x = " +shape_to_move.getTranslateX()+ " expected x = "+expected_x+ " --- actual y = " +shape_to_move.getTranslateY()+ " expected x = "+expected_y+"\n\n");


            System.out.println("Ellipse that I  would move : " + shape_to_move);
            //Limit Case : (endx - startx) = offsetx of move =>  view.getX+view.getWidth +offsetx<0= Min Width of Drawing Surface => offsetx_expected =  0-view.getX
            end_x = -80;
            expected_x = -view.getX();
            

            //Limit Case : (endy - starty) = offsety of move =>  view.getY+view.getHeigth +offsety<0= Min Heigth of Drawing Surface => offsety_expected =  0-view.getY
            end_y = -90;
            expected_y = - view.getY();
            System.out.println(limite_offset_x_inf+" <= offsetx <= "+limite_offset_x_sup + " ==== "+ "traslate request: "+(end_x-start_x));
            System.out.println(limite_offset_y_inf+" <= offsety <= "+limite_offset_y_sup + " ==== "+ "traslate request: "+(end_y-start_y));
            System.out.println("----call a Move----");
            command = new MoveCommand(shape_to_move, view, end_x, end_y, start_x, start_y);
            command.execute();
            assertEquals(expected_x, shape_to_move.getTranslateX());
            assertEquals(expected_y, shape_to_move.getTranslateY());
            System.out.println("Ellipse "+shape_to_move +"\noffset after traslate --- actual x = " +shape_to_move.getTranslateX()+ " expected x = "+expected_x+ " --- actual y = " +shape_to_move.getTranslateY()+ " expected x = "+expected_y+"\n\n");
        }

        @Test
        public void executeMoveLine(){

            Shape shape_to_move = new Line(10, 10, 50, 70);
            Rectangle view = new Rectangle (7,7,56,76);
            double expected_x;
            double expected_y;
            double limite_offset_x_sup=773-view.getWidth()-view.getX();
            double limite_offset_x_inf=-view.getX();
            double limite_offset_y_sup = 670 - view.getHeight()-view.getY();
            double limite_offset_y_inf = -view.getY();
            System.out.println("\n\n =============================TEST CASE LINE TO MOVE=========================\n\n");
            double start_x = 30;
            double start_y = 40;
            System.out.println("Line that I  would move : " + shape_to_move);
            //Limit Case : (endx - startx) = offsetx of move =>  view.getX+view.getWidth +offsetx>773 773 = Max Width of Drawing Surface => offsetx_expected = 773 - view.getWidh-view.getX
            double end_x  = 800;
            expected_x=773- view.getX()- view.getWidth();
            //Limit Case : (endy - starty) = offsety of move =>  view.getY+view.getHeigth +offsety>670 670 = Max Heigth of Drawing Surface =>  670 -view.getHeigth-view.getY
            double end_y = 800;
            expected_y=670-view.getY()- view.getHeight();
            System.out.println(limite_offset_x_inf+" <= offsetx <= "+limite_offset_x_sup + " ==== "+ "traslate request: "+(end_x-start_x));
            System.out.println(limite_offset_y_inf+" <= offsety <= "+limite_offset_y_sup + " ==== "+ "traslate request: "+(end_y-start_y));
            System.out.println("----call a Move----");
            Command command = new MoveCommand(shape_to_move, view, end_x, end_y, start_x, start_y);
            command.execute();

            assertEquals(expected_x, shape_to_move.getTranslateX());
            assertEquals(expected_y, shape_to_move.getTranslateY());
            System.out.println("Line "+shape_to_move +"\noffset after traslate --- actual x = " +shape_to_move.getTranslateX()+ " expected x = "+expected_x+ " --- actual y = " +shape_to_move.getTranslateY()+ " expected x = "+expected_y+"\n\n");
            System.out.println("Line that I  would move : " + shape_to_move);


            //Good Case : (endx - startx) = offsetx of move =>  0<=view.getX+view.getWidth +offsetx<=773 =>  offsetx_expected = offsetX
            end_x = 50 ;
            expected_x = end_x-start_x;
            
            //Good Case : (endy - starty) = offsety of move =>  0<=view.getY+view.getHeigth +offsety<=670 =>  offsety_expected = offsetY
             end_y = 35;
             expected_y = end_y-start_y;
             System.out.println(limite_offset_x_inf+" <= offsetx <= "+limite_offset_x_sup + " ==== "+ "traslate request: "+(end_x-start_x));
            System.out.println(limite_offset_y_inf+" <= offsety <= "+limite_offset_y_sup + " ==== "+ "traslate request: "+(end_y-start_y));
            System.out.println("----call a Move----");
             command = new MoveCommand(shape_to_move, view, end_x, end_y, start_x, start_y);
             command.execute();
             assertEquals(expected_x, shape_to_move.getTranslateX());
            assertEquals(expected_y, shape_to_move.getTranslateY());
            System.out.println("Line "+shape_to_move +"\noffset after traslate --- actual x = " +shape_to_move.getTranslateX()+ " expected x = "+expected_x+ " --- actual y = " +shape_to_move.getTranslateY()+ " expected x = "+expected_y+"\n\n");
            System.out.println("Line that I  would move : " + shape_to_move);
            //Limit Case : (endx - startx) = offsetx of move =>  view.getX+view.getWidth +offsetx<0= Min Width of Drawing Surface => offsetx_expected =  0-view.getX
            end_x = -80;
            expected_x = -view.getX();
            

            //Limit Case : (endy - starty) = offsety of move =>  view.getY+view.getHeigth +offsety<0= Min Heigth of Drawing Surface => offsety_expected =  0-view.getY
            end_y = -90;
            expected_y = - view.getY();
            System.out.println(limite_offset_x_inf+" <= offsetx <= "+limite_offset_x_sup + " ==== "+ "traslate request: "+(end_x-start_x));
            System.out.println(limite_offset_y_inf+" <= offsety <= "+limite_offset_y_sup + " ==== "+ "traslate request: "+(end_y-start_y));
            System.out.println("----call a Move----");
            command = new MoveCommand(shape_to_move, view, end_x, end_y, start_x, start_y);
            command.execute();
            assertEquals(expected_x, shape_to_move.getTranslateX());
            assertEquals(expected_y, shape_to_move.getTranslateY());
            System.out.println("Line "+shape_to_move +"\noffset after traslate --- actual x = " +shape_to_move.getTranslateX()+ " expected x = "+expected_x+ " --- actual y = " +shape_to_move.getTranslateY()+ " expected x = "+expected_y+"\n\n");


        }
        
     
       


    
}
