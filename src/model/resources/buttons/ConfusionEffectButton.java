package model.resources.buttons;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.entities.Champion;
import model.resources.Scenery;
import model.resources.effects.Confusion;

public class ConfusionEffectButton extends EffectsButtons{

	public ConfusionEffectButton() {
		super(new Image("resources\\Effects\\confusion.png"));
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
				
				int vdmA = (int)(championReceiver.getVdm() * (0.1 * Math.random()));
				int inteligenceA = (int)(championReceiver.getInteligence() * (0.3 * Math.random()));
				
				int played = (int)(100 * Math.random());
				
				if(played < 80) {
					played = (int)(4*Math.random());
				}else {
					played = 0;
				}
				
				setEffect(new Confusion(0,0,0,0,-vdmA,0,-inteligenceA,played));
				
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
