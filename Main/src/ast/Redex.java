// Generated by delombok at Fri Sep 01 12:17:59 NZST 2017
package ast;

import java.util.List;
import ast.ExpCore.Block;
import ast.ExpCore.Signal;

public interface Redex {

  static Redex invalid() {
    return NoRedex.instance;
  }

  final class NoRedex implements Redex {
    private static final Redex instance = new NoRedex();

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public NoRedex() {
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Redex.NoRedex)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      int result = 1;
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Redex.NoRedex()";
    }
  }

  final class MethCall implements Redex {
    private final ExpCore.MCall that;

    @java.beans.ConstructorProperties({"that"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public MethCall(final ExpCore.MCall that) {
      this.that = that;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ExpCore.MCall getThat() {
      return this.that;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Redex.MethCall)) return false;
      final MethCall other = (MethCall)o;
      final java.lang.Object this$that = this.getThat();
      final java.lang.Object other$that = other.getThat();
      if (this$that == null ? other$that != null : !this$that.equals(other$that)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $that = this.getThat();
      result = result * PRIME + ($that == null ? 0 : $that.hashCode());
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Redex.MethCall(that=" + this.getThat() + ")";
    }
  }

  final class Garbage implements Redex {
    private final ExpCore thatLessGarbage;

    @java.beans.ConstructorProperties({"thatLessGarbage"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Garbage(final ExpCore thatLessGarbage) {
      this.thatLessGarbage = thatLessGarbage;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ExpCore getThatLessGarbage() {
      return this.thatLessGarbage;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Redex.Garbage)) return false;
      final Garbage other = (Garbage)o;
      final java.lang.Object this$thatLessGarbage = this.getThatLessGarbage();
      final java.lang.Object other$thatLessGarbage = other.getThatLessGarbage();
      if (this$thatLessGarbage == null ? other$thatLessGarbage != null : !this$thatLessGarbage.equals(other$thatLessGarbage)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $thatLessGarbage = this.getThatLessGarbage();
      result = result * PRIME + ($thatLessGarbage == null ? 0 : $thatLessGarbage.hashCode());
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Redex.Garbage(thatLessGarbage=" + this.getThatLessGarbage() + ")";
    }
  }

  final class Ph implements Redex {
    private final ExpCore.Block that;
    private final int phIndex;

    @java.beans.ConstructorProperties({"that", "phIndex"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Ph(final ExpCore.Block that, final int phIndex) {
      this.that = that;
      this.phIndex = phIndex;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ExpCore.Block getThat() {
      return this.that;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getPhIndex() {
      return this.phIndex;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Redex.Ph)) return false;
      final Ph other = (Ph)o;
      final java.lang.Object this$that = this.getThat();
      final java.lang.Object other$that = other.getThat();
      if (this$that == null ? other$that != null : !this$that.equals(other$that)) return false;
      if (this.getPhIndex() != other.getPhIndex()) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $that = this.getThat();
      result = result * PRIME + ($that == null ? 0 : $that.hashCode());
      result = result * PRIME + this.getPhIndex();
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Redex.Ph(that=" + this.getThat() + ", phIndex=" + this.getPhIndex() + ")";
    }
  }

  final class Using implements Redex {
    private final ExpCore.Using that;
    private final ExpCore toReplace;

    @java.beans.ConstructorProperties({"that", "toReplace"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Using(final ExpCore.Using that, final ExpCore toReplace) {
      this.that = that;
      this.toReplace = toReplace;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ExpCore.Using getThat() {
      return this.that;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ExpCore getToReplace() {
      return this.toReplace;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Redex.Using)) return false;
      final Using other = (Using)o;
      final java.lang.Object this$that = this.getThat();
      final java.lang.Object other$that = other.getThat();
      if (this$that == null ? other$that != null : !this$that.equals(other$that)) return false;
      final java.lang.Object this$toReplace = this.getToReplace();
      final java.lang.Object other$toReplace = other.getToReplace();
      if (this$toReplace == null ? other$toReplace != null : !this$toReplace.equals(other$toReplace)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $that = this.getThat();
      result = result * PRIME + ($that == null ? 0 : $that.hashCode());
      final java.lang.Object $toReplace = this.getToReplace();
      result = result * PRIME + ($toReplace == null ? 0 : $toReplace.hashCode());
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Redex.Using(that=" + this.getThat() + ", toReplace=" + this.getToReplace() + ")";
    }
  }

  final class UsingOut implements Redex {
    private final ExpCore.Using that;

    @java.beans.ConstructorProperties({"that"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public UsingOut(final ExpCore.Using that) {
      this.that = that;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ExpCore.Using getThat() {
      return this.that;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Redex.UsingOut)) return false;
      final UsingOut other = (UsingOut)o;
      final java.lang.Object this$that = this.getThat();
      final java.lang.Object other$that = other.getThat();
      if (this$that == null ? other$that != null : !this$that.equals(other$that)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $that = this.getThat();
      result = result * PRIME + ($that == null ? 0 : $that.hashCode());
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Redex.UsingOut(that=" + this.getThat() + ")";
    }
  }

  final class LoopR implements Redex {
    private final ExpCore.Loop that;

    @java.beans.ConstructorProperties({"that"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public LoopR(final ExpCore.Loop that) {
      this.that = that;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ExpCore.Loop getThat() {
      return this.that;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Redex.LoopR)) return false;
      final LoopR other = (LoopR)o;
      final java.lang.Object this$that = this.getThat();
      final java.lang.Object other$that = other.getThat();
      if (this$that == null ? other$that != null : !this$that.equals(other$that)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $that = this.getThat();
      result = result * PRIME + ($that == null ? 0 : $that.hashCode());
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Redex.LoopR(that=" + this.getThat() + ")";
    }
  }

  final class BlockElim implements Redex {
    private final ExpCore.Block that;
    private final int elimIndex;

    @java.beans.ConstructorProperties({"that", "elimIndex"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public BlockElim(final ExpCore.Block that, final int elimIndex) {
      this.that = that;
      this.elimIndex = elimIndex;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ExpCore.Block getThat() {
      return this.that;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getElimIndex() {
      return this.elimIndex;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Redex.BlockElim)) return false;
      final BlockElim other = (BlockElim)o;
      final java.lang.Object this$that = this.getThat();
      final java.lang.Object other$that = other.getThat();
      if (this$that == null ? other$that != null : !this$that.equals(other$that)) return false;
      if (this.getElimIndex() != other.getElimIndex()) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $that = this.getThat();
      result = result * PRIME + ($that == null ? 0 : $that.hashCode());
      result = result * PRIME + this.getElimIndex();
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Redex.BlockElim(that=" + this.getThat() + ", elimIndex=" + this.getElimIndex() + ")";
    }
  }

  final class Subst implements Redex {
    private final ExpCore.Block that;
    private final int substIndex;

    @java.beans.ConstructorProperties({"that", "substIndex"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Subst(final ExpCore.Block that, final int substIndex) {
      this.that = that;
      this.substIndex = substIndex;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ExpCore.Block getThat() {
      return this.that;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getSubstIndex() {
      return this.substIndex;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Redex.Subst)) return false;
      final Subst other = (Subst)o;
      final java.lang.Object this$that = this.getThat();
      final java.lang.Object other$that = other.getThat();
      if (this$that == null ? other$that != null : !this$that.equals(other$that)) return false;
      if (this.getSubstIndex() != other.getSubstIndex()) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $that = this.getThat();
      result = result * PRIME + ($that == null ? 0 : $that.hashCode());
      result = result * PRIME + this.getSubstIndex();
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Redex.Subst(that=" + this.getThat() + ", substIndex=" + this.getSubstIndex() + ")";
    }
  }

  final class Meta implements Redex {
    private final ExpCore.ClassB that;

    @java.beans.ConstructorProperties({"that"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Meta(final ExpCore.ClassB that) {
      this.that = that;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ExpCore.ClassB getThat() {
      return this.that;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Redex.Meta)) return false;
      final Meta other = (Meta)o;
      final java.lang.Object this$that = this.getThat();
      final java.lang.Object other$that = other.getThat();
      if (this$that == null ? other$that != null : !this$that.equals(other$that)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $that = this.getThat();
      result = result * PRIME + ($that == null ? 0 : $that.hashCode());
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Redex.Meta(that=" + this.getThat() + ")";
    }
  }

  final class CaptureOrNot implements Redex {
    private final ExpCore.Block that;
    private final int throwIndex;
    private final Signal throwExtracted;

    @java.beans.ConstructorProperties({"that", "throwIndex", "throwExtracted"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CaptureOrNot(final ExpCore.Block that, final int throwIndex, final Signal throwExtracted) {
      this.that = that;
      this.throwIndex = throwIndex;
      this.throwExtracted = throwExtracted;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ExpCore.Block getThat() {
      return this.that;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getThrowIndex() {
      return this.throwIndex;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Signal getThrowExtracted() {
      return this.throwExtracted;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Redex.CaptureOrNot)) return false;
      final CaptureOrNot other = (CaptureOrNot)o;
      final java.lang.Object this$that = this.getThat();
      final java.lang.Object other$that = other.getThat();
      if (this$that == null ? other$that != null : !this$that.equals(other$that)) return false;
      if (this.getThrowIndex() != other.getThrowIndex()) return false;
      final java.lang.Object this$throwExtracted = this.getThrowExtracted();
      final java.lang.Object other$throwExtracted = other.getThrowExtracted();
      if (this$throwExtracted == null ? other$throwExtracted != null : !this$throwExtracted.equals(other$throwExtracted)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $that = this.getThat();
      result = result * PRIME + ($that == null ? 0 : $that.hashCode());
      result = result * PRIME + this.getThrowIndex();
      final java.lang.Object $throwExtracted = this.getThrowExtracted();
      result = result * PRIME + ($throwExtracted == null ? 0 : $throwExtracted.hashCode());
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Redex.CaptureOrNot(that=" + this.getThat() + ", throwIndex=" + this.getThrowIndex() + ", throwExtracted=" + this.getThrowExtracted() + ")";
    }
  }

  final class NoThrowRemoveOn implements Redex {
    private final ExpCore.Block that;

    @java.beans.ConstructorProperties({"that"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public NoThrowRemoveOn(final ExpCore.Block that) {
      this.that = that;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ExpCore.Block getThat() {
      return this.that;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Redex.NoThrowRemoveOn)) return false;
      final NoThrowRemoveOn other = (NoThrowRemoveOn)o;
      final java.lang.Object this$that = this.getThat();
      final java.lang.Object other$that = other.getThat();
      if (this$that == null ? other$that != null : !this$that.equals(other$that)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $that = this.getThat();
      result = result * PRIME + ($that == null ? 0 : $that.hashCode());
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Redex.NoThrowRemoveOn(that=" + this.getThat() + ")";
    }
  }

  final class FUpdateExtended implements Redex {
    private final ExpCore ctx;
    private final Block aroundCtx;
    private final int positionX;
    private final List<Block.Dec> dvs;

    @java.beans.ConstructorProperties({"ctx", "aroundCtx", "positionX", "dvs"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public FUpdateExtended(final ExpCore ctx, final Block aroundCtx, final int positionX, final List<Block.Dec> dvs) {
      this.ctx = ctx;
      this.aroundCtx = aroundCtx;
      this.positionX = positionX;
      this.dvs = dvs;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ExpCore getCtx() {
      return this.ctx;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Block getAroundCtx() {
      return this.aroundCtx;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getPositionX() {
      return this.positionX;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public List<Block.Dec> getDvs() {
      return this.dvs;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Redex.FUpdateExtended)) return false;
      final FUpdateExtended other = (FUpdateExtended)o;
      final java.lang.Object this$ctx = this.getCtx();
      final java.lang.Object other$ctx = other.getCtx();
      if (this$ctx == null ? other$ctx != null : !this$ctx.equals(other$ctx)) return false;
      final java.lang.Object this$aroundCtx = this.getAroundCtx();
      final java.lang.Object other$aroundCtx = other.getAroundCtx();
      if (this$aroundCtx == null ? other$aroundCtx != null : !this$aroundCtx.equals(other$aroundCtx)) return false;
      if (this.getPositionX() != other.getPositionX()) return false;
      final java.lang.Object this$dvs = this.getDvs();
      final java.lang.Object other$dvs = other.getDvs();
      if (this$dvs == null ? other$dvs != null : !this$dvs.equals(other$dvs)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $ctx = this.getCtx();
      result = result * PRIME + ($ctx == null ? 0 : $ctx.hashCode());
      final java.lang.Object $aroundCtx = this.getAroundCtx();
      result = result * PRIME + ($aroundCtx == null ? 0 : $aroundCtx.hashCode());
      result = result * PRIME + this.getPositionX();
      final java.lang.Object $dvs = this.getDvs();
      result = result * PRIME + ($dvs == null ? 0 : $dvs.hashCode());
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Redex.FUpdateExtended(ctx=" + this.getCtx() + ", aroundCtx=" + this.getAroundCtx() + ", positionX=" + this.getPositionX() + ", dvs=" + this.getDvs() + ")";
    }
  }
}