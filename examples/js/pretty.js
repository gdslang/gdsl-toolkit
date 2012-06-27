
function pretty (insn) {
  function prettyOpnd (o) {
    const tag = o.tag;
    switch (tag) {
      case 'MEM': return prettyMem(o.payload);
      case 'REG': return prettyOpnd(o.payload);
      case 'SUM': return prettySum(o.payload);
      case 'SCALE':
        return (prettyFac(o.payload.___imm)+prettyOpnd(o.payload.___opnd));
      case 'NEARABS': return 'NEAR ' + prettyOpnd(o.payload);
      case 'FAR': return 'FAR ' + prettyOpnd(o.payload);
      case 'REL8':
      case 'REL16':
      case 'REL32':
      case 'REL64': return 'RELATIVE ' + prettyBitvec(o.payload);
      case 'IMM8':
      case 'IMM16':
      case 'IMM32':
      case 'IMM64': return prettyBitvec(o.payload);
      default: return tag;
     }
  }
  function prettyBitvec (o) {
    return o.vec.toString();
  }
  function prettySum (o) {
    const a = o.___a;
    const b = o.___b;
    return (prettyOpnd(a) + '+' + prettyOpnd(b));
  }
  function prettyFac (o) {
    switch(__casetag(o)) {
      case 0: return '1*';
      case 1: return '2*';
      case 2: return '4*';
      case 3: return '8*';
    }
  }
  function prettyMem (o) {
    const sz = o.___sz;
    const segment = o.___segment;
    const opnd = o.___opnd;
    var ptrsz;
    switch (sz) {
      case 8: ptrsz = 'BYTE PTR '; break;
      case 16: ptrsz = 'WORD PTR '; break;
      case 32: ptrsz = 'DWORD PTR '; break;
      case 64: ptrsz = 'QWORD PTR '; break;
      case 128: ptrsz = 'XMMWORD PTR '; break;
      case 256: ptrsz = 'YMMWORD PTR '; break;
      default: ptrsz = 'PTR(' + sz + ')'; break;
    }
    return (ptrsz + prettyOpnd(segment) + ":[" + prettyOpnd(opnd) + "]");
  }
  const tag = insn.tag;
  if (tag == 'ARITY0') {
    return insn.payload.___tag;
  } else if (tag == 'ARITY1') {
    var i;
    i = insn.payload.___tag.tag + " " + prettyOpnd(insn.payload.___opnd1);
    return i;
  } else if (tag == 'ARITY2') {
    var i;
    i = insn.payload.___tag.tag + " ";
    i = i + prettyOpnd(insn.payload.___opnd1) + ",";
    i = i + prettyOpnd(insn.payload.___opnd2);
    return i;
  } else if (tag == 'ARITY3') {
    var i;
    i = insn.payload.___tag.tag + " ";
    i = i + prettyOpnd(insn.payload.___opnd1) + ",";
    i = i + prettyOpnd(insn.payload.___opnd2) + ",";
    i = i + prettyOpnd(insn.payload.___opnd3);
    return i;
  } else if (tag == 'ARITY4') {
    var i;
    i = insn.payload.___tag.tag + " ";
    i = i + prettyOpnd(insn.payload.___opnd1) + ",";
    i = i + prettyOpnd(insn.payload.___opnd2) + ",";
    i = i + prettyOpnd(insn.payload.___opnd3) + ",";
    i = i + prettyOpnd(insn.payload.___opnd4);
    return i;
  } else if (tag == 'FLOW1') {
    var i;
    i = insn.payload.___tag.tag + " " + prettyOpnd(insn.payload.___opnd1);
    return i;
  }
  throw 'InvalidInstructionRepresentation';
}
