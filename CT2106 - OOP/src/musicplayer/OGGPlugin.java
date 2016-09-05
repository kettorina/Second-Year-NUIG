package musicplayer;

public class OGGPlugin implements Plugin{
	
	private static String format = "ogg";
	   
	@Override
	   public void play(AudioFile audio) throws UnSupportedAudioFormatException{
		if(audio.getAudioType().equals(format)){
	      System.out.println("Playing ogg file: "+ audio.getFileName());
	      
		}else{
			throw new UnSupportedAudioFormatException("unsupported format: "
					+ audio.getAudioType());
		}
	   }

	}