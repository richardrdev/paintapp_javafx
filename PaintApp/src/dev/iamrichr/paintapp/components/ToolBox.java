/*
 * ToolBox.java
 * 
 * This class represents the panel used in the DrawView UI to allow for drawing tool selection.
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.components;

import java.util.List;

import dev.iamrichr.paintapp.controller.UserInteraction;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ToolBox
{
	private VBox box;
	
	public ToolBox(List<Node> toolList)
	{
		box = new VBox();
		box.setPadding(new Insets(8.0));
		box.setSpacing(5.0);
		
		for(Node node : toolList)
		{
			box.getChildren().add(node);
			if(node.getClass() == Button.class)
			{
				((Button) node).setOnAction(new UserInteraction.toolButtonHandler());
			}
		}
	}

	public VBox getBox()
	{
		return box;
	}
	
}
