package newTypeSystem;
import ast.Ast.MethodType;
import ast.Ast.NormType;
import ast.Ast.Type;
import ast.Ast.Path;
import ast.ExpCore.ClassB.Member;
import ast.ExpCore.ClassB.MethodWithType;
import auxiliaryGrammar.WellFormednessCore;
import coreVisitors.From;
import programReduction.Program;
import tools.Map;

import java.util.ArrayList;
import java.util.List;

import ast.Ast.Mdf;
import ast.Ast.MethodSelector;

import static newTypeSystem.TypeManipulation.*;

public class AlternativeMethodTypes {

  static MethodType mBase(Program p, Path P, MethodSelector ms){
//p(P)(ms).mh[from P]=refine? mdf0 method T m(T1 x1,..Tn xn) exception Ps
//T'=fwd% T if fwd_or_fwd%_in(Ts)
//otherwise T'=T       
//(mBase)-------------------------------------------------------------------
//mdf0 P T1..Tn-> T';Ps in methTypes(p,P,ms)    MethodWithType mwt = (MethodWithType) p.extractClassB(P)._getMember(ms);
    MethodWithType mwt = (MethodWithType) p.extractClassB(P)._getMember(ms);
    assert mwt!=null;
    MethodType mt=From.from(mwt.getMt(),P);
    return mBase(mt);
    }
  static MethodType mBase(MethodType mt){
  NormType retT=mt.getReturnType().getNT();    
    if (fwd_or_fwdP_in(mt.getTs())){
      retT=fwdP(mt.getReturnType().getNT());
    }
    return mt.withReturnType(retT);
    }
  static MethodType mNoFwd(MethodType mt){
//  Ts->T;Ps in methTypes(p,P,ms) 
//(mNoFwd)-------------------------------------------------------------------
//  noFwd Ts-> noFwd T;Ps in methTypes(p,P,ms)
    List<Type> ts = Map.of(t->noFwd(t.getNT()),mt.getTs());
    Type retT=noFwd(mt.getReturnType().getNT());
    return mt.withReturnType(retT).withTs(ts);
    }

  static MethodType _mC(MethodType mt){
//Ts->mut P0;Ps in methTypes(p,P,ms)
//(mC)-------------------------------------------------------------------
//mutToCapsule(Ts)->capsule P0;Ps in methTypes(p,P,ms)
    NormType retT=mt.getReturnType().getNT();
    if(retT.getMdf()!=Mdf.Mutable){return null;}
    retT=retT.withMdf(Mdf.Capsule);
    List<Type> ts = Map.of(t->mutToCapsule(t.getNT()),mt.getTs());
    return mt.withReturnType(retT).withTs(ts);
    }
  static MethodType _mI(MethodType mt){
//Ts->read P0;Ps in methTypes(p,P,ms) //by well formedness if return type is read, not fwd_or_fwd%_in Ts
//(mI)-------------------------------------------------------------------
//toImmOrCapsule(Ts)->imm P0;Ps in methTypes(p,P,ms) 
////the behaviour of immorcapsule on fwd is not relevant since the method
//// returns a read and will be not well formed if it had fwd parameters
    NormType retT=mt.getReturnType().getNT();
    if(retT.getMdf()!=Mdf.Readable){return null;}
    retT=retT.withMdf(Mdf.Immutable);
    List<Type> ts = Map.of(t->toImmOrCapsule(t.getNT()),mt.getTs());
    return mt.withReturnType(retT).withTs(ts);
    }
  static MethodType _mVp(MethodType mt, int parNum){
//Ts0 mut P Ts2->T;Ps in methTypes(p,P,ms)
//Ts'=mutToCapsule(Ts0) lent P mutToCapsule(Ts2) //this implies not fwd_or_fwd%_in Ts0,Ts2
//(mVp)-------------------------------------------------------------------
//Ts'->toLent(T);Ps in methTypes(p,P,ms)
    NormType pN=mt.getTs().get(parNum).getNT();
    if (pN.getMdf()!=Mdf.Mutable){return null;}
    NormType retT=mt.getReturnType().getNT();
    retT=_toLent(retT);
    if(retT==null){return null;}
    List<Type> ts = Map.of(t->mutToCapsule(t.getNT()),mt.getTs());
    ts.set(parNum, pN.withMdf(Mdf.Lent));
    MethodType res= mt.withReturnType(retT).withTs(ts);
    if(WellFormednessCore.methodTypeWellFormed(res)){return res;}
    return null;
    }
  static MethodType _mImmFwd(MethodType mt){
//Ts->fwd%Mut P0;Ps in methTypes(p,P,ms)
//fwd_or_fwd%_in(Ts)
//(mImmFwd)-------------------------------------------------------------------
//mutToCapsuleAndFwdMutToFwdImm(Ts)->fwd%Imm P0;Ps in methTypes(p,P,ms)
    if(!TypeManipulation.fwd_or_fwdP_in(mt.getTs())){return null;}
    NormType retT=mt.getReturnType().getNT();
    if(retT.getMdf()!=Mdf.MutablePFwd){return null;}
    retT=retT.withMdf(Mdf.ImmutablePFwd);
    List<Type> ts = Map.of(t->mutToCapsuleAndFwdMutToFwdImm(t.getNT()),mt.getTs());
    MethodType res= mt.withReturnType(retT).withTs(ts);
    if(WellFormednessCore.methodTypeWellFormed(res)){return res;}
    return null;
    }
  static MethodType _mRead(MethodType mt){
//Ts->fwd%Mut P0;Ps in methTypes(p,P,ms)
//fwd_or_fwd%_in(Ts)
//(mRead)-------------------------------------------------------------------
//mutToCapsuleAndFwdMutToRead(Ts)->read P0;Ps in methTypes(p,P,ms)
    if(!TypeManipulation.fwd_or_fwdP_in(mt.getTs())){return null;}
    NormType retT=mt.getReturnType().getNT();
    if(retT.getMdf()!=Mdf.MutablePFwd){return null;}
    retT=retT.withMdf(Mdf.Readable);
    List<Type> ts = Map.of(t->mutToCapsuleAndFwdMutToRead(t.getNT()),mt.getTs());
    MethodType res=mt.withReturnType(retT).withTs(ts);
    if(WellFormednessCore.methodTypeWellFormed(res)){return res;}
    return null;
    }
  
  static void add(List<MethodType>l,MethodType t){
    if(t==null){return;}
    l.add(t);
    }
  static List<MethodType> types(Program p, Path P, MethodSelector ms){
    List<MethodType>res=new ArrayList<>();
    MethodType base=mBase(p,P,ms);
    add(res,base);
    MethodType mNoFwd=mBase(p,P,ms);
    add(res,mNoFwd);
    MethodType mImmFwd=_mImmFwd(base);
    add(res,mImmFwd);
    MethodType mRead=_mRead(base);
    add(res, mRead);
    add(res,_mC(base));
    add(res,_mC(mNoFwd));
    add(res,_mI(base));
    if(mRead!=null){add(res,_mI(mRead));}
    if(mImmFwd!=null){add(res,mNoFwd(mImmFwd));}  
    {int i=-1;for(Type ti:base.getTs()){i+=1;
      if(ti.getNT().getMdf()!=Mdf.Mutable){continue;}
      add(res,_mVp(base,i)); //1 mType for each mut parameter
      }}
    {int i=-1;for(Type ti:mNoFwd.getTs()){i+=1;
    if(ti.getNT().getMdf()!=Mdf.Mutable){continue;}
    add(res,_mVp(mNoFwd,i)); //1 mType for each mut parameter
    }}
    return res;
  }
  }
