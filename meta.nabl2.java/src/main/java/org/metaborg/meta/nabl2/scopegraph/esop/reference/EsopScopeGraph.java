package org.metaborg.meta.nabl2.scopegraph.esop.reference;

import java.io.Serializable;

import org.metaborg.meta.nabl2.scopegraph.ILabel;
import org.metaborg.meta.nabl2.scopegraph.IOccurrence;
import org.metaborg.meta.nabl2.scopegraph.IResolutionParameters;
import org.metaborg.meta.nabl2.scopegraph.IScope;
import org.metaborg.meta.nabl2.scopegraph.OpenCounter;
import org.metaborg.meta.nabl2.scopegraph.esop.IEsopScopeGraph;
import org.metaborg.meta.nabl2.util.collections.HashFunction;
import org.metaborg.meta.nabl2.util.collections.HashRelation3;
import org.metaborg.meta.nabl2.util.collections.IFunction;
import org.metaborg.meta.nabl2.util.collections.IRelation3;
import org.metaborg.meta.nabl2.util.functions.Function1;

import io.usethesource.capsule.Set;

public class EsopScopeGraph<S extends IScope, L extends ILabel, O extends IOccurrence>
        implements IEsopScopeGraph<S, L, O>, IEsopScopeGraph.Builder<S, L, O>, Serializable {

    private static final long serialVersionUID = 42L;

    private final Set.Transient<S> allScopes;
    private final Set.Transient<O> allDecls;
    private final Set.Transient<O> allRefs;

    private final IFunction.Mutable<O, S> decls;
    private final IFunction.Mutable<O, S> refs;
    private final IRelation3.Mutable<S, L, S> directEdges;
    private final IRelation3.Mutable<O, L, S> assocEdges;
    private final IRelation3.Mutable<S, L, O> importEdges;

    public EsopScopeGraph() {
        this.allScopes = Set.Transient.of();
        this.allDecls = Set.Transient.of();
        this.allRefs = Set.Transient.of();

        this.decls = HashFunction.create();
        this.refs = HashFunction.create();
        this.directEdges = HashRelation3.create();
        this.assocEdges = HashRelation3.create();
        this.importEdges = HashRelation3.create();
    }

    // -----------------------

    @Override public Set.Immutable<S> getAllScopes() {
        return Set.Immutable.<S>of().__insertAll(allScopes);
    }

    @Override public Set.Immutable<O> getAllDecls() {
        return Set.Immutable.<O>of().__insertAll(allDecls);
    }

    @Override public Set.Immutable<O> getAllRefs() {
        return Set.Immutable.<O>of().__insertAll(allRefs);
    }


    @Override public IFunction<O, S> getDecls() {
        return decls;
    }

    @Override public IFunction<O, S> getRefs() {
        return refs;
    }

    @Override public IRelation3<S, L, S> getDirectEdges() {
        return directEdges;
    }

    @Override public IRelation3<O, L, S> getExportEdges() {
        return assocEdges;
    }

    @Override public IRelation3<S, L, O> getImportEdges() {
        return importEdges;
    }

    // -----------------------

    public void addDecl(S scope, O decl) {
        // FIXME: check scope/D is not closed
        allScopes.__insert(scope);
        allDecls.__insert(decl);
        decls.put(decl, scope);
    }

    public void addRef(O ref, S scope) {
        // FIXME: check scope/R is not closed
        allScopes.__insert(scope);
        allRefs.__insert(ref);
        refs.put(ref, scope);
    }

    public void addDirectEdge(S sourceScope, L label, S targetScope) {
        // FIXME: check scope/l is not closed
        allScopes.__insert(sourceScope);
        directEdges.put(sourceScope, label, targetScope);
    }

    public void addAssoc(O decl, L label, S scope) {
        // FIXME: check decl/l is not closed
        allScopes.__insert(scope);
        allDecls.__insert(decl);
        assocEdges.put(decl, label, scope);
    }

    public void addImport(S scope, L label, O ref) {
        // FIXME: check scope/l is not closed
        allScopes.__insert(scope);
        allRefs.__insert(ref);
        importEdges.put(scope, label, ref);
    }

    // ------------------------------------

    /**
     * Return identity because this class implements both the mutable builder interface and the and graph interface.
     */
    @Override public IEsopScopeGraph<S, L, O> result() {
        return this;
    }

    // ------------------------------------

    @Override public EsopNameResolution<S, L, O> resolve(IResolutionParameters<L> params,
            OpenCounter<S, L> scopeCounter, Function1<S, String> tracer) {
        return new EsopNameResolution<>(this, params, scopeCounter, tracer);
    }

}