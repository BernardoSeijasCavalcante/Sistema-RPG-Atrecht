package model.resources.championsPane;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.entities.Champion;
import model.entities.Character;
import model.resources.TypeAttacked;

public class ShonButton extends ChampionButton{

	public ShonButton(Group root) {
		super(new Image("resources\\heroes\\Shon.png"),-50, -20, root);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void clickEvent(MouseEvent e) {
		if(getTarget().contains(e.getX(),e.getY())) {
			ChampionPanel.champions.add(new Champion(new Character(200,100,100,50,60,0,185,TypeAttacked.ATTACKER,"Shon Mágnes", getPicture(),-35,0,202.5,370.0)));
		}
	}
}
