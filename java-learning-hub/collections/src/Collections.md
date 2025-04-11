## Java collections provides a way to store and manipulate group of objects.

###### There are interfaces and classes in the java collection framework.

### INTERFACES

> Collection Interface.

```
List - Ordered collection of elements that allow s duplicate elements. 
Set - Unordered collection of elements that does not allows duplicate elements.
Queue - Collection used for holding elements prior to processing (FIFO Order).
Deque - Double-ended queue that supports element insertion and removal at both ends.
```

> Map Interface - Represents a collection of key value pair.

```   
Hash Map - Implements Map interface using a hash table.
Tree Map - Implements Map interface using a red-black tree, maintaining order based on keys.
Linked Hash Map - Extends Hash Map to maintain insertion order.
```

> Iterator - Allows iterating over elements in the collection.
> List Iterator - Extends Iterator.Allows bidirectional traversal of lists.

### CLASSES

```
 Array List - Resizeable array implementation of List interface
 Linked List - Doubly linked list implementation of queue and deque interfaces.
 Hash Set - Implements Set interface using a hash table for storage.
 Tree Set - Implements Set interface using a red-black tree for storage, maintaining sorted order.
 Priority Queue - Implements Queue interface with elements ordered based on natural ordering or a specified comparator.
 HashMap, TreeMap, LinkedHashMap: Mentioned earlier as classes implementing the Map interface.
```

> Utility Classes

```
Collections - Contains static methods for manipulating collections, such as sorting, shuffling, searching, etc.
Arrays - Contains static methods for working with arrays, including converting arrays to collections and vice versa.
```

> List in detail.

```
Array and linked list maintains order.

```