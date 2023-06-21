/*
 * AlertManager.java
 * 
 * Holds a variety of error messages for use throughout the app.
 * 
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.controller;

import javafx.scene.control.Alert;

public class AlertManager
{
	public static class PaintAppAlert
	{
		public static void showAlert(Alert.AlertType type, String message)
		{
			Alert alert = new Alert(type);
			alert.setContentText(message);
			alert.show();
		}
	}
	
	public static class LoadFailureAlert extends PaintAppAlert
	{
		public static void show()
		{
			Alert.AlertType type = Alert.AlertType.ERROR;
			String message = "Encountered an error while attemping to load drawing.\n" + 
											"Please ensure filename is correct and try again.";
			showAlert(type, message);
		}
	}
	
	public static class FileNotFoundAlert extends PaintAppAlert
	{
		public static void show(String filename)
		{
			Alert.AlertType type = Alert.AlertType.ERROR;
			String message = String.format("Filename %s was not found.  Please ensure\n",filename) + 
											"File exists and try again";
			showAlert(type, message);
		}
	}
	
	public static class SaveFileFailureAlert extends PaintAppAlert
	{
		public static void show()
		{
			Alert.AlertType type = Alert.AlertType.ERROR;
			String message = "Unknown error occurred while attemping to load drawing.";
			showAlert(type, message);
		}
	}
	
	public static class ResourceLoadFailure_UI extends PaintAppAlert
	{
		public static void show(String filename)
		{
			Alert.AlertType type = Alert.AlertType.ERROR;
			String message = String.format("Error occurred while attempting to load resource file %s", filename);
			showAlert(type, message);
		}
		
		public static void show()
		{
			Alert.AlertType type = Alert.AlertType.ERROR;
			String message = "Unknown error occurred while loading resource files.";
			showAlert(type, message);
		}
	}
	
	public static class CanvasSizeInputError extends PaintAppAlert
	{
		public static void show()
		{
			Alert.AlertType type = Alert.AlertType.ERROR;
			String message = "Given dimensions could not be processed.\n" + 
							"Drawing will be created with default dimensions.";
			showAlert(type, message);
		}
	}
}
