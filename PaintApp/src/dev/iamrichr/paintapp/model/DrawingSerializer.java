/*
 * DrawingSerializer.java
 * 
 * This class provides the functionality to save and load Drawing Objects
 * to and from a file.  Exception handling is provided.
 * 
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dev.iamrichr.paintapp.controller.AlertManager;

public class DrawingSerializer
{
	public static void saveDrawingToFile(String saveFilename, Drawing drawingToSave)
	{
		try
		{
			FileOutputStream writeFile = new FileOutputStream(saveFilename);
			ObjectOutputStream byteStream = new ObjectOutputStream(writeFile);
			
			byteStream.writeObject(drawingToSave);
			
			byteStream.close();
			writeFile.close();
			
		} catch (FileNotFoundException e)
		{
			AlertManager.FileNotFoundAlert.show(saveFilename);
		} catch (IOException e)
		{
			AlertManager.SaveFileFailureAlert.show();
		}
		
	}
	
	public static Drawing loadDrawingFromFile(String loadFilename)
	{
		try
		{
			FileInputStream loadFile = new FileInputStream(loadFilename);
			ObjectInputStream byteStream = new ObjectInputStream(loadFile);
			
			Drawing loadedDrawing = (Drawing) byteStream.readObject();
			
			byteStream.close();
			loadFile.close();
			
			return loadedDrawing;
		} catch (FileNotFoundException e)
		{
			return null;
		} catch (IOException e)
		{
			return null;
		} catch (ClassNotFoundException e)
		{
			return null;
		}
		
	}
	
}
