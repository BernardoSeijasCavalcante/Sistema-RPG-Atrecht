package model.resources.buttons;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.entities.Champion;
import model.resources.Scenery;
import model.resources.effects.Blood;

public class BloodEffectButton extends EffectsButtons{

	public BloodEffectButton() {
		super(new Image("resources\\Effects\\Gota de Sangue.png"));
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
				
				int damage = (int)((strength / 10 + (idm/strength) / 10) * (Math.random()));
				int strengthA = (int)(championReceiver.getStrength()/20 + strength/20);
				int defenseA = (int)(championReceiver.getDefense()/10);
				
				int played = (int) (100 *Math.random());
				
				if(played < 50) {
					played = (int)(3*Math.random());
				}else {
					played = 0;
				}
				
				setEffect(new Blood(-damage,0,-strengthA,-defenseA,0,0,0,played));
				
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
