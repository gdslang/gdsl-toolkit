/*
 * This file contains function template definitions to compare
 * collections.
 */

#pragma once
#include <memory>
#include <vector>

namespace gdsl {

/*
 * Collections are of the following form
 */
template <typename T>
using elements_t = std::vector<std::unique_ptr<T>>;

template <typename T>
bool equals(elements_t<T> const& a, elements_t<T> const& b) {
  if (a.size() != b.size()) return false;
  auto a_it = a.begin();
  auto b_it = b.begin();
  while (a_it != a.end()) {
    // Compare what is pointed to, not the pointer value
    if (**a_it != **b_it) return false;
    a_it++;
    b_it++;
  }
  return true;
}

}  // namespace gdsl
