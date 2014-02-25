import pygdsl

print('; b8 05 00 00 00      mov eax, 0x5')
print(pygdsl.semantics_instr('\xb8\x05\x00\x00\x00'))
print('; 81 c3 04 00 00 00   add ebx, 0x4')
print(pygdsl.semantics_instr('\x81\xc3\x04\x00\x00\x00'))
print('; 0f af c3            imul eax, ebx')
print(pygdsl.semantics_instr('\x0f\xaf\xc3'))
try:
    print(pygdsl.semantics_instr('abcd'))
except Exception as e:
    print("Successfully generated exception:")
    print("Exception message: {}".format(e))

