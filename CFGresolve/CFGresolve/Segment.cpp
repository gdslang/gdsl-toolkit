//
//  Segment.cpp
//
//  A segment is a blob of code or data in the program.
//
//  CFGresolve
//
//  Created by Axel Simon on 15.09.12.
//  Copyright (c) 2012 Axel Simon. All rights reserved.
//

#include "Segment.h"
#include <sys/mman.h>
#include <unistd.h>
#include <errno.h>
#include <err.h>
#include <iomanip>

bool Segment::addressInRange(uint64_t addr) {
  return (addr>=base && addr<=base+size);
};

char* Segment::getPtrAt(uint64_t addr, char** limit) {
  if (limit) *limit = content+size;
  return content+(addr-base);
};

std::ostream& operator<<(std::ostream& o, const Segment& s) {
  return o << s.name << "[" << std::hex << s.base << "," << s.size << "]";
};

bool Segment::map(int fd) {
  void* res;
  if (file_offset==0) {
    // this segement is not backed by a file but a zero-filled one
    res = mmap(NULL, size+displ, PROT_READ | PROT_WRITE, MAP_SHARED | MAP_ANON, 0, 0);
    if (res!=MAP_FAILED) bzero(res,size+displ);
  } else {
    res = mmap(NULL, size+displ, PROT_READ, MAP_SHARED, fd, file_offset-displ);
  }
  if (res==MAP_FAILED) {
    err(errno, "when mapping section");
    return false;
  }
  content = ((char*) res)+displ;
  return true;
}

void Segment::unmap() {
  if (content) {
    munmap(content-displ, size);
    content = NULL;
  }
}

std::ostream& Segment::dump(std::ostream& o, uint64_t addr, uint64_t len) {
  if (addr==0) addr=base;
  if (len==0) len=size;
  if (!addressInRange(addr))
    return o << "Segment.dump: address " << std::hex << addr << " out of range" << std::endl;
  if (len>size)
    return o << "Segment.dump: size too large" << std::endl;
  char txt[17];
  txt[16]=0;
  for (uint64_t i=addr-base; i<len; i+=16) {
    o << std::hex << base+i << ": ";
    for (uint64_t j=0; j<16; j++) {
      if (i+j>=len) {
        o << "   ";
        txt[j] = ' ';
      } else {
        char c = content[i+j];
        o.precision(2);
        o << std::setfill('0') << std::setw(2) << std::hex << (uint32_t) ((unsigned char) c) << " ";
        txt[j] = (c>=32 && c<125 ? c : '.');
      }
    }
    o << "  " << &(txt[0]) << std::endl;
  }
  return o << std::setw(0);
}

std::ostream& operator<<(std::ostream& o, const SegmentSet& s) {
  for (typename std::vector<Segment*>::const_iterator
       iter = s.begin(); iter != s.end(); iter++) {
    o << *(*iter) << std::endl;
    (*iter)->dump(o);
  }
  return o ;
}

