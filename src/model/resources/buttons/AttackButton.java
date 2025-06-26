package model.resources.buttons;

import java.util.List;

import application.Main;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import model.entities.Champion;
import model.resources.Action;
import model.resources.Scenery;

public class AttackButton{
	
	private Group Button;
	private static Canvas canvas;
	private static GraphicsContext gc;
	
	private static Boolean visible;
	
	private static Circle target;

	
	public AttackButton(Group root) {
		visible = true;
		
		Button = new Group();
		canvas = new Canvas(200,200);
		gc = canvas.getGraphicsContext2D();
		
		Button.getChildren().add(canvas);
		
		target = new Circle(0,0,canvas.getWidth());
		
		root.getChildren().add(Button);

		
	}
	
	public static void update(MouseEvent e) {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		if(visible) {
			if(!target.contains(e.getX(), e.getY())) {
				gc.drawImage(new Image("resources\\buttons\\MainButtons\\AttackButton\\Botão de Ataque.png"), 0, 0, canvas.getWidth(), canvas.getHeight());
			}
			else {
				gc.drawImage(new Image("resources\\buttons\\MainButtons\\AttackButton\\Botão de Ataque2.png"), 0, 0, canvas.getWidth(), canvas.getHeight());
			}
		}
	}
	
	public static void clickEvent(MouseEvent e, List<Action> actions,List<Champion> champions) {
		if(visible) {
			if(target.contains(e.getX(), e.getY())) {
				for(Action ac:actions) {
					ac.execute();
				}
			
				Scenery.turnPass();
				
			}
		}
	}
}
