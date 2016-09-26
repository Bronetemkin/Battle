package ru.bronetemkin.battle.player.stats;

import ru.bronetemkin.battle.player.stats.exception.WrongStatsException;

import java.util.Random;

/**
 * Created by bronetemkin on 26.09.16.
 */
public class StatsFactory {

    public static Stats makeCustomStats(byte endurance, byte power, byte agility) throws WrongStatsException{
        if(isStatsNormal(new Stats(endurance, power, agility), Stats.MIN_CHAR_VALUE, Stats.MAX_CHAR_VALUE))
            return new Stats(endurance, power, agility);
        else
            throw new WrongStatsException("Wrong input values. The values should be: " + Stats.MIN_CHAR_VALUE + " < value < " + Stats.MAX_CHAR_VALUE);
    }

    public static Stats makeRandomStats(){
        Stats result;
        while (!isStatsNormal(result = generateStats(), Stats.MIN_CHAR_VALUE, Stats.MAX_CHAR_VALUE))
            generateStats();
        return result;
    }

    private static Stats generateStats(){
        log("generateStats");
        byte sum = 0, endurance, power, agility;
        Random random = new Random(System.currentTimeMillis());
        endurance = (byte) (random.nextInt(Stats.MAX_CHAR_VALUE) + Stats.MIN_CHAR_VALUE);
        sum += endurance;
        if(Stats.STAT_VALUE - sum > Stats.MAX_CHAR_VALUE){
            power = (byte) (random.nextInt(Stats.MAX_CHAR_VALUE - Stats.MIN_CHAR_VALUE * 2) + Stats.MIN_CHAR_VALUE);
        } else {
            power = (byte) (random.nextInt(Stats.STAT_VALUE - sum) + Stats.MIN_CHAR_VALUE);
        }
        sum += power;
        agility = (byte) (Stats.STAT_VALUE - sum);
        return new Stats(endurance, power, agility);
    }

    private static boolean isStatsNormal(Stats stats, byte minValue, byte maxValue){
        return isNumberBelongs(stats.getByteAgilityValue(), minValue, maxValue) &&
                isNumberBelongs(stats.getByteEnduranceValue(), minValue, maxValue) &&
                isNumberBelongs(stats.getBytePowerValue(), minValue, maxValue) &&
                (stats.getByteAgilityValue() + stats.getBytePowerValue() + stats.getByteEnduranceValue()) == Stats.STAT_VALUE;
    }

    private static boolean isNumberBelongs(byte number, byte min, byte max){
        return (number >= min && number <= max);
    }

    public static class Stats {
        public static final byte STAT_VALUE = 8;
        public static final byte MAX_CHAR_VALUE = 5, MIN_CHAR_VALUE = 1;
        public static final byte DEFAULT_HEALTH_LEVEL = 100;
        public static final byte STATS_MODIFIER = 2;

        private byte health = DEFAULT_HEALTH_LEVEL, endurance, power, agility;

        private Stats(byte endurance, byte power, byte agility){
            this.endurance = endurance;
            this.power = power;
            this.agility = agility;
        }

        private byte getByteHealthValue(){
            return health;
        }

        private byte getByteEnduranceValue(){
            return endurance;
        }

        private byte getBytePowerValue(){
            return power;
        }

        private byte getByteAgilityValue(){
            return agility;
        }

        public float getHealth(){
            return health / STATS_MODIFIER;
        }

        public float getEndurance(){
            return endurance / STATS_MODIFIER;
        }

        public float getPower(){
            return power / STATS_MODIFIER;
        }

        public float getAgility(){
            return agility / STATS_MODIFIER;
        }
    }

    private static void log(String msg){
        System.out.println(msg);
    }
}
