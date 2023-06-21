/*
 * FilenameInputView.java
 * 
 * This is the window that the user sees when inputting a filename.  This is seen both
 * when entering a filename to save a file to, and also when entering a filename to load from.
 * 
 * Author:  Richard Rickborn
 * 
 */

package dev.iamrichr.paintapp.view.views;

import dev.iamrichr.paintapp.controller.UserInteraction;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FilenameInputView extends View
{
	static public enum FileType {SAVE, LOAD};
	private static final int FILE_INPUT_VIEW_WIDTH = 224;
	private static final int FILE_INPUT_VIEW_HEIGHT = 99;
	private static final String DEFAULT_FILENAME = "drawing.dat";
	private FileType type;
	private TextField input;
	private Stage stage;
	private Button submitBtn;
	
	public FilenameInputView(FileType type)
	{
		super(FILE_INPUT_VIEW_WIDTH, FILE_INPUT_VIEW_HEIGHT);
		this.type = type;
		applyType();
		stage = new Stage();
		stage.setScene(scene);
	}
	
	public Stage getStage()
	{
		return stage;
	}

	public Pane createRoot()
	{
		FlowPane root = new FlowPane(Orientation.VERTICAL);
		root.setVgap(5.0);
		root.setPadding(new Insets(8.0));
		return root;
	}
	
	public void createLayout()
	{
		Label inputLabel = new Label("Enter filename:");
		input = new TextField(DEFAULT_FILENAME);
		submitBtn = new Button();
		
		root.getChildren().add(inputLabel);
		root.getChildren().add(input);
		root.getChildren().add(submitBtn);
	}
	
	private void applyType()
	{
		if(type.equals(FileType.LOAD))
		{
			submitBtn.setText("Load");
			submitBtn.setOnAction(new UserInteraction.submitLoadDrawingFilename());
		} else
		{
			submitBtn.setText("Save");
			submitBtn.setOnAction(new UserInteraction.submitSaveDrawingFilename());
		}
	}

	public String getFilename()
	{
		String inputFileName = input.getText();
		if(inputFileName.equals(""))
		{
			return DEFAULT_FILENAME;
		} else
		{
			return inputFileName;
		}
	}
	
}
