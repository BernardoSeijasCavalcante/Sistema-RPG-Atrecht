//-------------------CÓDIGO CRIADO POR: BERNARDO SEIJAS CAVALCANTE-------------------
//Linkedin: ww.linkedin.com/in/bernardo-seijas-658562339

package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.entities.Champion;
import model.resources.Action;
import model.resources.ElapsedTime;
import model.resources.LastNanoTime;
import model.resources.Scenery;
import model.resources.Table;
import model.resources.TableTurn;
import model.resources.buttons.AttackButton;
import model.resources.buttons.DefenseButton;
import model.resources.championsPane.ChampionPanel;
import model.resources.soundsPane.SoundPane;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		/*try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		Group root = new Group();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		
		Canvas canvas = new Canvas(1920,1080);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.drawImage(new Image("resources\\scenery\\image.jpg"),0,0,1920,1080);
		
		root.getChildren().add(canvas);
		
		root.getChildren().add(Scenery.played);
		
		List<Champion> champions = new ArrayList<>();
		
		ChampionPanel championPanel = new ChampionPanel(champions);
		
		try {
			
			championPanel.start(new Stage());
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		List<Action> actions = new ArrayList<>();
		
		Table tb = new Table(root);
		TableTurn tbt = new TableTurn(root);
		
		Scenery.table = tb;
		Scenery.tableTurn = tbt;
		
		Scenery.champions = champions;
		
		AttackButton ab = new AttackButton(root);
		DefenseButton db = new DefenseButton(root);
		
		ElapsedTime elapsedTime = new ElapsedTime(0);
		LastNanoTime lastNanoTime = new LastNanoTime(System.nanoTime());
		
		//root.getChildren().add(Table.effectsButtons.get(0).getButton());
		
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				Action.creatingAction(actions, e); //Seta seguindo mouse
				
				Table.mouseOverEffectsButtons(e);
				TableTurn.mouseOverEffectsButtons(e);
				
				AttackButton.update(e);
				DefenseButton.update(e);
				
			}
			
		});
		
		scene.setOnMouseClicked(new EventHandler<MouseEvent>(){
			
			@Override
			public void handle(MouseEvent e) {
				Action.createOfAction(actions, champions, root, e); //Geração da seta
				Action.clickMovementAction(actions, e);
				
				Table.activity(e);
				Table.clickEffectsButtons(e);
				TableTurn.activity(e);
				TableTurn.clickEffectsButtons(e);
				
				AttackButton.clickEvent(e, actions,champions);
				DefenseButton.clickEvent(e, actions, champions);
				
			}
			
		});
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				
				if(e.getCode().toString().equals("E")) {//Exibir monitor de atributos do champion selecionado
					for(Champion c : champions) {
						if(c.isSelected() && !c.isAtributesMonitorExhibition()) {
							c.setAtributesMonitorExhibition(true);
						}else if(c.isAtributesMonitorExhibition()) {
							c.setAtributesMonitorExhibition(false);
						}
					}
				}
				
				if(e.getCode().toString().equals("ESCAPE")) {
					if(actions.size() != 0 && actions.get(actions.size() - 1).getReceiver() == null) {
						actions.get(actions.size() - 1).clearArrow();;
						actions.remove(actions.get(actions.size() - 1));
					}
				}
				
				if(e.getCode().toString().equals("V")) {
					if(actions.size() == 0) {
						Scenery.turnBack();
					}
					for(Action ac : actions) {
						ac.getSender().load();
						if(ac.getReceiver() != null)
							ac.getReceiver().load();
						ac.clearArrow();
					}
					actions.clear();
				}
				
				if(e.getCode().toString().equals("B")) {
					
					Scenery.turnPass(true);
				}
				
				if(e.getCode().toString().equals("N")) {
					Scenery.turnPass(false);
				}
				
				if(e.getCode().toString().equals("Q")) {
					for(Champion c : champions) {
						c.setCampMonitorActivity(true);
						c.updateCampMonitor((int)((1000) * (c.getVdm() * 1.0/champions.get(Scenery.turn).getVdm()*1.0) * (c.getInteligence()*1.0/champions.get(Scenery.turn).getInteligence()*1.0)));
					}
				}
				
				if(e.getCode().toString().equals("W")) {
					for(Champion c : champions) {
						c.setCampMonitorActivity(false);
					}
				}
				
			}
			
		});
		
		new AnimationTimer() {

			@Override
			public void handle(long currentNanoTime) {
				
				elapsedTime.value = ((currentNanoTime - lastNanoTime.value) / 1000000000.0); //Delay do frame
				lastNanoTime.value = currentNanoTime; //Variável auxiliar para geração do delay do frame
				
				Scenery.t = elapsedTime.value;
				
				if(Scenery.activePlayed) {
					Scenery.textPlayed(Scenery.textPlayed, null);
				}
				
				for(Champion c : champions) {
					c.insertInScene(root);
				}		
				
				for(Champion c : champions) {
					c.update(elapsedTime.value);
				}
				
				tb.update(elapsedTime.value);
				tbt.update(elapsedTime.value);
				
				//System.out.println(champions.get(0).getLife()[0]);
				
				//----------------------RENDERIZAR SETA NO CENÁRIO---------------------
				
				Action.actionSelected(actions);
				
				if(Scenery.tableTurn.isActivity()) {
				TableTurn.selectTarget();
				}
			}
			
		}.start();
		
		primaryStage.setTitle("Sistema RPG!");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
