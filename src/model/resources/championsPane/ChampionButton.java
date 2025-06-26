package model.resources.championsPane;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChampionButton {
	
	private Group button;
	private Canvas canvas;
	private GraphicsContext gc;
	
	private Image picture;
	private Integer offsetX;
	private Integer offsetY;
	
	private Rectangle target;
	
	public ChampionButton(Image picture,Integer offsetX, Integer offsetY,Group root) {
		this.picture = picture;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		
		canvas = new Canvas(50,100);
		gc = canvas.getGraphicsContext2D();
		
		button = new Group();
		button.getChildren().add(canvas);
		
		target = new Rectangle(button.getTranslateX(), button.getTranslateY(),canvas.getWidth(),canvas.getHeight());
		
		root.getChildren().add(button);
	}
	
	
	
	public Group getButton() {
		return button;
	}



	public void setButton(Group button) {
		this.button = button;
	}



	public Rectangle getTarget() {
		return target;
	}



	public void setTarget(Rectangle target) {
		this.target = target;
	}



	public Image getPicture() {
		return picture;
	}



	public void setPicture(Image picture) {
		this.picture = picture;
	}



	public void update(MouseEvent e) {
		gc.drawImage(picture, offsetX, offsetY,canvas.getWidth()*3,canvas.getHeight()*3);
		target = new Rectangle(button.getTranslateX(), button.getTranslateY(),canvas.getWidth(),canvas.getHeight());
		
		if(target.contains(e.getX(),e.getY())) {
			gc.setStroke(Color.YELLOW);
		}else {
			gc.setStroke(Color.BLACK);
		}
		gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	public void clickEvent(MouseEvent e) {
		if(target.contains(e.getX(),e.getY())) {
			System.out.println("Click");
		}
	}
}
