# Task 2 - ConcurrentModificationException Analysis

## 1. What is the exact cause of ConcurrentModificationException in Java?

ConcurrentModificationException occurs when a collection is modified while it is being iterated using an Iterator or an enhanced for-loop. The iterator detects that the collection's structure has changed unexpectedly and throws this exception.

---

## 2. What code pattern at line 142 most likely triggered this error?

The most likely cause is removing or adding elements to an ArrayList while iterating over it using a for-each loop.

For Example:
java
for (Transaction transaction : transactions) {
    if (transaction.isInvalid()) {
        transactions.remove(transaction);
    }
}

## 3. Provide the minimal code change (one or two lines) that resolves this safely.

Use the Iterator's remove() method instead of removing elements directly from the list.

For Example:-
Iterator<Transaction> iterator = transactions.iterator();

while (iterator.hasNext()) {
    Transaction transaction = iterator.next();

    if (transaction.isInvalid()) {
        iterator.remove();
    }
}

This safely removes elements during iteration without causing ConcurrentModificationException.