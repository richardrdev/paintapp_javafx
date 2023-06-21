/*
 * Palette.java
 * 
 * This class represents a simple two-tone color palette.  Currently only the primary color
 * is in use so the secondary has been commented out.
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.model;

import javafx.scene.paint.Color;

public class Palette
{
	private Color primary;
	//private Color secondary;
	
	public Palette()
	{
		primary = Color.BLACK;
		//secondary = Color.WHITE;
	}

	public Palette(Color primary, Color secondary)
	{
		this.primary = primary;
		//this.secondary = secondary;
	}
	
	public Color getPrimary()
	{
		return primary;
	}

	public void setPrimary(Color primary)
	{
		this.primary = primary;
	}

	/*public Color getSecondary()
	{
		return secondary;
	}*/

	/*public void setSecondary(Color secondary)
	{
		this.secondary = secondary;
	}*/
	
	
}
