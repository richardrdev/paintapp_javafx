/*
 * Interaction.java
 * 
 * This class represents a single Mouse interaction with the canvas, at a specific location.
 * A list of these interactions can represent a full gesture
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.model;

import java.io.Serializable;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public class Interaction implements Serializable
{
	private static final long serialVersionUID = 3217276951246797428L;
	private EventType<? extends MouseEvent> type;
	private double x;
	private double y;
	
	public Interaction(MouseEvent event)
	{
		type = event.getEventType();
		x = event.getX();
		y = event.getY();
	}

	public EventType<? extends MouseEvent> getType()
	{
		return type;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public String toString()
	{
		return String.format("%s at (%f, %f) with %s", type.toString(), x, y);
	}
	
}
