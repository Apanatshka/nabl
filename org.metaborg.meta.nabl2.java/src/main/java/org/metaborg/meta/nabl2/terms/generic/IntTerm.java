package org.metaborg.meta.nabl2.terms.generic;

import org.immutables.serial.Serial;
import org.immutables.value.Value;
import org.metaborg.meta.nabl2.terms.IIntTerm;
import org.metaborg.meta.nabl2.terms.ITermVar;
import org.pcollections.HashTreePSet;
import org.pcollections.PSet;

import com.google.common.collect.ImmutableClassToInstanceMap;

@Value.Immutable
@Serial.Version(value = 42L)
abstract class IntTerm implements IIntTerm {

    @Value.Parameter @Override public abstract int getValue();

    @Override public boolean isGround() {
        return true;
    }

    @Value.Default @Value.Auxiliary @Override public boolean isLocked() {
        return false;
    }
    
    @Value.Lazy @Override public PSet<ITermVar> getVars() {
        return HashTreePSet.empty();
    }

    @Value.Default @Value.Auxiliary @Override public ImmutableClassToInstanceMap<Object> getAttachments() {
        return ImmutableClassToInstanceMap.<Object>builder().build();
    }

    @Override public <T> T match(Cases<T> cases) {
        return cases.caseInt(this);
    }

    @Override public <T, E extends Throwable> T matchOrThrow(CheckedCases<T, E> cases) throws E {
        return cases.caseInt(this);
    }

    @Override public String toString() {
        return Integer.toString(getValue());
    }

}