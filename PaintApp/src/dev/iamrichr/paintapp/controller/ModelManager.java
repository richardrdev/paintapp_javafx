/*
 * ModelManager.java
 * 
 * This class manages functionality between the various members of the model package,
 * and handles communication between those objects and the View, through the ViewManager.
 * 
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.controller;

import java.util.ArrayList;
import java.util.List;

import dev.iamrichr.paintapp.model.Brush;
import dev.iamrichr.paintapp.model.Drawing;
import dev.iamrichr.paintapp.model.DrawingSerializer;
import dev.iamrichr.paintapp.model.DrawingTool;
import dev.iamrichr.paintapp.model.Gesture;
import dev.iamrichr.paintapp.model.Interaction;
import dev.iamrichr.paintapp.model.Palette;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ModelManager
{
	private Gesture currentGesture;
	private DrawingTool activeTool;
	private Palette colors;
	private ViewManager view;
	private List<Gesture> history;

	public ModelManager()
	{
	}
	
	public void setViewManager(ViewManager view)
	{
		this.view = view;
	}

	public DrawingTool getActiveTool()
	{
		return activeTool;
	}

	public void setActiveTool(DrawingTool activeTool)
	{
		this.activeTool = activeTool;
	}
	
	public void setActiveTool(String toolStr)
	{
		activeTool = new Brush(toolStr);
	}
	
	public void changeColors(String colorStr)
	{
		colors.setPrimary(Color.web(colorStr.split(";")[0].split(": ")[1]));
	}
	
	public void setupDrawing()
	{
		activeTool = new Brush("Pencil");
		colors = new Palette();
		history = new ArrayList<Gesture>();
	}
	
	public void closeDrawing()
	{
		activeTool = null;
		colors = null;
		history = null;
	}
	
	public void setHistory(List<Gesture> history)
	{
		this.history = history;
	}

	public void handleMouseInteraction(MouseEvent event)
	{
		EventType<? extends MouseEvent> type = event.getEventType();
		Interaction currentInteraction = new Interaction(event);
		double x = event.getX();
		double y = event.getY();
		if(currentGesture == null)
		{
			if(type == MouseEvent.MOUSE_PRESSED)
			{
				currentGesture = new Gesture(activeTool, colors.getPrimary().toString(), currentInteraction);
				view.beginStroke(colors.getPrimary(), activeTool.getStrokeWidth(), x, y);
			}
		} else if(type == MouseEvent.MOUSE_DRAGGED)
		{
			currentGesture.addInteraction(currentInteraction);
			view.stroke(x, y);
		} else if(type == MouseEvent.MOUSE_RELEASED)
		{
			currentGesture.endGesture(currentInteraction);
			view.endStroke(x, y);
			history.add(currentGesture);
			currentGesture = null;
		}
		
	}

	public void saveDrawingToFile(String saveFilename, double[] canvasDimensions)
	{
		Drawing drawingToSave = new Drawing(history, canvasDimensions);
		DrawingSerializer.saveDrawingToFile(saveFilename, drawingToSave);
	}

	public void loadDrawingFromFile(String filename)
	{
		Drawing loadedDrawing = DrawingSerializer.loadDrawingFromFile(filename);
		if(loadedDrawing != null)
		{
			loadDrawing(loadedDrawing);
		} else
		{
			AlertManager.LoadFailureAlert.show();
		}
	}
	
	private void loadDrawing(Drawing loadedDrawing)
	{
		List<Gesture> history = loadedDrawing.getHistory();
		double[] dimensions = loadedDrawing.getDimensions();
		
		setupDrawing();
		setHistory(history);
		view.showDrawingView(dimensions);
		
		for(Gesture gesture : history)
		{
			Color color = Color.web(gesture.getColorUsed());
			double strokeWidth = gesture.getToolUsed().getStrokeWidth();
			List<Interaction> interactionList = gesture.getGesture();
			double[][] points = new double[interactionList.size()][2];
			
			for(Interaction interaction : interactionList)
			{
				int currentIndex = interactionList.indexOf(interaction);
				points[currentIndex][0] = interaction.getX();
				points[currentIndex][1] = interaction.getY();
			}
			
			view.renderStroke(color, strokeWidth, points);
		}
	}
}
