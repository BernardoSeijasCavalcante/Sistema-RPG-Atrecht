package model.resources.championsPane;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.entities.Champion;
import model.entities.Character;
import model.resources.TypeAttacked;

public class GuardaAnaoButton extends ChampionButton{

	public GuardaAnaoButton(Group root) {
		super(new Image("resources\\enemies\\Soldado Anão 1.png"),-50, -20, root);
		
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public void clickEvent(MouseEvent e) {
		if(getTarget().contains(e.getX(),e.getY())) {
			Integer played = (int) (Math.random() * 2);
			Image image;
			if(played == 1) {
				image = new Image("resources\\enemies\\Soldado Anão 1.png");
			}else {
				image = new Image("resources\\enemies\\Soldado Anão 2.png");	
			}
			ChampionPanel.champions.add(new Champion(new Character(200,100,85,70,70,0,80,TypeAttacked.ATTACKER,"Soldado Anão", image,-35,-20,202.75,337.5)));//135,225
		}
	}
}
