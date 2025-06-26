package model.resources;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.entities.Champion;

public class Scenery {
	public static Integer turn = 0;
	public static List<Champion> champions;
	public static Table table;
	public static TableTurn tableTurn;
	public static Canvas played = new Canvas(960,540);
	public static GraphicsContext gcPlayed = played.getGraphicsContext2D();
	
	public static double t;
	public static double count;
	public static boolean activePlayed;
	public static String textPlayed;
	
	public static List<Clip> clip = new ArrayList<>();
	
	public static void textPlayed(String text, Boolean active) {
		
		if(active != null) {
			if(active) {
				activePlayed = true;
				textPlayed = text;
			}
			if(active == false) {
				activePlayed = false;
				textPlayed = text;
			}
		}
		
		gcPlayed.clearRect(0, 0, played.getWidth(), played.getHeight());
		
		played.setTranslateX(480);
		played.setTranslateY(-100);
		
		gcPlayed.setFill(Color.RED);
		gcPlayed.setStroke(Color.BLACK);
		gcPlayed.setLineWidth(3);
		gcPlayed.setFont(Font.font("Times New Roman", FontWeight.BOLD, 150));
		gcPlayed.fillText(textPlayed, 0, 300);
		gcPlayed.strokeText(textPlayed, 0, 300);
		
		if(count < 2) {
			count += t;
		}else {
			gcPlayed.clearRect(0, 0, played.getWidth(), played.getHeight());
			activePlayed = false;
			count = 0;
		}

		
		
		
	}
	
	public static void turnPass() {
		turn = turn < (champions.size() - 1) ? turn + 1 : 0;
		for(Champion c : champions) {
			c.setSelected(false);
		}
		
		for(Champion ch : champions) {
			for(Effects ef : ch.getEffects()) {
				if(ef.getLifeA() != 0 || ef.getResilienceA() != 0) {
					ch.beingAttacked(ef.getLifeA(), ef.getResilienceA(),null);
				}
			}
		}
		
		passEffects();
		
		champions.get(turn).setSelected(true);
		
	}
	
	public static void passEffects() {
		for(Effects ef : champions.get(turn).getEffects()) {
			System.out.println(ef.getDuration());
			ef.setDuration(ef.getDuration() - 1);
			
		}
	}
	
	public static void playClip(String path) {
		try {
            // Especificando o caminho do arquivo de áudio
            File audioFile = new File(path);

            // Abrindo o arquivo de áudio
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            // Criando o clip de áudio
            clip.add(AudioSystem.getClip());

            // Carregando o áudio no clip
            clip.get(clip.size()-1).open(audioStream);

            // Tocando o áudio
            clip.get(clip.size()-1).start();

            // Aguardar até o áudio terminar

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
	}
	
	public static void stopClip() {
		for(Clip c : clip) {
			c.stop();
		}
		clip.clear();
	}
}
