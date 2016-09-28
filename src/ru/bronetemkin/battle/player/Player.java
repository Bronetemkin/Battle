package ru.bronetemkin.battle.player;

import ru.bronetemkin.battle.listener.StatusListener;
import ru.bronetemkin.battle.player.stats.StatsFactory;

/**
 * Created by bronetemkin on 26.09.16.
 */
public class Player {

    private StatusListener statusListener;
    private StatsFactory.Stats stats;
    private int status;
    private String name;

    public void setName(String name){
        if(name != null && !name.isEmpty() && !name.equals("")){
            this.name = name;
        }
    }

    public String getName(){
        return name;
    }

    public void setStats(StatsFactory.Stats stats){
        this.stats = stats;
    }

    public StatsFactory.Stats getStats(){
        return stats;
    }

    private void setStatus(int status){
        this.status = status;
    }

    public int getStatus(){
        return status;
    }

    public void setStatusListener(StatusListener statusListener){
        if(statusListener != null){
            this.statusListener = statusListener;
        }
    }

    public void updateStatus(int status){
        setStatus(status);
        if(statusListener != null){
            statusListener.onStatusChanged(status, null);
        }
    }

    public class Status{
        public static final int ATTACK = 0,
                HALF_ATTACK = 1,
                DEFENSE = 2,
                WAIT = 3,
                DEAD = 4;
    }

}
