//
//  Segment.h
//
//  A segment is a blob of code or data in the program.
//
//  CFGresolve
//
//  Created by Axel Simon on 15.09.12.
//  Copyright (c) 2012 Axel Simon. All rights reserved.
//

#ifndef __CFGresolve__Segment__
#define __CFGresolve__Segment__

#include <iostream>
#include <vector>

class Segment {
  std::string name;
  const uint64_t base;
  const uint64_t size;
  const uint64_t file_offset;
  const uint64_t displ;
  char* content;
public:
  Segment(char* seg_name, uint64_t base, uint64_t size, uint64_t file_offset) :
      base(base), size(size), file_offset(file_offset), displ(file_offset % getpagesize()) {
    name.append(seg_name);
    content = 0;
  }
  bool addressInRange(uint64_t addr);
  
  char* getPtrAt(uint64_t addr, char** limit);
  
  // Load segment into memory. Returns true if successful.
  bool map(int fd);
  
  std::string getName() {
    return name;
  }

  uint64_t getBase() {
    return base;
  }
  
  void unmap();
  
  ~Segment() {
    unmap();
  }

  std::ostream& dump(std::ostream& o, uint64_t addr = 0, uint64_t len = 0);
  
  friend std::ostream& operator<<(std::ostream& o, const Segment& s);
};

class SegmentSet : public std::vector<Segment*> {
public:
  char* resolve(uint64_t addr, char** limit) const {
    for (typename std::vector<Segment*>::const_iterator
         iter = this->begin(); iter != this->end(); iter++) {
      if ((*iter)->addressInRange(addr)) return (*iter)->getPtrAt(addr, limit);
    }
    if (limit) *limit=NULL;
    return NULL;
  }
  
  void addSegment(Segment* seg) { push_back(seg); }
  
  bool map(int fd) {
    for (typename std::vector<Segment*>::const_iterator
         iter = this->begin(); iter != this->end(); iter++) {
      bool res = (*iter)->map(fd);
      if (!res) return false;
    };
    return true;
  }

  std::ostream& dump(std::ostream& o) const {
    for (typename std::vector<Segment*>::const_iterator
         iter = this->begin(); iter != this->end(); iter++) {
      (*iter)->dump(o);
    }
    return o;
  };

  Segment* findByName(const std::string segName) const {
    for (typename std::vector<Segment*>::const_iterator
         iter = this->begin(); iter != this->end(); iter++) {
      if ((*iter)->getName().find(segName)!=std::string::npos) return *iter;
    }
    return NULL;
  };

  friend std::ostream& operator<<(std::ostream& o, const SegmentSet& s);

};

#endif /* defined(__CFGresolve__Segment__) */
