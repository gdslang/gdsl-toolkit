
#ifndef __PRETTY_H
#define __PRETTY_H

#include <dis.h>

char* pretty (__obj,char*,__word);
char* prettyln (__obj,char*,__word);
char* prettyOpnd(__obj,char*,__word);
char* prettyMnemonic(__obj,char*,__word);

#endif /* __PRETTY_H */
