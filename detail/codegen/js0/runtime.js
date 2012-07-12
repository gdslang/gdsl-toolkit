
var __TRUE = {sz:1, vec:1}
var __FALSE = {sz:1, vec:0}
var __UNIT = {}

function __halt (o) { return o; }

function __raise (o) { throw o; }

function __consume (s) {
  var blob = s.___blob;
  var i = s.___idx;
  var v = blob[i];
  var ss = s; // FIXME: destructive update!
  ss.___idx = i+1; 
  return {___1:{vec:v,sz:8}, ___2:ss}
}

function __unconsume (s) {
  var ss = s; // FIXME: destructive update!
  ss.___idx = s.___idx-1;
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

function __equal (a, b) {
  var aa = a.vec;
  var bb = b.vec;
  var szOfA = a.sz;
  var szOfB = b.sz;
  return ((a == b && szOfA == szOfB) ? __TRUE : __FALSE);
}

function __not (a) {
  return {sz:a.sz, vec:~a.vec & ((1<<sz)-1)};
}

function __and (a, b) {
  var aa = a.vec;
  var bb = b.vec;
  var sz = a.sz;
  return {sz:sz, vec:a & b};
}

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

function __eval (f, blob) {
  var s = {___blob:blob, ___idx:0};
  return f(__halt,s);
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
  for (var i=0;i<str.length/2;i++) {
    var a = toByte(str[i*2]);
    var b = toByte(str[i*2+1]);
    blob[i] = ((a<<4) | b) & 0xff;
  }
  return blob;
}

function prettyJSON (o) {
  print(JSON.stringify(o));
}

function decode64 (str) {
  var blob = toBytes(str);
  var s = __eval(__decode__,blob);
  return(s.___1);
}

function decodeAndPrint (str) {
  prettyJSON(decode64(str));
}

@functions@
