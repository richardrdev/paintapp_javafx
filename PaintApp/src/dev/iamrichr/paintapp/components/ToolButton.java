/*
 * ToolButton.java
 * 
 * This class represents a button used for drawing tool selection in the ColorBox panel.
 * Kept as it's own class mainly for organizing style code.
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.components;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import dev.iamrichr.paintapp.controller.AlertManager;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ToolButton extends DrawViewButton
{
	private Image icon;
	private ImageView iconView;
	
	public ToolButton(String record)
	{
		super(record);
		
		FileInputStream imgStream = null;
		
		String imageURL = initData[1];
		
		try
		{
			imgStream = new FileInputStream(imageURL);
			icon = new Image(imgStream);
			iconView = new ImageView(icon);
			button = new Button(btnText, iconView);
		} catch (FileNotFoundException e)
		{
			AlertManager.ResourceLoadFailure_UI.show(imageURL);
			button = new Button(btnText);
		}
		
	}


	
	
}
