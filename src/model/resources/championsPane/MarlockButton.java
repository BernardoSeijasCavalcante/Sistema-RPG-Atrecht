package model.resources.championsPane;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.entities.Champion;
import model.entities.Character;
import model.resources.TypeAttacked;

public class MarlockButton extends ChampionButton{

	public MarlockButton(Group root) {
		super(new Image("resources\\enemies\\Marlock.png"),-50, -20, root);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void clickEvent(MouseEvent e) {
		if(getTarget().contains(e.getX(),e.getY())) {
			ChampionPanel.champions.add(new Champion(new Character(200,100,60,60,90,3000,140,TypeAttacked.MAGICAL,"Marlock", getPicture(),-35,-20,202.75,337.5)));//135,225
		}
	}
}
