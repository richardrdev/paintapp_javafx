/*
 * DrawViewButton.java
 * 
 * This is the parent class for the ToolButton and ColorButton classes.
 * Both classes function similarly and are similarly loaded from text files,
 * so they share behavior through this parent.  In a future, more complex version
 * of this app, this job might be better suited to an interface, but for now this is
 * how it works.
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.components;

import javafx.scene.control.Button;

public class DrawViewButton
{
	protected String[] initData;
	protected String btnText;
	protected Button button;
	
	public DrawViewButton(String record)
	{
		this.initData = record.split(",");
		btnText = initData[0];
	}
	
	public Button getButton()
	{
		return button;
	}
}
