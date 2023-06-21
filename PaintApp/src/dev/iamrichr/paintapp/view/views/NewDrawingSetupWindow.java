/*
 * NewDrawingSetupWindow.java
 * 
 * This is a secondary window that is displayed before creating a new drawing.  Will
 * allow the user to input custom canvas dimensions.  If dimensions are not provided or
 * are invalid, the used will be notified and a canvas with default dimensions will be created.
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.view.views;

import dev.iamrichr.paintapp.controller.AlertManager;
import dev.iamrichr.paintapp.controller.UserInteraction;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NewDrawingSetupWindow extends View
{
	private static final int SETUP_WINDOW_VIEW_WIDTH = 192;
	private static final int SETUP_WINDOW_VIEW_HEIGHT = 225;
	private Stage stage;
	private TextField widthInputField;
	private TextField heightInputField;
	
	public NewDrawingSetupWindow()
	{
		super(SETUP_WINDOW_VIEW_WIDTH, SETUP_WINDOW_VIEW_HEIGHT);
		stage = new Stage();
		stage.setTitle("New Drawing Setup");
		stage.setScene(scene);
	}
	
	protected Pane createRoot()
	{
		FlowPane root = new FlowPane(Orientation.VERTICAL);
		root.setPadding(new Insets(8.0));
		root.setStyle(getRootStyles());
		return root;
	}
	
	protected void createLayout()
	{
		VBox contentBox = new VBox();
		contentBox.setSpacing(5.0);
		contentBox.setStyle(getContentStyles());
		
		Label widthInputLabel = new Label("Input width");
		
		widthInputField = new TextField();
		
		Label heightInputLabel = new Label("Input height");
		
		heightInputField = new TextField();
		
		Button submitButton = new Button("Create");
		submitButton.setOnAction(new UserInteraction.canvasSetupSubmitHandler());
		submitButton.setStyle(getButtonStyles());
		
		contentBox.getChildren().add(widthInputLabel);
		contentBox.getChildren().add(widthInputField);
		contentBox.getChildren().add(heightInputLabel);
		contentBox.getChildren().add(heightInputField);
		contentBox.getChildren().add(submitButton);
		root.getChildren().add(contentBox);
	}
	
	private String getRootStyles()
	{
		double paddingVal = 8.0;
		String bgColor = MEDIUM_DARK_COLOR;
		return String.join("\n", new String[] {
			String.format("-fx-padding: %f;", paddingVal),
			String.format("-fx-alignment: %s;", "center"),
			String.format("-fx-background-color: %s;", bgColor)
		});
	}
	
	private String getContentStyles()
	{
		double paddingVal = 3.0;
		String bgColor = MEDIUM_LIGHT_COLOR;
		return String.join("\n", new String[] {
			String.format("-fx-padding: %f;", paddingVal),
			String.format("-fx-alignment: %s;", "center"),
			String.format("-fx-background-color: %s;", bgColor)
		});
	}
	
	public double[] getInputs()
	{
		double cWidth = 0.0;
		double cHeight = 0.0;
		
		try
		{
			cWidth = Double.parseDouble(widthInputField.getText());
			cHeight = Double.parseDouble(heightInputField.getText());
			return new double[] {cWidth, cHeight};
		} catch (NumberFormatException e) {
			AlertManager.CanvasSizeInputError.show();
			return new double[] {};
		}
	}
	
	public Stage getStage()
	{
		return stage;
	}
}
