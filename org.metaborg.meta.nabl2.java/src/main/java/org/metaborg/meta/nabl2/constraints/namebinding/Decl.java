package org.metaborg.meta.nabl2.constraints.namebinding;

import org.immutables.serial.Serial;
import org.immutables.value.Value;
import org.metaborg.meta.nabl2.constraints.IConstraint;
import org.metaborg.meta.nabl2.terms.ITerm;

@Value.Immutable
@Serial.Structural
public abstract class Decl implements INamebindingConstraint {

    public abstract ITerm getScope();

    public abstract ITerm getDeclaration();

    @Override public <T> T match(Cases<T> cases) {
        return cases.caseDecl(this);
    }

    @Override public <T> T match(IConstraint.Cases<T> cases) {
        return cases.caseNamebinding(this);
    }

    @Override public <T, E extends Throwable> T matchThrows(CheckedCases<T,E> cases) throws E {
        return cases.caseDecl(this);
    }

    @Override public <T, E extends Throwable> T matchThrows(IConstraint.CheckedCases<T,E> cases) throws E {
        return cases.caseNamebinding(this);
    }

    @Override public String toString() {
        return getScope() + " -> " + getDeclaration();
    }

}