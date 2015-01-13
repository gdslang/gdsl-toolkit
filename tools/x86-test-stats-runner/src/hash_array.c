/*
 * hash_array.c
 *
 *  Created on: 26.05.2013
 *      Author: jucs
 */

#define _GNU_SOURCE
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <errno.h>
#include <search.h>
#include "hash_array.h"

static void hash_array_grow(struct hash_array *ha) {
  ha->nel <<= 1;
  ha->entries = (ENTRY*)realloc(ha->entries, sizeof(ENTRY) * ha->nel);

  hdestroy_r(&ha->htab);
  memset(&ha->htab, 0, sizeof(ha->htab));
  hcreate_r(ha->nel, &ha->htab);
}

struct hash_array *hash_array_init(size_t nel) {
  struct hash_array *ha = (struct hash_array*)malloc(sizeof(struct hash_array));

  memset(&ha->htab, 0, sizeof(ha->htab));
  hcreate_r(nel, &ha->htab);

  ha->entries = (ENTRY*)malloc(sizeof(ENTRY) * nel);
  ha->entries_length = 0;

  ha->nel = nel;

  return ha;
}

ENTRY *hash_array_search_insert(struct hash_array *ha, char *key) {
  ENTRY param, *retval, *result;

  param.key = key;
  hsearch_r(param, FIND, &retval, &ha->htab);

  if(retval) result = &ha->entries[(size_t)retval->data];
  else {
    if(ha->entries_length == ha->nel) hash_array_grow(ha);

    while(1) {
      param.key = key;
      param.data = (void*)ha->entries_length;
      int r = hsearch_r(param, ENTER, &retval, &ha->htab);
      if(r == ENOMEM) hash_array_grow(ha);
      else break;
    }

    result = &ha->entries[ha->entries_length++];
    result->key = key;
    result->data = NULL;
  }

  return result;
}

size_t hash_array_entries_get(struct hash_array *ha, ENTRY **entries) {
  *entries = ha->entries;
  return ha->entries_length;
}

void hash_array_free(struct hash_array *ha) {
  if(ha) {
    hdestroy_r(&ha->htab);
    free(ha->entries);
    free(ha);
  }
}
