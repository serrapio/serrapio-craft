package io.github.avdaco.serrapiocraft.timer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import io.github.avdaco.serrapiocraft.SerrapioCraft;
import io.github.avdaco.serrapiocraft.messaging.Whisperer;

public class DeathTimer {

	private static final int TIME_TO_DELETION = 300;
	private static final int TIMER_STOPPED = -1;
	private static final int TIMER_FINISHED = -2;

	private Player player;
	
	private BukkitScheduler scheduler;
	private int time;
	private int taskId;

	public DeathTimer() {
		this.scheduler = Bukkit.getServer().getScheduler();
		startNewTimer();
	}
	
	public DeathTimer(Player player) {
		this();
		this.player = player;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void stopTimer() {
		if (!isStopped() && !isFinished()) {
			Bukkit.getScheduler().cancelTask(taskId);
			this.taskId = TIMER_STOPPED;
		}
	}
	
	public void finishTimer() {
		Bukkit.getScheduler().cancelTask(taskId);
		this.taskId = TIMER_FINISHED;
	}

	public void startNewTimer() {
		this.time = TIME_TO_DELETION;
		this.taskId = TIMER_STOPPED;
		startTimer();
	}

	public void startTimer() {
		if (isStopped()) {
			this.taskId = this.scheduler.scheduleSyncRepeatingTask(SerrapioCraft.getPlugin(), new Runnable() {
		
				@Override
				public void run() {
					manageTimerActions();
				}
			}, 0L, 20L);
		}
	}

	private void manageTimerActions() {
		if (this.time <= 0) {
			finishTimer();
			return;
		} else if (isTimerInReminderThreshold()) {
			whisperReminder();
		}

		this.time = this.time - 1;
	}

	public boolean isStopped() {
		return this.taskId == TIMER_STOPPED;
	}
	
	public boolean isFinished() {
		return this.taskId == TIMER_FINISHED;
	}
	
	private void whisperReminder() {
		Whisperer.whisper(this.player, "Faltan " + this.time + " segundos para perder los objetos");
	}
	
	private boolean isTimerInReminderThreshold() {
		return (((this.time % 30) == 0) && (this.time != 300)) || (this.time < 10);
	}

}
