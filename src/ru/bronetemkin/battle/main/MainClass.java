package ru.bronetemkin.battle.main;

import ru.bronetemkin.battle.player.StatsFactory;

/**
 * Created by Bronetemkin on 26.09.2016.
 */
public class MainClass {

    public static void main(String[] args){
        StatsFactory.Stats stats = StatsFactory.makeRandomStats();
        log("health = " + stats.getHealth());
        log("endurance = " + stats.getEndurance());
        log("power = " + stats.getPower());
        log("agility =  " + stats.getAgility());
    }

    public void start(){

    }

    public void stop(){

    }

    public void pause(){

    }

    public void resume(){

    }

    private static void log(String msg){
        System.out.println(msg);
    }

}
