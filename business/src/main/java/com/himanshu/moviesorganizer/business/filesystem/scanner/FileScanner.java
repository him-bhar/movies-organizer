package com.himanshu.moviesorganizer.business.filesystem.scanner;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Preconditions;

public class FileScanner {
  private final File rootDir;
  
  public FileScanner(String rootDir) {
    Preconditions.checkNotNull(rootDir, "rootDir cannot be null");
    this.rootDir = new File(rootDir);
    Preconditions.checkArgument(this.rootDir.isDirectory(), "rootDir not a valid directory");
  }
  
  public File[] listFiles(String regex) {  //Regex will be something like including brackets:  (.mpg|.dat)
    Pattern fileExtensionPattern = Pattern.compile(regex);
    File[] files = this.rootDir.listFiles((directory, name) -> {
      Matcher m  = fileExtensionPattern.matcher(name);
      return m.matches();
    });
    return files;
  }
}
