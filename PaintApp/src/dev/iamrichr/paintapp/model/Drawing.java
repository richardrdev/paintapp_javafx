/*
 * Drawing.java
 * 
 * This class acts as a wrapper for all the data needed to save a particular drawing to
 * file.
 * 
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.model;

import java.io.Serializable;
import java.util.List;

public class Drawing implements Serializable
{
	private static final long serialVersionUID = -9108508530770028361L;
	private List<Gesture> history;
	private double[] dimensions;
	
	public Drawing(List<Gesture> history, double[] dimensions)
	{
		this.history = history;
		this.dimensions = dimensions;
	}

	public List<Gesture> getHistory()
	{
		return history;
	}

	public double[] getDimensions()
	{
		return dimensions;
	}

}
