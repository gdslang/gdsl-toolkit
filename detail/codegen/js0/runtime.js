
var __TRUE = {sz:1, vec:1}
var __FALSE = {sz:1, vec:0}
var __UNIT = {}

function __raise (o) { throw o; }

function __consume8 (s) {
  var blob = s.___blob;
  var i = s.___idx;
  var v = blob[i];
  var ss = s; // FIXME: destructive update!
  ss.___idx = i+1; 
  return {___1:{vec:v,sz:8}, ___2:ss}
}

function __unconsume8 (s) {
  var ss = s; // FIXME: destructive update!
  ss.___idx = s.___idx-1;
  return {___1:__UNIT, ___2:ss};
}

function __consume16 (s) {
  var blob = s.___blob;
  var i = s.___idx;
  var v1 = blob[i];
  var v2 = blob[i+1]<<8;
  var ss = s; // FIXME: destructive update!
  ss.___idx = i+1; 
  return {___1:{vec:(v1|v2)&0xffff,sz:8}, ___2:ss}
}

function __unconsume16 (s) {
  var ss = s; // FIXME: destructive update!
  ss.___idx = s.___idx-2;
  return {___1:__UNIT, ___2:ss};
}

function __consume32 (s) {
  var blob = s.___blob;
  var i = s.___idx;
  var v1 = blob[i];
  var v2 = blob[i+1]<<8;
  var v3 = blob[i+2]<<16;
  var v4 = blob[i+3]<<24;
  var ss = s; // FIXME: destructive update!
  ss.___idx = i+1; 
  return {___1:{vec:(v1|v2|v3|v4)&0xffffffff,sz:8}, ___2:ss}
}

function __unconsume32 (s) {
  var ss = s; // FIXME: destructive update!
  ss.___idx = s.___idx-4;
  return {___1:__UNIT, ___2:ss};
}

function __slice (tok, offs, sz) {
  var tokk = tok.vec;
  var x = ((tokk>>offs) & ((1<<sz)-1));
  return {sz:sz, vec:x};
}

function __concat (a, b) {
  var aa = a.vec;
  var bb = b.vec;
  var szOfA = a.sz;
  var szOfB = b.sz;
  return {sz:szOfA+szOfB, vec:aa << szOfB | bb};
}

function __concatstring (a, b) {
  return a + b;
}

function __showbitvec (x) {
  return '0x' + x.vec.toString(16);
}

function __showint (x) {
  return x.toString();
}

function __equal (a, b) {
  var aa = a.vec;
  var bb = b.vec;
  var szOfA = a.sz;
  var szOfB = b.sz;
  return ((aa == ab && szOfA == szOfB) ? __TRUE : __FALSE);
}

function __not (a) {
  return {sz:a.sz, vec:~a.vec & ((1<<sz)-1)};
}

// FIXME:
function __sx (x) {
  return x.vec
}

// FIXME:
function __zx (x) {
  return x.vec
}

function __and (a, b) {
  var aa = a.vec;
  var bb = b.vec;
  var sz = a.sz;
  return {sz:sz, vec:aa & bb};
}

function __or (a, b) {
  var aa = a.vec;
  var bb = b.vec;
  var sz = a.sz;
  return {sz:sz, vec:aa | bb};
}

// ## Operations on integers

function __eqi (a, b) {
  return a==b?__TRUE:__FALSE;
}

function __lti (a, b) {
  return a<b?__TRUE:__FALSE;
}

function __lei (a, b) {
  return a<=b?__TRUE:__FALSE;
}

function __addi (a, b) {
  return a + b;
}

function __subi (a, b) {
  return a - b;
}

function __muli (a, b) {
  return a * b;
}

// DEPRECATED
function __casetag (obj) {
  if (typeof obj == "number") {
    return obj;
  } else if ('vec' in obj) {
    return obj.vec;
  } else if ('tag' in obj) {
    return obj.tag;
  }
  throw '__CASETAG() applied to non-tagged object'
}

function __decon (obj) {
  if (typeof obj == 'number')
    return obj;
  else
    return 'payload' in obj ? obj.payload : obj;
}

function __casetagcon (obj) { return obj.tag };

function __casetagvec (obj) { return obj.vec };

function __casetagint (obj) { return obj };

function __halt (o) { return o; }

function __eval (f, blob) {
  var s = {___blob:blob, ___idx:0};
  return f(__halt,s);
}

function __evalPure (f, x) {
  return f(__halt,x);
}

function __eval2 (f, x, y) {
  function k (g) { return g(__halt,y); }
  return f(k,x);
}

function toBytes (str) {
  function toByte (c) {
    switch (c) {
      case '0': return 0;
      case '1': return 1;
      case '2': return 2;
      case '3': return 3;
      case '4': return 4;
      case '5': return 5;
      case '6': return 6;
      case '7': return 7;
      case '8': return 8;
      case '9': return 9;
      case 'a': case 'A': return 10;
      case 'b': case 'B': return 11;
      case 'c': case 'C': return 12;
      case 'd': case 'D': return 13;
      case 'e': case 'E': return 14;
      case 'f': case 'F': return 15;
      default:
        throw 'InvalidCharacter';
    }
  }
  var blob = new Uint8Array(str.length/2);
  str = str.replace(/ /g,"");
  for (var i=0;i<str.length/2;i++) {
    var a = toByte(str[i*2]);
    var b = toByte(str[i*2+1]);
    blob[i] = ((a<<4) | b) & 0xff;
  }
  return blob;
}

function prettyJSON (o) {
  return JSON.stringify(o);
}

function __prettyln(f,s,x) {
  print(s+":"+__evalPure(f,x));
}

function pretty (i) {
  return __evalPure(__pretty__,i);
}

function decode (str) {
  var blob = toBytes(str);
  var s = __eval(__decode__,blob);
  return s.___1;
}

@functions@
