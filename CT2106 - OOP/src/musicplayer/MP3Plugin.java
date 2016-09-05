package musicplayer;

public class MP3Plugin implements Plugin {

	private static String format = "mp3";
	   
	@Override
	   public void play(AudioFile audio) throws UnSupportedAudioFormatException {
		
		if(audio.getAudioType().equals(format)){
	      System.out.println("Playing mp3 file: "+ audio.getFileName());
	      
		} else{
			throw new UnSupportedAudioFormatException("unsupported format: "
					+ audio.getAudioType());
		}
	   }
}
