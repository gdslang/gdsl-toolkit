/*
 * main-elf.cpp
 *
 *  Created on: Oct 23, 2012
 *      Author: jucs
 */

#include <stdint.h>
#include <iostream>
#include <fstream>
#include "Segment.h"
#include "RReil.h"
#include <vector>
#include <fcntl.h>

int main(int argc, const char * argv[]) {
	char *file_name = "/bin/echo";

  SegmentSet segments;

  // Read in what code/data segments there are and store them in
//  uint32_t cmd_buf[header.sizeofcmds/sizeof(uint32_t)];
//  char* cp = (char*) &cmd_buf;
//  f.read(cp, header.sizeofcmds);
//  uint32_t ncmds = header.ncmds;
//  while ((cp-(char*) &cmd_buf)<header.sizeofcmds && ncmds--) {
//    struct load_command* lc = (struct load_command*) cp;
//    switch (lc->cmd) {
//    case LC_SEGMENT_64: {
//      struct segment_command_64* cmd = (struct segment_command_64*) cp;
//      char name[17];
//      name[16]=0;
//      memcpy(&name[0], &cmd->segname[0], 16);
//      std::cout << "found " << &name[0] << " segment" << std::endl;
//      uint32_t nsect = cmd->nsects;
//      struct section_64* sect = (struct section_64*) (cp+sizeof(struct segment_command_64));
//      for (int i=0; i<nsect; i++, sect++) {
//        sect->sectname[15]=0;
//        Segment* s = new Segment(&(sect->sectname[0]), sect->addr, sect->size, sect->offset);
//        segments.addSegment(s);
//      }
//    }
//    }
//    cp = cp+lc->cmdsize;
//  }

  Segment* s = new Segment("text", 0x401170, 0xbd, 0x1170);
  segments.addSegment(s);

//  f.close();
  int fd = open(file_name, O_RDONLY);
  if (fd== -1) return 1;

  bool res = segments.map(fd);
  if (!res) {
    std::cout << "Cannot map segment sections." << std::endl;
    return 1;
  }
  //std::cout << segments;

  Segment* text = segments.findByName("text");
  if (text==NULL) {
    std::cout << "Segment containing code not found." << std::endl;
    return 1;
  }

  std::cout << segments << std::endl;

  uint64_t start = text->getBase();
  char* limit;
  char* addr = segments.resolve(start, &limit);
  //std::cout << "first byte of text segment is " << std::hex << start << ": " << std::hex << (uint8_t) (*addr) << std::dec << std::endl;
  RReilBB* b = translate(addr,limit);
  if (b!=NULL) std::cout << "basic block:" << std::endl << *b << std::endl;
  return 0;
}
