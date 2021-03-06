package is.L42.connected.withSafeOperators;
import ast.ExpCore.*;
import ast.ExpCore.ClassB.Phase;
import auxiliaryGrammar.Locator;
import programReduction.Program;
import ast.ExpCore;
import ast.Ast.Path;
import coreVisitors.CloneWithPath;
public class IsValidCompleteCode {
  boolean isComplete(ClassB cb){
    boolean[]found={false};
    cb.accept(new CloneWithPath(){
    @Override protected Path liftP(Path p){
        Locator l=this.getLocator().copy();
        if(p.outerNumber()>l.size()){found[0]=true;}
        return super.liftP(p);
      }
    });
    return found[0];
  }
  void ensureWellTyped(ClassB cb){//In case of error, should be false or error?
    newTypeSystem.TypeSystem.instance().topTypeLib(Phase.Typed, Program.emptyLibraryProgram().updateTop(cb));
  }
}
