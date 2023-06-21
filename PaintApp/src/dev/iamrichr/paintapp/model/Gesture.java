/*
 * Gesture.java
 * 
 * This class represents a single full stroke across the canvas.  Each gesture holds
 * a list of Interactions, starting with a MOUSE_PRESSED interactions, continuing with
 * a series of MOUSE_DRAGGED interactions, and ending with a MOUSE_RELEASED interaction.
 * This class also holds data on the type of drawing tool and the color used to draw the stroke,
 * for the purposes of redrawing gestures upon loading.
 * 
 * In the future, Gestures could serve as a solid foundation for building undo/redo functionality.
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gesture implements Serializable
{
	
	private static final long serialVersionUID = 5660884774367983910L;
	private List<Interaction> interactions;
	private boolean gestureComplete;
	private DrawingTool toolUsed;
	private String colorUsedHex;
	
	
	public Gesture(DrawingTool toolUsed, String colorUsedHex, Interaction initialPress)
	{
		interactions = new ArrayList<Interaction>();
		interactions.add(initialPress);
		this.toolUsed = toolUsed;
		this.colorUsedHex = colorUsedHex;
		gestureComplete = false;
	}

	public String getColorUsed()
	{
		return colorUsedHex;
	}

	public DrawingTool getToolUsed()
	{
		return toolUsed;
	}

	public List<Interaction> getGesture()
	{
		return Collections.unmodifiableList(interactions);
	}
	
	public void addInteraction(Interaction drag)
	{
		interactions.add(drag);
	}
	
	public void endGesture(Interaction release)
	{
		interactions.add(release);
		gestureComplete = true;
	}

	public boolean isGestureComplete()
	{
		return gestureComplete;
	}
}
