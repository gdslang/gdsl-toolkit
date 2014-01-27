"""
Wrapper for communication w/ IDA.
All interaction between an IDAPython sensor and IDA Pro must be
through these functions.
@author: Craig Miles
"""
import idc
import idaapi
import idautils

class SPIDA:
    
    regDict = dict()
    regDict[0]  = "eax"
    regDict[1]  = "ecx"
    regDict[2]  = "edx"
    regDict[3]  = "ebx"
    regDict[4]  = "esp"
    regDict[5]  = "ebp"
    regDict[6]  = "esi"
    regDict[7]  = "edi"
    regDict[16] = "al"
    regDict[17] = "cl"
    regDict[18] = "dl"
    regDict[19] = "bl"
    regDict[20] = "ah"
    regDict[21] = "ch"
    regDict[22] = "dh"
    regDict[23] = "bh"
    regDict[29] = "es"
    regDict[30] = "cs"
    regDict[31] = "ss"
    regDict[32] = "ds"
    regDict[33] = "fs"
    regDict[34] = "gs"
    regDict[44] = "efl"
    regDict[53] = "ctrl"
    regDict[54] = "stat"
    regDict[55] = "tags"
    regDict[56] = "mm0"
    regDict[57] = "mm1"
    regDict[58] = "mm2"
    regDict[59] = "mm3"
    regDict[60] = "mm4"
    regDict[61] = "mm5"
    regDict[62] = "mm6"
    regDict[63] = "mm7"
    regDict[64]  = "xmm0"
    regDict[65]  = "xmm1"
    regDict[66]  = "xmm2"
    regDict[67]  = "xmm3"
    regDict[68]  = "xmm4"
    regDict[69]  = "xmm5"
    regDict[70]  = "xmm6"
    regDict[71]  = "xmm7"
    regDict[72]  = "xmm8"
    regDict[73]  = "xmm9"
    regDict[74]  = "xmm10"
    regDict[75]  = "xmm11"
    regDict[76]  = "xmm12"
    regDict[77]  = "xmm13"
    regDict[78]  = "xmm14"
    regDict[79]  = "xmm15"
    regDict[80]  = "mxcsr"
    regDict[90]  = "ax"
    regDict[91]  = "cx"
    regDict[90]  = "dx"
    regDict[90]  = "bx"
       
    def __init__(self):
        """Constructor for SPIDA.  Waits for IDA Pro to finish analyzing
        the .exe, then builds a dictionary mapping EA's to imported APIs' names"""
        idaapi.autoWait()
        self.import_dict = dict()
        self.curr_mod_name = ""
        self.firstImport = True
        self.imports_segment_name = ""
        self.buildImportDictionary()
        self.makeMissedProcedures()
    
    def imp_cb(self, ea, name, ord1):
        """Callback passed to idaapi.enum_import_name in buildImportDictionary().
        Sets the name of the PE segment in which the import table resides, and
        inserts current import in dictionary of imported APIS"""
        if self.firstImport:
            self.imports_segment_name = idaapi.get_segm_name(ea)
            self.firstImport = False
        demangled_name = idc.Demangle(name, idc.GetLongPrm(idc.INF_SHORT_DN))
        if not demangled_name:
            self.import_dict[ea] = (name, self.curr_mod_name)
        else:
            self.import_dict[ea] = (demangled_name, self.curr_mod_name)
        return True
    
    def buildImportDictionary(self):
        """Iterates over each of the import modules (dll's)
        and enumerates each of the APIs imported from them.
        enum_import_names implements a visitor pattern which passes
        each imported API name and it's EA in the import table to
        imp_cb above."""
        nimps = idaapi.get_import_module_qty()
        for i in xrange(0, nimps):
            self.curr_mod_name = idaapi.get_import_module_name(i)
            if not self.curr_mod_name:
                continue
            idaapi.enum_import_names(i, self.imp_cb)
            
    # Get the name of the API whose import table entry is at ea.
    def getAPIName(self, ea):
        tup = self.import_dict[ea]
        return tup[0]
    
    # Get the name of the dll the API at ea belongs to.
    def getAPIModule(self, ea):
        tup = self.import_dict[ea]
        return tup[1]
    
    def getSegmentName(self, ea):
        return idaapi.get_segm_name(ea)
    
    def getEntryPointEA(self):
        """Return EA of the PE's entry point."""
        return idc.GetLongPrm(idc.INF_START_IP)
    
    def getJMPorCallTarget(self, ea):
        if self.instructionIsACall(ea):
            return self.getCallTarget(ea)
        elif self.instructionIsAJMPToAPI(ea):
            return self.getJmpToAPITarget(ea)
        else:
            return None
       
           
    def getCallTarget(self, ea):
        """Assumes ea is the EA of a call instruction.  Returns the
        target ea of the call."""
        if ea == 0xDEADBEEF:
            return 0xDEADBEEF
        refs = idautils.CodeRefsFrom(ea, 0)
        refs_list = list(refs)
        if(len(refs_list) == 0):
            return None
        else:
            return refs_list[0]
        
    def getJmpToAPITarget(self, ea):
        if ea == 0xDEADBEEF:
            return 0xDEADBEEF
        refs = idautils.DataRefsFrom(ea)
        refs_list = list(refs)
        if(len(refs_list) == 0):
            return None
        else:
            return refs_list[0]
        
    def getDataRefsTo(self, ea):
        return idautils.DataRefsTo(ea)    
    
    def getByteOffsetOfEA(self, ea):
        """Return the file byte offset of ea"""
        return idaapi.get_fileregion_offset(ea)
    
    def isAnAPI(self, ea):
        """True if an ea is an API entry in the import table.
        False otherwise."""
        if ea in self.import_dict.keys():
            return True
        else:
            return False
    
    def instructionIsAJMPToAPI(self, ea):
        mnem = idc.GetMnem(ea)
        if (mnem == "jmp") and self.getJmpToAPITarget(ea):
            return True
        else:
            return False
    
    def instructionIsACall(self, ea):
        """Returns True if the instruction at ea is a call instruction.
        False otherwise."""
        mnem = idc.GetMnem(ea)
        if(mnem == "call"):
            return True
        else:
            return False
        
    def getFuncT(self, ea):
        return idaapi.get_func(ea)
        
    def getFunctionName(self, ea):
        """Returns the name of the function to which ea belongs"""
        demangled_name = idc.Demangle(idc.GetFunctionName(ea), idc.GetLongPrm(idc.INF_SHORT_DN))
        if not demangled_name:
            return idc.GetFunctionName(ea)
        else:
            return demangled_name
        
    def isLibraryFunction(self, ea):
        """Returns True if a function was identified as statically linked
        library code via FLIRT signatures"""
        func = idaapi.get_func(ea)
        # #define FUNC_LIB 0x00000004 in idasdk\include\funcs.hpp
        if(func.flags & 4):
            return True
        else:
            return False
        
    def isThunkFunction(self, ea):
        """Returns True if a function was identified as a thunk"""
        func = idaapi.get_func(ea)
        # #define FUNC_THUNK 0x00000080 in idasdk\include\funcs.hpp
        if(func.flags & 0x80):
            return True
        else:
            return False
   
    def getSegmentStart(self, ea):
        """Returns the effective address of the start of the segment
        in which ea resides"""
        return idc.SegStart(ea)
        
    def isCode(self, ea):
        """Returns True if the data at ea is code, False otherwise"""
        return idc.isCode(idc.GetFlags(ea))
                   
    def getMD5OfInputFile(self):
        """Returns the MD5 of the file currently being analyzed."""
        return idc.GetInputMD5()
    
    def Functions(self, start=None, end=None):
        """Returns list of Functions entry's in the program being analyzed"""
        return idautils.Functions(start, end)
    
    def Chunks(self, start):
        """Returns list of Chunks in the Function that starts at start"""
        return idautils.Chunks(start)
    
    def Heads(self, start=None, end=None):
        """Returns list of instructions (heads) between start and end."""
        return idautils.Heads(start, end)
    
    def Strings(self):
        """Returns list of Strings in the strings table."""
        return idautils.Strings(False)
       
    def killIDA(self):
        """Terminate IDA Pro process."""
        idc.Exit(0)
        
    def getMnemonic(self, ea):
        """Get mnemonic of instruction at EA."""
        return idc.GetMnem(ea)
    
    def getOperand(self, ea, op):
        """Get the op'th operand of the instruction at ea"""
        return idc.GetOpnd(ea, op)
    
    def getOperandType(self, ea, op):
        return idc.GetOpType(ea, op)
    
    def getOperandValue(self, ea, op):
        return idc.GetOperandValue(ea,op)
    
    def setOperandDisplayModeToSegment(self, ea, op):
        idc.OpSeg(ea, op)
        return
    
    def lookupRegFromRegNum(self, regnum):
        if regnum in self.regDict.keys():
            return self.regDict[regnum]
        return None
    
    def removeAllRegisterRenamingsInFunc(self, func_t):
        for reg in self.regDict.values():
            idaapi.del_regvar(func_t, func_t.startEA, func_t.endEA, reg)
            
    def getScreenEA(self):
        return idc.ScreenEA()
    
    def getFuncCFG(self, func_t, CALC_PREDS=False):
        if not CALC_PREDS:
            return idaapi.FlowChart(func_t)
        else:
            return idaapi.FlowChart(func_t, None, idaapi.FC_PREDS)
        
    def makeComment(self, ea, comment):
        idc.MakeComm(ea, comment)
    
    def VA2RVA(self, VA):
        peutils = idautils.peutils_t()
        return VA - peutils.imagebase
    
    def RVA2VA(self, RVA):
        peutils = idautils.peutils_t()
        return RVA + peutils.imagebase
    
    def getStringsObject(self):
        return idautils.Strings()
    
    def isAssignedToAFunction(self, ea):
        funcs = idautils.Functions(ea, ea+1)
        funcs_list = list(funcs)
        if len(funcs_list) != 0:
            return True
        return False
    
    def getDisassembly(self, ea):
        return idc.GetDisasm(ea)
    
    def makeFunction(self, start, end=4294967295):
        idc.MakeFunction(start, end)
        return
    
    def makeMissedProcedures(self):
        justSawPushEBP = False
        lastEA = None
        for ea in self.Heads():
            if not self.isAssignedToAFunction(ea):
                dis = self.getDisassembly(ea)
                if dis == "push    ebp":
                    justSawPushEBP = True
                    lastEA = ea
                    continue
                elif justSawPushEBP and dis == "mov     ebp, esp":
                    self.makeFunction(lastEA)
            justSawPushEBP = False
            lastEA = ea
    
    

    