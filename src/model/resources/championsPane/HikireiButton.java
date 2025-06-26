package model.resources.championsPane;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.entities.Champion;
import model.entities.Character;
import model.resources.TypeAttacked;

public class HikireiButton extends ChampionButton{

	public HikireiButton(Group root) {
		super(new Image("resources\\heroes\\Hikirei.png"),-50, -20, root);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void clickEvent(MouseEvent e) {
		if(getTarget().contains(e.getX(),e.getY())) {
			ChampionPanel.champions.add(new Champion(new Character(200,100,20,95,75,1000,80,TypeAttacked.MAGICAL,"Hikirei Rellse", getPicture(),-40,0,202.5,360.0)));
		}
	}
}
