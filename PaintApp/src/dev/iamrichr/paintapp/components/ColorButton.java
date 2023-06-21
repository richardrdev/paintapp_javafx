/*
 * ColorButton.java
 * 
 * This class represents a button used for color selection in the ColorBox panel.
 * Kept as it's own class mainly for organizing style code.
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.components;

import javafx.scene.control.Button;

public class ColorButton extends DrawViewButton
{
	private String colorCode;
	
	public ColorButton(String record)
	{
		super(record);
		colorCode = initData[1];
		
		button = new Button(btnText);
		button.setStyle(String.format("-fx-background-color: %s;\n",colorCode) + 
				String.format("-fx-text-fill: %s;",colorCode));
	}
}
