/*
 * View.java
 * 
 * This is the parent class for all UI displays in this app.  Every View is either a scene
 * pushed to the main stage, or a separate window with its own stage.
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.view.views;

import java.util.List;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class View
{
	protected Scene scene;
	protected Pane root;
	private final double VIEW_WIDTH;
	private final double VIEW_HEIGHT;
	protected static final String DARK_COLOR = "#2B303A";
	protected static final String MEDIUM_DARK_COLOR = "#546A76";
	protected static final String MEDIUM_LIGHT_COLOR = "#88A0A8";
	protected static final String LIGHT_COLOR = "#CAD8DE";
	
	public View(double width, double height)
	{
		VIEW_WIDTH = width;
		VIEW_HEIGHT = height;
		root = createRoot();
		createLayout();
		createScene();
	}
	
	protected Pane createRoot()
	{
		Pane root = new Pane();
		return root;
	}
	
	protected void createLayout()
	{	
	}
	
	protected void createScene()
	{
		scene = new Scene(root, VIEW_WIDTH, VIEW_HEIGHT);
	}
	
	protected String getButtonStyles()
	{
		double borderWidth = 0.0;
		String buttonColor = LIGHT_COLOR;
		return String.join("\n", new String[] {
			String.format("-fx-border-width: %f;", borderWidth),
			String.format("-fx-background-color: %s;", buttonColor)
		});
	}
	
	public Scene getScene()
	{
		return scene;
	}
	
}
