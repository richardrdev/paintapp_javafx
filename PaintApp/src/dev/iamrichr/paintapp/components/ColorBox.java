/*
 * ColorBox.java
 * 
 * This class represents the panel used in the DrawView UI to allow for color selection.
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ColorBox
{
	private GridPane grid;
	private static final int nodesPerRow = 3;
	private static final double prefButtonLength = 1.0;
	
	public ColorBox(List<Node> toolList)
	{
		grid = new GridPane();
		grid.setPadding(new Insets(8.0));
		
		for(int i = 0; i < toolList.size(); i++)
		{
			if(toolList.get(i).getClass() == Button.class)
			{
				Button node = (Button) toolList.get(i);
				grid.add(node, i%3, i/nodesPerRow, 1, 1);
				node.setPrefSize(prefButtonLength, prefButtonLength);
				((Button) node).setOnAction(new UserInteraction.colorButtonHandler());
			}
		}
	}

	public GridPane getBox()
	{
		return grid;
	}
}
