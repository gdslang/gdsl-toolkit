import pygdsl

with open('tests/a.bin','r') as testdump:
    instrs = testdump.read()

    print(pygdsl.semantics_multi(instrs))

    print(pygdsl.semantics_multi_opt(instrs, pygdsl.GDSL_SEM_PRESERVATION_EVERYWHERE))
    print(pygdsl.semantics_multi_opt(instrs, pygdsl.GDSL_SEM_PRESERVATION_CONTEXT))
    print(pygdsl.semantics_multi_opt(instrs, pygdsl.GDSL_SEM_PRESERVATION_BLOCK))
