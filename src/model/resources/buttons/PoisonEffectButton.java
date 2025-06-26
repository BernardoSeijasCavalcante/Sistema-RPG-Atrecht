package model.resources.buttons;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.entities.Champion;
import model.resources.Scenery;
import model.resources.effects.Poison;

public class PoisonEffectButton extends EffectsButtons{

	public PoisonEffectButton() {
		super(new Image("resources\\Effects\\poison.png"));
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
				
				int life = (int)(championReceiver.getCharacter().getLife() * 0.1);
				int vdmA = (int)(championReceiver.getVdm() * (0.1));
				int resilience = (int)(championReceiver.getCharacter().getResilience() * (0.05));
				
				int played = (int)(100 * Math.random());
				
				if(played < 80) {
					played = (int)(4*Math.random());
				}else {
					played = 0;
				}
				
				setEffect(new Poison(-life,-resilience,0,0,-vdmA,0,0,played));
				
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
