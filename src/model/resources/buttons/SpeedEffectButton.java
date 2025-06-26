package model.resources.buttons;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.entities.Champion;
import model.resources.Scenery;
import model.resources.effects.Speed;

public class SpeedEffectButton extends EffectsButtons{

	public SpeedEffectButton() {
		super(new Image("resources\\Effects\\speed.png"));
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
				
				int vdmA = (int) (championReceiver.getVdm() * (0.1 + 0.1 * Math.random()));
				
				int played = (int)(3 * Math.random());
				
				setEffect(new Speed(0,0,0,0,vdmA,0,0,played));
				
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
