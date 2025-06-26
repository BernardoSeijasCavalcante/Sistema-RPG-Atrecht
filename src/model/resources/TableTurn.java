package model.resources;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import model.entities.Champion;
import model.resources.buttons.BlindnessEffectButton;
import model.resources.buttons.BloodEffectButton;
import model.resources.buttons.BloquedEffectButton;
import model.resources.buttons.BrokenBonesEffectButton;
import model.resources.buttons.ConfusionEffectButton;
import model.resources.buttons.CureEffectButton;
import model.resources.buttons.CureResilienceEffectButton;
import model.resources.buttons.DefenseAEffectButton;
import model.resources.buttons.DesarmedEffectButton;
import model.resources.buttons.EffectsButtons;
import model.resources.buttons.ElectrocutingEffectButton;
import model.resources.buttons.EruditionEffectButton;
import model.resources.buttons.FearEffectButton;
import model.resources.buttons.FireEffectButton;
import model.resources.buttons.InvisibilityEffectButton;
import model.resources.buttons.PoisonEffectButton;
import model.resources.buttons.SlownessEffectButton;
import model.resources.buttons.SpeedEffectButton;
import model.resources.buttons.StrengthEffectButton;
import model.resources.buttons.VulnerabilityEffectButton;
import model.resources.buttons.WeeknessEffectButton;
import model.resources.effects.Blindness;
import model.resources.effects.Blood;
import model.resources.effects.Bloqued;
import model.resources.effects.BrokenBones;
import model.resources.effects.Confusion;
import model.resources.effects.Cure;
import model.resources.effects.CureResilience;
import model.resources.effects.Desarmed;
import model.resources.effects.Electrocuting;
import model.resources.effects.Fire;
import model.resources.effects.Poison;

public class TableTurn {
	private Integer lifeAffected = 0;
	private Integer resilienceAffected = 0;
	private Integer strengthAffected = 0;
	private Integer defenseAffected = 0;
	private Integer vdmAffected = 0;
	private Integer idmAffected = 0;
	private Integer inteligenceAffected = 0;
	
	private TypeAttacked typeAttacked;
	
	private List<Effects> effects = new ArrayList<>();
	
	private static boolean activity = false;
	
	private static Group table = new Group();
	private static Group root;
	
	private Canvas canvas = new Canvas(610,1080);
	private GraphicsContext gc = canvas.getGraphicsContext2D();
	
	private TextField lifeTF = new TextField();
	private TextField resilienceTF = new TextField();
	private TextField strengthTF = new TextField();
	private TextField defenseTF = new TextField();
	private TextField vdmTF = new TextField();
	private TextField idmTF = new TextField();
	private TextField inteligenceTF = new TextField();

	private ChoiceBox<String> typeAttackedBox	= new ChoiceBox<>();

	public static List<EffectsButtons> effectsButtons = new ArrayList<>();
	
	private static Rectangle target;
	
	public static Integer positionX = -540;
	
	public TableTurn(Group root) {
		
		this.root = root;
		
		gc.drawImage(new Image("resources/Table/TábuaDeControle.png"), 0, 0);
		
		lifeTF.setTranslateX(270);
		lifeTF.setTranslateY(40);
		
		resilienceTF.setTranslateX(270);
		resilienceTF.setTranslateY(80);
		
		strengthTF.setTranslateX(270);
		strengthTF.setTranslateY(120);
		
		defenseTF.setTranslateX(270);
		defenseTF.setTranslateY(160);
		
		vdmTF.setTranslateX(270);
		vdmTF.setTranslateY(200);
		
		idmTF.setTranslateX(270);
		idmTF.setTranslateY(240);
		
		inteligenceTF.setTranslateX(270);
		inteligenceTF.setTranslateY(280);
		
		typeAttackedBox.setTranslateX(270);
		typeAttackedBox.setTranslateY(320);
		
		typeAttackedBox.setItems(FXCollections.observableArrayList(TypeAttacked.ATTACKER.toString(), TypeAttacked.MAGICAL.toString(), TypeAttacked.SHOOTER.toString()));
		
		table.getChildren().add(canvas);
		
		//------------------------------EFFECTSBUTTONS----------------------------
		
		effectsButtons.add(new FireEffectButton());
		effectsButtons.add(new BloodEffectButton());
		effectsButtons.add(new BrokenBonesEffectButton());
		effectsButtons.add(new ConfusionEffectButton());
		effectsButtons.add(new BlindnessEffectButton());
		effectsButtons.add(new DesarmedEffectButton());
		effectsButtons.add(new BloquedEffectButton());
		effectsButtons.add(new CureEffectButton());
		effectsButtons.add(new CureResilienceEffectButton());
		effectsButtons.add(new ElectrocutingEffectButton());
		effectsButtons.add(new PoisonEffectButton());
		effectsButtons.add(new SlownessEffectButton());
		effectsButtons.add(new WeeknessEffectButton());
		effectsButtons.add(new VulnerabilityEffectButton());
		effectsButtons.add(new InvisibilityEffectButton());
		effectsButtons.add(new StrengthEffectButton());
		effectsButtons.add(new SpeedEffectButton());
		effectsButtons.add(new EruditionEffectButton());
		effectsButtons.add(new DefenseAEffectButton());
		effectsButtons.add(new FearEffectButton());
		
		for(EffectsButtons eb : effectsButtons) {
			table.getChildren().add(eb.getButton());
		}
		
		effectsButtons.get(0).getButton().setTranslateX(100);
		effectsButtons.get(0).getButton().setTranslateY(400);
		
		effectsButtons.get(1).getButton().setTranslateX(200);
		effectsButtons.get(1).getButton().setTranslateY(400);
		
		effectsButtons.get(2).getButton().setTranslateX(300);
		effectsButtons.get(2).getButton().setTranslateY(400);
		
		effectsButtons.get(3).getButton().setTranslateX(400);
		effectsButtons.get(3).getButton().setTranslateY(400);
		
		effectsButtons.get(4).getButton().setTranslateX(100);
		effectsButtons.get(4).getButton().setTranslateY(500);

		effectsButtons.get(5).getButton().setTranslateX(200);
		effectsButtons.get(5).getButton().setTranslateY(500);

		effectsButtons.get(6).getButton().setTranslateX(300);
		effectsButtons.get(6).getButton().setTranslateY(500);
		
		effectsButtons.get(7).getButton().setTranslateX(400);
		effectsButtons.get(7).getButton().setTranslateY(500);
		
		effectsButtons.get(8).getButton().setTranslateX(100);
		effectsButtons.get(8).getButton().setTranslateY(600);
		
		effectsButtons.get(9).getButton().setTranslateX(200);
		effectsButtons.get(9).getButton().setTranslateY(600);
		
		effectsButtons.get(10).getButton().setTranslateX(300);
		effectsButtons.get(10).getButton().setTranslateY(600);
		
		effectsButtons.get(11).getButton().setTranslateX(400);
		effectsButtons.get(11).getButton().setTranslateY(600);
		
		effectsButtons.get(12).getButton().setTranslateX(100);
		effectsButtons.get(12).getButton().setTranslateY(700);
		
		effectsButtons.get(13).getButton().setTranslateX(200);
		effectsButtons.get(13).getButton().setTranslateY(700);
		
		effectsButtons.get(14).getButton().setTranslateX(300);
		effectsButtons.get(14).getButton().setTranslateY(700);
		
		effectsButtons.get(15).getButton().setTranslateX(400);
		effectsButtons.get(15).getButton().setTranslateY(700);
		
		effectsButtons.get(16).getButton().setTranslateX(100);
		effectsButtons.get(16).getButton().setTranslateY(800);
		
		effectsButtons.get(17).getButton().setTranslateX(200);
		effectsButtons.get(17).getButton().setTranslateY(800);
		
		effectsButtons.get(18).getButton().setTranslateX(300);
		effectsButtons.get(18).getButton().setTranslateY(800);
		
		effectsButtons.get(19).getButton().setTranslateX(400);
		effectsButtons.get(19).getButton().setTranslateY(800);
		//------------------------------EFFECTSBUTTONS----------------------------
		
		canvas.setRotate(180);
		
		table.getChildren().add(lifeTF);
		table.getChildren().add(resilienceTF);
		table.getChildren().add(strengthTF);
		table.getChildren().add(defenseTF);
		table.getChildren().add(vdmTF);
		table.getChildren().add(idmTF);		
		table.getChildren().add(inteligenceTF);	
		
		table.getChildren().add(typeAttackedBox);
		
		lifeTF.setText("0");
		resilienceTF.setText("0");
		
		strengthTF.setText("0");
		defenseTF.setText("0");
		vdmTF.setText("0");
		idmTF.setText("0");
		inteligenceTF.setText("0");
		
		root.getChildren().add(table);
	}
	
	
	
	public Integer getLifeAffected() {
		return lifeAffected;
	}



	public void setLifeAffected(Integer lifeAffected) {
		this.lifeAffected = lifeAffected;
	}



	public Integer getResilienceAffected() {
		return resilienceAffected;
	}



	public void setResilienceAffected(Integer resilienceAffected) {
		this.resilienceAffected = resilienceAffected;
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


	public Integer getInteligenceAffected() {
		return inteligenceAffected;
	}



	public void setInteligenceAffected(Integer inteligenceAffected) {
		this.inteligenceAffected = inteligenceAffected;
	}


	public TypeAttacked getTypeAttacked() {
		return typeAttacked;
	}



	public void setTypeAttacked(TypeAttacked typeAttacked) {
		this.typeAttacked = typeAttacked;
	}

	public void addEffect(Effects ef) {
		effects.add(ef);
	}
	
	public void removeEffect(Effects ef) {
		effects.remove(ef);
	}
	
	public boolean isActivity() {
		return activity;
	}



	public void setActivity(boolean activity) {
		this.activity = activity;
	}



	public Group getTable() {
		return table;
	}



	public void setTable(Group table) {
		this.table = table;
	}



	public Rectangle getTarget() {
		return target;
	}



	public void setTarget(Rectangle target) {
		this.target = target;
	}



	public Integer getPositionX() {
		return positionX;
	}



	public void setPositionX(Integer positionX) {
		this.positionX = positionX;
	}

	
	
	public void update(Double t) {
		table.setTranslateX(positionX);
		setTarget(new Rectangle(positionX + 550,0,60,1080));
		
		//-------------------MOVIMENTO DA TÁBUA---------------------------------
		if(positionX < (0) && isActivity()) {
			positionX += (int)(300 * t);
		}else if(positionX > (-540) && !isActivity()) {
			positionX -= (int)(300 * t);
		}
		
		
		
		//---------------CAMPOS E VARIÁVEIS---------------
		if(isActivity()) {
				try {
					if(!lifeTF.getText().equals("")) 
						lifeAffected = Integer.parseInt(lifeTF.getText());
				} catch(Exception e) {
					System.out.println("Os campos só aceitam números!");
					lifeTF.setText("");
				}
			
				try {
					if(!resilienceTF.getText().equals("")) 
						resilienceAffected = Integer.parseInt(resilienceTF.getText());
				} catch(Exception e) {
					System.out.println("Os campos só aceitam números!");
					resilienceTF.setText("");
				}
			
				try {
					if(!strengthTF.getText().equals("")) 
						strengthAffected = Integer.parseInt(strengthTF.getText());
				} catch(Exception e) {
					System.out.println("Os campos só aceitam números!");
					strengthTF.setText("");
				}
				
				try {
					if(!defenseTF.getText().equals("")) 
						defenseAffected = Integer.parseInt(defenseTF.getText());
				} catch(Exception e) {
					System.out.println("Os campos só aceitam números!");
					defenseTF.setText("");
				}
				
				try {
					if(!vdmTF.getText().equals("")) 
						vdmAffected = Integer.parseInt(vdmTF.getText());
				} catch(Exception e) {
					System.out.println("Os campos só aceitam números!");
					vdmTF.setText("");
				}
				
				try {
					if(!idmTF.getText().equals("")) 
						idmAffected = Integer.parseInt(idmTF.getText());
				} catch(Exception e) {
					System.out.println("Os campos só aceitam números!");
					idmTF.setText("");
				}
				
				try {
					if(!inteligenceTF.getText().equals("")) 
						inteligenceAffected = Integer.parseInt(inteligenceTF.getText());
				} catch(Exception e) {
					System.out.println("Os campos só aceitam números!");
					inteligenceTF.setText("");
				}
				
		}else {
			if(!Scenery.table.isActivity())
				typeAttackedBox.requestFocus();
		}
	}
	
	public void download(Champion champion) {
		
		lifeTF.setText(champion.getLife()[1].toString());
		resilienceTF.setText(champion.getResilience()[1].toString());
		
		strengthTF.setText(champion.getMainStrength().toString());
		defenseTF.setText(champion.getMainDefense().toString());
		vdmTF.setText(champion.getMainVdm().toString());
		idmTF.setText(champion.getMainIdm().toString());
		inteligenceTF.setText(champion.getMainInteligence().toString());
		
		lifeAffected = Integer.parseInt(lifeTF.getText());
		resilienceAffected = Integer.parseInt(resilienceTF.getText());
		
		strengthAffected = Integer.parseInt(strengthTF.getText());
		defenseAffected = Integer.parseInt(defenseTF.getText());
		vdmAffected = Integer.parseInt(vdmTF.getText());
		idmAffected = Integer.parseInt(idmTF.getText());
		inteligenceAffected = Integer.parseInt(inteligenceTF.getText());
		
		typeAttackedBox.setValue(champion.getType().toString());
		
		effects = champion.getEffects();
		
		Action action = new Action(champion,champion, effects);
		
		for(EffectsButtons eb : effectsButtons) {
			eb.setActivity(false);
			eb.setEffect(null);
			eb.setAction(action);
		}
		
		for(Effects ef : effects) {
			if(ef.getClass() == new Fire().getClass()) {
				effectsButtons.get(0).setEffect(ef);
				effectsButtons.get(0).setActivity(true);
			}
			if(ef.getClass() == new Blood().getClass()) {
				effectsButtons.get(1).setEffect(ef);
				effectsButtons.get(1).setActivity(true);
			}
			if(ef.getClass() == new BrokenBones().getClass()) {
				effectsButtons.get(2).setEffect(ef);
				effectsButtons.get(2).setActivity(true);
			}
			if(ef.getClass() == new Confusion().getClass()) {
				effectsButtons.get(3).setEffect(ef);
				effectsButtons.get(3).setActivity(true);
			}
			if(ef.getClass() == new Blindness().getClass()) {
				effectsButtons.get(4).setEffect(ef);
				effectsButtons.get(4).setActivity(true);
			}
			if(ef.getClass() == new Desarmed().getClass()) {
				effectsButtons.get(5).setEffect(ef);
				effectsButtons.get(5).setActivity(true);
			}
			if(ef.getClass() == new Bloqued().getClass()) {
				effectsButtons.get(6).setEffect(ef);
				effectsButtons.get(6).setActivity(true);
			}
			if(ef.getClass() == new Cure().getClass()) {
				effectsButtons.get(7).setEffect(ef);
				effectsButtons.get(7).setActivity(true);
			}
			if(ef.getClass() == new CureResilience().getClass()) {
				effectsButtons.get(8).setEffect(ef);
				effectsButtons.get(8).setActivity(true);
			}
			if(ef.getClass() == new Electrocuting().getClass()) {
				effectsButtons.get(9).setEffect(ef);
				effectsButtons.get(9).setActivity(true);
			}
			if(ef.getClass() == new Poison().getClass()) {
				effectsButtons.get(10).setEffect(ef);
				effectsButtons.get(10).setActivity(true);
			}
			
		}
		
	}
	
	public void upload(Champion champion) {
		champion.setLife(getLifeAffected());
		champion.setResilience(getResilienceAffected());
		
		champion.setStrength(getStrengthAffected());
		champion.setDefense(getDefenseAffected());
		champion.setVdm(getVdmAffected());
		champion.setIdm(getIdmAffected());
		champion.setInteligence(getInteligenceAffected());
		
		champion.setType(TypeAttacked.valueOf(typeAttackedBox.getValue()));
		
		champion.setEffects(effects);
	}
	
	public static void mouseOverEffectsButtons(MouseEvent e) {
		for(EffectsButtons eb : effectsButtons) {
			eb.update(e);
		}
	}
	
	public static void clickEffectsButtons(MouseEvent e) {
		for(EffectsButtons eb : effectsButtons) {
			eb.clickEvent(e);
		}
	}
	
	public static void activity(MouseEvent e) {
		if(target.contains(e.getX(), e.getY())) {
			activity = activity == true ? false : true;
			root.getChildren().remove(table);
			root.getChildren().add(table);
		}
	}
	
	private static Champion lastChampionSelected;
	
	public static void selectTarget() {
		for(Champion c : Scenery.champions) {
			if(c.isSelected()) {
				if(c != lastChampionSelected) {
					Scenery.tableTurn.download(c);
					lastChampionSelected = c;
					System.out.println("aaaaaaaaaamarelo");
				}
				Scenery.tableTurn.upload(c);
				break;
			}
		}
	}
}
