// Generated by delombok at Fri Sep 01 12:17:59 NZST 2017
package ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ast.Ast.Doc;
import ast.Ast.MethodSelector;
import ast.Ast.Path;
import ast.Ast.Stage;
import ast.ExpCore.*;
import ast.ExpCore.ClassB.Member;
import ast.Util.InvalidMwtAsState;

public class Util {


  public static final class PrivatePedex {
    private final int family;
    private final int number;

    @java.beans.ConstructorProperties({"family", "number"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public PrivatePedex(final int family, final int number) {
      this.family = family;
      this.number = number;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getFamily() {
      return this.family;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int getNumber() {
      return this.number;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Util.PrivatePedex)) return false;
      final PrivatePedex other = (PrivatePedex)o;
      if (this.getFamily() != other.getFamily()) return false;
      if (this.getNumber() != other.getNumber()) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      result = result * PRIME + this.getFamily();
      result = result * PRIME + this.getNumber();
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Util.PrivatePedex(family=" + this.getFamily() + ", number=" + this.getNumber() + ")";
    }
  }

  public static final class InfoAboutMs {
    @NonNull
    private final java.util.List<Path> allSuper;
    @NonNull
    private final Path original;
    @NonNull
    private final ast.Ast.MethodType mt;

    @java.beans.ConstructorProperties({"allSuper", "original", "mt"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public InfoAboutMs(@NonNull final java.util.List<Path> allSuper, @NonNull final Path original, @NonNull final ast.Ast.MethodType mt) {
      if (allSuper == null) {
        throw new java.lang.NullPointerException("allSuper");
      }
      if (original == null) {
        throw new java.lang.NullPointerException("original");
      }
      if (mt == null) {
        throw new java.lang.NullPointerException("mt");
      }
      this.allSuper = allSuper;
      this.original = original;
      this.mt = mt;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.util.List<Path> getAllSuper() {
      return this.allSuper;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Path getOriginal() {
      return this.original;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ast.Ast.MethodType getMt() {
      return this.mt;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Util.InfoAboutMs)) return false;
      final InfoAboutMs other = (InfoAboutMs)o;
      final java.lang.Object this$allSuper = this.getAllSuper();
      final java.lang.Object other$allSuper = other.getAllSuper();
      if (this$allSuper == null ? other$allSuper != null : !this$allSuper.equals(other$allSuper)) return false;
      final java.lang.Object this$original = this.getOriginal();
      final java.lang.Object other$original = other.getOriginal();
      if (this$original == null ? other$original != null : !this$original.equals(other$original)) return false;
      final java.lang.Object this$mt = this.getMt();
      final java.lang.Object other$mt = other.getMt();
      if (this$mt == null ? other$mt != null : !this$mt.equals(other$mt)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $allSuper = this.getAllSuper();
      result = result * PRIME + ($allSuper == null ? 0 : $allSuper.hashCode());
      final java.lang.Object $original = this.getOriginal();
      result = result * PRIME + ($original == null ? 0 : $original.hashCode());
      final java.lang.Object $mt = this.getMt();
      result = result * PRIME + ($mt == null ? 0 : $mt.hashCode());
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Util.InfoAboutMs(allSuper=" + this.getAllSuper() + ", original=" + this.getOriginal() + ", mt=" + this.getMt() + ")";
    }
  }

  public static final class InvalidMwtAsState {
    @NonNull
    private final String reason;
    @NonNull
    private final ExpCore.ClassB.MethodWithType mwt;

    @java.beans.ConstructorProperties({"reason", "mwt"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public InvalidMwtAsState(@NonNull final String reason, @NonNull final ExpCore.ClassB.MethodWithType mwt) {
      if (reason == null) {
        throw new java.lang.NullPointerException("reason");
      }
      if (mwt == null) {
        throw new java.lang.NullPointerException("mwt");
      }
      this.reason = reason;
      this.mwt = mwt;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public String getReason() {
      return this.reason;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ExpCore.ClassB.MethodWithType getMwt() {
      return this.mwt;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Util.InvalidMwtAsState)) return false;
      final InvalidMwtAsState other = (InvalidMwtAsState)o;
      final java.lang.Object this$reason = this.getReason();
      final java.lang.Object other$reason = other.getReason();
      if (this$reason == null ? other$reason != null : !this$reason.equals(other$reason)) return false;
      final java.lang.Object this$mwt = this.getMwt();
      final java.lang.Object other$mwt = other.getMwt();
      if (this$mwt == null ? other$mwt != null : !this$mwt.equals(other$mwt)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $reason = this.getReason();
      result = result * PRIME + ($reason == null ? 0 : $reason.hashCode());
      final java.lang.Object $mwt = this.getMwt();
      result = result * PRIME + ($mwt == null ? 0 : $mwt.hashCode());
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Util.InvalidMwtAsState(reason=" + this.getReason() + ", mwt=" + this.getMwt() + ")";
    }
  }

  public static final class PathMwt {
    @NonNull
    private final Path original;
    @NonNull
    private final ast.ExpCore.ClassB.MethodWithType mwt;

    public String toString() {
      return "" + this.original + "::" + sugarVisitors.ToFormattedText.of(this.mwt).trim().replace("\n", "");
    }

    @java.beans.ConstructorProperties({"original", "mwt"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public PathMwt(@NonNull final Path original, @NonNull final ast.ExpCore.ClassB.MethodWithType mwt) {
      if (original == null) {
        throw new java.lang.NullPointerException("original");
      }
      if (mwt == null) {
        throw new java.lang.NullPointerException("mwt");
      }
      this.original = original;
      this.mwt = mwt;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Path getOriginal() {
      return this.original;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ast.ExpCore.ClassB.MethodWithType getMwt() {
      return this.mwt;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Util.PathMwt)) return false;
      final PathMwt other = (PathMwt)o;
      final java.lang.Object this$original = this.getOriginal();
      final java.lang.Object other$original = other.getOriginal();
      if (this$original == null ? other$original != null : !this$original.equals(other$original)) return false;
      final java.lang.Object this$mwt = this.getMwt();
      final java.lang.Object other$mwt = other.getMwt();
      if (this$mwt == null ? other$mwt != null : !this$mwt.equals(other$mwt)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $original = this.getOriginal();
      result = result * PRIME + ($original == null ? 0 : $original.hashCode());
      final java.lang.Object $mwt = this.getMwt();
      result = result * PRIME + ($mwt == null ? 0 : $mwt.hashCode());
      return result;
    }
  }

  public static final class CsMx {
    @NonNull
    private final java.util.List<Ast.C> cs;
    @NonNull
    private final MethodSelector ms;

    public String toString() {
      String prefix = PathAux.as42Path(cs);
      return prefix + "::" + ms;
    }

    @java.beans.ConstructorProperties({"cs", "ms"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsMx(@NonNull final java.util.List<Ast.C> cs, @NonNull final MethodSelector ms) {
      if (cs == null) {
        throw new java.lang.NullPointerException("cs");
      }
      if (ms == null) {
        throw new java.lang.NullPointerException("ms");
      }
      this.cs = cs;
      this.ms = ms;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.util.List<Ast.C> getCs() {
      return this.cs;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public MethodSelector getMs() {
      return this.ms;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Util.CsMx)) return false;
      final CsMx other = (CsMx)o;
      final java.lang.Object this$cs = this.getCs();
      final java.lang.Object other$cs = other.getCs();
      if (this$cs == null ? other$cs != null : !this$cs.equals(other$cs)) return false;
      final java.lang.Object this$ms = this.getMs();
      final java.lang.Object other$ms = other.getMs();
      if (this$ms == null ? other$ms != null : !this$ms.equals(other$ms)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $cs = this.getCs();
      result = result * PRIME + ($cs == null ? 0 : $cs.hashCode());
      final java.lang.Object $ms = this.getMs();
      result = result * PRIME + ($ms == null ? 0 : $ms.hashCode());
      return result;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsMx withCs(@NonNull final java.util.List<Ast.C> cs) {
      if (cs == null) {
        throw new java.lang.NullPointerException("cs");
      }
      return this.cs == cs ? this : new CsMx(cs, this.ms);
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsMx withMs(@NonNull final MethodSelector ms) {
      if (ms == null) {
        throw new java.lang.NullPointerException("ms");
      }
      return this.ms == ms ? this : new CsMx(this.cs, ms);
    }
  }

  public static final class CsPath {
    @NonNull
    private final java.util.List<Ast.C> cs;
    @NonNull
    private final Path path;

    public String toString() {
      String prefix = PathAux.as42Path(cs);
      return prefix + "->" + path;
    }

    @java.beans.ConstructorProperties({"cs", "path"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsPath(@NonNull final java.util.List<Ast.C> cs, @NonNull final Path path) {
      if (cs == null) {
        throw new java.lang.NullPointerException("cs");
      }
      if (path == null) {
        throw new java.lang.NullPointerException("path");
      }
      this.cs = cs;
      this.path = path;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.util.List<Ast.C> getCs() {
      return this.cs;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Path getPath() {
      return this.path;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Util.CsPath)) return false;
      final CsPath other = (CsPath)o;
      final java.lang.Object this$cs = this.getCs();
      final java.lang.Object other$cs = other.getCs();
      if (this$cs == null ? other$cs != null : !this$cs.equals(other$cs)) return false;
      final java.lang.Object this$path = this.getPath();
      final java.lang.Object other$path = other.getPath();
      if (this$path == null ? other$path != null : !this$path.equals(other$path)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $cs = this.getCs();
      result = result * PRIME + ($cs == null ? 0 : $cs.hashCode());
      final java.lang.Object $path = this.getPath();
      result = result * PRIME + ($path == null ? 0 : $path.hashCode());
      return result;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsPath withCs(@NonNull final java.util.List<Ast.C> cs) {
      if (cs == null) {
        throw new java.lang.NullPointerException("cs");
      }
      return this.cs == cs ? this : new CsPath(cs, this.path);
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsPath withPath(@NonNull final Path path) {
      if (path == null) {
        throw new java.lang.NullPointerException("path");
      }
      return this.path == path ? this : new CsPath(this.cs, path);
    }
  }

  public static final class CsMxMx {
    @NonNull
    private final java.util.List<Ast.C> cs;
    private final boolean flag;
    private final MethodSelector ms1;
    private final MethodSelector ms2;

    public String toString() {
      String prefix = PathAux.as42Path(cs);
      return prefix + "[" + flag + "]" + ms1 + "->" + ms2;
    }

    @java.beans.ConstructorProperties({"cs", "flag", "ms1", "ms2"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsMxMx(@NonNull final java.util.List<Ast.C> cs, final boolean flag, final MethodSelector ms1, final MethodSelector ms2) {
      if (cs == null) {
        throw new java.lang.NullPointerException("cs");
      }
      this.cs = cs;
      this.flag = flag;
      this.ms1 = ms1;
      this.ms2 = ms2;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.util.List<Ast.C> getCs() {
      return this.cs;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean isFlag() {
      return this.flag;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public MethodSelector getMs1() {
      return this.ms1;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public MethodSelector getMs2() {
      return this.ms2;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Util.CsMxMx)) return false;
      final CsMxMx other = (CsMxMx)o;
      final java.lang.Object this$cs = this.getCs();
      final java.lang.Object other$cs = other.getCs();
      if (this$cs == null ? other$cs != null : !this$cs.equals(other$cs)) return false;
      if (this.isFlag() != other.isFlag()) return false;
      final java.lang.Object this$ms1 = this.getMs1();
      final java.lang.Object other$ms1 = other.getMs1();
      if (this$ms1 == null ? other$ms1 != null : !this$ms1.equals(other$ms1)) return false;
      final java.lang.Object this$ms2 = this.getMs2();
      final java.lang.Object other$ms2 = other.getMs2();
      if (this$ms2 == null ? other$ms2 != null : !this$ms2.equals(other$ms2)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $cs = this.getCs();
      result = result * PRIME + ($cs == null ? 0 : $cs.hashCode());
      result = result * PRIME + (this.isFlag() ? 79 : 97);
      final java.lang.Object $ms1 = this.getMs1();
      result = result * PRIME + ($ms1 == null ? 0 : $ms1.hashCode());
      final java.lang.Object $ms2 = this.getMs2();
      result = result * PRIME + ($ms2 == null ? 0 : $ms2.hashCode());
      return result;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsMxMx withCs(@NonNull final java.util.List<Ast.C> cs) {
      if (cs == null) {
        throw new java.lang.NullPointerException("cs");
      }
      return this.cs == cs ? this : new CsMxMx(cs, this.flag, this.ms1, this.ms2);
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsMxMx withFlag(final boolean flag) {
      return this.flag == flag ? this : new CsMxMx(this.cs, flag, this.ms1, this.ms2);
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsMxMx withMs1(final MethodSelector ms1) {
      return this.ms1 == ms1 ? this : new CsMxMx(this.cs, this.flag, ms1, this.ms2);
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsMxMx withMs2(final MethodSelector ms2) {
      return this.ms2 == ms2 ? this : new CsMxMx(this.cs, this.flag, this.ms1, ms2);
    }
  }

  public static final class PathMx {
    @NonNull
    private final Path path;
    @NonNull
    private final MethodSelector ms;

    public String toString() {
      return "" + path + "::" + ms;
    }

    @java.beans.ConstructorProperties({"path", "ms"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public PathMx(@NonNull final Path path, @NonNull final MethodSelector ms) {
      if (path == null) {
        throw new java.lang.NullPointerException("path");
      }
      if (ms == null) {
        throw new java.lang.NullPointerException("ms");
      }
      this.path = path;
      this.ms = ms;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Path getPath() {
      return this.path;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public MethodSelector getMs() {
      return this.ms;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Util.PathMx)) return false;
      final PathMx other = (PathMx)o;
      final java.lang.Object this$path = this.getPath();
      final java.lang.Object other$path = other.getPath();
      if (this$path == null ? other$path != null : !this$path.equals(other$path)) return false;
      final java.lang.Object this$ms = this.getMs();
      final java.lang.Object other$ms = other.getMs();
      if (this$ms == null ? other$ms != null : !this$ms.equals(other$ms)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $path = this.getPath();
      result = result * PRIME + ($path == null ? 0 : $path.hashCode());
      final java.lang.Object $ms = this.getMs();
      result = result * PRIME + ($ms == null ? 0 : $ms.hashCode());
      return result;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public PathMx withPath(@NonNull final Path path) {
      if (path == null) {
        throw new java.lang.NullPointerException("path");
      }
      return this.path == path ? this : new PathMx(path, this.ms);
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public PathMx withMs(@NonNull final MethodSelector ms) {
      if (ms == null) {
        throw new java.lang.NullPointerException("ms");
      }
      return this.ms == ms ? this : new PathMx(this.path, ms);
    }
  }

  public static final class PathMxMx {
    @NonNull
    private final Path path;
    @NonNull
    private final MethodSelector ms1;
    @NonNull
    private final MethodSelector ms2;

    @java.beans.ConstructorProperties({"path", "ms1", "ms2"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public PathMxMx(@NonNull final Path path, @NonNull final MethodSelector ms1, @NonNull final MethodSelector ms2) {
      if (path == null) {
        throw new java.lang.NullPointerException("path");
      }
      if (ms1 == null) {
        throw new java.lang.NullPointerException("ms1");
      }
      if (ms2 == null) {
        throw new java.lang.NullPointerException("ms2");
      }
      this.path = path;
      this.ms1 = ms1;
      this.ms2 = ms2;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Path getPath() {
      return this.path;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public MethodSelector getMs1() {
      return this.ms1;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public MethodSelector getMs2() {
      return this.ms2;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Util.PathMxMx)) return false;
      final PathMxMx other = (PathMxMx)o;
      final java.lang.Object this$path = this.getPath();
      final java.lang.Object other$path = other.getPath();
      if (this$path == null ? other$path != null : !this$path.equals(other$path)) return false;
      final java.lang.Object this$ms1 = this.getMs1();
      final java.lang.Object other$ms1 = other.getMs1();
      if (this$ms1 == null ? other$ms1 != null : !this$ms1.equals(other$ms1)) return false;
      final java.lang.Object this$ms2 = this.getMs2();
      final java.lang.Object other$ms2 = other.getMs2();
      if (this$ms2 == null ? other$ms2 != null : !this$ms2.equals(other$ms2)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $path = this.getPath();
      result = result * PRIME + ($path == null ? 0 : $path.hashCode());
      final java.lang.Object $ms1 = this.getMs1();
      result = result * PRIME + ($ms1 == null ? 0 : $ms1.hashCode());
      final java.lang.Object $ms2 = this.getMs2();
      result = result * PRIME + ($ms2 == null ? 0 : $ms2.hashCode());
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Util.PathMxMx(path=" + this.getPath() + ", ms1=" + this.getMs1() + ", ms2=" + this.getMs2() + ")";
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public PathMxMx withPath(@NonNull final Path path) {
      if (path == null) {
        throw new java.lang.NullPointerException("path");
      }
      return this.path == path ? this : new PathMxMx(path, this.ms1, this.ms2);
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public PathMxMx withMs1(@NonNull final MethodSelector ms1) {
      if (ms1 == null) {
        throw new java.lang.NullPointerException("ms1");
      }
      return this.ms1 == ms1 ? this : new PathMxMx(this.path, ms1, this.ms2);
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public PathMxMx withMs2(@NonNull final MethodSelector ms2) {
      if (ms2 == null) {
        throw new java.lang.NullPointerException("ms2");
      }
      return this.ms2 == ms2 ? this : new PathMxMx(this.path, this.ms1, ms2);
    }
  }

  public static final class PathPath {
    @NonNull
    private final Path path1;
    @NonNull
    private final Path path2;

    public String toString() {
      return "" + path1 + "->" + path2;
    }

    @java.beans.ConstructorProperties({"path1", "path2"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public PathPath(@NonNull final Path path1, @NonNull final Path path2) {
      if (path1 == null) {
        throw new java.lang.NullPointerException("path1");
      }
      if (path2 == null) {
        throw new java.lang.NullPointerException("path2");
      }
      this.path1 = path1;
      this.path2 = path2;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Path getPath1() {
      return this.path1;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Path getPath2() {
      return this.path2;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Util.PathPath)) return false;
      final PathPath other = (PathPath)o;
      final java.lang.Object this$path1 = this.getPath1();
      final java.lang.Object other$path1 = other.getPath1();
      if (this$path1 == null ? other$path1 != null : !this$path1.equals(other$path1)) return false;
      final java.lang.Object this$path2 = this.getPath2();
      final java.lang.Object other$path2 = other.getPath2();
      if (this$path2 == null ? other$path2 != null : !this$path2.equals(other$path2)) return false;
      return true;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $path1 = this.getPath1();
      result = result * PRIME + ($path1 == null ? 0 : $path1.hashCode());
      final java.lang.Object $path2 = this.getPath2();
      result = result * PRIME + ($path2 == null ? 0 : $path2.hashCode());
      return result;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public PathPath withPath1(@NonNull final Path path1) {
      if (path1 == null) {
        throw new java.lang.NullPointerException("path1");
      }
      return this.path1 == path1 ? this : new PathPath(path1, this.path2);
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public PathPath withPath2(@NonNull final Path path2) {
      if (path2 == null) {
        throw new java.lang.NullPointerException("path2");
      }
      return this.path2 == path2 ? this : new PathPath(this.path1, path2);
    }
  }

  public static class CsSPath {
    @NonNull
    List<Ast.C> cs;
    @NonNull
    java.util.Set<Path> pathsSet;

    public String toString() {
      return "" + cs + "->" + pathsSet;
    }

    @java.beans.ConstructorProperties({"cs", "pathsSet"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsSPath(@NonNull final List<Ast.C> cs, @NonNull final java.util.Set<Path> pathsSet) {
      if (cs == null) {
        throw new java.lang.NullPointerException("cs");
      }
      if (pathsSet == null) {
        throw new java.lang.NullPointerException("pathsSet");
      }
      this.cs = cs;
      this.pathsSet = pathsSet;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public List<Ast.C> getCs() {
      return this.cs;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.util.Set<Path> getPathsSet() {
      return this.pathsSet;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public void setCs(@NonNull final List<Ast.C> cs) {
      if (cs == null) {
        throw new java.lang.NullPointerException("cs");
      }
      this.cs = cs;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public void setPathsSet(@NonNull final java.util.Set<Path> pathsSet) {
      if (pathsSet == null) {
        throw new java.lang.NullPointerException("pathsSet");
      }
      this.pathsSet = pathsSet;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Util.CsSPath)) return false;
      final CsSPath other = (CsSPath)o;
      if (!other.canEqual((java.lang.Object)this)) return false;
      final java.lang.Object this$cs = this.getCs();
      final java.lang.Object other$cs = other.getCs();
      if (this$cs == null ? other$cs != null : !this$cs.equals(other$cs)) return false;
      final java.lang.Object this$pathsSet = this.getPathsSet();
      final java.lang.Object other$pathsSet = other.getPathsSet();
      if (this$pathsSet == null ? other$pathsSet != null : !this$pathsSet.equals(other$pathsSet)) return false;
      return true;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    protected boolean canEqual(final java.lang.Object other) {
      return other instanceof Util.CsSPath;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $cs = this.getCs();
      result = result * PRIME + ($cs == null ? 0 : $cs.hashCode());
      final java.lang.Object $pathsSet = this.getPathsSet();
      result = result * PRIME + ($pathsSet == null ? 0 : $pathsSet.hashCode());
      return result;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsSPath withCs(@NonNull final List<Ast.C> cs) {
      if (cs == null) {
        throw new java.lang.NullPointerException("cs");
      }
      return this.cs == cs ? this : new CsSPath(cs, this.pathsSet);
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsSPath withPathsSet(@NonNull final java.util.Set<Path> pathsSet) {
      if (pathsSet == null) {
        throw new java.lang.NullPointerException("pathsSet");
      }
      return this.pathsSet == pathsSet ? this : new CsSPath(this.cs, pathsSet);
    }
  }

  public static class CsMwtPMwt {
    @NonNull
    List<Ast.C> src1;
    @NonNull
    ClassB.MethodWithType mwt1;
    @NonNull
    Path src2;
    @NonNull
    ClassB.MethodWithType mwt2;

    @java.beans.ConstructorProperties({"src1", "mwt1", "src2", "mwt2"})
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsMwtPMwt(@NonNull final List<Ast.C> src1, @NonNull final ClassB.MethodWithType mwt1, @NonNull final Path src2, @NonNull final ClassB.MethodWithType mwt2) {
      if (src1 == null) {
        throw new java.lang.NullPointerException("src1");
      }
      if (mwt1 == null) {
        throw new java.lang.NullPointerException("mwt1");
      }
      if (src2 == null) {
        throw new java.lang.NullPointerException("src2");
      }
      if (mwt2 == null) {
        throw new java.lang.NullPointerException("mwt2");
      }
      this.src1 = src1;
      this.mwt1 = mwt1;
      this.src2 = src2;
      this.mwt2 = mwt2;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public List<Ast.C> getSrc1() {
      return this.src1;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ClassB.MethodWithType getMwt1() {
      return this.mwt1;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Path getSrc2() {
      return this.src2;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ClassB.MethodWithType getMwt2() {
      return this.mwt2;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public void setSrc1(@NonNull final List<Ast.C> src1) {
      if (src1 == null) {
        throw new java.lang.NullPointerException("src1");
      }
      this.src1 = src1;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public void setMwt1(@NonNull final ClassB.MethodWithType mwt1) {
      if (mwt1 == null) {
        throw new java.lang.NullPointerException("mwt1");
      }
      this.mwt1 = mwt1;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public void setSrc2(@NonNull final Path src2) {
      if (src2 == null) {
        throw new java.lang.NullPointerException("src2");
      }
      this.src2 = src2;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public void setMwt2(@NonNull final ClassB.MethodWithType mwt2) {
      if (mwt2 == null) {
        throw new java.lang.NullPointerException("mwt2");
      }
      this.mwt2 = mwt2;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
      if (o == this) return true;
      if (!(o instanceof Util.CsMwtPMwt)) return false;
      final CsMwtPMwt other = (CsMwtPMwt)o;
      if (!other.canEqual((java.lang.Object)this)) return false;
      final java.lang.Object this$src1 = this.getSrc1();
      final java.lang.Object other$src1 = other.getSrc1();
      if (this$src1 == null ? other$src1 != null : !this$src1.equals(other$src1)) return false;
      final java.lang.Object this$mwt1 = this.getMwt1();
      final java.lang.Object other$mwt1 = other.getMwt1();
      if (this$mwt1 == null ? other$mwt1 != null : !this$mwt1.equals(other$mwt1)) return false;
      final java.lang.Object this$src2 = this.getSrc2();
      final java.lang.Object other$src2 = other.getSrc2();
      if (this$src2 == null ? other$src2 != null : !this$src2.equals(other$src2)) return false;
      final java.lang.Object this$mwt2 = this.getMwt2();
      final java.lang.Object other$mwt2 = other.getMwt2();
      if (this$mwt2 == null ? other$mwt2 != null : !this$mwt2.equals(other$mwt2)) return false;
      return true;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    protected boolean canEqual(final java.lang.Object other) {
      return other instanceof Util.CsMwtPMwt;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $src1 = this.getSrc1();
      result = result * PRIME + ($src1 == null ? 0 : $src1.hashCode());
      final java.lang.Object $mwt1 = this.getMwt1();
      result = result * PRIME + ($mwt1 == null ? 0 : $mwt1.hashCode());
      final java.lang.Object $src2 = this.getSrc2();
      result = result * PRIME + ($src2 == null ? 0 : $src2.hashCode());
      final java.lang.Object $mwt2 = this.getMwt2();
      result = result * PRIME + ($mwt2 == null ? 0 : $mwt2.hashCode());
      return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public java.lang.String toString() {
      return "Util.CsMwtPMwt(src1=" + this.getSrc1() + ", mwt1=" + this.getMwt1() + ", src2=" + this.getSrc2() + ", mwt2=" + this.getMwt2() + ")";
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsMwtPMwt withSrc1(@NonNull final List<Ast.C> src1) {
      if (src1 == null) {
        throw new java.lang.NullPointerException("src1");
      }
      return this.src1 == src1 ? this : new CsMwtPMwt(src1, this.mwt1, this.src2, this.mwt2);
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsMwtPMwt withMwt1(@NonNull final ClassB.MethodWithType mwt1) {
      if (mwt1 == null) {
        throw new java.lang.NullPointerException("mwt1");
      }
      return this.mwt1 == mwt1 ? this : new CsMwtPMwt(this.src1, mwt1, this.src2, this.mwt2);
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsMwtPMwt withSrc2(@NonNull final Path src2) {
      if (src2 == null) {
        throw new java.lang.NullPointerException("src2");
      }
      return this.src2 == src2 ? this : new CsMwtPMwt(this.src1, this.mwt1, src2, this.mwt2);
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CsMwtPMwt withMwt2(@NonNull final ClassB.MethodWithType mwt2) {
      if (mwt2 == null) {
        throw new java.lang.NullPointerException("mwt2");
      }
      return this.mwt2 == mwt2 ? this : new CsMwtPMwt(this.src1, this.mwt1, this.src2, mwt2);
    }
    //@NonNull List<Path> paths1; @NonNull List<Path> paths2;
    //public String toString(){return ""+paths1+"->"+paths2;}
  }
}