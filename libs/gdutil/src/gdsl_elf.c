/*
 * elf.c
 *
 *  Created on: Jul 10, 2014
 *      Author: Julian Kranz
 */

#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <gdsl_elf.h>
#include <gelf.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

char elf_section_boundary_get(char *path, size_t *offset, size_t *size) {
  char retval = 0;

  int fd = open(path, O_RDONLY);
  if(!fd) {
    retval = 8;
    goto end_0;
  }

  if(elf_version(EV_CURRENT) == EV_NONE) {
    retval = 2;
    goto end_0;
  }

  Elf *e = elf_begin(fd, ELF_C_READ, NULL);
  if(!e) {
    retval = 3;
    goto end_0;
  }

  if(elf_kind(e) != ELF_K_ELF) {
    retval = 4;
    goto end_1;
  }

  size_t shstrndx;
//  if(elf_getshdrstrndx(e, &shstrndx) != 0) {
//    retval = 5;
//    goto end_1;
//  }
  elf_getshdrstrndx(e, &shstrndx);

  Elf_Scn *scn = NULL;

  char found = 0;
  while((scn = elf_nextscn(e, scn)) != NULL) {
    GElf_Shdr shdr;
    if(gelf_getshdr(scn, &shdr) != &shdr) {
      retval = 6;
      goto end_1;
    }

    char *name = elf_strptr(e, shstrndx, shdr.sh_name);
    if(!name) {
      retval = 7;
      goto end_1;
    }
    if(!strcmp(name, ".text")) {
      *offset = shdr.sh_offset;
      *size = shdr.sh_size;
      found = 1;
      break;
    }
//    printf("%s - %zu:%zu\n", name, shdr.sh_offset, shdr.sh_size);
  }

  if(!found)
    retval = 1;

  end_1: elf_end(e);

  end_0: close(fd);

  return retval;
}
