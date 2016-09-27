package ru.bronetemkin.battle.player;

import ru.bronetemkin.battle.listener.StatusListener;
import ru.bronetemkin.battle.player.stats.StatsFactory;

/**
 * Created by bronetemkin on 26.09.16.
 */
public class Player {

    private StatusListener<Integer> statusListener;
    private StatsFactory.Stats stats;

    public void setStats(StatsFactory.Stats stats){
        this.stats = stats;
    }

    public StatsFactory.Stats getStats(){
        return stats;
    }

    public void setStatusListener(StatusListener<Integer> statusListener){
        if(statusListener != null){
            this.statusListener = statusListener;
        }
    }

    public void updateStatus(int status){
        if(statusListener != null){
            statusListener.onStatusChanged(status);
        }
    }

}
