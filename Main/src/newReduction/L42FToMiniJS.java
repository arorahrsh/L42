package newReduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ast.Ast.SignalKind;
import ast.L42F;
import ast.L42F.Block;
import ast.L42F.Body;
import ast.L42F.BreakLoop;
import ast.L42F.Call;
import ast.L42F.Cast;
import ast.L42F.Cn;
import ast.L42F.D;
import ast.L42F.If;
import ast.L42F.K;
import ast.L42F.Kind;
import ast.L42F.Loop;
import ast.L42F.Null;
import ast.L42F.SimpleKind;
import ast.L42F.Throw;
import ast.L42F.Unreachable;
import ast.L42F.Update;
import ast.L42F.Use;
import ast.L42F.X;
import ast.L42F._void;
import ast.MiniJ;
import ast.MiniJ.*;
import auxiliaryGrammar.Functions;
import facade.L42;
import l42FVisitors.JVisitor;
import l42FVisitors.Visitor;
import tools.Assertions;

import platformSpecific.javaTranslation.Resources;

public class L42FToMiniJS implements Visitor<MiniJ.S>{
  public L42FToMiniJS(ClassTable ct){
    assert ct!=null;
    this.ct = ct;
    }
  ClassTable ct;
  String x0=null;
  String label=null;
  boolean emptyC(){return x0==null && label==null;}
  MiniJ.S wrapE(MiniJ.E e){
    if(emptyC()){return new MiniJ.Return(e);}
    if(x0!=null){return new MiniJ.VarAss(x0, e);}
    return e;
    }
  public static MiniJ.S forBody(ClassTable ct, L42F.E body){
    body=body.accept(new OptimizeBlock());
    S res=body.accept(new L42FToMiniJS(ct));
    if(res instanceof MiniJ.B){return res;}
    if(res instanceof MiniJ.RawJ){return res;}
    MiniJ.B b=new MiniJ.B(null,Collections.singletonList(res));
    return b;
    }
  MiniJ.S liftWith(String x0,String label,L42F.E inner){
    String oldX0=this.x0;
    String oldLabel=this.label;
    this.x0=x0;
    this.label=label;
    try{return inner.accept(this);}
    finally{this.x0=oldX0;this.label=oldLabel;}
  }

  @Override
  public MiniJ.S visit(BreakLoop s) {
    if(label==null){throw Assertions.codeNotReachable();}
    return new MiniJ.Break(label);
    }

  @Override
  public MiniJ.S visit(X s) {
    return wrapE(new MiniJ.X(L42FToMiniJ.liftX(s.getInner())));
    }

  @Override
  public MiniJ.S visit(Cn s) {
    boolean classAny = isClassAny(s);
    if(classAny){
      E e=new MiniJ.MCall("generated.Resource", "£COf_"+s.getInner(), Collections.emptyList());
      return wrapE(e);
    }
    String name=ct.l42ClassName(s.getInner());
    E e=new MiniJ.MCall(name, "Instance", Collections.emptyList());
    return wrapE(e);
    }
  private boolean isClassAny(Cn s) {
    if(L42F.Cn.cnAny.equals(s)){return true;}
    if(L42F.Cn.cnFwd.getInner()>=s.getInner()){return false;}
    ast.L42F.CD cd=ct.get(s.getInner()).cd;
    Kind k = cd.getKind();
    boolean classAny=false;
    if(k==null || k==SimpleKind.Interface){classAny=true;}
    return classAny;
    }

  @Override
  public MiniJ.S visit(_void s) {
    String name=Resources.Void.class.getCanonicalName();
    E e=new MiniJ.MCall(name, "Instance", Collections.emptyList());
    return wrapE(e);
    }

  @Override
  public MiniJ.S visit(Null s) {
    MiniJ.E e=new MiniJ.Null();
    return wrapE(e);
    }

  @Override
  public MiniJ.S visit(Call s) {
    E e=new MiniJ.MCall(
      ct.l42ClassName(s.getCn()),
      L42FToMiniJ.liftMs(s.getMs()),
      tools.Map.of(L42FToMiniJ::liftX,s.getXs())
      );
    return wrapE(e);
    }

@Override
  public MiniJ.S visit(Use s) {
    S inner=liftWith(null,null,s.getInner());
    E e=new MiniJ.UseCall(s.getDoc(),s.getUi(),
            L42FToMiniJ.liftMs(s.getMs()),
            tools.Map.of(L42FToMiniJ::liftX, s.getXs()),inner);
    return wrapE(e);
    }
  @Override
  public MiniJ.S visit(Throw s) {
    return new MiniJ.Throw(s.getKind(), L42FToMiniJ.liftX(s.getX()));
    }

  @Override
  public MiniJ.S visit(Loop s) {
    String label0=Functions.freshName("label",L42.usedNames);
    S inner=liftWith(null,label0,s.getInner());
    return new MiniJ.WhileTrue(label0,inner);
    }
  @Override
  public MiniJ.S visit(Cast s) {
    String cn = ct.className(s.getT().getCn());
    return wrapE(new MiniJ.Cast(cn,L42FToMiniJ.liftX(s.getX())));
    }
  @Override
  public MiniJ.S visit(Update s) {
    return new MiniJ.VarAss(L42FToMiniJ.liftX(s.getX1()), new MiniJ.X(L42FToMiniJ.liftX(s.getX2())));
    }
  @Override
  public MiniJ.S visit(If s) {
    S then=s.getThen().accept(this);
    S _else=s.get_else().accept(this);
    return new MiniJ.If(L42FToMiniJ.liftX(s.getCondition()), then, _else);
  }

  @Override
  public MiniJ.S visit(Block s) {
    String label0=null;
    List<S>ds=new ArrayList<>();
    for(D di:s.getDs()){
      ds.add(liftDsTX(di));
      }
    if(s.getKs().isEmpty()){
      for(D di:s.getDs()){
        ds.add(liftDsXE(di));
        }
      }
    else{
      label0=Functions.freshName("label",L42.usedNames);
      List<S>dsTry=new ArrayList<>();
      for(D di:s.getDs()){
        dsTry.add(liftDsXE(di));
        }
      List<MiniJ.K> ks=liftKs(label0,s.getKs());
      Try t=new Try(new B(null,dsTry),ks);
      ds.add(t);
      }
    if(!(s.getE() instanceof Unreachable)){
      ds.add(s.getE().accept(this));
      }
    return new B(label0,ds);
    }
  private List<MiniJ.K> liftKs(String label0,List<K> ks) {
    List<K> errs=new ArrayList<>();
    List<K> excs=new ArrayList<>();
    List<K> rets=new ArrayList<>();
    for(K k:ks) {
      if (k.getKind()==SignalKind.Error) {errs.add(k);}
      if (k.getKind()==SignalKind.Exception) {excs.add(k);}
      if (k.getKind()==SignalKind.Return) {rets.add(k);}
      }
    List<MiniJ.K> tot=new ArrayList<>();
    liftKs(label0,SignalKind.Error,errs,tot);
    liftKs(label0,SignalKind.Exception,excs,tot);
    liftKs(label0,SignalKind.Return,rets,tot);
    return tot;

    }
  private void liftKs(String label0,SignalKind kind,List<K> ks,List<MiniJ.K> acc) {
    if(ks.isEmpty()){return;}
    String catchX=Functions.freshName("catchX",L42.usedNames);
    S s=new MiniJ.Throw(null, catchX);
    Collections.reverse(ks);
    boolean isTerminating=true;
    for(K ki:ks){
      isTerminating=isTerminating&& ki.getE().accept(new Terminating());
      String cn = ct.boxedClassName(ki.getT().getCn());
      S then = ki.getE().accept(this);
      boolean positive=Cn.cnLibrary.getInner()!=ki.getT().getCn();
      if(!positive) {
        cn=NotLibrary.class.getCanonicalName();
      }
      s=new MiniJ.IfTypeCase(positive,catchX, L42FToMiniJ.liftX(ki.getX()), cn, then,s);
      }
    List<S>ss=new ArrayList<>();
    ss.add(s);
    if(!emptyC() &&!isTerminating){
      ss.add(new MiniJ.Break(label0));
      }
    B b=new B(null,ss);
    MiniJ.K res=new MiniJ.K(kind, catchX, b);
    acc.add(res);
    }
  private S liftDsXE(D di) {
    return liftWith(L42FToMiniJ.liftX(di.getX()), label, di.getE());
  }

  private S liftDsTX(D di) {
    return new MiniJ.VarDec(ct.className(di.getT().getCn()),L42FToMiniJ.liftX(di.getX()));
  }
@Override
public S visit(Unreachable s) { throw Assertions.codeNotReachable();}

}
