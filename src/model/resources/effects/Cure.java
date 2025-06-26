package model.resources.effects;

import javafx.scene.image.Image;
import model.resources.Effects;

public class Cure extends Effects{
	
	public Cure(int lifeA, int resilienceA, int strengthA, int defenseA, int vdmA, int idmA, int inteligenceA,
			int duration) {
		super(lifeA, resilienceA, strengthA, defenseA, vdmA, idmA, inteligenceA, duration);
		setPicture(new Image("resources\\Effects\\cure.png"));
	}

	public Cure() {
		
	}
	
}
