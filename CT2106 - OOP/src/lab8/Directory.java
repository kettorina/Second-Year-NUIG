package lab8;

import java.util.ArrayList;

public class Directory extends AbstractFiles{

	ArrayList<AbstractFiles> abstractfiles;

	public Directory(String string) {
		this.name=string;
		this.abstractfiles = new ArrayList<AbstractFiles> ();
	}

	public void add(AbstractFiles z) {
		
		this.abstractfiles.add(z);
		
	}//this way you add objects of abstractFiles together not just files and separate 
	 //folders

	/**
	 * @return the size of files in the folders
	 */
	@Override
	public int size() {
		int size = 0;
		for (AbstractFiles abstr: abstractfiles)
		{
			size+=abstr.size();
		}
		return size;
	}
	/**
	 * @return number of files in directories and sub directories
	 */
	@Override
	public int getNumFiles() {
		int numFiles=0;
		for(AbstractFiles abstr: abstractfiles)
		{
			numFiles+=abstr.getNumFiles();
		}
		return numFiles;
	}
	/**
	 * @return the number folders in sub directories and directories
	 */
	@Override
	public int getNumFolders() {
		int numFolders=0;
		for (AbstractFiles abstr: abstractfiles)
		{
			if (abstr instanceof Directory)
			{
				numFolders++;
				numFolders+=abstr.getNumFolders();
			}
		}
		return numFolders;
	}

}
