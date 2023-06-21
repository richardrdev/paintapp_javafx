/*
 * ViewManager.java
 * 
 * This class manages functionality between the various members of the view packages.
 * 
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.controller;

import dev.iamrichr.paintapp.components.CanvasManager;
import dev.iamrichr.paintapp.view.views.DrawingView;
import dev.iamrichr.paintapp.view.views.FilenameInputView;
import dev.iamrichr.paintapp.view.views.NewDrawingSetupWindow;
import dev.iamrichr.paintapp.view.views.StartView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ViewManager
{
	private Stage stage;
	private StartView startView;
	private NewDrawingSetupWindow setupView;
	private DrawingView drawView;
	private CanvasManager canvasManager;
	private FilenameInputView fileNameInput;

	public ViewManager()
	{
		startView = new StartView();
	}
	
	public void setStage(Stage stage)
	{
		this.stage = stage;
	}
	
	public void showStartView()
	{
		stage.setTitle("Paint App");
		stage.setScene(startView.getScene());
		stage.show();
	}
	
	public void closeDrawing()
	{
		canvasManager = null;
		drawView = null;
	}
	
	public void showNewDrawingSetup()
	{
		setupView = new NewDrawingSetupWindow();
		setupView.getStage().show();
	}
	
	public double[] getSetupInputs()
	{
		return setupView.getInputs();
	}
	
	public void closeSetup()
	{
		setupView.getStage().close();
	}
	
	public void beginStroke(Color color, double strokeWidth, double x, double y)
	{
		canvasManager.beginStroke(color, strokeWidth, x, y);
	}
	
	public void stroke(double x, double y)
	{
		canvasManager.stroke(x, y);
	}
	
	public void endStroke(double x, double y)
	{
		canvasManager.endStroke(x, y);
	}
	
	public void showDrawingView()
	{
		canvasManager = new CanvasManager(getSetupInputs());
		drawView = new DrawingView(canvasManager.getCanvas());
		stage.setScene(drawView.getScene());
		stage.show();
	}
	
	public void showDrawingView(double[] dimensions)
	{
		canvasManager = new CanvasManager(dimensions);
		drawView = new DrawingView(canvasManager.getCanvas());
		stage.setScene(drawView.getScene());
		stage.show();
	}

	public void promptSaveFilename()
	{
		fileNameInput = new FilenameInputView(FilenameInputView.FileType.SAVE);
		fileNameInput.getStage().show();
	}
	
	public void promptLoadFilename()
	{
		fileNameInput = new FilenameInputView(FilenameInputView.FileType.LOAD);
		fileNameInput.getStage().show();
	}

	public String getFilename()
	{
		String saveFilename = fileNameInput.getFilename();
		fileNameInput.getStage().close();
		fileNameInput = null;
		return saveFilename;
	}

	public double[] getCanvasDimensions()
	{
		return new double[] {canvasManager.getCanvas().getWidth(), canvasManager.getCanvas().getHeight()};
	}

	public void renderStroke(Color color, double strokeWidth, double[][] points)
	{
		canvasManager.fullStroke(color, strokeWidth, points);
	}
	
}
