package model.resources.championsPane;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.entities.Champion;
import model.entities.Character;
import model.resources.TypeAttacked;

public class LoretoButton extends ChampionButton{

	public LoretoButton(Group root) {
		super(new Image("resources\\heroes\\Loreto.png"),-50, -20, root);
		// TODO Auto-generated constructor stub
	}
	//champions.add(new Champion(new Character(200,100,50,50,50,50,50,TypeAttacked.MAGICAL,"Ruberns Noirs", new Image("resources/heroes/Rubens.png"))));
	@Override
	public void clickEvent(MouseEvent e) {
		if(getTarget().contains(e.getX(),e.getY())) {
			
			ChampionPanel.champions.add(new Champion(new Character(200,100,75,68,125,0,90,TypeAttacked.SHOOTER,"Loreto Woruno", getPicture(),-60,-20,270.0,450.0)));
		}
	}
}
