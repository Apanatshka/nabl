package org.metaborg.meta.nabl2.constraints.base;

import org.metaborg.meta.nabl2.constraints.Constraints;
import org.metaborg.meta.nabl2.constraints.messages.MessageInfo;
import org.metaborg.meta.nabl2.terms.ITerm;
import org.metaborg.meta.nabl2.terms.Terms.IMatcher;
import org.metaborg.meta.nabl2.terms.Terms.M;
import org.metaborg.meta.nabl2.terms.generic.TB;
import org.metaborg.meta.nabl2.unification.ISubstitution;

public final class BaseConstraints {

    private static final String C_FALSE = "CFalse";
    private static final String C_TRUE = "CTrue";
    private static final String C_CONJ = "CConj";
    private static final String C_EXISTS = "CExists";
    private static final String C_NEW = "CNew";

    public static IMatcher<IBaseConstraint> matcher() {
        return M.<IBaseConstraint>cases(
            // @formatter:off
            M.appl1(C_TRUE, MessageInfo.matcherOnlyOriginTerm(), (c, origin) -> {
                return ImmutableCTrue.of(origin);
            }),
            M.appl1(C_FALSE, MessageInfo.matcher(), (c, msginfo) -> {
                return ImmutableCFalse.of(msginfo);
            }),
            M.appl2(C_CONJ, (t -> Constraints.matcher().match(t)), (t -> Constraints.matcher().match(t)),
                    (c, c1, c2) -> {
                        return ImmutableCConj.of(c1, c2, MessageInfo.empty());
                    }),
            M.appl2(C_EXISTS, M.listElems(M.var()), (t -> Constraints.matcher().match(t)),
                    (c, vars, constraints) -> {
                        return ImmutableCExists.of(vars, constraints, MessageInfo.empty());
                    }),
            M.appl2(C_NEW, M.listElems(M.var()), MessageInfo.matcherOnlyOriginTerm(),
                    (c, vars, msginfo) -> {
                        return ImmutableCNew.of(vars, msginfo);
                    })
            // @formatter:on
        );
    }

    public static ITerm build(IBaseConstraint constraint) {
        return constraint.match(IBaseConstraint.Cases.<ITerm>of(
            // @formatter:off
            t -> TB.newAppl(C_TRUE, MessageInfo.buildOnlyOriginTerm(t.getMessageInfo())),
            f -> TB.newAppl(C_FALSE, MessageInfo.build(f.getMessageInfo())),
            c -> TB.newAppl(C_CONJ, Constraints.build(c.getLeft()), Constraints.build(c.getRight())),
            e -> TB.newAppl(C_EXISTS, TB.newList(e.getEVars()), Constraints.build(e.getConstraint())),
            n -> TB.newAppl(C_NEW, TB.newList(n.getNVars()), MessageInfo.buildOnlyOriginTerm(n.getMessageInfo()))
            // @formatter:on
        ));
    }

    public static IBaseConstraint substitute(IBaseConstraint constraint, ISubstitution.Immutable subst) {
        return constraint.match(IBaseConstraint.Cases.<IBaseConstraint>of(
            // @formatter:off
            t -> ImmutableCTrue.of(t.getMessageInfo().apply(subst::find)),
            f -> ImmutableCTrue.of(f.getMessageInfo().apply(subst::find)),
            c -> {
                return ImmutableCConj.of(
                        Constraints.substitute(c.getLeft(), subst),
                        Constraints.substitute(c.getRight(), subst),
                        c.getMessageInfo().apply(subst::find));
            },
            e -> {
                final ISubstitution.Immutable restrictedSubst = subst.removeAll(e.getEVars());
                return ImmutableCExists.of(e.getEVars(),
                        Constraints.substitute(e.getConstraint(), restrictedSubst),
                        e.getMessageInfo().apply(restrictedSubst::find));
            },
            n -> ImmutableCNew.of(n.getNVars(), n.getMessageInfo().apply(subst::find))
            // @formatter:on
        ));
    }

}