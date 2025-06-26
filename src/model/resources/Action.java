package model.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.entities.Champion;

public class Action {
	private Champion sender;
	private Champion receiver;
	
	List<Effects> effects = new ArrayList<>();
	
	private Group group;
	
	private Canvas canvas;
	private GraphicsContext gc;
	
	private Integer strengthAffected;
	private Integer defenseAffected;
	private Integer vdmAffected;
	private Integer idmAffected;
	private Integer inteligenceAffected;
	
	private Integer chance;
	private Integer resilienceCust;
	
	private Boolean isAttack = true;
	
	private TypeAttacked typeAttack;
	
	private Boolean activity;
	
	public Action(Group root) {
		group = new Group();
				
		canvas = new Canvas(200,100);
		group.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();
		
		setStrengthAffected(0);
		setDefenseAffected(0);
		setVdmAffected(0);
		setIdmAffected(0);
		setInteligenceAffected(0);
		
		setChance(100);
		setResilienceCust(0);
		
		activity = true;
		
		root.getChildren().add(group);
	}
	
	public Action(Champion sender, Champion receiver, List<Effects> effects) {
		this.sender = sender;
		this.receiver = receiver;
		this.effects = effects;
		
		setStrengthAffected(0);
		setDefenseAffected(0);
		setVdmAffected(0);
		setIdmAffected(0);
		setInteligenceAffected(0);
	}

	public Champion getSender() {
		return sender;
	}

	public void setSender(Champion sender) {
		this.sender = sender;
		this.typeAttack = sender.getType();
	}

	public Champion getReceiver() {
		return receiver;
	}

	public void setReceiver(Champion receiver) {
		this.receiver = receiver;
	}

	public List<Effects> getEffects() {
		return effects;
	}

	public void setEffects(List<Effects> effects) {
		this.effects = effects;
	}
	
	public Integer getStrengthAffected() {
		return strengthAffected;
	}

	public void setStrengthAffected(Integer strengthAffected) {
		this.strengthAffected = strengthAffected;
	}

	public Integer getDefenseAffected() {
		return defenseAffected;
	}

	public void setDefenseAffected(Integer defenseAffected) {
		this.defenseAffected = defenseAffected;
	}

	public Integer getVdmAffected() {
		return vdmAffected;
	}

	public void setVdmAffected(Integer vdmAffected) {
		this.vdmAffected = vdmAffected;
	}

	public Integer getIdmAffected() {
		return idmAffected;
	}

	public void setIdmAffected(Integer idmAffected) {
		this.idmAffected = idmAffected;
	}
	
	public Integer getInteligenceAffected() {
		return inteligenceAffected;
	}

	public void setInteligenceAffected(Integer inteligenceAffected) {
		this.inteligenceAffected = inteligenceAffected;
	}
	
	public Integer getChance() {
		return chance;
	}

	public void setChance(Integer chance) {
		this.chance = chance;
	}

	public Integer getResilienceCust() {
		return resilienceCust;
	}

	public void setResilienceCust(Integer resilienceCust) {
		this.resilienceCust = resilienceCust;
	}

	public Boolean getIsAttack() {
		return isAttack;
	}

	public void setIsAttack(Boolean isAttack) {
		this.isAttack = isAttack;
	}

	public TypeAttacked getTypeAttack() {
		return typeAttack;
	}

	public void setTypeAttack(TypeAttacked typeAttack) {
		this.typeAttack = typeAttack;
	}
	
	public Boolean getActivity() {
		return activity;
	}

	public void setActivity(Boolean activity) {
		this.activity = activity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(receiver, sender);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Action other = (Action) obj;
		return Objects.equals(receiver, other.receiver) && Objects.equals(sender, other.sender);
	}

	public void clearArrow() {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		activity = false;
	}
	
	public void updateArrow(Double mouseX, Double mouseY, boolean state) {
		if(activity) {
			
			group.setTranslateX(sender.getChampion().getTranslateX() - canvas.getWidth()/2 + 67);
			group.setTranslateY(sender.getChampion().getTranslateY() - canvas.getHeight()/2 + 112);
			
			canvas.setWidth(Math.sqrt(Math.pow(mouseX - (sender.getChampion().getTranslateX() + 67), 2) + Math.pow(mouseY - (sender.getChampion().getTranslateY() + 112), 2))*2);
			canvas.setHeight(canvas.getWidth()/5);
	
			group.setRotate(Math.toDegrees(Math.atan2(mouseY - (sender.getChampion().getTranslateY() + 112) , mouseX - (sender.getChampion().getTranslateX() + 67))));
			
			
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			
			Image image;
			
			if(state) {
				 image = new Image("resources/arrow/SETA_SEL.png");
			}else {
				 image = new Image("resources/arrow/SETA_DESSEL.png");
			}
			
			gc.drawImage(image, canvas.getWidth()/2, canvas.getHeight()/2 - canvas.getHeight()/4,canvas.getWidth()/2,canvas.getHeight()/2);
			
			Double distance = Math.sqrt(Math.pow(sender.getPositionX()[1] - mouseX,2) + Math.pow(sender.getPositionY()[1] - mouseY,2));
			Double purcentage = 0.0;
			
			if(typeAttack == TypeAttacked.ATTACKER) {
				 purcentage = Math.floor((500/distance)*100);
			}
			if(typeAttack == TypeAttacked.SHOOTER) {
				purcentage = Math.floor((1300/distance)*100);
			}
			if(typeAttack == TypeAttacked.MAGICAL) {
				purcentage = Math.floor((700/distance)*100);
			}
			
			
			gc.setFill(Color.BLACK);
			gc.setFont(Font.font("Times New Roman", FontWeight.BOLD, 48));
			gc.fillText(purcentage.toString() + "%", canvas.getWidth() / 2 + 50, canvas.getHeight()/2 + 15);
		}
		
	}
	
	public void execute() {
		
		clearArrow();
		
		Double played = Math.random() * 100;
		Double distance = Math.sqrt(Math.pow(sender.getPositionX()[1] - receiver.getPositionX()[1],2) + Math.pow(sender.getPositionY()[1] - receiver.getPositionY()[1],2));
		
		Integer attack = sender.getStrength() + strengthAffected;
		Integer defense = sender.getDefense() + defenseAffected;
		Integer vdm = sender.getVdm() + vdmAffected;
		Integer idm = sender.getIdm() + idmAffected;
		Integer inteligence = sender.getInteligence() + inteligenceAffected;
		
		Double pointVdm = vdm * 1.0/receiver.getVdm() * 1.0;
		Double pointInteligence = inteligence * 1.0/receiver.getInteligence() * 1.0;
		
		if(getSender().getResilience()[1] > 0) {
			if(typeAttack == TypeAttacked.ATTACKER) {
				if(played > 100 - ((30 * pointVdm) + (10 * pointInteligence)) * (500/distance) * (getChance()/100)) {
					if(played > 100 - 10 * (500/distance) * pointInteligence * (getChance()/100)) {
						
						Integer lifeAffected = attack - receiver.getDefense() + 10 > 0 ? (int) ((attack - receiver.getDefense() + 10) * (1+0.25 * Math.random()) * (500/distance)) : 0;
						Integer resilienceAffected = (int) ((attack - receiver.getDefense()) * (1+0.25 * Math.random()) * 0.1);
						
						sender.setResilience(sender.getResilience()[1] - getResilienceCust());
						
						sender.setDamageDone(sender.getDamageDone()[1] + lifeAffected);
						receiver.setDefended(receiver.getDefended()[1] + receiver.getDefense());
						receiver.beingAttacked(-lifeAffected, -resilienceAffected, effects);
						Scenery.textPlayed("Acerto Crítico!",true);
						System.out.println("Acerto Crítico!");
						
					}else {
						Integer lifeAffected = (attack - receiver.getDefense()) > 0 ? (int)((attack - receiver.getDefense()) * (500/distance)) : 0;

						sender.setResilience(sender.getResilience()[1] - getResilienceCust());
						
						System.out.println("a " + lifeAffected);
						
						sender.setDamageDone(sender.getDamageDone()[1] + lifeAffected);
						receiver.setDefended(receiver.getDefended()[1] + receiver.getDefense());
						receiver.beingAttacked(-lifeAffected, 0, effects);
						Scenery.textPlayed("Acertou!",true);
						System.out.println("Acertou!");
					}
				}else if(played < ((100 - ((30 * pointVdm) + (10 * pointInteligence)) * (500/distance) * (getChance()/100))) * 0.1) {
					Integer lifeAffected = attack - receiver.getDefense() > 0 ? (int) ((attack - receiver.getDefense() + 10) * (500/distance) * 0.75) : 0;
					Integer resilienceAffected = (int) ((attack - receiver.getDefense()) * 0.1);

					sender.setResilience(sender.getResilience()[1] - getResilienceCust());
					
					sender.setDamageReceived(sender.getDamageReceived()[1] + lifeAffected);
					sender.beingAttacked(-lifeAffected, -resilienceAffected, effects);
					sender.setBubble(0);
					Scenery.textPlayed("Erro Crítico!",true);
					System.out.println("Erro Crítico!");
				}else {
					sender.setBubble(sender.getBubble() + 1);
					if(sender.getBubble() > 3) {
						Integer lifeAffected = (attack - receiver.getDefense()) > 0 ? (int)((attack - receiver.getDefense()) * (500/distance)) : 0;
						
						sender.setDamageDone(sender.getDamageDone()[1] + lifeAffected);
						receiver.setDefended(receiver.getDefended()[1] + receiver.getDefense());
						receiver.beingAttacked(-lifeAffected, 0, effects);
						Scenery.textPlayed("Acertou!",true);
						System.out.println("Acertou!");
						
						sender.setBubble(0);
					}

					sender.setResilience(sender.getResilience()[1] - getResilienceCust());
					Scenery.textPlayed("Errou!",true);
					System.out.println("Errou!");
				}
			}
			if(typeAttack == TypeAttacked.SHOOTER) {
				if(played > 100 - ((40 * pointVdm) + (10 * pointInteligence)) * (1300/distance) * (getChance()/100)) {
					if(played > 100 - 10 * (1300/distance) * pointInteligence) {
						Integer lifeAffected = attack - receiver.getDefense() + 10 > 0 ? (int) ((attack - receiver.getDefense() + 10) * (1+0.25 * Math.random()) * (distance/700)) : 0;
						Integer resilienceAffected = (int) ((attack - receiver.getDefense()) * (1+0.25 * Math.random()) * 0.1);

						sender.setResilience(sender.getResilience()[1] - getResilienceCust());
						
						sender.setDamageDone(sender.getDamageDone()[1] + lifeAffected);
						receiver.setDefended(receiver.getDefended()[1] + receiver.getDefense());
						receiver.beingAttacked(-lifeAffected, -resilienceAffected, effects);
						Scenery.textPlayed("Acerto Crítico!",true);
						System.out.println("Acerto Crítico!");
					}else {
						Integer lifeAffected = (attack - receiver.getDefense()) > 0 ? (int)((attack - receiver.getDefense()) * (distance/700)) : 0;

						sender.setResilience(sender.getResilience()[1] - getResilienceCust());
						
						sender.setDamageDone(sender.getDamageDone()[1] + lifeAffected);
						receiver.setDefended(receiver.getDefended()[1] + receiver.getDefense());
						receiver.beingAttacked(-lifeAffected, 0, effects);
						Scenery.textPlayed("Acertou!",true);
						System.out.println("Acertou!");
					}
				}else if(played < ((100 - ((40 * pointVdm) + (10 * pointInteligence)) * (1300/distance) * (getChance()/100))) * 0.1 ) {
					Integer lifeAffected = attack - receiver.getDefense() + 10 > 0 ? (int) ((attack - receiver.getDefense() + 10) * (500/distance) * 0.75) : 0;
					Integer resilienceAffected = (int) ((attack - receiver.getDefense()) * 0.1);

					sender.setResilience(sender.getResilience()[1] - getResilienceCust());
					
					sender.setDamageReceived(sender.getDamageReceived()[1] + lifeAffected);
					sender.beingAttacked(-lifeAffected, -resilienceAffected, effects);
					sender.setBubble(0);
					Scenery.textPlayed("Erro Crítico!",true);
					System.out.println("Erro Crítico!");
				}else {
					sender.setBubble(sender.getBubble() + 1);
					if(sender.getBubble() > 3) {
						Integer lifeAffected = (attack - receiver.getDefense()) > 0 ? (int)((attack - receiver.getDefense()) * (distance/700)) : 0;
						
						sender.setDamageDone(sender.getDamageDone()[1] + lifeAffected);
						receiver.setDefended(receiver.getDefended()[1] + receiver.getDefense());
						receiver.beingAttacked(-lifeAffected, 0, effects);
						Scenery.textPlayed("Acertou!",true);
						System.out.println("Acertou!");
						
						sender.setBubble(0);
					}

					sender.setResilience(sender.getResilience()[1] - getResilienceCust());
					Scenery.textPlayed("Errou!",true);
					System.out.println("Errou!");
				}
			}
			if(typeAttack == TypeAttacked.MAGICAL) {
				if(played > 100 - ((30 * pointVdm) + (20 * pointInteligence)) * (700/distance) * (getChance()/100)) {
					if(played > 100 - 10 * (900/distance) * pointInteligence) {
						Integer lifeAffected = (idm / attack) - (receiver.getIdm() / receiver.getDefense()) > 0 ? (int) (((idm / attack) - (receiver.getIdm() / receiver.getDefense())) * (1 + 0.25 * Math.random())) : 0;
						Integer resilienceAffected = (int) (((idm / attack) - (receiver.getIdm() / receiver.getDefense())) * 0.1);

						sender.setResilience(sender.getResilience()[1] - getResilienceCust() - 20);
						
						sender.setDamageDone(sender.getDamageDone()[1] + lifeAffected);
						receiver.setDefended(receiver.getDefended()[1] + (receiver.getIdm() / receiver.getDefense()));
						receiver.beingAttacked(-lifeAffected, -resilienceAffected, effects);
						Scenery.textPlayed("Acerto Crítico!",true);
						System.out.println("Acerto Crítico!");
					}else {
						Integer lifeAffected = (idm / attack) - (receiver.getIdm() / receiver.getDefense()) > 0 ? (int) (((idm / attack) - (receiver.getIdm() / receiver.getDefense()))) : 0;
						receiver.beingAttacked(-lifeAffected, 0, effects);
						
						sender.setResilience(sender.getResilience()[1] - getResilienceCust() - 20);
						
						sender.setDamageDone(sender.getDamageDone()[1] + lifeAffected);
						receiver.setDefended(receiver.getDefended()[1] + (receiver.getIdm() / receiver.getDefense()));
						Scenery.textPlayed("Acertou!",true);
						System.out.println("Acertou!");
					}
				}else if(played < ((100 - ((30 * pointVdm) + (20 * pointInteligence)) * (700/distance) * (getChance()/100))) * 0.1) {
					Integer lifeAffected = (int) (((sender.getIdm() / sender.getStrength())) * 0.75);
					Integer resilienceAffected = (int) (((idm / attack) - (receiver.getIdm() / receiver.getDefense())) * 0.1);

					sender.setResilience(sender.getResilience()[1] - getResilienceCust() - 20);
					
					sender.setDamageReceived(sender.getDamageReceived()[1] + lifeAffected);
					sender.beingAttacked(-lifeAffected, -resilienceAffected, effects);
					sender.setBubble(0);
					Scenery.textPlayed("Erro Crítico!",true);
					System.out.println("Erro Crítico!");
				}else {
					sender.setBubble(sender.getBubble() + 1);
					if(sender.getBubble() > 3) {
						Integer lifeAffected = (idm / attack) - (receiver.getIdm() / receiver.getDefense()) > 0 ? (int) (((idm / attack) - (receiver.getIdm() / receiver.getDefense()))) : 0;
						receiver.beingAttacked(-lifeAffected, 0, effects);

						sender.setDamageDone(sender.getDamageDone()[1] + lifeAffected );
						receiver.setDefended(receiver.getDefended()[1] + (receiver.getIdm() / receiver.getDefense()));
						Scenery.textPlayed("Acertou!",true);
						System.out.println("Acertou!");

						sender.setResilience(sender.getResilience()[1] - getResilienceCust() - 20);
						
						sender.setBubble(0);
					}else {
						sender.setResilience(sender.getResilience()[1] - getResilienceCust() - 20);
						Scenery.textPlayed("Errou!",true);
						System.out.println("Errou!");
					}
				}
			}
		}
	}
	
	public void saveChampions() {
		sender.save();
		receiver.save();
	}
	
	public static void creatingAction(List<Action> actions, MouseEvent e) {
		for(Action ac : actions) {
			if(ac.getReceiver() == null) {
				ac.updateArrow(e.getX(), e.getY(),false);
			}
		}
	}
	
	public static void clickMovementAction(List<Action> actions,MouseEvent e) {
		if(actions.size() > 0) {
			if(actions.get(actions.size() - 1).getReceiver() == null) {
				
				if(actions.get(actions.size() - 1).getSender().isMovement()) {
					actions.get(actions.size() - 1).getSender().clearMovement();
				}else {
					actions.get(actions.size() - 1).getSender().startMovement((int)e.getX(), (int)e.getY());	
				}
				
				System.out.println("azul");
			}
		}
	}
	
	public static void createOfAction(List<Action> actions, List<Champion> champions,Group root, MouseEvent e) {
		for(Champion c : champions) {
			if(c.getTarget().contains(e.getX(), e.getY()) && !Scenery.table.isActivity() && !Scenery.tableTurn.isActivity() ) {
				
				if(actions.size() != 0 && (champions.get(Scenery.turn) == actions.get(0).sender)) {
					//Instanciando a segunda ou maior ação da lista
					//--------------SELECIONANDO A ORIGEM DA AÇÃO; CRIANDO A AÇÃO E ADICIONANDO SEU REMETENTE----------------
					if(c.isSelected() && champions.indexOf(c) == Scenery.turn && actions.get(actions.size() - 1).getReceiver() != null) {
						Action action = new Action(root);
						actions.add(action);
						actions.get(actions.indexOf(action)).setSender(c);
						
					}
					//--------------ADICIONANDO O DESTINATÁRIO DA AÇÃO----------------
					else if(!c.isSelected() && actions.get(actions.size() - 1).getReceiver() == null) {
						boolean exist = false;
						for(Action ac : actions) {
							if(ac.getReceiver() == c) {
								exist = true;
							}
						}
						if(!exist)
							actions.get(actions.size() - 1).setReceiver(c);
					}
				}else {
					for(Action ac : actions) {
						ac.saveChampions();
					}
					actions.clear();
					//Instanciando a primeira ação da lista
					if(c.isSelected() && champions.indexOf(c) == Scenery.turn) {
						Action action = new Action(root);
						actions.add(action);
						actions.get(actions.indexOf(action)).setSender(c);
						
					}	
				}
				
				
				
				//-----SELECIONAR O CHAMPION CLICADO----
				for(Champion ch : champions) {
					ch.setSelected(false);
				}
				c.setSelected(true);
			}
		}
	}
	
	private static Action lastActionSelected;
	
	public static void actionSelected(List<Action> actions) {
		for(Action ac : actions) {
			if(ac.getReceiver() != null && !ac.getReceiver().isSelected()) {
				ac.updateArrow(ac.getReceiver().getChampion().getTranslateX() + 67, ac.getReceiver().getChampion().getTranslateY() + 112,false);
			}else if(ac.getReceiver() != null && ac.getReceiver().isSelected()){//Se a seta atual for a do champion selecionado, então...
				if(lastActionSelected != ac) {
					Scenery.table.download(ac);
					lastActionSelected = ac;
				}
				
				//System.out.println(ac + " - " + tb.getStrengthAffected());
				
				ac.updateArrow(ac.getReceiver().getChampion().getTranslateX() + 67, ac.getReceiver().getChampion().getTranslateY() + 112,true);
				Scenery.table.upload(ac);
				
			}
		}
	}
}
