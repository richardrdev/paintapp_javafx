/*
 * PaintApp.java
 * 
 * This is the main controller for the app.  Functions as a Singleton, 
 * the main function of this class is to perform the initial startup of the app,
 * and then pass control over to the View and Model controllers
 * 
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.controller;

import javafx.stage.Stage;

public class PaintApp
{
	private static PaintApp instance;
	private ViewManager view;
	private ModelManager model;
	
	private PaintApp()
	{
		view = new ViewManager();
		model = new ModelManager();
		model.setViewManager(view);
	}
	
	public static PaintApp getInstance()
	{
		if(instance == null)
		{
			instance = new PaintApp();
		}
		return instance;
	}
	
	public void start(Stage stage)
	{
		view.setStage(stage);
		view.showStartView();
	}
	
	public ViewManager getViewManager()
	{
		return view;
	}
	
	public ModelManager getModelManager()
	{
		return model;
	}

}
