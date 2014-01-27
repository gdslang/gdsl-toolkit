"""
IDAPython analysis example.

Run this code from the IDA GUI after an .exe has already been loaded.
File -> Script File...

Look through spidautils for other helper functions, such as those to
get operands of specific instructions.

IDAPython API reference is here:
https://www.hex-rays.com/products/ida/support/idapython_docs/

@author: Craig Miles
"""

import spidautils
      
ida = spidautils.SPIDA() 

# Iterate over each function IDA has identified.
# Each element in Functions() is a an EA (effective address AKA virtual address) of the
# entry point of a function.
for function_start_ea in ida.Functions():
    # Get function object
    func_t = ida.getFuncT(function_start_ea)
    
    # IDA automatically renames some registers which is pain when trying to consistently compare
    # operands, so this removes all of those renamings.
    ida.removeAllRegisterRenamingsInFunc(func_t)
    
    # Get the control flow graph of the current function.
    CFG = ida.getFuncCFG(func_t)
    
    # Iterate over each basic block in the CFG
    for basicBlock in CFG:
        
        # Iterate over each instruction (AKA Head) between the start and end of the basic block.
        for ea in ida.Heads(basicBlock.startEA, basicBlock.endEA):
            
            # Check if the current instruction is actually code.  X86 code can have data interspersed
            # with code.
            if ida.isCode(ea):
                
                # Check if instruction is a Call instruction.
                if ida.instructionIsACall(ea):
                    
                    # Get the target of the Call instruction, then check if there is actually code there.
                    target = ida.getCallTarget(ea)
                    if target != None:
                        
                        # Check if the Call is to an external DLL's export.
                        if ida.isAnAPI(target):
                            print "Found an API Call at address %s to %s in %s" % (hex(ea), ida.getAPIName(target), ida.getAPIModule(target))
                        else:
                            print "Found a Call at address %s to %s" % (hex(ea), hex(ida.getCallTarget(ea)))
                            
            

                

    
