[
   Var                      -- _1,
   Wld                      -- KW["_"],
   Int                      -- _1,
   Real                     -- _1,
   Str                      -- _1,
   Op                       -- _1 KW["("] _2 KW[")"],
   Op.2:iter-star-sep       -- _1 KW[","],
   OpQ                      -- _1 KW["("] _2 KW[")"],
   OpQ.2:iter-star-sep      -- _1 KW[","],
   NoAnnoList               -- _1,
   ListVar                  -- _1,
   Var                      -- _1,
   Char                     -- _1,
   List                     -- KW["["] _1 KW["]"],
   List.1:iter-star-sep     -- _1 KW[","],
   ListTail                 -- KW["["] _1 KW["|"] _2 KW["]"],
   ListTail.1:iter-star-sep -- _1 KW[","],
   Naming                   -- KW["module"] _1 _2 _3 _4,
   Import                   -- _1,
   Namespace                -- _1,
   NsRef                    -- _1,
   ND-Rule                  -- _1 KW[":"] _2 _3,
   ND-Rule.2:iter           -- _1,
   ND-Rule.3:iter-star      -- _1,
   ND-Def                   -- KW["defines"] _1 _2 _3 _4 _5,
   ND-Import                -- KW["imports"] _1 KW["from"] _2 _3 _4 _5,
   ND-Ref                   -- KW["refers"] KW["to"] _1 _2 _3 _4,
   ND-Scope                 -- KW["scope"] KW["for"] _1,
   ND-Type                  -- KW["has"] KW["type"] _1,
   Where                    -- KW["where"] _1 _2,
   TypeCheck                -- KW["has"] KW["type"] _1,
   ReferenceCheck           -- KW["refers"] KW["to"] _1 _2 _3 _4,
   TypeBinding              -- KW["of"] KW["type"] _1,
   None                     -- ,
   DefScope                 -- KW["in"] _1,
   Forward                  -- KW["forward"],
   Backward                 -- KW["backward"],
   None                     -- ,
   RefScope                 -- KW["in"] _1 _2,
   None                     -- ,
   Annos                    -- KW["{"] _1 KW["}"],
   Annos.1:iter-sep         -- _1 KW[","],
   Annos                    -- KW["{"] _1 KW["}"],
   Annos.1:iter-sep         -- _1 KW[","],
   NonUnique                -- KW["non-unique"],
   Unique                   -- KW["unique"],
   Ordered                  -- KW["ordered"],
   NonOrdered               -- KW["unordered"],
   Transitive               -- KW["transitive"],
   CurrentFile              -- KW["current-file"],
   Ordered                  -- KW["ordered"],
   NonOrdered               -- KW["unordered"]
]