package model.resources.effects;

import javafx.scene.image.Image;
import model.resources.Effects;

public class Poison extends Effects{
	
	public Poison(int lifeA, int resilienceA, int strengthA, int defenseA, int vdmA, int idmA, int inteligenceA,
			int duration) {
		super(lifeA, resilienceA, strengthA, defenseA, vdmA, idmA, inteligenceA, duration);
		setPicture(new Image("resources\\Effects\\poison.png"));
	}

	public Poison() {
		
	}
	
}
