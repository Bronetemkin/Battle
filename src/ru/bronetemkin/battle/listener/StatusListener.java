package ru.bronetemkin.battle.listener;

/**
 * Created by bronetemkin on 26.09.16.
 */
public interface StatusListener<StatusType, DataType> {
    void onStatusChanged(StatusType status, DataType data);
}
