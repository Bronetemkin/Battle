package ru.bronetemkin.battle.player;

import ru.bronetemkin.battle.player.stats.StatsFactory;

/**
 * Created by bronetemkin on 26.09.16.
 */
public class Player {

    private StatsFactory.Stats stats;

    public void setStats(StatsFactory.Stats stats){
        this.stats = stats;
    }

}
