package repl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import facade.L42;
import helpers.TestHelper;
import profiling.Timer;

public class ReplTest {
public static void main(String[]arg)throws Throwable{
  ClassLoader.getSystemClassLoader()
  .setDefaultAssertionStatus(true);
  Timer.activate("TOP");
  ReplMain.main(arg);
  }
/*@Test
public void test() throws Throwable {
  ReplGui.main(null);
  this.wait(10000);
  }*/

}
