package musicplayer;

public class WMAPlugin implements Plugin{

	private static String format = "wma";

	@Override
	public void play(AudioFile audio) throws UnSupportedAudioFormatException{
		if(audio.getAudioType().equals(format)){   
			System.out.println("Playing wma file: "+ audio.getFileName());		
		}else{
			throw new UnSupportedAudioFormatException("unsupported format: "
					+ audio.getAudioType());
		}
	}
}
