package lab8;

public class File extends AbstractFiles {
	
	private String name;
	private int size;
	
	
	public File(String nm){
		this.name = nm;
		this.size = nm.length(); // for demo purposes the size of the file is the number of characters in its name
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public int getNumFiles() {
		return 1;
	}
	
	@Override
	public int getNumFolders() {
		return 0;
	}
}
