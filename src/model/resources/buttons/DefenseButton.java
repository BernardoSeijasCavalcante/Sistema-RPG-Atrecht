package model.resources.buttons;

import java.util.List;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import model.entities.Champion;
import model.resources.Action;
import model.resources.Effects;
import model.resources.Scenery;
import model.resources.effects.CureResilience;
import model.resources.effects.Defense;

public class DefenseButton{
	private Group Button;
	private static Canvas canvas;
	private static GraphicsContext gc;
	
	private static Boolean visible;
	
	private static Circle target;
	
	public DefenseButton(Group root) {
		visible = true;
		
		Button = new Group();
		canvas = new Canvas(200,200);
		gc = canvas.getGraphicsContext2D();
		
		Button.getChildren().add(canvas);
		
		target = new Circle(100,300,canvas.getWidth()/2.5);
				
		Button.setTranslateY(200);
		
		root.getChildren().add(Button);
	}
	
	public static void update(MouseEvent e) {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		if(visible) {
			if(!target.contains(e.getX(), e.getY())) {
				gc.drawImage(new Image("resources\\buttons\\MainButtons\\DefenseButton\\Botão de Defesa.png"), 0, 0, canvas.getWidth(), canvas.getHeight());
			}
			else {
				gc.drawImage(new Image("resources\\buttons\\MainButtons\\DefenseButton\\Botão de Defesa2.png"), 0, 0, canvas.getWidth(), canvas.getHeight());
			}
		}
	}
	
	public static void clickEvent(MouseEvent e, List<Action> actions,List<Champion> champions) {
		if(visible) {
			if(target.contains(e.getX(), e.getY())) {
				for(Action ac:actions) {
					ac.execute();
				}
				boolean defended = false;
				for(Effects ef : champions.get(Scenery.turn).getEffects()) {
					if(ef.getClass() == new Defense().getClass()) {
						defended = true;
					}
				}
				if(defended == false) {
					champions.get(Scenery.turn).addEffect(new Defense(0,0,0,(int)(champions.get(Scenery.turn).getDefense()*0.25),0,0,0,1));
					champions.get(Scenery.turn).addEffect(new CureResilience(0,(int)(champions.get(Scenery.turn).getCharacter().getResilience() * 0.1),0,0,0,0,0,1));
					Scenery.turnPass(true);
				}
			}
		}
	}
}
