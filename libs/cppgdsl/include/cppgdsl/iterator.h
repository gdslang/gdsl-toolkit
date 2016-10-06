/*
 * This file contains an iterator implementation for vectors of unique
 * pointers. Vectors of unique pointers are used throughout this library
 * as collection type. The iterator allows to hide internal implementation
 * details (the fact that the library uses a vector and that this vector
 * is comprised of unique_ptr objects).
 */

#pragma once

#include <memory>
#include <vector>
#include <iterator>

namespace gdsl {

/*
 * Collections are of the following form
 */
template <typename T>
using elements_t = std::vector<std::unique_ptr<T>>;

/*
 * The iterator class is a wrapper class for the const
 * iterator of the vector. Instead of returning a reference
 * to the inner unique_ptr, it returns a reference to the
 * pointed to object when dereferenced.
 *
 * The class implements all requirements for bidirectional
 * iterators.
 */
template <typename T>
class iterator : public std::iterator<std::bidirectional_iterator_tag, T> {
 private:
  using inner_t = typename elements_t<T>::const_iterator;
  inner_t it;

 public:
  explicit iterator(inner_t it) : it(it) {}

  bool operator==(iterator<T> other) { return it == other.it; }

  bool operator!=(iterator<T> other) { return it != other.it; }

  // Forward iterator requirements
  /*
   * Returns a reference to the pointed to object instead
   * of the unique_ptr
   */
  T const& operator*() { return **it; }

  T const* operator->() const { return it->get(); }

  iterator<T>& operator++() {
    ++it;
    return *this;
  }

  iterator<T> operator++(int) { return iterator<T>(it++); }

  // Bidirectional iterator requirements
  iterator<T>& operator--() {
    --it;
    return *this;
  }

  iterator<T> operator--(int) { return iterator<T>(it--); }
};

/*
 * The iterable class is used as return value for getters of collections.
 * It exposes the interface necessary to use it in range-based loops.
 * Additionally, it allows to query the amount of elements the container
 * stores.
 */
template <typename T>
class iterable {
 private:
  elements_t<T> const& elements;

 public:
  explicit iterable(elements_t<T> const& elements) : elements(elements) {}

  iterator<T> begin() const { return iterator<T>(elements.cbegin()); }

  iterator<T> end() const { return iterator<T>(elements.cend()); }

  typename elements_t<T>::size_type size() const { return elements.size(); }
};

}  // namespace gdsl
