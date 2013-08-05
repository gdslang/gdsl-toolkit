/*
 * hash_array.h
 *
 *  Created on: 26.05.2013
 *      Author: jucs
 */

#ifndef HASH_ARRAY_H_
#define HASH_ARRAY_H_

#define _GNU_SOURCE
#include <search.h>

struct hash_array {
	struct hsearch_data htab;

	ENTRY *entries;
	size_t entries_length;

	size_t nel;
};

extern struct hash_array *hash_array_init(size_t nel);
extern ENTRY *hash_array_search_insert(struct hash_array *ha, char *key);
extern size_t hash_array_entries_get(struct hash_array *ha, ENTRY **entries);
extern void hash_array_free(struct hash_array *ha);

#endif /* HASH_ARRAY_H_ */
