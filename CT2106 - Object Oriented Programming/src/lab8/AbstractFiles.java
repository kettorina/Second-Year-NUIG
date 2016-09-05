package lab8;

public abstract class AbstractFiles {
	
	protected String name;
	
	public abstract int size();//abstract methods such as size(),
	public abstract int getNumFiles();//getNumFiles(),
	public abstract int getNumFolders();//getNumFolders()
	
	public String getName(){
		return name;
	}
}
