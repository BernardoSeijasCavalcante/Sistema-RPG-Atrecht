package model.resources.buttons;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.entities.Champion;
import model.resources.Scenery;
import model.resources.effects.Blindness;

public class BlindnessEffectButton extends EffectsButtons{

	public BlindnessEffectButton() {
		super(new Image("resources\\Effects\\olho.png"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void clickEvent(MouseEvent e) {
		if(getTarget().contains(e.getX(), e.getY())) {
			if(!isActivity()) {
				Champion championSender = getAction().getSender();
				Champion championReceiver = getAction().getReceiver();
				
				int strength = championSender.getStrength() + getAction().getStrengthAffected();
				int defense = championSender.getDefense() + getAction().getDefenseAffected();
				int vdm = championSender.getVdm() + getAction().getVdmAffected();
				int idm = championSender.getIdm() + getAction().getIdmAffected();
				int inteligence = championSender.getInteligence() + getAction().getInteligenceAffected();
				
				int vdmA = (int)(championReceiver.getVdm() * (0.2 * Math.random() + 0.2));
				
				
				int played = (int)(100 * Math.random());
				
				if(played < 50) {
					played = (int)(3*Math.random());
				}else {
					played = 0;
				}
				
				setEffect(new Blindness(0,0,0,0,-vdmA,0,0,played));
				
				if(getButton().getParent().getTranslateX() > 1000) {
					Scenery.table.addEffect(getEffect());
				}else {
					Scenery.tableTurn.addEffect(getEffect());
				}
				setActivity(true);
			}else {
				if(getButton().getParent().getTranslateX() > 1000) {
					Scenery.table.removeEffect(getEffect());
				}else {
					Scenery.tableTurn.removeEffect(getEffect());
				}				
				setActivity(false);
			}
			
		}
	}

}
