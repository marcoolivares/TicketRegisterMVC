/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ticket.TicketController;
import ticket.TicketModel;
import ticket.TicketView;

/**
 *
 * @author Marco
 */
public class TicketRegisterMVC extends Application
{
    
    @Override
    public void start(Stage primaryStage)
    {
        TicketModel tm = new TicketModel();
        TicketView tv = new TicketView();
        TicketController tc = new TicketController(tm,tv);
        StackPane root = new StackPane();
        root.getChildren().add(tv);
        
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("Ticket Register MVC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
