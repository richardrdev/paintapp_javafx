/*
 * Driver.java
 * 
 * This is the starting point of the app.  Holds the main method
 * and starts the Application.
 * 
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class Driver extends Application
{

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		PaintApp app = PaintApp.getInstance();
		app.start(primaryStage);
	}

	public static void main(String[] args)
	{
		Application.launch(args);
	}

}
