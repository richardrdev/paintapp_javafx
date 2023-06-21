/*
 * StartView.java
 * 
 * This is the first view the user sees upon starting the app.  Contains nothing but two buttons,
 * one for creating a new drawing, and one for loading an existing drawing from a file.  User will
 * be returned to this view upon closing a drawing.
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.view.views;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import dev.iamrichr.paintapp.controller.UserInteraction;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class StartView extends View
{
	private static final double START_VIEW_WIDTH = 256.0;
	private static final double START_VIEW_HEIGHT = 72.0;
	//private static final String stylesheetPath = "StartView.css";
	
	public StartView()
	{
		super(START_VIEW_WIDTH, START_VIEW_HEIGHT);
		/*double verticalPadding = START_VIEW_HEIGHT/4.0;
		double horizontalPadding = START_VIEW_WIDTH/4.0;
		String rootStyle = String.format("-fx-padding: %f, %f, %f, %f", 
				verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
		root.setStyle(rootStyle);*/
		//scene.getStylesheets().add(stylesheetPath);
	}
	
	protected FlowPane createRoot()
	{
		FlowPane root = new FlowPane(Orientation.VERTICAL);
		root.setStyle(getRootStyles());
		return root;
	}
	
	protected void createLayout()
	{
		
		HBox btnBox = new HBox();
		btnBox.setSpacing(5.0);
		
		Button newDrawingBtn = new Button("New Drawing");
		Button loadBtn = new Button("Load Drawing");
		
		newDrawingBtn.setOnAction(new UserInteraction.newDrawingButtonHandler());
		newDrawingBtn.setStyle(getButtonStyles());
		//newDrawingBtn.setId("newDrawingBtn");
		//System.out.println(newDrawingBtn.getStyleClass());
		//newDrawingBtn.getStyleClass().add("test-stylel");
		loadBtn.setOnAction(new UserInteraction.loadDrawingButtonHandler());
		loadBtn.setStyle(getButtonStyles());
		//loadBtn.setId("loadBtn");
		
		btnBox.getChildren().add(newDrawingBtn);
		btnBox.getChildren().add(loadBtn);
		
		btnBox.setAlignment(Pos.CENTER);
		root.getChildren().add(btnBox);
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


	
}
