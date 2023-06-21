/*
 * UserInteraction.java
 * 
 * This class holds a series of different event handlers that are generated from all over
 * the user interface.  These event handlers are organized into this class for convenience's sake,
 * but all the actual functionality responding to these events takes place in the Model and View controllers.
 * 
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class UserInteraction
{
	private static ViewManager view = PaintApp.getInstance().getViewManager();
	private static ModelManager model = PaintApp.getInstance().getModelManager();
	
	public static class newDrawingButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			model.setupDrawing();
			view.showNewDrawingSetup();
		}
	}
	
	public static class canvasSetupSubmitHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			view.closeSetup();
			view.showDrawingView();
		}
	}
	
	public static class toolButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			model.setActiveTool(((Button)event.getSource()).getText());
		}
	}
	
	public static class colorButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			model.changeColors(((Button)event.getSource()).getStyle());
		}
	}
	
	public static class saveDrawingButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			view.promptSaveFilename();
		}
	}
	
	public static class loadDrawingButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			view.promptLoadFilename();
		}
	}
	
	public static class submitSaveDrawingFilename implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			model.saveDrawingToFile(view.getFilename(), view.getCanvasDimensions());
		}
	}
	
	public static class submitLoadDrawingFilename implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			model.loadDrawingFromFile(view.getFilename());
		}
	}
	
	public static class closeDrawingButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			model.closeDrawing();
			view.closeDrawing();
			view.showStartView();
		}
	}
	
	public static class MouseHandler implements EventHandler<MouseEvent>
	{
		@Override
		public void handle(MouseEvent event)
		{
			if(event.getEventType() == MouseEvent.MOUSE_PRESSED ||
					event.getEventType() == MouseEvent.MOUSE_DRAGGED ||
					event.getEventType() == MouseEvent.MOUSE_RELEASED)
			{
				model.handleMouseInteraction(event);
			}
			
		}
	}

}
