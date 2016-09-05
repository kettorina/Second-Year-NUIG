package musicplayer;
//This is a Concrete Music Player

public class VLCPlayer{

	private PluginAdapter adapter = new PluginAdapter();
	private boolean playState = false;
	

	public void play(AudioFile audio) throws UnSupportedAudioFormatException{		

			this.adapter.play(audio);
			this.playState = true;
	}  
	
	public boolean getPlayState(){
		return playState;
	}
	
	public void stop(){
		this.playState =false;
	}
	
	public void registerPlugin(String audioType, Plugin plug){
		adapter.registerPlugin(audioType, plug);
		
	}
}

