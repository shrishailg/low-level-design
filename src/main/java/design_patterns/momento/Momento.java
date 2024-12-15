package main.java.design_patterns.momento;

// this design pattern provides ability to revert an object
// to previous state i.e UNDO capability and it does not expose the object internal implementation
public class Momento {
}

/*
It hs 3 parts: Originator; Memento; and caretaker
Originator: - It represents the object for which state needs to be saved and restore
            - Exposes methods to save and restore its state using memento object

Memento: - it represents an Object which holds the state of the originator

Caretaker: - Manages the list of states
 */
