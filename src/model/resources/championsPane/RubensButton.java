package model.resources.championsPane;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.entities.Champion;
import model.entities.Character;
import model.resources.TypeAttacked;

public class RubensButton extends ChampionButton{

	public RubensButton(Group root) {
		super(new Image("resources\\heroes\\Rubens.png"),-50, -20, root);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void clickEvent(MouseEvent e) {
		if(getTarget().contains(e.getX(),e.getY())) {
			ChampionPanel.champions.add(new Champion(new Character(200,100,93,41,20,4000,100,TypeAttacked.ATTACKER,"Rubens Noirs", getPicture(),-50,0,270.0,450.0)));
		}
	}
}
