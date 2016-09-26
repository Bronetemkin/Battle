package ru.bronetemkin.battle.player.stats.exception;

/**
 * Created by bronetemkin on 26.09.16.
 */
public class WrongStatsException extends Exception {

    public WrongStatsException(String msg){
        super(msg);
    }

    public WrongStatsException(){}
}
