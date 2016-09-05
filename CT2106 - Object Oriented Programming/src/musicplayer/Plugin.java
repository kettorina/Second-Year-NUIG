package musicplayer;

public interface Plugin {
	
	public void play(AudioFile audio) 
			throws UnSupportedAudioFormatException;
	
}



