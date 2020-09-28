package com.lawnmower;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import com.lawnmower.exceptions.DirectionNotFoundException;
import com.lawnmower.exceptions.OrientationNotFoundException;


public class Application {
	
	/**
	 * method used to build a lawn and lawnmower object, call the movesProcess() method and finally print the lawnmower object after process
	 * 
	 * @param lawnSurface
	 * @param lawnMowerPosition
	 * @param moves
	 * @throws OrientationNotFoundException
	 * @throws DirectionNotFoundException
	 */
	public static void execution(String lawnSurface, String lawnMowerPosition, String moves) throws OrientationNotFoundException, DirectionNotFoundException {
		Lawn lawn = new Lawn(Integer.parseInt(lawnSurface.split(" ")[0]), Integer.parseInt(lawnSurface.split(" ")[1]));
		LawnMower lawnMower = new LawnMower(Integer.parseInt(lawnMowerPosition.split(" ")[0]),
				Integer.parseInt(lawnMowerPosition.split(" ")[1]), lawnMowerPosition.charAt(4), lawn);
		lawnMower.movesProcess(moves);
		System.out.println(lawnMower);
	}

	
	public static void main(String[] args) throws OrientationNotFoundException, DirectionNotFoundException{
		
		String fileName = "instructions.txt";
		
		// several pattern declared in order to define each part of the reading file
		Pattern patternLawn = Pattern.compile("[0-9]\\s[0-9]");
    	Pattern patternLawnMower = Pattern.compile("[0-9]\\s[0-9]\\s[A-Z]");
    	Pattern patternMoves = Pattern.compile("([A-Z])*");

    	// instanciate several list in order to stock each part of the reading file
    	ArrayList<String> lawns = new ArrayList<>();
    	ArrayList<String> lawnMowerPositions = new ArrayList<>();
    	ArrayList<String> moves = new ArrayList<>();


    	// file browsing
    		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
    			// for each line of the file we check if the line match with the declared patterns and stock in the appropriate list
    			stream.forEach(p -> {	 																
    				Matcher matcherLawn = patternLawn.matcher(p);
    				Matcher matcherLawnMower = patternLawnMower.matcher(p);
    				Matcher matcherMoves = patternMoves.matcher(p);

    				if (matcherLawn.matches()) {
    					lawns.add(p);

    				}
    				else if (matcherLawnMower.matches()) {
    					lawnMowerPositions.add(p);

    				}
    				else if (matcherMoves.matches()) {
    					moves.add(p);
    				}

    			});

    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		// once the lists have been completed we iterate the lawnMowerPositions and moves lists in order to associate each one to a lawn present in the lawns list
    		for (String l : lawns) {
    			for (int i = 0; i < lawnMowerPositions.size(); i++) {
    				execution(l, lawnMowerPositions.get(i), moves.get(i));
    			}
    		}
    	}

	}
	

