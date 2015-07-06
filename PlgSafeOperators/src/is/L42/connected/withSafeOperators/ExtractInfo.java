package is.L42.connected.withSafeOperators;

import ast.Ast.MethodType;
import ast.ExpCore;
import ast.ExpCore.ClassB.Member;
import ast.ExpCore.ClassB.MethodWithType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ast.Ast.Path;
import ast.ExpCore.*;
import coreVisitors.CloneWithPath;
import coreVisitors.From;
import platformSpecific.javaTranslation.Resources;

public class ExtractInfo {
  static class IsUsed extends CloneWithPath{
    Path target;IsUsed(Path target){this.target=target;}
    Set<Path> whereUsed=new HashSet<>();
    public ExpCore visit(Path s) {
      if(From.fromP(s, getPath()).equals(target)){
        whereUsed.add(getPath());
        }
      return super.visit(s);
      }
  public static Set<Path> of(ClassB cb,Path path){
    IsUsed iu=new IsUsed(path);
    cb.accept(iu);
    return iu.whereUsed;
    }
  }
  //path member is not a nestedclass
  //path is used
  public static void checkBox(ClassB cb,Path path) throws Resources.Error/*NotBox*/{
    List<String> meth=new ArrayList<>();
    for(ClassB.Member m:cb.getMs()){
      m.match(nc->false, mi->meth.add(mi.getS().toString()), mt->meth.add(mt.getMs().toString()));
      }
    Set<Path> used = ExtractInfo.IsUsed.of(cb,Path.outer(0));
    if(meth.isEmpty()&& used.isEmpty() && !cb.isInterface()){return;}
    throw Resources.Error.multiPartStringError("NotBox",
        "UsedBy",""+used,
        "ContainsMethods",""+meth,
        "IsInterface",""+cb.isInterface());
  }
  public static String memberKind(Member m){
    return m.match(
      nc->"NestedClass",
      mi->"InterfaceImplementedMethod",
      mt->(mt.getInner().isPresent())?"ImplementedMethod":"AbstractMethod");
  }
  public static void checkMethodClash(MethodWithType mta, MethodWithType mtb){
    boolean implClash=mta.getInner().isPresent() && mtb.getInner().isPresent();
    boolean exc=isExceptionOk(mta,mtb);
    List<Integer> pars=isParTypeOk(mta,mtb);
    boolean retType=mta.getMt().getReturnType().equals(mtb.getMt().getReturnType());
    boolean thisMdf=mta.getMt().getMdf().equals(mtb.getMt().getMdf());
    if(!implClash && exc && pars.isEmpty() && retType && thisMdf){return;}
    throw Resources.Error.multiPartStringError("MethodClash",
    "left",sugarVisitors.ToFormattedText.of(mta),
    "right",sugarVisitors.ToFormattedText.of(mtb),
    "leftKind",memberKind(mta),
    "rightKind",memberKind(mtb),
    "incompatibleHeader",""+(!exc||!pars.isEmpty() || !retType || !thisMdf),
    "differentParameters",""+ pars,
    "differentReturnType",""+ !retType,
    "differentThisMdf",""+ !thisMdf,
    "incompatibleException",""+!exc);
  }
  static Resources.Error clashImpl(Member ma, Member mb) {
    throw Resources.Error.multiPartStringError("MethodClash",
        "left",sugarVisitors.ToFormattedText.of(ma),
        "right",sugarVisitors.ToFormattedText.of(mb),
        "leftKind",memberKind(ma),
        "rightKind",memberKind(mb),
        "incompatibleHeader",""+false,//ok to have all at false to keep a single kind of error?
        "differentParameters",""+ false,
        "differentReturnType",""+ false,
        "differentThisMdf",""+ false,
        "incompatibleException",""+false);
  }
  private static List<Integer> isParTypeOk(MethodWithType mta, MethodWithType mtb) {
    List<Integer>res=new ArrayList<>();
    for(int i=0;i<mta.getMt().getTs().size();i++){
      if(!mta.getMt().getTs().get(i).equals(mtb.getMt().getTs().get(i))){res.add(i);}
    }
    return res;
  }
  private static boolean isExceptionOk(MethodWithType mta, MethodWithType mtb) {
    Set<Path> pa=new HashSet<>(mta.getMt().getExceptions());
    Set<Path> pb=new HashSet<>(mtb.getMt().getExceptions());
    Set<Path> pc=new HashSet<>(pa);
    pc.retainAll(pb);
    if(mta.getInner().isPresent() && !pc.containsAll(pa)){return false;}
    if(mtb.getInner().isPresent() && !pc.containsAll(pb)){return false;}
    return true;
  }
}
