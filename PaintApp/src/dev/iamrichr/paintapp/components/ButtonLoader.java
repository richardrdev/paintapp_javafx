/*
 * ButtonLoader.java
 * 
 * This class holds the functionality to generate lists of two different types of buttons
 * used in the DrawView UI.  These lists are generated from data found in text files.
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.components;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import dev.iamrichr.paintapp.controller.AlertManager;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class ButtonLoader
{
	
	public static List<Node> getNodeListFromFile(Class<? extends DrawViewButton> btnType, String dataFileURL)
	{
		return createList(btnType, dataFileURL);
	}
	
	private static List<Node> createList(Class<? extends DrawViewButton> btnType, String dataFileURL)
	{
		List<Node> nodes = new ArrayList<Node>();
		
		List<String> records = loadToolButtonInfo(dataFileURL);
		
		Label containerLabel = new Label(records.remove(0));
		
		nodes.add(containerLabel);
		
		List<DrawViewButton> btns = createButtonsFromList(records, btnType);
		
		for(DrawViewButton btn : btns)
		{
			nodes.add(btn.getButton());
		}
		
		return nodes;
	}
	
	private static List<String> loadToolButtonInfo(String dataFileURL)
	{
		try
		{
			List<String> records = Files.readAllLines(Paths.get(dataFileURL));
			return records;
		} catch(IOException e)
		{
			AlertManager.ResourceLoadFailure_UI.show(dataFileURL);
			return new ArrayList<String>();
		}
	}
	
	private static List<DrawViewButton> createButtonsFromList(List<String> records, Class<? extends DrawViewButton> btnType)
	{
		List<DrawViewButton> btns = new ArrayList<DrawViewButton>();
		
		for(String record : records)
		{
			try
			{
				DrawViewButton newButton = btnType.getDeclaredConstructor(String.class).newInstance(record);
				btns.add(newButton);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e)
			{
				AlertManager.ResourceLoadFailure_UI.show();
			}
		}
		
		return btns;
	}
}
