package model.resources.buttons;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.resources.Action;
import model.resources.Effects;
import model.resources.Table;
import model.resources.TableTurn;

public class EffectsButtons {
	private Group button;
	private Canvas canvas;
	private GraphicsContext gc;
	
	private Circle target;
	private Image picture;
	
	private boolean activity = false;
	
	private Effects effect;
	
	private Action action;
	
	public EffectsButtons(Image picture) {
		this.picture = picture;
		
		button = new Group();
		canvas = new Canvas(100,100);
		gc = canvas.getGraphicsContext2D();
		
		button.getChildren().add(canvas);
		
	}
	
	public Group getButton() {
		return button;
	}



	public void setButton(Group button) {
		this.button = button;
	}

	public Circle getTarget() {
		return target;
	}

	public void setTarget(Circle target) {
		this.target = target;
	}
	
	public boolean isActivity() {
		return activity;
	}

	public void setActivity(boolean activity) {
		this.activity = activity;
	}
	
	

	public Effects getEffect() {
		return effect;
	}

	public void setEffect(Effects effect) {
		this.effect = effect;
	}
	
	

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public void update(MouseEvent e) {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		target = new Circle(button.getTranslateX() + Table.positionX + canvas.getWidth()/2, button.getTranslateY() + canvas.getWidth()/2,canvas.getWidth()/2.5);
		
		if(button.getParent().getTranslateX() > 1000) {
			target = new Circle(button.getTranslateX() + Table.positionX + canvas.getWidth()/2, button.getTranslateY() + canvas.getWidth()/2,canvas.getWidth()/2.5);
		}else {
			target = new Circle(button.getTranslateX() + TableTurn.positionX + canvas.getWidth()/2, button.getTranslateY() + canvas.getWidth()/2,canvas.getWidth()/2.5);
		}
		
		if(target.contains(e.getX(),e.getY()) || activity) {
			gc.setFill(Color.YELLOW);
			gc.setStroke(Color.WHITE);
			
			gc.setGlobalAlpha(0.5);
			gc.fillOval(0, 0, canvas.getWidth(), canvas.getHeight());
			gc.strokeOval(0, 0, canvas.getWidth(), canvas.getHeight());
			gc.setGlobalAlpha(1);
		}
		
		gc.drawImage(new Image("resources\\buttons\\EffectsButtons\\EmblemaChamas3.png"), 0, 0,canvas.getWidth(),canvas.getHeight());
		gc.drawImage(picture, 0, 0,canvas.getWidth(),canvas.getHeight());
		
	}
	
	public void clickEvent(MouseEvent e) {
		if(target.contains(e.getX(), e.getY())) {
			System.out.println("Click");
		}
	}
}
