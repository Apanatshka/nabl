package org.metaborg.meta.nabl2.constraints.equality;

import org.immutables.serial.Serial;
import org.immutables.value.Value;
import org.metaborg.meta.nabl2.constraints.IConstraint;
import org.metaborg.meta.nabl2.terms.ITerm;

@Value.Immutable
@Serial.Structural
public abstract class Inequal implements IEqualityConstraint {

    public abstract ITerm getLeft();

    public abstract ITerm getRight();

    @Override public <T> T match(Cases<T> cases) {
        return cases.caseInequal(this);
    }

    @Override public <T> T match(IConstraint.Cases<T> cases) {
        return cases.caseEquality(this);
    }

    @Override public <T, E extends Throwable> T matchThrows(CheckedCases<T,E> cases) throws E {
        return cases.caseInequal(this);
    }

    @Override public <T, E extends Throwable> T matchThrows(IConstraint.CheckedCases<T,E> cases) throws E {
        return cases.caseEquality(this);
    }

    @Override public String toString() {
        return getLeft() + " != " + getRight();
    }

}