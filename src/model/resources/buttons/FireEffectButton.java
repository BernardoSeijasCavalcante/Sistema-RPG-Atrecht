package model.resources.buttons;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.entities.Champion;
import model.resources.Scenery;
import model.resources.effects.Fire;

public class FireEffectButton extends EffectsButtons{

	public FireEffectButton() {
		super(new Image("resources\\Effects\\fogo.png"));
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
				int defenseA = (int)(championReceiver.getDefense()/10);
				
				int played = (int) (100 *Math.random());
				
				if(played < 50) {
					played = (int)(3*Math.random()) + 1;
				}else {
					played = 0;
				}
				
				System.out.println("aaa" + played);
				
				setEffect(new Fire(-damage,0,0,-defenseA,0,0,0,played));
				
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
