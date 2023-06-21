/*
 * DrawingView.java
 * 
 * This is the main window of the application.  The drawing canvas is held here, and the buttons on
 * the left and the right communicate with the model (through the controller) to update the color palette
 * and the drawing tool currently in use.  The user can also save a drawing through this window.
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.view.views;

import dev.iamrichr.paintapp.components.ButtonLoader;
import dev.iamrichr.paintapp.components.ColorBox;
import dev.iamrichr.paintapp.components.ColorButton;
import dev.iamrichr.paintapp.components.ToolBox;
import dev.iamrichr.paintapp.components.ToolButton;
import dev.iamrichr.paintapp.controller.UserInteraction;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class DrawingView extends View
{
	private static final int DRAW_VIEW_WIDTH = 800;
	private static final int DRAW_VIEW_HEIGHT = 600;
	private static final String toolDataURL = "data/ToolButtons.dat";
	private static final String colorDataURL = "data/ColorButtons.dat";
	
	public DrawingView(Canvas canvas)
	{
		super(DRAW_VIEW_WIDTH, DRAW_VIEW_HEIGHT);
		((BorderPane)root).setCenter(canvas);
	}
	
	protected BorderPane createRoot()
	{
		BorderPane root = new BorderPane();
		return root;
	}
	
	protected void createLayout()
	{
		BorderPane bPane = ((BorderPane) root);
		ToolBox toolBox = new ToolBox(ButtonLoader.getNodeListFromFile(ToolButton.class, toolDataURL));
		bPane.setLeft(toolBox.getBox());
		ColorBox colorBox = new ColorBox(ButtonLoader.getNodeListFromFile(ColorButton.class, colorDataURL));
		bPane.setRight(colorBox.getBox());
		
		
		bPane.setBottom(createBottomPanel());
	}
	
	protected HBox createBottomPanel()
	{
		HBox bottomPanel = new HBox();
		
		bottomPanel.setSpacing(15.0);
		bottomPanel.setPadding(new Insets(20.0));
		
		Button saveBtn = new Button("Save");
		Button closeBtn = new Button("Close");
		
		saveBtn.setOnAction(new UserInteraction.saveDrawingButtonHandler());
		closeBtn.setOnAction(new UserInteraction.closeDrawingButtonHandler());
		
		bottomPanel.getChildren().add(saveBtn);
		bottomPanel.getChildren().add(closeBtn);
		
		return bottomPanel;
	}

}
