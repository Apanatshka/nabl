package org.metaborg.meta.nabl2.terms;

import org.pcollections.PSet;

import com.google.common.collect.ImmutableClassToInstanceMap;

public interface ITerm {

    boolean isGround();

    PSet<ITermVar> getVars();

    default boolean termEquals(ITerm other) {
        return equals(other);
    }

    ImmutableClassToInstanceMap<Object> getAttachments();

    ITerm setAttachments(ImmutableClassToInstanceMap<Object> value);

    <T> T match(Cases<T> cases);

    interface Cases<T> {

        T caseAppl(IApplTerm appl);

        T caseList(IListTerm cons);

        T caseString(IStringTerm string);

        T caseInt(IIntTerm integer);

        T caseVar(ITermVar var);

    }

    <T, E extends Throwable> T matchOrThrow(CheckedCases<T, E> cases) throws E;

    interface CheckedCases<T, E extends Throwable> {

        T caseAppl(IApplTerm appl) throws E;

        T caseList(IListTerm cons) throws E;

        T caseString(IStringTerm string) throws E;

        T caseInt(IIntTerm integer) throws E;

        T caseVar(ITermVar var) throws E;

    }

}