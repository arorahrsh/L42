package newTypeSystem;

import java.util.ArrayList;
import java.util.List;

import ast.Ast.Doc;
import ast.Ast.Mdf;
import ast.Ast.Type;
import ast.Ast.Path;
import ast.Ast.Position;
import ast.Ast.SignalKind;
import ast.ErrorMessage;
import ast.ExpCore;
import ast.ExpCore.Block;
import ast.ExpCore.ClassB;
import ast.ExpCore.Loop;
import ast.ExpCore.MCall;
import ast.ExpCore.Signal;
import ast.ExpCore.Using;
import ast.ExpCore.X;
import ast.ExpCore._void;
import platformSpecific.fakeInternet.PluginWithPart.UsingInfo;
import ast.ExpCore.UpdateVar;
import tools.Assertions;

public interface TsOperations extends TypeSystem{
    
    default TOut tsPath(TIn in, ExpCore.EPath s) {
      Type t=new Type(Mdf.Class,s.getInner(),Doc.empty());
      if(s.getInner().isCore()){    
        ClassB cb=in.p.extractClassB(s.getInner());
        assert cb!=null;
        if(cb.isInterface()){t=t.withPath(Path.Any());}
        }
      ErrorKind subErr=TypeSystem.subtype(in.p, t, in.expected);
      if(subErr==null){
        return new TOk(in,s,t);
        }
      TErr out=new TErr(in,"----",t,subErr);
      return out;
      }

    default TOut tsX(TIn in, X s) {
    //D |-x ~> x :D.G(x) <= T | emptyTr
    //  D.p|- D.G(x) <= T
    Type nt=in.g(s.getInner());
    ErrorKind subErr=TypeSystem.subtype(in.p,nt,in.expected);
    if(subErr==null){
      return new TOk(in,s,nt);
      }
    return new TErr(in,"",nt,subErr);
    }

    default TOut tsVoid(TIn in, _void s) {
    //D |- void~> void:imm Void <= T | emptyTr
    //D.p|-imm Void <= T
    Type t=Path.Void().toImmNT();
    ErrorKind subErr=TypeSystem.subtype(in.p, t, in.expected);
    if(subErr==null){
      return new TOk(in,s,t);
      }
    TErr out=new TErr(in,"misplaced void constant",t,subErr);
    return out;
    }

    default TOut tsUsing(TIn in, Using s) {
    //D |- use P check m(x1:e1.. xn:en) e0 ~>use P check m(x1:e'1.. xn:e'n) e'0 :T0 <= T | Tr0 U..U Trn
    //  plugin(D.p,P,m(x1..xn))=plg, T1..Tn->T0;empty //plg is a free variable, in the small step reduction would be the function representing the behaviour
    //  D.p|-T0 <= T
    //  forall i 0..n D|- ei ~> e'i : T'i <=Ti |Tri
    //Now plugings are assumed to always ask for imm/class parameters
    if (s.getPath().isPrimitive()){     
      throw new ErrorMessage.InvalidURL("No plug-in url present for primitive path "+s.getPath(),null);     
      }       
    List<Type> lt;try{lt = platformSpecific.fakeInternet.OnLineCode.pluginType(in.p, s);}
    catch(UsingInfo.NonExistantMethod nem){
      throw new ErrorMessage.PluginMethodUndefined(null,s,null,Position.noInfo);  
    }
    assert s.getEs().size()==lt.size()-1;
    ErrorKind k=TypeSystem.subtype(in.p,lt.get(0),in.expected);
    if(k!=null){return new TErr(in,"",lt.get(0),k);}
    List<ExpCore> newEs=new ArrayList<>();
    TOut out0=type(in.withE(s.getInner(),lt.get(0)));
    if(!out0.isOk()){return out0;}
    TOk okAcc=out0.toOk();
    {int i=-1;for(ExpCore ei:s.getEs()){i+=1;       
      Type ti=lt.get(i+1);//1..n      
      assert ti.getMdf()==Mdf.Immutable || ti.getMdf()==Mdf.Class;
      TOut outi=type(in.withE(ei,ti));
      if(!outi.isOk()){return outi;}
      newEs.add(outi.toOk().annotated);
      okAcc=okAcc.trUnion(outi.toOk());
      }}
    okAcc=okAcc.withAC(s.withInner(okAcc.annotated).withEs(newEs),lt.get(0));
    return okAcc;
    }

    default TOut tsSignal(TIn in, Signal s) {
      //D |- throw[_,_] e~> throw[T0,T3] e' : T0 <= T0 | Tr
      //  T1 = resolve(D.p,guessType(D.G,e))// Note, resolves and guessTypes can go in error, and need to become a type error here
      //  if throw=exception, T2= imm T1.P and Tr=Ts;Ps,P
      //  if throw=error,     T2= imm T1.P and Tr=Ts;Ps
      //  if throw=return,    T2= (fwd T1) and Tr=(Ts,T3);Ps 
      //  D|- e~>  e' :  T3 <=T2|Ts;Ps
      Type T1=GuessTypeCore._of(in.p,in, s.getInner(),true);
      assert T1!=null;
      Type T2;      
      if(s.getKind()!=SignalKind.Return){
        T2=T1.getPath().toImmNT();
        }
      else{T2=TypeManipulation.fwd(T1);}
      TOut innerT=type(in.withE(s.getInner(), T2));
      if(!innerT.isOk()){return innerT.toError();}
      TOk res=innerT.toOk();
      Type T3=res.computed;
      if(s.getKind()==SignalKind.Return){res=res.returnsAdd(T3);}
      if(s.getKind()==SignalKind.Exception){res=res.exceptionsAdd(T3.getPath());}
      s=s.withInner(res.annotated).withTypeIn(T3).withTypeOut(in.expected);
      return res.withAC(s,in.expected);
    }

    default TOut tsClassB(TIn in, ClassB s) {
    //D |- L ~> L' : imm Library <= T | emptyTr
    //D.p|-imm Library <= T
    //D.Phase  |- D.p.evilPush(L) ~> L'
    Type t=Path.Library().toImmNT();
    ErrorKind subErr=TypeSystem.subtype(in.p, t, in.expected);
    if(subErr!=null){
      TErr out=new TErr(in,"-----------",t,subErr);
      return out;  
      }
    TOut out=typeLib(in.withP(in.p.evilPush(s)));
    if(out.isOk()){
      return new TOk(in,out.toOk().annotated,t);
      }
    return out.toError().enrich(in);
    }

    default TOut tsLoop(TIn in, Loop s) {
    //D |- loop e ~> loop e' : imm Void <= T | Tr
    //  D.p|-imm Void <= T
    //  D|- e ~> e' : _ <= imm Void | Tr
    TOut innerT=type(in.withE(s.getInner(), Path.Void().toImmNT()));
    if(!innerT.isOk()){return innerT.toError();}
    ErrorKind subErr=TypeSystem.subtype(in.p, Path.Void().toImmNT(),in.expected);
    if(subErr==null){
      TOk res= new TOk(in,s.withInner(innerT.toOk().annotated),innerT.toOk().computed);
      res=res.trUnion(innerT.toOk());
      return res;
      }
    return new TErr(in,"",Path.Void().toImmNT(),subErr);
    }

    default TOut tsUpdateVar(TIn in, UpdateVar s) {
      //D |-x:=e ~> x:=e' :imm Void <= T | Tr
       //     where
       //     D.G(x).var?=var
       //     D.p|- imm Void <= T
       //     D|- e ~> e':_<=D.G(x).T|Tr
       //     not fwd_or_fwd%_in(D.G(x).T)
      if(!in.gVar(s.getVar())){
        assert false;
        //TODO: return TErr locked var to improve
        }
      ErrorKind subErr=TypeSystem.subtype(in.p, Path.Void().toImmNT(),in.expected);
      if(subErr!=null){
        assert false;//strange exp like Foo(a:=b)
        }
      Type expected=in.g(s.getVar());
      if(TypeManipulation.fwd_or_fwdP_in(expected.getMdf())){
        assert false;//can it even happen or is blocked by well formedness before?
        }
      TOut innerT=type(in.withE(s.getInner(), expected));
      if(!innerT.isOk()){return innerT;}
      TOk ok=innerT.toOk();
      ok=ok.withAC(s.withInner(ok.annotated), Path.Void().toImmNT());
      return ok;
      }

}
