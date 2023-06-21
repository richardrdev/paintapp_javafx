/*
 * Brush.java
 * 
 * This class provides the functionality for all Brush-type drawing tools.  This includes
 * any tool that is used to click-and-drag to make simple line strokes across the canvas.
 * The current brushes available are Pencil, and Small/Medium/Large brushes.  These brushes
 * are auto-generated from the ToolButtons.dat file, so inclusion of another differently-sized
 * brush would be relatively simple
 * 
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.model;

public class Brush extends DrawingTool
{
	private static final long serialVersionUID = 8073611264870216757L;
	private static final double PENCIL_STROKE_WIDTH = 1.0;
	private static final double BRUSH_SMALL_STROKE_WIDTH = 3.5;
	private static final double BRUSH_MEDIUM_STROKE_WIDTH = 5.0;
	private static final double BRUSH_LARGE_STROKE_WIDTH = 8.0;
	
	public Brush(double strokeWidth)
	{
		super(strokeWidth);
	}
	
	public Brush(String brushType)
	{
		super(strokeWidthByType(brushType));
	}
	
	private static double strokeWidthByType(String brushType)
	{
		double newWidth = 1.0;
		
		switch(brushType)
		{
			case("Pencil"):
				newWidth = PENCIL_STROKE_WIDTH;
				break;
			case("Small Brush"):
				newWidth = BRUSH_SMALL_STROKE_WIDTH;
				break;
			case("Medium Brush"):
				newWidth = BRUSH_MEDIUM_STROKE_WIDTH;
				break;
			case("Large Brush"):
				newWidth = BRUSH_LARGE_STROKE_WIDTH;
				break;
			default:
				newWidth = PENCIL_STROKE_WIDTH;
				break;
		}
		
		return newWidth;
	}
	
}
