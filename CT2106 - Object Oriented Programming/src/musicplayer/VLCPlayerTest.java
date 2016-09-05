package musicplayer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class VLCPlayerTest {

	VLCPlayer player;

	@Before
	public void setUp(){
		player = new VLCPlayer();
		player.registerPlugin("ogg", new OGGPlugin());
		player.registerPlugin("mp3", new MP3Plugin());
		player.registerPlugin("wma", new WMAPlugin());
	}

	// test that the OGG plugin is working with the player
	@Test
	public void testOGG() {
		AudioFile oggFile = new AudioFile("ogg", "C://Music/Amator_Silenti.ogg");
		try{
			player.play(oggFile);
		}catch(UnSupportedAudioFormatException e){
			System.out.println(e.getMessage());
		}
		assertTrue(player.getPlayState()); // assert that the Player is playing
		player.stop();
	}

	// test that the MP3 plugin is working with the player
	@Test
	public void testMP3() {

		AudioFile mp3File = new AudioFile("mp3", "C://Music/Vicissitudes.mp3");
		try{
			player.play(mp3File);
		}catch(UnSupportedAudioFormatException e){
			System.out.println(e.getMessage());
		}

		assertTrue(player.getPlayState()); // assert that the Player is playing
		player.stop();
	}

	// test that the WMA plugin is working with the player
	@Test
	public void testWMA() {
		AudioFile wmaFile = new AudioFile("wma", "C://Music/Lucky_Seven.wma");
		try{
			player.play(wmaFile);

		}catch(UnSupportedAudioFormatException e){
			System.out.println(e.getMessage());
		}
		assertTrue(player.getPlayState()); // assert that the Player is playing
		player.stop();
	}

	// test the correct unsupported audio behaviour
	@Test
	public void testUnsupportedAudio() {
		AudioFile aacFile = new AudioFile("aac", "C://Music/In_Silent_Way.aac");
		try{
			player.play(aacFile);

		}catch(UnSupportedAudioFormatException e){
			System.out.println(e.getMessage());
		}
		assertTrue(!player.getPlayState()); // assert that the Player is not playing
		player.stop();
	}

}
