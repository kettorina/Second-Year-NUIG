package musicplayer;

import java.util.HashMap;

public class PluginAdapter implements Plugin {

	private Plugin player;

	private HashMap <String, Plugin> plugins = new HashMap<String, Plugin>();
 
	

	@Override
	public void play(AudioFile audio) throws UnSupportedAudioFormatException {

		this.player = plugins.get(audio.getAudioType());

		if(player==null){
			throw new UnSupportedAudioFormatException("unsupported format: "
					+ audio.getAudioType());
		}

		this.player.play(audio);
	}


	public void registerPlugin(String audioType, Plugin plug) {
		plugins.put(audioType, plug);
	}
}


