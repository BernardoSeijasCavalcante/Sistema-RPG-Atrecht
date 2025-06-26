package model.resources.championsPane;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.entities.Champion;
import model.entities.Character;
import model.resources.TypeAttacked;

public class FelixButton extends ChampionButton{

	public FelixButton(Group root) {
		super(new Image("resources\\heroes\\Felix.png"),-50, -20, root);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void clickEvent(MouseEvent e) {
		if(getTarget().contains(e.getX(),e.getY())) {
			ChampionPanel.champions.add(new Champion(new Character(200,100,70,90,85,0,130,TypeAttacked.SHOOTER,"Felix Edgard", getPicture(),-50,0,202.5,337.5)));
		}
	}
}
