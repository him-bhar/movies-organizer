package com.himanshu.moviesorganizer.business.filesystem.scanner;

import java.io.File;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileScannerTest {
  
  private static FileScanner fScanner;
  
  
  @BeforeClass
  public static void setup() {
    fScanner = new FileScanner(FileScannerTest.class.getResource("/").getFile().concat("/test/fs/data"));
  }
  
  @Test
  public void shouldListAllFileExceptMp3() {
    File[] files = fScanner.listFiles(".*.(.wmv|.dat)$");
    Assert.assertThat(files.length, Matchers.equalTo(2));
  }
}
