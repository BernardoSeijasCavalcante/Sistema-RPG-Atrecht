package model.resources.buttons;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.entities.Champion;
import model.resources.Scenery;
import model.resources.TypeAttacked;
import model.resources.effects.Desarmed;

public class DesarmedEffectButton extends EffectsButtons{

	public DesarmedEffectButton() {
		super(new Image("resources\\Effects\\desarmed.png"));
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
				
				int strengthA = (int)(championReceiver.getStrength() * (0.3 * Math.random() + 0.2));
				int inteligenceA = (int)(championReceiver.getInteligence() * (0.1));
				
				int played = (int)(100 * Math.random());
				
				if(played < 70) {
					played = (int)(3*Math.random());
				}else {
					played = 0;
				}
				
				if(championReceiver.getType() == TypeAttacked.MAGICAL) {
					int idmA = (int)(championReceiver.getIdm() * (0.5));
					setEffect(new Desarmed(0,0,0,0,0,-idmA,inteligenceA,played));
				}else {
					setEffect(new Desarmed(0,0,-strengthA,0,0,0,inteligenceA,played));
				}
					
				
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
