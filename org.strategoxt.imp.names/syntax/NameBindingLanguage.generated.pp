[
   Todo                                                   -- KW["todo"] _1 _2,
   Fixme                                                  -- KW["fixme"] _1 _2,
   Discuss                                                -- KW["discuss"] _1 _2,
   TestSuite                                              -- KW["test"] KW["suite"] _1,
   AssignedTo                                             -- _1,
   AssignedTo.1:iter-star-sep                             -- _1 KW[","],
   AssignedTo.1:iter-star-sep.1:iter                      -- _1,
   Example                                                -- KW["example"] _1,
   Description                                            -- KW["description"] _1,
   Version                                                -- KW["version"] _1,
   Status                                                 -- V  [H  [KW["status"]] _1],
   Status.1:iter                                          -- _1,
   Author                                                 -- KW["author"] _1 _2 _3,
   Author.1:iter                                          -- _1,
   None                                                   -- ,
   EMail                                                  -- KW["("] _1 KW[")"],
   None                                                   -- ,
   Affiliation                                            -- V  [H  [KW[","]] _1],
   Affiliation.1:iter                                     -- _1,
   Int                                                    -- _1,
   Real                                                   -- _1,
   Str                                                    -- _1,
   Op                                                     -- _1 KW["("] _2 KW[")"],
   Op.2:iter-star-sep                                     -- _1 KW[","],
   Op.2:iter-star-sep.1:parameterized-sort                -- _1 _2,
   Op.2:iter-star-sep.1:parameterized-sort.1:"Term"       -- ,
   OpQ                                                    -- _1 KW["("] _2 KW[")"],
   OpQ.2:iter-star-sep                                    -- _1 KW[","],
   OpQ.2:iter-star-sep.1:parameterized-sort               -- _1 _2,
   OpQ.2:iter-star-sep.1:parameterized-sort.1:"Term"      -- ,
   NoAnnoList                                             -- _1,
   NoAnnoList.1:parameterized-sort                        -- _1 _2,
   NoAnnoList.1:parameterized-sort.1:"PreTerm"            -- ,
   Char                                                   -- _1,
   Tuple                                                  -- KW["("] _1 KW[")"],
   Tuple.1:iter-star-sep                                  -- _1 KW[","],
   Tuple.1:iter-star-sep.1:parameterized-sort             -- _1 _2,
   Tuple.1:iter-star-sep.1:parameterized-sort.1:"Term"    -- ,
   List                                                   -- KW["["] _1 KW["]"],
   List.1:iter-star-sep                                   -- _1 KW[","],
   List.1:iter-star-sep.1:parameterized-sort              -- _1 _2,
   List.1:iter-star-sep.1:parameterized-sort.1:"Term"     -- ,
   ListTail                                               -- KW["["] _1 KW["|"] _2 KW["]"],
   ListTail.1:iter-star-sep                               -- _1 KW[","],
   ListTail.1:iter-star-sep.1:parameterized-sort          -- _1 _2,
   ListTail.1:iter-star-sep.1:parameterized-sort.1:"Term" -- ,
   ListTail.2:parameterized-sort                          -- _1 _2,
   ListTail.2:parameterized-sort.1:"Term"                 -- ,
   SortVar                                                -- _1,
   SortNoArgs                                             -- _1,
   Sort                                                   -- _1 KW["("] _2 KW[")"],
   Sort.2:iter-star-sep                                   -- _1 KW[","],
   TypeDecl                                               -- _1 _2 _3,
   TypeDeclQ                                              -- _1 _2 _3,
   Str                                                    -- _1,
   NoTypeParams                                           -- ,
   TypeParams                                             -- KW["("] _1 KW[")"],
   TypeParams.1:iter-sep                                  -- _1 KW[","],
   TypeParam                                              -- _1 KW[":"] _2,
   Wld                                                    -- KW["_"],
   Var                                                    -- _1,
   ListVar                                                -- _1,
   VarRef                                                 -- _1,
   ListVarRef                                             -- _1,
   Module                                                 -- KW["module"] _1 _2 _3,
   Module.2:iter-star                                     -- _1,
   Module.3:iter-star                                     -- _1,
   Imports                                                -- V  [H  [KW["imports"]] _1],
   Imports.1:iter-star                                    -- _1,
   Import                                                 -- _1,
   Namespaces                                             -- V  [H  [KW["namespaces"]] _1],
   Namespaces.1:iter-star                                 -- _1,
   Namespace                                              -- _1,
   NamespaceRef                                           -- _1,
   ImportedNsRef                                          -- KW["imported"] _1,
   Properties                                             -- V  [H  [KW["properties"]] _1],
   Properties.1:iter-star                                 -- _1,
   Property                                               -- _1 KW["of"] _2 KW[":"] _3,
   Property.2:iter-sep                                    -- _1 KW[","],
   PropertyRef                                            -- _1,
   TypeProp                                               -- KW["type"],
   BindingRules                                           -- V  [H  [KW["binding"] KW["rules"]] _1],
   BindingRules.1:iter-star                               -- _1,
   BindingRule                                            -- _1 _2 KW[":"] _3,
   BindingRule.1:iter-star                                -- _1,
   BindingRule.3:iter                                     -- _1,
   DefSite                                                -- KW["defines"] _1 _2 _3 _4 _5,
   DefSite.3:iter-star                                    -- _1,
   DefSite.5:iter-star                                    -- _1,
   Unique                                                 -- ,
   Unique                                                 -- KW["unique"],
   NonUnique                                              -- KW["non-unique"],
   NameBinding                                            -- _1 _2,
   NameBinding                                            -- _1 _2,
   NameBinding                                            -- _1 _2,
   PropertyBinding                                        -- KW["of"] _1 _2,
   PropertyBinding                                        -- KW["of"] _1 _2,
   Current                                                -- ,
   Current                                                -- KW["in"] KW["current"] KW["scope"],
   DefScopes                                              -- V  [H  [KW["in"]] _1],
   DefScopes.1:iter-sep                                   -- _1 KW[","],
   Subsequent                                             -- KW["subsequent"] KW["scope"],
   DefScope                                               -- _1,
   Scopes                                                 -- V  [H  [KW["scopes"]] _1],
   Scopes.1:iter-sep                                      -- _1 KW[","],
   UseSite                                                -- _1,
   UseSite.1:iter-sep                                     -- _1 KW["otherwise"],
   Reference                                              -- _1 _2 _3 _4,
   Reference.2:iter-star                                  -- _1,
   Reference.4:iter-star                                  -- _1,
   RefScope                                               -- KW["in"] _1 _2 _3,
   RefScope.2:iter-star                                   -- _1,
   Current                                                -- KW["in"] KW["current"] KW["scope"],
   Surrounding                                            -- KW["in"] KW["surrounding"] _1,
   All                                                    -- ,
   QualifiedName                                          -- _1,
   QualifiedName.1:iter-sep                               -- _1 KW["otherwise"],
   Qualifier                                              -- KW["qualifies"] _1 KW["in"] _2 _3,
   Qualifier.3:iter-star                                  -- _1,
   OverlayName                                            -- _1,
   OverlayName.1:iter-sep                                 -- _1 KW["otherwise"],
   Overlay                                                -- KW["names"] _1,
   ImportSite                                             -- _1,
   ImportSite.1:iter-sep                                  -- _1 KW["otherwise"],
   Import                                                 -- KW["imports"] _1 KW["from"] _2 _3,
   Import.1:iter-sep                                      -- _1 KW[","],
   RefScope                                               -- _1,
   Current                                                -- ,
   Current                                                -- KW["into"] KW["current"] KW["scope"],
   DefScopes                                              -- V  [H  [KW["into"]] _1],
   DefScopes.1:iter-sep                                   -- _1 KW[","],
   Constraint                                             -- KW["where"] _1 _2,
   PropertyCond                                           -- KW["has"] _1 _2,
   PropertyCond                                           -- KW["is"] KW["of"] _1 _2,
   ReferenceCond                                          -- KW["refers"] KW["to"] _1 _2 _3,
   ReferenceCond.2:iter-star                              -- _1
]