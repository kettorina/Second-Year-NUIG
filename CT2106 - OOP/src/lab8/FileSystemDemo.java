package lab8;

public class FileSystemDemo {

	public static void main(String[] args) {

		Directory documents = new Directory("Documents"), music = new Directory("Music"),
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
		
		// expected results
		int expectedSize = 54;
		int expectedNumFiles = 5;
		int expectedNumFolders = 4;
		
		// results returned from the code
		int sizeResult = documents.size();
		int numFilesResult = documents.getNumFiles();
		int numFoldersResult = documents.getNumFolders();
		
		
		// testing to see if the expected results match the results returned from the code
		if(sizeResult==expectedSize){
			System.out.println("size = " + expectedSize + ": correct");
		}else{
			System.out.println("size returned = " + sizeResult + ": incorrect");
		}
		
		
		if(numFilesResult==expectedNumFiles){
			System.out.println("numFiles = " + expectedNumFiles + ": correct");
		}else{
			System.out.println("numFiles returned = " + numFilesResult + ": incorrect");
		}
		
		if(numFoldersResult==expectedNumFolders){
			System.out.println("NumFolders = " + expectedNumFolders + ": correct");
		}else{
			System.out.println("numFolders returned = " + numFoldersResult + ": incorrect");
		}

	}




}
