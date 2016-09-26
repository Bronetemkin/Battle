package ru.bronetemkin.battle.listener;

/**
 * Created by bronetemkin on 26.09.16.
 */
public interface StatusListener<StatusType> {
    void onStatusChanged(StatusType type);
}
