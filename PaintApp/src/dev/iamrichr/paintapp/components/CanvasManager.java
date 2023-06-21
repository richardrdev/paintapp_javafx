/*
 * CanvasManager.java
 * 
 * This class holds the data and functionality needed for the UI to generate
 * and draw to the drawing canvas.
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.components;

import dev.iamrichr.paintapp.controller.UserInteraction;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class CanvasManager
{
	private static final double DEFAULT_CANVAS_WIDTH = 400.0;
	private static final double DEFAULT_CANVAS_HEIGHT = 300.0;
	private Canvas canvas;
	private GraphicsContext context;
	
	public CanvasManager(double[] canvasDimensions)
	{
		if(canvasDimensions.length == 0)
		{
			canvasDimensions = getDefaultCanvasSize();
		}
		
		double cWidth = canvasDimensions[0];
		double cHeight = canvasDimensions[1];
		canvas = new Canvas(cWidth, cHeight);
		context = canvas.getGraphicsContext2D();
		clearCanvas();
		canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new UserInteraction.MouseHandler());
		canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, new UserInteraction.MouseHandler());
		canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, new UserInteraction.MouseHandler());
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}

	private double[] getDefaultCanvasSize()
	{
		return new double[] {DEFAULT_CANVAS_WIDTH, DEFAULT_CANVAS_HEIGHT};
	}
	
	public void beginStroke(Color color, double strokeWidth, double x, double y)
	{
		context.setStroke(color);
		context.setLineWidth(strokeWidth);
		context.beginPath();
		context.moveTo(x,y);
		context.stroke();
	}
	
	public void stroke(double x, double y)
	{
		context.lineTo(x, y);
		context.stroke();
	}
	
	public void endStroke(double x, double y)
	{
		stroke(x,y);
		context.closePath();
	}
	
	public void fullStroke(Color color, double strokeWidth, double[][] points)
	{
		beginStroke(color, strokeWidth, points[0][0], points[0][1]);
		for(int i = 1; i < points.length-1; i++)
		{
			stroke(points[i][0], points[i][1]);
		}
		endStroke(points[points.length-1][0], points[points.length-1][1]);
	}
	
	public void clearCanvas()
	{
		context.setFill(Color.WHITE);
		context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
}
