package lab8;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DirectoryTest {
	
	static Directory documents;
	
	@Before 
	public void setUp() throws Exception{
		documents = new Directory("Documents");
		Directory music = new Directory("Music"),
		photos = new Directory("Photos"), dylan = new Directory("Dylan"), band = new Directory("Band");
		
		File a = new File("assign1.doc"), b = new File("family.jpg"), c = new File("tambourine.pm3"), 
				d = new File("dixie.mp3"), e = new File("weight.mp3");

		documents.add(a);
		documents.add(music);
		documents.add(photos);
		photos.add(b);
		music.add(dylan);
		music.add(band);
		dylan.add(c);
		band.add(d);
		band.add(e);
	}
	
	@Test
	public void testSize() {
		int expectedSize = 54;
		int sizeResult = documents.size();
		assertTrue(expectedSize==sizeResult);
	}

	@Test
	public void testGetnumFiles() {
		int expectedNumFiles = 5;
		int numFilesResult = documents.getNumFiles();
		assertTrue(expectedNumFiles==numFilesResult);
	}

	@Test
	public void testGetnumFolders() {
		int expectedNumFolders = 4;
		int numFoldersResult = documents.getNumFolders();
		assertTrue(expectedNumFolders==numFoldersResult);
	}

}
