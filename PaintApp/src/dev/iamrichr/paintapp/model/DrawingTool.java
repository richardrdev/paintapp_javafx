/*
 * DrawingTool.java
 * 
 * This class provides a generic blueprint for a tool used to interact with the Canvas.
 * Currently, the only child of this class is Brush, so technically this Parent class is unnecessary,
 * but the inclusion of this class would make the implementation of different drawing tools, i.e. an 
 * eraser, a line tool, a spray tool, etc, much simpler.
 * 
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.model;

import java.io.Serializable;

public class DrawingTool implements Serializable
{
	protected static final long serialVersionUID = 8027296683002859438L;
	protected double strokeWidth;
	
	public DrawingTool(double strokeWidth)
	{
		setStrokeWidth(strokeWidth);
	}
	
	public void setStrokeWidth(double strokeWidth)
	{
		this.strokeWidth = strokeWidth;
	}
	
	public double getStrokeWidth()
	{
		return strokeWidth;
	}
	
}
