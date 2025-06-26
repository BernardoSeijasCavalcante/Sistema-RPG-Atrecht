package model.resources.championsPane;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.entities.Champion;
import model.entities.Character;
import model.resources.TypeAttacked;

public class SalazarButton extends ChampionButton{

	public SalazarButton(Group root) {
		super(new Image("resources\\enemies\\Salazar.png"),-50, -20, root);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void clickEvent(MouseEvent e) {
		if(getTarget().contains(e.getX(),e.getY())) {
			ChampionPanel.champions.add(new Champion(new Character(200,100,100,70,75,0,130,TypeAttacked.ATTACKER,"Salazar", getPicture(),-25,-30,202.5,337.5)));
		}
	}
}
